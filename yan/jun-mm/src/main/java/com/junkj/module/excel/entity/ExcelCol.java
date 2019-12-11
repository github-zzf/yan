package com.junkj.module.excel.entity;

import java.util.Date;

/**
 * 业务表列
 */
public class ExcelCol {

	// 业务表CODE
	private String tableCode;
	// 列CODE
	private String colCode;
	// 列名称
	private String colName;
	// 列java类型
	private String colType;
	// 排序
	private Integer colSort;
	// 系统时间
	private Date sysDate;

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

	public String getColType() {
		return colType;
	}

	public void setColType(String colType) {
		this.colType = colType;
	}

	public Integer getColSort() {
		return colSort;
	}

	public void setColSort(Integer colSort) {
		this.colSort = colSort;
	}

	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

}