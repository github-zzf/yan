package com.junkj.module.stock.entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.junkj.common.entity.BaseEntity;
import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.module.shop.entity.Goods;

/**
 * 库存实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月16日
 * @version: 1.0.0
 */
@Table(name = "stock", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "goods_id", attrName = "goodsId"),
		@Column(name = "num", attrName = "num"),
		@Column(name = "create_id", attrName = "createId"),
		@Column(name = "create_time", attrName = "createTime", isQuery = false),
		@Column(name = "update_id", attrName = "updateId"),
		@Column(name = "update_time", attrName = "updateTime", isQuery = false),
		@Column(includeEntity = BaseEntity.class)
	},joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = Goods.class, alias = "g", on = "g.id=a.goods_id", columns = {
			@Column(name = "name", attrName = "goodsName")
		})
	}, orderBy = "a.id DESC"
)
public class Stock extends DataEntity<Stock> {

	private static final long serialVersionUID = 1L;

	private String goodsId; // 商品id
	private Double num; // 库存数量
	
	// 业务字段
	private String goodsName; // 商品名称


	@NotEmpty(message = "商品不能为空")
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	@NotNull(message = "库存数量不能为空")
	public Double getNum() {
		return num;
	}
	public void setNum(Double num) {
		this.num = num;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

}