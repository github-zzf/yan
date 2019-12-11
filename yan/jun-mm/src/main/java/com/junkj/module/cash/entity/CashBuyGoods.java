package com.junkj.module.cash.entity;

import com.junkj.common.entity.BaseEntity;
import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;
import com.junkj.module.shop.entity.Goods;

/**
 * 消费明细实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月28日
 */
@Table(name = "cash_buy_goods", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "com_id", attrName = "comId"),
		@Column(name = "buy_id", attrName = "buyId"),
		@Column(name = "goods_id", attrName = "goodsId"),
		@Column(name = "num", attrName = "num"),
		@Column(name = "price", attrName = "price"),
		@Column(name = "money", attrName = "money"),
		@Column(includeEntity = BaseEntity.class)
	},joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = Goods.class, alias = "g", on = "g.id = a.goods_id", columns = {
			@Column(name = "name", attrName = "goodsName", queryType = QueryType.LIKE)
		})
	},orderBy = "a.id DESC"
)
public class CashBuyGoods extends DataEntity<CashBuyGoods> {

	private static final long serialVersionUID = 1L;

	private String comId; // 企业
	private String buyId; // 消费记录主键
	private String goodsId; // 商品id
	private Double num; // 数量
	private Double price; // 单价
	private Double money; // 总价
	
	//业务字段
	private String goodsName; // 商品名

	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}

	public String getBuyId() {
		return buyId;
	}
	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}

	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public Double getNum() {
		return num;
	}
	public void setNum(Double num) {
		this.num = num;
	}

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	

}