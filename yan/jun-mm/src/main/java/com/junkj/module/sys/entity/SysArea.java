package com.junkj.module.sys.entity;


import com.junkj.common.entity.TreeEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;

/**
 * 行政区实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Table(name = "sys_area", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "name", attrName = "name"),
		@Column(name = "remark", attrName = "remark"),
		@Column(includeEntity = TreeEntity.class)
	},joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysArea.class, alias = "s", on = "s.id = a.parent_id", columns = {
			@Column(name = "name", attrName = "parentName", queryType = QueryType.LIKE)
		}),
	}, orderBy = "a.tree_sorts, a.tree_sort"
)
public class SysArea extends TreeEntity<SysArea> {

	private static final long serialVersionUID = 1L;

	private String name; // 地址名称
	private String remark; // 备注


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String getTreeName() {
		return this.name;
	}

}