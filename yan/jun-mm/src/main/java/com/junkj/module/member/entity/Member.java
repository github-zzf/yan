package com.junkj.module.member.entity;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;
import com.junkj.module.company.entity.ComMember;
import com.junkj.module.sys.entity.SysBeanData;
import com.junkj.module.weixin.entity.WxUser;

/**
 * 会员实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月27日
 */
@Table(name = "member", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "open_id", attrName = "openId", queryType= QueryType.LIKE),
		@Column(name = "name", attrName = "name", queryType= QueryType.LIKE),
		@Column(name = "phone", attrName = "phone", queryType= QueryType.LIKE),
		@Column(name = "qq", attrName = "qq", queryType= QueryType.LIKE),
		@Column(name = "email", attrName = "email", queryType= QueryType.LIKE),
		@Column(name = "address", attrName = "address"),
		@Column(name = "sex", attrName = "sex"),
		@Column(name = "birthday", attrName = "birthday")
	}, joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = ComMember.class, alias = "cm", on = "cm.member_id = a.id ", columns = {
			@Column(name = "com_id", attrName = "comId", isUpdate = false),
			@Column(name = "level_id", attrName = "levelId", isUpdate = false),
			@Column(name = "points", attrName = "points", isUpdate = false),
			@Column(name = "source", attrName = "source", isUpdate = false),
			@Column(name = "remark", attrName = "remark", isUpdate = false),
			@Column(name = "create_id", attrName = "createId"),
			@Column(name = "create_time", attrName = "createTime"),
			@Column(name = "update_id", attrName = "updateId"),
			@Column(name = "update_time", attrName = "updateTime")
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = Level.class, alias = "b", on = "b.id = cm.level_id ", columns = {
			@Column(name = "name", attrName = "levelTxt", queryType = QueryType.LIKE),
			@Column(name = "ratio", attrName = "levelRatio")
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysBeanData.class, alias = "c", on = "c.bean_key='member_source' and c.bean_val = cm.source", columns = {
			@Column(name = "bean_txt", attrName = "sourceTxt", queryType = QueryType.LIKE)
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = WxUser.class, alias = "wu", on = "wu.member_id = a.id", columns = {
			@Column(name = "head_img", attrName = "headImg", queryType = QueryType.LIKE)
		})
	}, orderBy = "a.id DESC"
)
public class Member extends DataEntity<Member> {

	private static final long serialVersionUID = 1L;

	private String openId; // 用户openId
	private String name; // 姓名
	private String phone; // 手机
	private String qq; // QQ
	private String email; // 电子邮件
	private String address; // 地址
	private String sex; // 性别
	private String birthday; // 生日
	
	// 企业会员字段
	private String levelId; // 会员级别
	private Long points; // 积分
	private String source; // 来源（1店内、2微信）
	private String remark; // 备注
	private String h1; // 
	private String h2; // 
	private String h3; // 
	private String h4; // 
	private String h5; // 
	private String h6; // 
	private String h7; // 
	private String h8; // 
	private String h9; // 
	private String h10; // 
	private String h11; // 
	private String h12; // 
	private String h13; // 
	private String h14; // 
	private String h15; // 
	private String h16; // 
	private String h17; // 
	private String h18; // 
	private String h19; // 
	private String h20; // 
	
	// 业务字段
	private String headImg; // 头像
	private String levelTxt; // 会员级别
	private String sourceTxt; // 来源
	private String levelRatio; // 折扣率
	private Long newPoints; // 添加积分
	
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	@Length(min=0, max=32, message="会员级别长度不能超过32个字符")
	public String getLevelId() {
		return levelId;
	}
	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}
	
	@NotEmpty(message="姓名不能为空")
	@Length(min=0, max=10, message="会员姓名长度不能超过20个字符")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotEmpty(message="手机不能为空")
	@Length(min=0, max=30, message="手机长度不能超过30个字符")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=30, message="QQ长度不能超过30个字符")
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	@Length(min=0, max=30, message="电子邮箱长度不能超过30个字符")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=60, message="地址长度不能超过60个字符")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Long getPoints() {
		return points;
	}
	public void setPoints(Long points) {
		this.points = points;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getH1() {
		return h1;
	}
	public void setH1(String h1) {
		this.h1 = h1;
	}
	public String getH2() {
		return h2;
	}
	public void setH2(String h2) {
		this.h2 = h2;
	}
	public String getH3() {
		return h3;
	}
	public void setH3(String h3) {
		this.h3 = h3;
	}
	public String getH4() {
		return h4;
	}
	public void setH4(String h4) {
		this.h4 = h4;
	}
	public String getH5() {
		return h5;
	}
	public void setH5(String h5) {
		this.h5 = h5;
	}
	public String getH6() {
		return h6;
	}
	public void setH6(String h6) {
		this.h6 = h6;
	}
	public String getH7() {
		return h7;
	}
	public void setH7(String h7) {
		this.h7 = h7;
	}
	public String getH8() {
		return h8;
	}
	public void setH8(String h8) {
		this.h8 = h8;
	}
	public String getH9() {
		return h9;
	}
	public void setH9(String h9) {
		this.h9 = h9;
	}
	public String getH10() {
		return h10;
	}
	public void setH10(String h10) {
		this.h10 = h10;
	}
	public String getH11() {
		return h11;
	}
	public void setH11(String h11) {
		this.h11 = h11;
	}
	public String getH12() {
		return h12;
	}
	public void setH12(String h12) {
		this.h12 = h12;
	}
	public String getH13() {
		return h13;
	}
	public void setH13(String h13) {
		this.h13 = h13;
	}
	public String getH14() {
		return h14;
	}
	public void setH14(String h14) {
		this.h14 = h14;
	}
	public String getH15() {
		return h15;
	}
	public void setH15(String h15) {
		this.h15 = h15;
	}
	public String getH16() {
		return h16;
	}
	public void setH16(String h16) {
		this.h16 = h16;
	}
	public String getH17() {
		return h17;
	}
	public void setH17(String h17) {
		this.h17 = h17;
	}
	public String getH18() {
		return h18;
	}
	public void setH18(String h18) {
		this.h18 = h18;
	}
	public String getH19() {
		return h19;
	}
	public void setH19(String h19) {
		this.h19 = h19;
	}
	public String getH20() {
		return h20;
	}
	public void setH20(String h20) {
		this.h20 = h20;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getLevelTxt() {
		return levelTxt;
	}
	public void setLevelTxt(String levelTxt) {
		this.levelTxt = levelTxt;
	}
	public String getSourceTxt() {
		return sourceTxt;
	}
	public void setSourceTxt(String sourceTxt) {
		this.sourceTxt = sourceTxt;
	}
	public String getLevelRatio() {
		return levelRatio;
	}
	public void setLevelRatio(String levelRatio) {
		this.levelRatio = levelRatio;
	}
	public Long getNewPoints() {
		return newPoints;
	}
	public void setNewPoints(Long newPoints) {
		this.newPoints = newPoints;
	}
	

}