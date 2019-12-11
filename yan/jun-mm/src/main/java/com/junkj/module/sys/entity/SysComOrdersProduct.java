package com.junkj.module.sys.entity;

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
@Table(name = "sys_com_orders_product", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "com_id", attrName = "comId"),
		@Column(name = "orders_id", attrName = "ordersId"),
		@Column(name = "product_id", attrName = "productId"),
		@Column(name = "price", attrName = "price"),
		@Column(name = "num", attrName = "num"),
		@Column(name = "money", attrName = "money"),
		@Column(includeEntity = DataEntity.class)
	}, joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysProduct.class, alias = "b", on = "b.id = a.product_id ", columns = {
				@Column(name = "name", attrName = "productName", queryType = QueryType.EQ) 
		})
	}, orderBy = "a.id DESC"
)
public class SysComOrdersProduct extends DataEntity<SysComOrdersProduct> {

	private static final long serialVersionUID = 1L;

	private String ordersId; // 关联id
	private Long productId; // 
	private Double price; // 单价
	private Long num; // 数量
	private String money; // 总价
	
	// 业务字段
	private String productName;

	public String getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(String ordersId) {
		this.ordersId = ordersId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}

	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

}