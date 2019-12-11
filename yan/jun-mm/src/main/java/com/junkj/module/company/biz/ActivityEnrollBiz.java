package com.junkj.module.company.biz;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

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
import com.junkj.common.vo.JsonVo;
import com.junkj.module.cash.biz.CashMoneyBiz;
import com.junkj.module.cash.entity.CashMoney;
import com.junkj.module.company.dao.ActivityEnrollDao;
import com.junkj.module.company.entity.Activity;
import com.junkj.module.company.entity.ActivityEnroll;
import com.junkj.module.company.entity.Cards;
import com.junkj.module.company.entity.ComConfig;
import com.junkj.module.member.biz.CardChangeBiz;
import com.junkj.module.member.biz.MemberBiz;
import com.junkj.module.member.biz.MemberCardBiz;
import com.junkj.module.member.biz.PointsBiz;
import com.junkj.module.member.entity.CardChange;
import com.junkj.module.member.entity.Member;
import com.junkj.module.member.entity.MemberCard;
import com.junkj.module.member.entity.Points;
import com.junkj.module.sys.dao.SysPayDao;
import com.junkj.module.sys.entity.SysPay;

/**
 * 活动报名biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class ActivityEnrollBiz extends CrudBiz<ActivityEnrollDao, ActivityEnroll> {

	@Autowired
	private ActivityEnrollDao activityEnrollDao;
	@Autowired
	private ActivityBiz activityBiz;
	@Autowired
	private CardChangeBiz cardChangeBiz;
	@Autowired
	private MemberCardBiz cardBiz;
	@Resource
	private SysPayDao sysPayDao;
	@Autowired
	private MemberBiz memberBiz;
	@Autowired
	private PointsBiz pointsBiz;
	@Autowired
	private ComConfigBiz comConfigBiz;
	@Autowired
	private CashMoneyBiz cashMoneyBiz;

	/**
	 * 分页数据
	 */
	@Override
	public Page<ActivityEnroll> findPage(ActivityEnroll activityEnroll) {
		return super.findPage(activityEnroll);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<ActivityEnroll> findList(ActivityEnroll activityEnroll) {
		return super.findList(activityEnroll);
	}

	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(ActivityEnroll activityEnroll) {
		super.save(activityEnroll);
	}

	/**
	 * 添加
	 */
	@Transactional(readOnly = false)
	public JsonVo saveActivityEnroll(ActivityEnroll activityEnroll) {

		// 获取活动
		Activity activity = activityBiz.get(activityEnroll.getActivityId());

		if (activityEnroll.getIsNewT()) {
			activityEnroll.setEnrollStatus(ActivityEnroll.ENROLLSTATUS_0);
		}
		JsonVo vo = activityEnrollCheck(activityEnroll, activity);
		if (!"1".equals(vo.get("code").toString())) {
			return vo;
		}
		super.save(activityEnroll);

		if (!ActivityEnroll.ENROLLSTATUS_4.equals(activityEnroll.getEnrollStatus())) {
			// 微信模板消息：会员报名通知
			Member member = memberBiz.get(activityEnroll.getMemberId());
			if (member != null && StrUtils.notBlank(member.getOpenId())) {
				String comId = ComUtils.getCurrentComId();
				new Thread() {
					public void run() {
						try {
							List<String> data = ListUtils.newArrayList();
							data.add("您有一条预约活动通知!");
							data.add(activity.getName() + "\\n开始时间:" + DateUtils.formatDateTime(activity.getStartTime())
									+ "\\n结束时间:" + DateUtils.formatDateTime(activity.getEndTime()));
							data.add(DateUtils.getDateTime());
							data.add("点击查看详情");
							String url = ComUtils.getComUrl(comId, "/mobile#/pages/activityList/activityList?type=my");
							TplMsgUtils.sendMsg(comId, member.getOpenId(), url, TplMsgUtils.TPL_3, data);
						} catch (Exception e) {
							logger.error("预约通知失败", e);
						}
					}
				}.start();
			}
		}
		if(ActivityEnroll.ENROLLSTATUS_4.equals(activityEnroll.getEnrollStatus())){
			return JsonVo.sendOk("报名等位成功,等位序号为："+activityEnroll.getWaitNum());
		}else{
			return JsonVo.sendOk("保存成功！");
		}

	}

	/**
	 * 验证
	 */
	@Transactional(readOnly = false)
	public JsonVo activityEnrollCheck(ActivityEnroll activityEnroll, Activity activity) {
		ActivityEnroll old = this.activityByMember(activityEnroll.getActivityId(), activityEnroll.getMemberId());
		if (old != null) {
			return JsonVo.sendError("您已报名，不能重复预约");
		}
		String mcId = null;
		if (StrUtils.notBlank(activity.getCardsTypeId())) {
			MemberCard cardWhere = new MemberCard();
			cardWhere.setCardsTypeId(activity.getCardsTypeId());
			cardWhere.setMemberId(activityEnroll.getMemberId());
			// 查询会员会员卡
			List<MemberCard> cardList = cardBiz.getMemberCardList(cardWhere);
			if (cardList.size() > 0) {
				for (MemberCard mCard : cardList) {
					// 判断余额
					if (mCard.getStoredNum() < activity.getCardNum()) {
						continue;
					}
					mcId = mCard.getId();
				}
				if (mcId == null) {
					return JsonVo.sendError("会员卡余额不足!");
				}
			} else {
				return JsonVo.sendError("没有满足条件的会员卡!");
			}
		}
		if (activityEnroll.getIsNewT()) {
			Double renNum = this.findUpperLimit(activityEnroll.getActivityId());
			if (activity.getPeopleMax() <= renNum) {
				activityEnroll.setEnrollStatus(ActivityEnroll.ENROLLSTATUS_4);
				ActivityEnroll enrollWhere = new ActivityEnroll();
				enrollWhere.setActivityId(activity.getId());
				enrollWhere.setEnrollStatus(ActivityEnroll.ENROLLSTATUS_4);
				List<ActivityEnroll> enrollList = this.findList(enrollWhere);
				activityEnroll.setWaitNum(Long.valueOf((enrollList.size() + 1) + ""));
			}
		}
		return JsonVo.sendOk();
	}

	/**
	 * 取消
	 */
	@Transactional(readOnly = false)
	public void updateEnrollStatus(ActivityEnroll activityEnroll) {
		activityEnroll = dao.getByEntity(activityEnroll);
		activityEnroll.setEnrollStatus(ActivityEnroll.ENROLLSTATUS_1);
		super.update(activityEnroll);
		
		//等位
		ActivityEnroll enrollWhere = new ActivityEnroll();
		enrollWhere.setActivityId(activityEnroll.getActivityId());
		enrollWhere.setEnrollStatus(ActivityEnroll.ENROLLSTATUS_4);
		List<ActivityEnroll> enrollList = super.findList(enrollWhere);
		ActivityEnroll updateActivityEnroll = new ActivityEnroll();
		for (int i = 0; i < enrollList.size(); i++) {
			if (i == 0) {
				dao.updateActivityEnroll(enrollList.get(i).getId());
				ActivityEnroll eActivityEnroll = enrollList.get(i);
				// 微信模板消息：会员报名通知
				Member member = memberBiz.get(eActivityEnroll.getMemberId());
				// 获取活动
				Activity activity = activityBiz.get(eActivityEnroll.getActivityId());
				if (member != null && StrUtils.notBlank(member.getOpenId())) {
					String comId = ComUtils.getCurrentComId();
					new Thread() {
						public void run() {
							try {
								List<String> data = ListUtils.newArrayList();
								data.add("您有一条预约活动通知!");
								data.add(activity.getName() + "\\n开始时间:" + DateUtils.formatDateTime(activity.getStartTime())
										+ "\\n结束时间:" + DateUtils.formatDateTime(activity.getEndTime()));
								data.add(DateUtils.getDateTime());
								data.add("点击查看详情");
								String url = ComUtils.getComUrl(comId, "/mobile#/pages/activityList/activityList?type=my");
								TplMsgUtils.sendMsg(comId, member.getOpenId(), url, TplMsgUtils.TPL_3, data);
							} catch (Exception e) {
								logger.error("预约通知失败", e);
							}
						}
					}.start();
				}
			} else {
				updateActivityEnroll = enrollList.get(i);
				updateActivityEnroll.setWaitNum(updateActivityEnroll.getWaitNum() - 1);
			}
			super.update(updateActivityEnroll);
		}

		// 微信模板消息：取消预约通知
		Member member = memberBiz.get(activityEnroll.getMemberId());
		if (member != null && StrUtils.notBlank(member.getOpenId())) {
			Activity activity = activityBiz.get(activityEnroll.getActivityId());
			String comId = ComUtils.getCurrentComId();
			new Thread() {
				public void run() {
					try {
						List<String> data = ListUtils.newArrayList();
						data.add("您有一条取消活动预约通知!");
						data.add(DateUtils.formatDate(activity.getStartTime()));
						data.add(DateUtils.formatTime(activity.getStartTime()));
						data.add(activity.getName());
						data.add("取消预约成功");
						String url = ComUtils.getComUrl(comId, "/mobile#/pages/activityList/activityList?type=my");
						TplMsgUtils.sendMsg(comId, member.getOpenId(), url, TplMsgUtils.TPL_4, data);

					} catch (Exception e) {
						logger.error("取消活动通知失败", e);
					}
				}
			}.start();
		}
	}

	/**
	 * 签到
	 */
	@Transactional(readOnly = false)
	public void qiandao(ActivityEnroll activityEnroll, MemberCard mc) {
		Member member = memberBiz.get(activityEnroll.getMemberId());
		// 活动签到积分
		ComConfig where = new ComConfig();
		where.setConfigKey("sign_send_points");
		where.setComId(ComUtils.getCurrentComId());
		ComConfig comConfig = comConfigBiz.getByEntity(where);
		if (comConfig != null && !"0".equals(comConfig.getConfigValue())) {
			member.setPoints(member.getPoints() + Long.valueOf(comConfig.getConfigValue()));
			memberBiz.save(member);

			// 积分记录
			Points points = new Points();
			points.setMemberId(activityEnroll.getMemberId());
			points.setBizId(activityEnroll.getId());
			points.setType(Points.TYPE_1);
			points.setBizType(Points.BIZTYPE_3);
			points.setNum(Long.valueOf(comConfig.getConfigValue()));
			pointsBiz.save(points);
		}

		// 改变签到状态
		activityEnroll.setIsSign(ActivityEnroll.isSign_1);
		activityEnroll.setSignTime(new Date());
		super.update(activityEnroll);

		// 课程有会员卡减少卡余额
		Activity activity = activityBiz.get(activityEnroll.getActivityId());
		if (StrUtils.notBlank(activity.getCardsTypeId()) && StrUtils.notBlank(mc)) {
			// 添加变更记录
			CardChange cardChange = new CardChange();
			cardChange.setMcId(mc.getId());
			cardChange.setMemberId(mc.getMemberId());
			cardChange.setType(CardChange.TYPE_1);
			cardChange.setStoredNum(activity.getCardNum());
			cardChange.setStoredNew(mc.getStoredNum());
			cardChangeBiz.xiaoFei(cardChange);
		}

		// 微信模板消息：签到通知
		if (StrUtils.notBlank(member.getOpenId())) {
			String comId = ComUtils.getCurrentComId();
			new Thread() {
				public void run() {
					try {
						String k3 = "活动签到成功";
						if (StrUtils.notBlank(mc)) {
							if (Cards.CARDS_TYPE_1.equals(mc.getCardsType())) {
								k3 = "消费" + activity.getCardNum() + "元  剩余"
										+ (mc.getStoredNum() - activity.getCardNum()) + "元";
							} else if (Cards.CARDS_TYPE_2.equals(mc.getCardsType())) {
								k3 = "消费" + activity.getCardNum() + "次  剩余"
										+ (mc.getStoredNum() - activity.getCardNum()) + "次";
							}
						}

						List<String> data = ListUtils.newArrayList();
						data.add("您有一条签到通知");
						data.add(member.getName());
						data.add(DateUtils.getDateTime());
						data.add(k3);
						data.add("签到活动：" + activity.getName());
						String url = ComUtils.getComUrl(comId, "/mobile#/pages/activityList/activityList?type=my");
						TplMsgUtils.sendMsg(comId, member.getOpenId(), url, TplMsgUtils.TPL_5, data);

					} catch (Exception e) {
						logger.error("签到通知失败", e);
					}
				}
			}.start();
		}
	}

	/**
	 * 查询是否重复预约
	 */
	public ActivityEnroll activityByMember(String activityId, String memberId) {
		return activityEnrollDao.getByMember(activityId, memberId);
	}

	/**
	 * 查询人数上限
	 */
	public Double findUpperLimit(String activityId) {
		return activityEnrollDao.findUpperLimit(activityId);
	}

	/**
	 * 修改等位
	 */
	public void updateActivityEnroll(String id) {
		activityEnrollDao.updateActivityEnroll(id);
	}

	/**
	 * 活动支付回调
	 * 
	 * @param payCode
	 */
	@Transactional(readOnly = false)
	public void payBack(String payCode, String wxId) {
		SysPay where = new SysPay();
		where.setPayCode(payCode);
		SysPay pay = sysPayDao.getByEntity(where);
		if (SysPay.PAY_STATUS_1.equals(pay.getPayStatus())) {
			// 更新支付状态
			pay.setPayStatus(SysPay.PAY_STATUS_2);
			pay.setPayTime(new Date());
			pay.setWxId(wxId);
			sysPayDao.update(pay);

			// 添加活动报名
			ActivityEnroll enroll = new ActivityEnroll();
			enroll.setActivityId(pay.getBizId());
			enroll.setMemberId(pay.getMemberId());
			enroll.setEnrollStatus(ActivityEnroll.ENROLLSTATUS_0);
			enroll.setEnrollTime(pay.getPayTime());
			enroll.setPayState(ActivityEnroll.PAY_STATE_2);

			// 判断是否等位
			Activity activity = activityBiz.get(pay.getBizId());
			Double renNum = this.findUpperLimit(activity.getId());
			if (activity.getPeopleMax() <= renNum) {
				enroll.setEnrollStatus(ActivityEnroll.ENROLLSTATUS_4);
				ActivityEnroll enrollWhere = new ActivityEnroll();
				enrollWhere.setActivityId(activity.getId());
				enrollWhere.setEnrollStatus(ActivityEnroll.ENROLLSTATUS_4);
				List<ActivityEnroll> enrollList = this.findList(enrollWhere);
				enroll.setWaitNum(Long.valueOf((enrollList.size() + 1) + ""));
			}else{
				// 微信模板消息：消费通知
				Member member = memberBiz.get(pay.getMemberId());
				String activityId = activity.getId();
				String comId = activity.getComId();
				String comName = ComUtils.getCurrentComName();
				if (member != null && StrUtils.notBlank(member.getOpenId())) {
					new Thread() {
						public void run() {
							try {
								List<String> data = ListUtils.newArrayList();
								data.add("您有一条活动消费通知!");
								data.add(DateUtils.getDateTime());
								data.add(activity.getName());
								data.add(activity.getMoney() + "");
								data.add(activityId);
								data.add(comName);
								data.add("点击查看详情");
								String url = ComUtils.getComUrl(comId, "/mobile#/pages/activityList/activityList?type=my");
								TplMsgUtils.sendMsg(comId, member.getOpenId(), url, TplMsgUtils.TPL_1, data);
							} catch (Exception e) {
								logger.error("消费通知失败", e);
							}
						}
					}.start();
				}
			}
			super.save(enroll);
			
			// 活动添加消费记录
			CashMoney cashMoney = new CashMoney();
			cashMoney.setBizId(enroll.getId());
			cashMoney.setBizType(CashMoney.BIZTYPE_COM_ACTIVITY_ENROLL);
			cashMoney.setMoney(pay.getPayMoney());
			cashMoney.setBuyType(CashMoney.BUYTYPE_43);
			cashMoney.setType(CashMoney.TYPE_4);
			cashMoneyBiz.save(cashMoney);

		}
	}

	/**
	 * 到店支付
	 */
	@Transactional(readOnly = false)
	public void savePy(ActivityEnroll activityEnroll) {
		super.update(activityEnroll);
		activityEnroll = get(activityEnroll.getId());
		Activity activity = activityBiz.get(activityEnroll.getActivityId());

		// 删除活动销售金额记录
		CashMoney where = new CashMoney();
		where.setBizId(activityEnroll.getId());
		where.setBizType(CashMoney.BIZTYPE_COM_ACTIVITY_ENROLL);
		where.setBuyType(CashMoney.BUYTYPE_13);
		where.setType(CashMoney.TYPE_1);
		where = cashMoneyBiz.getByEntity(where);
		if(where != null){
			cashMoneyBiz.delete(where);
		}
		
		// 销售金额
		CashMoney cashMoney = new CashMoney();
		cashMoney.setBizId(activityEnroll.getId());
		cashMoney.setBizType(CashMoney.BIZTYPE_COM_ACTIVITY_ENROLL);
		cashMoney.setMoney(activity.getMoney());
		cashMoney.setBuyType(CashMoney.BUYTYPE_13);
		cashMoney.setType(CashMoney.TYPE_1);
		cashMoney.setPayType(activityEnroll.getPayType());
		cashMoneyBiz.save(cashMoney);
	}
	
	/**
	 * 删除
	 */
	@Transactional(readOnly = false)
	public void delete(ActivityEnroll activityEnroll) {
		// 删除活动销售金额记录
		CashMoney where = new CashMoney();
		where.setBizId(activityEnroll.getId());
		where.setBizType(CashMoney.BIZTYPE_COM_ACTIVITY_ENROLL);
		where = cashMoneyBiz.getByEntity(where);
		cashMoneyBiz.delete(where);
		
		delete(activityEnroll);
	}

}
