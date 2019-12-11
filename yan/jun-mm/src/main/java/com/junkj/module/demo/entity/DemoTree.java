package com.junkj.module.demo.entity;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.entity.TreeEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;

/**
 * 示例树实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月07日
 * @version: 1.0.0
 */
@Table(name = "demo_tree", alias = "a", columns = {
		@Column(name = "com_id", attrName = "comId", isPK = true),
		@Column(name = "com_name", attrName = "comName"),
		@Column(name = "full_name", attrName = "fullName"),
		@Column(includeEntity = TreeEntity.class),
		@Column(includeEntity = DataEntity.class)
	}, joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = DemoTree.class, alias = "b", on = "b.com_id = a.parent_id", columns = {
			@Column(name = "com_name", attrName = "parentName", queryType = QueryType.LIKE)
		}),
	}, orderBy = "a.tree_sorts, a.com_id"
)
public class DemoTree extends TreeEntity<DemoTree> {

	private static final long serialVersionUID = 1L;

	private String comId; // 公司编码
	private String comName; // 公司名称
	private String fullName; // 公司全称

	@Override
	public String getTreeName() {
		return this.comName;
	}

	public String getComId() {
		return comId;
	}

	public void setComId(String comId) {
		this.comId = comId;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}