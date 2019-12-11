package com.junkj.module.excel.entity;

import java.math.BigDecimal;


/**
 * 对应关系
 */
public class ExcelTplRelation2 {

	// 对应关系序号
	private Integer relationId;
	// 业务表CODE
	private String tableCode;
	// 列CODE
	private String colCode;
	// 列名称
	private String colName;
	// 排序
	private BigDecimal colSort;
	
	public Integer getRelationId() {
		return relationId;
	}
	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}
	public String getTableCode() {
		return tableCode;
	}
	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}
	public String getColCode() {
		return colCode;
	}
	public void setColCode(String colCode) {
		this.colCode = colCode;
	}
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	public BigDecimal getColSort() {
		return colSort;
	}
	public void setColSort(BigDecimal colSort) {
		this.colSort = colSort;
	}
	
}
