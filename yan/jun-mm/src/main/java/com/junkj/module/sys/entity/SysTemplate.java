package com.junkj.module.sys.entity;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.Table;

/**
 * 参数配置实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月07日
 * @version: 1.0.0
 */
@Table(name = "sys_template", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "tpl_code", attrName = "tplCode"),
		@Column(name = "tpl_name", attrName = "tplName"),
		@Column(name = "tpl_params", attrName = "tplParams"),
		@Column(name = "remark", attrName = "remark"),
		@Column(name = "create_id", attrName = "createId"),
		@Column(name = "create_time", attrName = "createTime", isQuery = false),
		@Column(name = "update_id", attrName = "updateId"),
		@Column(name = "update_time", attrName = "updateTime", isQuery = false)
	}, orderBy = "a.id DESC"
)
public class SysTemplate extends DataEntity<SysTemplate> {

	private static final long serialVersionUID = 1L;

	private String tplCode; // 模板编码
	private String tplName; // 模板名称
	private String tplParams; // 参数值
	private String remark; // 参数说明


	public String getTplCode() {
		return tplCode;
	}
	public void setTplCode(String tplCode) {
		this.tplCode = tplCode;
	}

	public String getTplName() {
		return tplName;
	}
	public void setTplName(String tplName) {
		this.tplName = tplName;
	}

	public String getTplParams() {
		return tplParams;
	}
	public void setTplParams(String tplParams) {
		this.tplParams = tplParams;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}