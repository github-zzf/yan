package com.junkj.module.member.biz;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.collect.ListUtils;
import com.junkj.common.config.Global;
import com.junkj.common.entity.Page;
import com.junkj.common.lang.DateUtils;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.utils.ComUtils;
import com.junkj.common.utils.TplMsgUtils;
import com.junkj.module.cash.biz.CashMoneyBiz;
import com.junkj.module.cash.entity.CashMoney;
import com.junkj.module.company.biz.CardsBiz;
import com.junkj.module.company.entity.Cards;
import com.junkj.module.member.dao.MemberCardDao;
import com.junkj.module.member.entity.Member;
import com.junkj.module.member.entity.MemberCard;
import com.junkj.module.sys.dao.SysPayDao;
import com.junkj.module.sys.entity.SysPay;

/**
 * 会员卡记录biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class MemberCardBiz extends CrudBiz<MemberCardDao, MemberCard> {

	@Autowired
	private SysPayDao sysPayDao;
	@Autowired
	private CardsBiz cardsBiz;
	@Autowired
	private MemberBiz memberBiz;
	@Autowired
	private CashMoneyBiz cashMoneyBiz;

	/**
	 * 分页数据
	 */
	@Override
	public Page<MemberCard> findPage(MemberCard card) {
		return super.findPage(card);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<MemberCard> findList(MemberCard card) {
		return super.findList(card);
	}

	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(MemberCard card) {
		super.save(card);
	}

	/**
	 * 查询会员会员卡
	 */
	public List<MemberCard> getMemberCardList(MemberCard card) {
		card.setComId(card.getComId());
		return dao.getMemberCardList(card);
	}

	/**
	 * 会员卡支付回调
	 * 
	 * @param payCode
	 */
	@Transactional(readOnly = false)
	public void payBack(String payCode, String wxId) {

		// 更新订单状态
		SysPay where = new SysPay();
		where.setPayCode(payCode);
		SysPay pay = sysPayDao.getByEntity(where);
		if (SysPay.PAY_STATUS_1.equals(pay.getPayStatus())) {
			// 更新支付状态
			pay.setPayStatus(SysPay.PAY_STATUS_2);
			pay.setPayTime(new Date());
			pay.setWxId(wxId);
			sysPayDao.update(pay);

			// 获取会员卡
			Cards cards = cardsBiz.get(pay.getBizId());
			// 失效日期
			Calendar ca = Calendar.getInstance();
			ca.add(Calendar.DATE, cards.getDays());
			Date invalidTiem = ca.getTime();

			// 获取会员未失效的会员卡
			MemberCard mCard = getOkCard(pay.getComId(), pay.getMemberId(), cards.getId());
			if (mCard != null) {
				// 余额
				mCard.setStoredAll(mCard.getStoredAll() + cards.getStoredNum());
				mCard.setStoredNum(mCard.getStoredNum() + cards.getStoredNum());
				// 失效日期
				mCard.setInvalidTime(invalidTiem);
				// 更新时间
				mCard.setUpdateTime(DateUtils.getNow());
				dao.update(mCard);
			} else {
				// 保存会员卡
				mCard = new MemberCard();
				mCard.setMemberId(pay.getMemberId());
				mCard.setCardId(cards.getId());
				mCard.setCardName(cards.getName());
				mCard.setStoredAll(cards.getStoredNum());
				mCard.setStoredNum(cards.getStoredNum());
				mCard.setInvalidTime(invalidTiem);
				super.save(mCard);
			}
			
			// 活动添加消费记录
			CashMoney cashMoney = new CashMoney();
			cashMoney.setBizId(mCard.getId());
			cashMoney.setBizType(CashMoney.BIZTYPE_MEMBER_CARD);
			cashMoney.setMoney(pay.getPayMoney());
			cashMoney.setBuyType(CashMoney.BUYTYPE_42);
			cashMoney.setType(CashMoney.TYPE_4);
			cashMoneyBiz.save(cashMoney);

			// 微信模板消息：消费通知
			Member member = memberBiz.get(mCard.getMemberId());
			String mcId = mCard.getId();
			String comId = pay.getComId();
			String comName = ComUtils.getCurrentComName();
			if (member != null && StrUtils.notBlank(member.getOpenId())) {
				new Thread() {
					public void run() {
						try {
							List<String> data = ListUtils.newArrayList();
							data.add("您有一条购买会员卡消费通知!");
							data.add(DateUtils.getDateTime());
							data.add(cards.getName());
							data.add(cards.getMoney() + "");
							data.add(mcId);
							data.add(comName);
							data.add("点击查看详情");
							String url = ComUtils.getComUrl(comId, "/mobile#/pages/nav/myCard/myCard");
							TplMsgUtils.sendMsg(comId, member.getOpenId(), url, TplMsgUtils.TPL_1, data);
						} catch (Exception e) {
							logger.error("消费通知失败", e);
						}
					}
				}.start();
			}
		}

	}

	/**
	 * 获取会员未失效的会员卡
	 */
	public MemberCard getOkCard(String comId, String memberId, String cardId) {
		return dao.getOkCard(comId, memberId, cardId);
	}
}
