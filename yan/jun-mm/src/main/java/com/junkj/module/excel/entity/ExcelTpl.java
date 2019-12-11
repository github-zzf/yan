package com.junkj.module.excel.entity;

import java.util.Date;

import com.junkj.common.entity.DataEntity;

/**
 * 模版
 */
public class ExcelTpl extends DataEntity<ExcelTpl> {

	// 模版ID
	private Integer tplId;
	// 业务表CODE
	private String tableCode;
	// 模版类型（1EXCEL；2XML；3其他）
	private String tplType;
	// 模版名称
	private String tplName;
	// 标题行
	private Integer titleIndex;
	// 是否默认(0否，1是)
	private String usable;
	// 系统时间
	private Date sysDate;

	public Integer getTplId() {
		return tplId;
	}

	public void setTplId(Integer tplId) {
		this.tplId = tplId;
	}

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public String getTplType() {
		return tplType;
	}

	public void setTplType(String tplType) {
		this.tplType = tplType;
	}

	public String getTplName() {
		return tplName;
	}

	public void setTplName(String tplName) {
		this.tplName = tplName;
	}

	public Integer getTitleIndex() {
		return titleIndex;
	}

	public void setTitleIndex(Integer titleIndex) {
		this.titleIndex = titleIndex;
	}

	public String getUsable() {
		return usable;
	}

	public void setUsable(String usable) {
		this.usable = usable;
	}

	public Date getSysDate() {
		return sysDate;
	}

	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

}