package com.junkj.common.entity;

import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;

@Table(columns = {
		@Column(name = "parent_id", attrName = "parentId"),
		@Column(name = "parent_ids", attrName = "parentIds", queryType = QueryType.LIKE),
		@Column(name = "tree_sort", attrName = "treeSort"),
		@Column(name = "tree_sorts", attrName = "treeSorts"),
		@Column(name = "tree_leaf", attrName = "treeLeaf"),
		@Column(name = "tree_level", attrName = "treeLevel"),
		@Column(name = "tree_names", attrName = "treeNames", queryType = QueryType.LIKE),
	}
)
public abstract class TreeEntity<T extends TreeEntity<?>> extends DataEntity<T> {

	private static final long serialVersionUID = 1L;
    public static final String ROOT_ID = "0";

	private String parentId; // 父级编号
	private String parentIds; // 所有父级编号
	private Double treeSort; // 本级排序号（升序）
	private String treeSorts; // 所有级别排序号
	private String treeLeaf; // 是否最末级
	private Double treeLevel; // 层次级别
	private String treeNames; // 全节点名
	
	private String parentName; // 父节点名称
	
	public abstract String getTreeName();
	
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentIds() {
		return parentIds;
	}
	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	public Double getTreeSort() {
		return treeSort;
	}
	public void setTreeSort(Double treeSort) {
		this.treeSort = treeSort;
	}
	public String getTreeSorts() {
		return treeSorts;
	}
	public void setTreeSorts(String treeSorts) {
		this.treeSorts = treeSorts;
	}
	public String getTreeLeaf() {
		return treeLeaf;
	}
	public void setTreeLeaf(String treeLeaf) {
		this.treeLeaf = treeLeaf;
	}
	public Double getTreeLevel() {
		return treeLevel;
	}
	public void setTreeLevel(Double treeLevel) {
		this.treeLevel = treeLevel;
	}
	public String getTreeNames() {
		return treeNames;
	}
	public void setTreeNames(String treeNames) {
		this.treeNames = treeNames;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}
