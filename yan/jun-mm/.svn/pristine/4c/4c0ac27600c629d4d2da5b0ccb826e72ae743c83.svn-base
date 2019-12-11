package com.junkj.module.cash.entity;

import com.junkj.common.entity.BaseEntity;
import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;
import com.junkj.module.sys.entity.SysUser;

/**
 * 消费提成比例实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月28日
 */
@Table(name = "cash_buy_user", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "buy_id", attrName = "buyId"),
		@Column(name = "user_id", attrName = "userId"),
		@Column(name = "pay_money", attrName = "payMoney"),
		@Column(name = "goods_money", attrName = "goodsMonye"),
		@Column(name = "card_money", attrName = "cardMoney"),
		@Column(name = "ratio_user", attrName = "ratioUser"),
		@Column(name = "card_ratio_user", attrName = "cardRatioUser"),
		@Column(name = "ratio", attrName = "ratio"),
		@Column(name = "money", attrName = "money"),
		@Column(name = "create_id", attrName = "createId"),
		@Column(name = "create_time", attrName = "createTime", isQuery = false),
		@Column(name = "update_id", attrName = "updateId"),
		@Column(name = "update_time", attrName = "updateTime", isQuery = false), 
		@Column(includeEntity = BaseEntity.class)
	},joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysUser.class, alias = "s", on = "s.id = a.user_id", columns = {
			@Column(name = "name", attrName = "userName", queryType = QueryType.LIKE)
		})
	}, orderBy = "a.id DESC"
)
public class CashBuyUser extends DataEntity<CashBuyUser> {

	private static final long serialVersionUID = 1L;

	private String buyId; // 消费记录主键
	private String userId; // 提成用户id
	private Double payMoney; // 销售金额
	private Double goodsMonye; // 商品金额
	private Double cardMoney; // 会员卡金额
	private Long ratioUser; // 员工消费项目提成比例
	private Long cardRatioUser; // 员工会员卡提成比例
	private Long ratio; // 分成比例
	private Double money; // 提成金额
	
	//业务字段
	private String userName; // 公司ID

	public String getBuyId() {
		return buyId;
	}
	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	public Double getGoodsMonye() {
		return goodsMonye;
	}
	public void setGoodsMonye(Double goodsMonye) {
		this.goodsMonye = goodsMonye;
	}
	
	public Double getCardMoney() {
		return cardMoney;
	}
	public void setCardMoney(Double cardMoney) {
		this.cardMoney = cardMoney;
	}
	
	public Long getRatioUser() {
		return ratioUser;
	}
	public void setRatioUser(Long ratioUser) {
		this.ratioUser = ratioUser;
	}

	public Long getCardRatioUser() {
		return cardRatioUser;
	}
	public void setCardRatioUser(Long cardRatioUser) {
		this.cardRatioUser = cardRatioUser;
	}
	
	public Long getRatio() {
		return ratio;
	}
	public void setRatio(Long ratio) {
		this.ratio = ratio;
	}

	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}