package com.junkj.module.excel.entity;

import java.util.Date;

/**
 * 校验规则
 */
public class ExcelColRule {

	// 业务表CODE
	private String tableCode;
	// 列CODE
	private String colCode;
	// 校验类型
	private String ruleType;
	// 校验值
	private String ruleValue;
	// 提示信息
	private String ruleMsg;
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

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getRuleValue() {
		return ruleValue;
	}

	public void setRuleValue(String ruleValue) {
		this.ruleValue = ruleValue;
	}

	public String getRuleMsg() {
		return ruleMsg;
	}

	public void setRuleMsg(String ruleMsg) {
		this.ruleMsg = ruleMsg;
	}

	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

}