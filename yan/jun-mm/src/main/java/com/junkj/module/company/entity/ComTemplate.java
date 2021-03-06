package com.junkj.module.company.entity;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;
import com.junkj.module.sys.entity.SysTemplate;

/**
 * 企业模板消息实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月07日
 * @version: 1.0.0
 */
@Table(name = "com_template", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "com_id", attrName = "comId", isUpdate = false),
		@Column(name = "tpl_code", attrName = "tplCode"),
		@Column(name = "tpl_id", attrName = "tplId"),
		@Column(name = "create_id", attrName = "createId"),
		@Column(name = "create_time", attrName = "createTime", isQuery = false),
		@Column(name = "update_id", attrName = "updateId"),
		@Column(name = "update_time", attrName = "updateTime", isQuery = false)
	}, joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysTemplate.class, alias = "b", on = "b.tpl_code = a.tpl_code", columns = {
			@Column(name = "tpl_name", attrName = "tplName", queryType = QueryType.LIKE),
			@Column(name = "tpl_params", attrName = "tplParams", queryType = QueryType.LIKE),
			@Column(name = "remark", attrName = "remark", queryType = QueryType.LIKE)
		})
	}, orderBy = "a.id DESC"
)
public class ComTemplate extends DataEntity<ComTemplate> {

	private static final long serialVersionUID = 1L;

	private String tplCode; // 模板编码
	private String tplId; // 模板ID

	// 关联字段
	private String tplName; // 模板消息名称
	private String tplParams; // 模板消息名称
	private String remark; // 模板编码

	public String getTplCode() {
		return tplCode;
	}

	public void setTplCode(String tplCode) {
		this.tplCode = tplCode;
	}

	public String getTplId() {
		return tplId;
	}

	public void setTplId(String tplId) {
		this.tplId = tplId;
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