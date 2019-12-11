package com.junkj.module.sys.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;

/**
 * 平台产品实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Table(name = "sys_product", alias = "a", columns = {
		@Column(name = "id", attrName = "id",isPK = true),
		@Column(name = "name", attrName = "name"),
		@Column(name = "price", attrName = "price"),
		@Column(name = "days", attrName = "days"),
		@Column(name = "sort", attrName = "sort"),
		@Column(name = "remark", attrName = "remark"),
		@Column(name = "content", attrName = "content"),
		@Column(name = "update_id", attrName = "updateId"),
		@Column(name = "update_time", attrName = "updateTime")
	},
	joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysUser.class, alias = "b", on = "b.id = a.update_id", columns = {
			@Column(name = "name", attrName = "updateName", queryType = QueryType.LIKE)
		})
	},orderBy = "a.id DESC"
)
public class SysProduct extends DataEntity<SysProduct> {

	private static final long serialVersionUID = 1L;

	private String name; // 产品名称
	private Double price; // 销售价格
	private Integer days; // 产品天数
	private Long sort; // 排序
	private String remark; // 备注
	private String content; // 产品过期提醒

	@NotEmpty(message="产品名称不能为空")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@NotNull(message="销售价格不能为空")
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@NotNull(message="产品天数不能为空")
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}

	public Long getSort() {
		return sort;
	}
	public void setSort(Long sort) {
		this.sort = sort;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}