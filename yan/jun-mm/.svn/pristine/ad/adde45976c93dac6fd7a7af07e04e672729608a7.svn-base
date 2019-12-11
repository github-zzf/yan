package com.junkj.module.stock.entity;

import java.util.Date;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.module.shop.entity.Goods;
import com.junkj.module.sys.entity.SysBeanData;

/**
 * 出入库明细实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月16日
 * @version: 1.0.0
 */
@Table(name = "stock_record_item", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "record_id", attrName = "recordId"),
		@Column(name = "goods_id", attrName = "goodsId"),
		@Column(name = "num_type", attrName = "numType"),
		@Column(name = "num", attrName = "num"),
		@Column(name = "num_new", attrName = "numNew")
	},
	joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = Goods.class, alias = "g", on = "g.id=a.goods_id", columns = {
			@Column(name = "name", attrName = "goodsName")
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysBeanData.class, alias = "b", on = "b.bean_key='stock_num_type' and b.bean_val = a.num_type", columns = {
			@Column(name = "bean_txt", attrName = "numTypeName")
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = StockRecord.class, alias = "s", on = "s.id=a.record_id", columns = {
				@Column(name = "create_time", attrName = "createTime")
			}),
	},orderBy = "a.id DESC"
)
public class StockRecordItem extends DataEntity<StockRecordItem> {

	private static final long serialVersionUID = 1L;

	private String recordId; // 出入库id
	private String goodsId; // 商品id
	private String numType; // 类型（1增加、2减少）
	private Double num; // 数量
	private Double numNew; // 新数量
	
	// 业务字段
	private String goodsName; // 商品名称
	private String numTypeName;  // 分类名称
	private Date createTime;  // 创建时间
	/**
	 * 类型（1增加）
	 */
	public static final String NUM_TYPE_1 = "1";
	/**
	 * 类型（2减少）
	 */
	public static final String NUM_TYPE_2 = "2";
	/**
	 * 类型（3盘点）
	 */
	public static final String NUM_TYPE_3 = "3";

	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getNumType() {
		return numType;
	}
	public void setNumType(String numType) {
		this.numType = numType;
	}

	public Double getNum() {
		return num;
	}
	public void setNum(Double num) {
		this.num = num;
	}

	public Double getNumNew() {
		return numNew;
	}
	public void setNumNew(Double numNew) {
		this.numNew = numNew;
	}
	public String getNumTypeName() {
		return numTypeName;
	}
	public void setNumTypeName(String numTypeName) {
		this.numTypeName = numTypeName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	
	

}