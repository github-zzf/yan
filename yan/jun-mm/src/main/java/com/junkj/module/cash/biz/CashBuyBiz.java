package com.junkj.module.cash.biz;

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
import com.junkj.common.lang.NumUtils;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.utils.ComUtils;
import com.junkj.common.utils.TplMsgUtils;
import com.junkj.module.cash.dao.CashBuyDao;
import com.junkj.module.cash.entity.CashBuy;
import com.junkj.module.cash.entity.CashBuyCard;
import com.junkj.module.cash.entity.CashBuyGoods;
import com.junkj.module.cash.entity.CashBuyUser;
import com.junkj.module.cash.entity.CashMoney;
import com.junkj.module.company.biz.CardsBiz;
import com.junkj.module.company.biz.ComConfigBiz;
import com.junkj.module.company.biz.ComMemberBiz;
import com.junkj.module.company.biz.StaffMoneySettingBiz;
import com.junkj.module.company.entity.Cards;
import com.junkj.module.company.entity.ComConfig;
import com.junkj.module.company.entity.ComMember;
import com.junkj.module.company.entity.StaffMoneySetting;
import com.junkj.module.demo.entity.DemoItem;
import com.junkj.module.member.biz.MemberBiz;
import com.junkj.module.member.biz.MemberCardBiz;
import com.junkj.module.member.biz.PointsBiz;
import com.junkj.module.member.entity.Member;
import com.junkj.module.member.entity.MemberCard;
import com.junkj.module.member.entity.Points;
import com.junkj.module.shop.biz.GoodsBiz;
import com.junkj.module.shop.entity.Goods;
import com.junkj.module.stock.biz.StockRecordBiz;
import com.junkj.module.stock.entity.StockRecord;
import com.junkj.module.stock.entity.StockRecordItem;

/**
 * 消费记录biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月28日
 */
@Service
@Transactional(readOnly = true)
public class CashBuyBiz extends CrudBiz<CashBuyDao, CashBuy> {

	@Autowired
	private CashBuyGoodsBiz cashBuyGoodsBiz;
	@Autowired
	private CashBuyCardBiz cashBuyCardBiz;
	@Autowired
	private CashBuyUserBiz cashBuyUserBiz;
	@Autowired
	private CashMoneyBiz cashMoneyBiz;
	@Autowired
	private MemberCardBiz memberCardBiz;
	@Autowired
	private StaffMoneySettingBiz staffMoneySettingBiz;
	@Autowired
	private CardsBiz cardsBiz;
	@Autowired
	private StockRecordBiz stockRecodBiz;
	@Autowired
	private MemberBiz memberBiz;
	@Autowired
	private ComMemberBiz comMemberBiz;
	@Autowired
	private PointsBiz pointsBiz;
	@Autowired
	private ComConfigBiz comConfigBiz;
	@Autowired
	private GoodsBiz goodsBiz;

