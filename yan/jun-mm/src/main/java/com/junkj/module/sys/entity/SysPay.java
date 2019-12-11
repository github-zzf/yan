package com.junkj.module.sys.entity;

import java.util.Date;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.Table;

@Table(name = "sys_pay", alias = "a",columns = {
		@Column(name = "id", attrName = "id",isPK = true),
		@Column(name = "pay_id", attrName = "payId"),
		@Column(name = "wx_id", attrName = "wxId"),
		@Column(name = "member_id", attrName = "memberId"),
		@Column(name = "pay_code", attrName = "payCode"),
		@Column(name = "biz_id", attrName = "bizId"),
		@Column(name = "biz_type", attrName = "bizType"), 
		@Column(name = "pay_status", attrName = "payStatus"), 
		@Column(name = "pay_type", attrName = "payType"), 
		@Column(name = "pay_money", attrName = "payMoney"), 
		@Column(name = "pay_time", attrName = "payTime"), 
		@Column(name = "create_time", attrName = "createTime"), 
		@Column(name = "update_time", attrName = "updateTime"), 
	})
public class SysPay extends DataEntity<SysPay> {
private static final long serialVersionUID = 1L;
	
	private String payId; 
	private String wxId; 
	private String memberId; 
	private String payCode; //支付单号
	private String bizId;  //关联id
	private String bizType;//关联类型(1储值储次、2活动)
	private String payStatus;  //支付状态(1待支付、2已支付、3已退款)
	private String payType; //支付方式(1微信、2支付宝、3银联支付、4下线支付）
	private Double payMoney; //支付金额
	private Date payTime;  //支付时间

	/**
	 * 1会员卡
	 */
	public static final String BIZ_TYPE_KA = "1";

	/**
	 * 2活动
	 */
	public static final String BIZ_TYPE_HD = "2";
	
	/**
	 * 1微信
	 */
	public static final String PAY_TYPE_1 = "1";

	/**
	 * 2支付宝
	 */
	public static final String PAY_TYPE_2 = "2";

	/**
	 * 3银联支付
	 */
	public static final String PAY_TYPE_3 = "3";
	
	/**
	 * 1待支付
	 */
	public static final String PAY_STATUS_1 = "1";

	/**
	 * 2已支付
	 */
	public static final String PAY_STATUS_2 = "2";

	/**
	 * 3已退款
	 */
	public static final String PAY_STATUS_3 = "3";
	
	
	
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getWxId() {
		return wxId;
	}
	public void setWxId(String wxId) {
		this.wxId = wxId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPayCode() {
		return payCode;
	}
	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}
	public String getBizId() {
		return bizId;
	}
	public void setBizId(String bizId) {
		this.bizId = bizId;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public Double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	
	
	
}
