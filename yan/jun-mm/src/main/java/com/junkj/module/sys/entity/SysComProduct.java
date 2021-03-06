package com.junkj.module.sys.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.junkj.common.entity.BaseEntity;
import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;

/**
 * 消费记录实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Table(name = "sys_com_product", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "com_id", attrName = "comId"),
		@Column(name = "product_id", attrName = "productId"),
		@Column(name = "start_time", attrName = "startTime"),
		@Column(name = "end_time", attrName = "endTime"),
		@Column(includeEntity = DataEntity.class)
	}, joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysCompany.class, alias = "b", on = "b.com_id = a.com_id", columns = {
			@Column(name = "com_name", attrName = "comNames", queryType = QueryType.EQ) 
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysProduct.class, alias = "c", on = "c.id = a.product_id", columns = {
			@Column(name = "name", attrName = "productName", queryType = QueryType.LIKE)
		})
	}, orderBy = "a.id DESC"
)
public class SysComProduct extends DataEntity<SysComProduct> {

	private static final long serialVersionUID = 1L;

	private String productId; // 产品
	private Date startTime; // 开始时间
	private Date endTime; // 结束时间
	private String remark; // 备注
	
	// 业务字段
	private String productName; // 产品Name
	private String comNames; // 企业Name

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getComNames() {
		return comNames;
	}
	public void setComNames(String comNames) {
		this.comNames = comNames;
	}

}