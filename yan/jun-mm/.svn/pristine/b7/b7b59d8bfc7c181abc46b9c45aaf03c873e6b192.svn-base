package com.junkj.module.sys.entity;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.Table;

/**
 * 参数配置实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019-08-25
 */
@Table(name = "sys_role", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "name", attrName = "name"),
		@Column(name = "pid", attrName = "pid"),
		@Column(name = "remark", attrName = "remark")
	}, orderBy = "a.id DESC"
)
public class SysAddress extends DataEntity<SysAddress> {

	private static final long serialVersionUID = 1L;
	private String name;
	private String pid;
	private String remark;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}