	/**
	 * 分页数据
	 */
	@Override
	public Page<CashBuy> findPage(CashBuy cashBuy) {
		return super.findPage(cashBuy);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<CashBuy> findList(CashBuy cashBuy) {
		return super.findList(cashBuy);
	}

	/**
	 * 添加
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(CashBuy cashBuy) {
		// 获取消费积分比例
		ComConfig where = new ComConfig();
		where.setConfigKey("buy_send_points");
		where.setComId(ComUtils.getCurrentComId());
		ComConfig comConfig = comConfigBiz.getByEntity(where);
		if (comConfig != null && !"0".equals(comConfig.getConfigValue())) {
			ComMember comMember = comMemberBiz.get(cashBuy.getMemberId());
			Double payMoney = 0D;
			Double jifen = 0D;
			if (cashBuy.getIsNewT()) {
				// 积分增加
				payMoney = cashBuy.getPayMoney();
				jifen = NumUtils.multiply(payMoney, Double.valueOf(comConfig.getConfigValue()) / 100);
				comMember.setPoints(comMember.getPoints() + jifen.longValue());
				comMemberBiz.save(comMember);
			} else {
				CashBuy oldCashBuy = super.get(cashBuy.getId());
				payMoney = NumUtils.subtract(cashBuy.getPayMoney(), oldCashBuy.getPayMoney());
				jifen = NumUtils.multiply(payMoney, Double.valueOf(comConfig.getConfigValue()) / 100);
				comMember.setPoints(comMember.getPoints() + jifen.longValue());
				comMemberBiz.save(comMember);
			}
			// 积分记录
			if (payMoney != 0D) {
				Points points = new Points();
				points.setMemberId(cashBuy.getMemberId());
				points.setBizId(cashBuy.getId());
				points.setType(payMoney > 0 ? Points.TYPE_1 : Points.TYPE_2);
				points.setBizType(Points.BIZTYPE_1);
				points.setNum(Math.abs(jifen.longValue()));
				pointsBiz.save(points);
			}
			cashBuy.setPoints(jifen.longValue());
		}

		boolean isNew = cashBuy.getIsNewT();
		// 消费收银
		cashBuy.setType(CashBuy.TYPE_1);
		super.save(cashBuy);

		// 更新库存
		saveStockRecord(cashBuy.getId(), cashBuy.getCashBuyGoods());

		// 商品总金额
		Double proMoney = 0D;
		// 保存商品明细
		for (CashBuyGoods item : cashBuy.getCashBuyGoods()) {
			if (!DemoItem.STATUS_DELETE.equals(item.getStatus())) {
				item.setBuyId(cashBuy.getId());
				proMoney += item.getMoney();
				if (item.getIsNewT()) {
					item.preInsert();
					cashBuyGoodsBiz.insert(item);
				} else {
					item.preUpdate();
					cashBuyGoodsBiz.update(item);
				}
			} else {
				cashBuyGoodsBiz.delete(item);
			}
		}

		if (!isNew) {
			// 删除销售记录
			cashMoneyBiz.deleteByBizType("cash_buy", cashBuy.getId(), CashMoney.BUYTYPE_11);
		}
		// 添加商品销售金额记录
		CashMoney cashMoney = new CashMoney();
		cashMoney.setBizId(cashBuy.getId());
		cashMoney.setBizType(CashMoney.BIZTYPE_CASH_BUY);
		cashMoney.setMoney(proMoney);
		cashMoney.setBuyType(CashMoney.BUYTYPE_11);
		cashMoney.setType(CashMoney.TYPE_1);
		cashMoney.setPayType(cashBuy.getPayType());
		cashMoneyBiz.save(cashMoney);

		// 会员卡总金额
		Double caMoney = 0D;
		// 保存卡明细
		for (CashBuyCard buyCard : cashBuy.getCashBuyCard()) {
			if (!DemoItem.STATUS_DELETE.equals(buyCard.getStatus())) {
				buyCard.setBuyId(cashBuy.getId());
				caMoney += buyCard.getMoney();
				if (buyCard.getIsNewT()) {
					buyCard.preInsert();
					cashBuyCardBiz.insert(buyCard);

					// 获取会员卡
					Cards cards = cardsBiz.get(buyCard.getCardId());
					// 失效日期
					Calendar ca = Calendar.getInstance();
					ca.add(Calendar.DATE, cards.getDays());
					Date invalidTiem = ca.getTime();

					// 获取会员未失效的会员卡
					MemberCard mCard = memberCardBiz.getOkCard(ComUtils.getCurrentComId(), cashBuy.getMemberId(),
							buyCard.getCardId());
					if (mCard != null) {
						// 余额
						mCard.setStoredAll(mCard.getStoredAll() + cards.getStoredNum());
						mCard.setStoredNum(mCard.getStoredNum() + cards.getStoredNum());
						// 失效日期
						mCard.setInvalidTime(invalidTiem);
						// 更新时间
						mCard.setUpdateTime(DateUtils.getNow());
						memberCardBiz.update(mCard);
					} else {
						// 保存会员卡
						mCard = new MemberCard();
						mCard.setMemberId(cashBuy.getMemberId());
						mCard.setCardId(cards.getId());
						mCard.setCardName(cards.getName());
						mCard.setStoredAll(cards.getStoredNum() * buyCard.getNum());
						mCard.setStoredNum(cards.getStoredNum() * buyCard.getNum());
						mCard.setInvalidTime(invalidTiem);
						memberCardBiz.save(mCard);
					}

				} else {
					buyCard.preUpdate();
					cashBuyCardBiz.update(buyCard);
				}
			} else {
				cashBuyCardBiz.delete(buyCard);
			}
		}

		if (!isNew) {
			// 删除销售记录
			cashMoneyBiz.deleteByBizType("cash_buy", cashBuy.getId(), CashMoney.BUYTYPE_12);
		}
		// 添加会员卡销售金额记录
		cashMoney = new CashMoney();
		cashMoney.setBizId(cashBuy.getId());
		cashMoney.setBizType(CashMoney.BIZTYPE_CASH_BUY);
		cashMoney.setMoney(caMoney);
		cashMoney.setBuyType(CashMoney.BUYTYPE_12);
		cashMoney.setType(CashMoney.TYPE_1);
		cashMoney.setPayType(cashBuy.getPayType());
		cashMoneyBiz.save(cashMoney);

		// caMoney proMoney
		// 保存子表
		for (CashBuyUser item : cashBuy.getCashBuyUser()) {
			if (!DemoItem.STATUS_DELETE.equals(item.getStatus())) {
				// 提成计算
				StaffMoneySetting setting = staffMoneySettingBiz.getByUserId(item.getUserId());
				if (StrUtils.notBlank(setting)) {
					item.setRatioUser(setting.getRatio());
					item.setCardRatioUser(setting.getCardRatio());
					item.setCardMoney(caMoney * item.getCardRatioUser() / 100D);
					item.setGoodsMonye(proMoney * item.getRatioUser() / 100D);

					Double money = (item.getCardMoney() + item.getGoodsMonye()) * item.getRatio() / 100D;
					item.setMoney(money);
				}
				item.setBuyId(cashBuy.getId());
				item.setPayMoney(cashBuy.getPayMoney());
				if (item.getIsNewT()) {
					item.preInsert();
					cashBuyUserBiz.insert(item);
				} else {
					item.preUpdate();
					cashBuyUserBiz.update(item);
				}
			} else {
				cashBuyUserBiz.delete(item);
			}
		}

		// 微信模板消息：消费通知
		Member member = memberBiz.get(cashBuy.getMemberId());
		if (member != null && StrUtils.notBlank(member.getOpenId())) {
			String comId = ComUtils.getCurrentComId();
			new Thread() {
				public void run() {
					try {
						List<String> data = ListUtils.newArrayList();
						data.add("您有一条消费通知!");
						data.add(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
						StringBuffer cou = new StringBuffer();
						// 商品信息
						for (CashBuyGoods cashBuyGoods : cashBuy.getCashBuyGoods()) {
							Goods goods = goodsBiz.get(cashBuyGoods.getGoodsId());
							cou.append(goods.getName() + "*" + cashBuyGoods.getNum());
						}
						// 卡信息
						for (CashBuyCard cashBuyCard : cashBuy.getCashBuyCard()) {
							Cards cards = cardsBiz.get(cashBuyCard.getCardId());
							cou.append(cards.getName() + "*" + cashBuyCard.getNum());
						}
						// 订单商品
						data.add(cou.toString());
						data.add(cashBuy.getPayMoney().toString());
						data.add(cashBuy.getId());
						data.add(ComUtils.getCurrentComName());
						data.add("点击查看详情");
						String url = ComUtils.getComUrl(comId, "/mobile#/pages/nav/myCard/myCard");
						TplMsgUtils.sendMsg(comId, member.getOpenId(), url, TplMsgUtils.TPL_1, data);
					} catch (Exception e) {
						e.printStackTrace();
						logger.error("消费通知失败", e);
					}
				}
			}.start();
		}
	}

	/**
	 * 通过消费记录添加出库记录
	 */
	public void saveStockRecord(String buyId, List<CashBuyGoods> cashBuyGoods) {
		List<StockRecordItem> recordList = ListUtils.newArrayList();
		// 减库存
		StockRecordItem recordItem = null;
		for (CashBuyGoods item : cashBuyGoods) {
			recordItem = new StockRecordItem();
			recordItem.setGoodsId(item.getGoodsId());

			if (!DemoItem.STATUS_DELETE.equals(item.getStatus())) {
				if (item.getIsNewT()) {
					// 添加
					recordItem.setNum(item.getNum());
				} else {
					// 修改
					CashBuyGoods old = cashBuyGoodsBiz.get(item.getId());
					if (old.getGoodsId().equals(item.getGoodsId())) {
						// 不修改商品
						recordItem.setNum(item.getNum() - old.getNum());
					} else {
						recordItem.setNum(item.getNum());
						// 修改商品添加还原记录
						StockRecordItem oldItem = new StockRecordItem();
						oldItem.setGoodsId(old.getGoodsId());
						oldItem.setNum(-old.getNum());
						recordList.add(oldItem);
					}
				}
				if (item.getNum() != 0) {
					recordList.add(recordItem);
				}
			} else {
				// 删除
				if (StrUtils.notBlank(item.getId())) {
					recordItem.setNum(-item.getNum());
					recordList.add(recordItem);
				}
			}
		}
		if (recordList.size() > 0) {
			StockRecord record = new StockRecord();
			record.setBizId(buyId);
			record.setBizType(StockRecord.BIZ_CASH_BUY);
			record.setRecordType(StockRecord.RECORD_TYPE_2);
			record.setRemark("消费收银变更库存");
			record.setStockRecordItem(recordList);
			stockRecodBiz.save(record);
		}
	}

}
