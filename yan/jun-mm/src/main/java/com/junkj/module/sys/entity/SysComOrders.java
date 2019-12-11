package com.junkj.module.sys.entity;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.junkj.common.collect.ListUtils;
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
@Table(name = "sys_com_orders", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "com_id", attrName = "comId"),
		@Column(name = "code", attrName = "code"),
		@Column(name = "money", attrName = "money"),
		@Column(name = "type", attrName = "type"),
		@Column(name = "pay_type", attrName = "payType"),
		@Column(name = "pay_money", attrName = "payMoney"),
		@Column(includeEntity = DataEntity.class)
	}, joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysCompany.class, alias = "b", on = "b.com_id = a.com_id ", columns = {
				@Column(name = "com_name", attrName = "companyName", queryType = QueryType.EQ) 
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysBeanData.class, alias = "c", on = "c.bean_key='pay_type' and c.bean_val = a.pay_type", columns = {
			@Column(name = "bean_txt", attrName = "payTypeName", queryType = QueryType.LIKE)
		})
	}, orderBy = "a.id DESC"
)
public class SysComOrders extends DataEntity<SysComOrders> {

	private static final long serialVersionUID = 1L;

	private String comId; // 企业
	private String code; // 订单编号
	private String money; // 应付金额
	private String type; // 消费类型(1消费收银、2储值扣费、3会员储值)
	private String payType; // 支付方式（1现金、2微信、3支付宝、4刷卡）
	private Double payMoney; // 实付金额
	
	// 业务字段
	private String companyName; // 企业name
	private String payTypeName; // 类型name
	
	// 业务字段
	private List<SysComOrdersProduct> sysComOrdersProduct = ListUtils.newArrayList();  // 子表数据


	@NotEmpty(message = "企业不能为空")
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@NotEmpty(message = "支付方式不能为空")
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}

	@NotNull(message = "实付金额不能为空")
	public Double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}
	
	public List<SysComOrdersProduct> getSysComOrdersProduct() {
		return sysComOrdersProduct;
	}
	public void setSysComOrdersProduct(List<SysComOrdersProduct> sysComOrdersProduct) {
		this.sysComOrdersProduct = sysComOrdersProduct;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPayTypeName() {
		return payTypeName;
	}
	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}

}