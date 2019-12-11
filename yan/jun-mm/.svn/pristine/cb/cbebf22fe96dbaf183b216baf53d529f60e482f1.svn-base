package com.junkj.module.sys.entity;

import javax.validation.constraints.NotEmpty;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;

/**
 * 企业实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Table(name = "sys_company", alias = "a", columns = {
		@Column(name = "com_id", attrName = "comId", isPK = true),
		@Column(name = "com_name", attrName = "comName"),
		@Column(name = "contacts", attrName = "contacts"),
		@Column(name = "phone", attrName = "phone",queryType = QueryType.LIKE),
		@Column(name = "email", attrName = "email", queryType = QueryType.LIKE),
		@Column(name = "qq", attrName = "qq", queryType = QueryType.LIKE),
		@Column(name = "wx", attrName = "wx", queryType = QueryType.LIKE),
		@Column(name = "x", attrName = "x"),
		@Column(name = "y", attrName = "y"),
		@Column(name = "area_id", attrName = "areaId"),
		@Column(name = "address", attrName = "address"),
		@Column(name = "remark", attrName = "remark"),
		@Column(name = "create_id", attrName = "createId"),
		@Column(name = "create_time", attrName = "createTime"),
		@Column(name = "update_id", attrName = "updateId"),
		@Column(name = "update_time", attrName = "updateTime")
	},
	joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysUser.class, alias = "b", on = "b.id = a.update_id", columns = {
			@Column(name = "name", attrName = "updateName", queryType = QueryType.LIKE)
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysArea.class, alias = "s", on = "s.id = a.area_id", columns = {
				@Column(name = "name", attrName = "areaName", queryType = QueryType.LIKE)
		})
	},orderBy = "a.create_time DESC"
)
public class SysCompany extends DataEntity<SysCompany> {

	private static final long serialVersionUID = 1L;

	private String comId; // 企业编码
	private String comName; // 企业名称
	private String contacts; // 联系人
	private String phone; // 联系电话
	private String email; // 电子邮箱
	private String qq; // QQ
	private String wx; // 微信
	private Double x; // 经度
	private Double y; // 纬度
	private String areaId; // 行政区
	private String address; // 详细地址
	private String remark; // 备注
	
	//业务字段
	private String areaName; // 行政区名称	
	
	@NotEmpty(message="企业编码不能为空")
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}

	@NotEmpty(message="企业名称不能为空")
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	
	@NotEmpty(message="联系人不能为空")
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	@NotEmpty(message="联系电话不能为空")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWx() {
		return wx;
	}
	public void setWx(String wx) {
		this.wx = wx;
	}
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}

	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}