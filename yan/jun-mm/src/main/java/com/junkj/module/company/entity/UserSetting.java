package com.junkj.module.company.entity;

import java.util.Date;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.Table;

/**
 * 企业用户设置实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月27日
 * @version: 1.0.0
 */
@Table(name = "com_sys_user_setting", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "ent_user_id", attrName = "entUserId"),
		@Column(name = "ratio", attrName = "ratio"),
		@Column(name = "bonus", attrName = "bonus"),
		@Column(name = "star1", attrName = "star1"),
		@Column(name = "star2", attrName = "star2"),
		@Column(name = "star3", attrName = "star3"),
		@Column(name = "star4", attrName = "star4"),
		@Column(name = "star5", attrName = "star5"),
		@Column(name = "enroll_msg", attrName = "enrollMsg"),
		@Column(name = "census_msg", attrName = "censusMsg"),
		@Column(name = "create_id", attrName = "createId"),
		@Column(name = "create_time", attrName = "createTime"),
		@Column(name = "update_id", attrName = "updateId"),
		@Column(name = "update_time", attrName = "updateTime"),
	}, orderBy = "a.id DESC"
)
public class UserSetting extends DataEntity<UserSetting> {

	private static final long serialVersionUID = 1L;

	private String entUserId; // 
	private Long ratio; // 提成比例
	private Long bonus; // 课时奖金
	private Long star1; // 一星奖金
	private Long star2; // 二星奖金
	private Long star3; // 三星奖金
	private Long star4; // 四星奖金
	private Long star5; // 五星奖金
	private String enrollMsg; // 预约通知(0不通知、1通知)
	private String censusMsg; // 统计通知(0不通知、1通知)


	public String getEntUserId() {
		return entUserId;
	}
	public void setEntUserId(String entUserId) {
		this.entUserId = entUserId;
	}

	public Long getRatio() {
		return ratio;
	}
	public void setRatio(Long ratio) {
		this.ratio = ratio;
	}

	public Long getBonus() {
		return bonus;
	}
	public void setBonus(Long bonus) {
		this.bonus = bonus;
	}

	public Long getStar1() {
		return star1;
	}
	public void setStar1(Long star1) {
		this.star1 = star1;
	}

	public Long getStar2() {
		return star2;
	}
	public void setStar2(Long star2) {
		this.star2 = star2;
	}

	public Long getStar3() {
		return star3;
	}
	public void setStar3(Long star3) {
		this.star3 = star3;
	}

	public Long getStar4() {
		return star4;
	}
	public void setStar4(Long star4) {
		this.star4 = star4;
	}

	public Long getStar5() {
		return star5;
	}
	public void setStar5(Long star5) {
		this.star5 = star5;
	}

	public String getEnrollMsg() {
		return enrollMsg;
	}
	public void setEnrollMsg(String enrollMsg) {
		this.enrollMsg = enrollMsg;
	}

	public String getCensusMsg() {
		return censusMsg;
	}
	public void setCensusMsg(String censusMsg) {
		this.censusMsg = censusMsg;
	}

}