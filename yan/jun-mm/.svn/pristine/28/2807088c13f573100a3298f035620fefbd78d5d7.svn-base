package com.junkj.module.member.entity;

import com.junkj.common.entity.BaseEntity;
import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.Table;

/**
 * 会员卡记录实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月27日
 * @version: 1.0.0
 */
@Table(name = "member_card_user", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "change_id", attrName = "changeId"),
		@Column(name = "user_id", attrName = "userId"),
		@Column(name = "stored_num", attrName = "storedNum"),
		@Column(includeEntity = BaseEntity.class) 
	}, orderBy = "a.id DESC")
public class CardUser extends DataEntity<CardUser> {

	private static final long serialVersionUID = 1L;

	private String changeId; // 消费记录主键
	private String userId; // 提成用户id
	private Double storedNum; // 次数/金额

	public String getChangeId() {
		return changeId;
	}

	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Double getStoredNum() {
		return storedNum;
	}

	public void setStoredNum(Double storedNum) {
		this.storedNum = storedNum;
	}

}