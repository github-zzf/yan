package com.junkj.module.shop.entity;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.junkj.common.entity.BaseEntity;
import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;
import com.junkj.module.sys.entity.SysBeanData;
import com.junkj.module.sys.entity.SysUser;

/**
 * 消费项目实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月27日
 * @version: 1.0.0
 */
@Table(name = "shop_goods", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "type_id", attrName = "typeId"),
		@Column(name = "name", attrName = "name", queryType = QueryType.LIKE),
		@Column(name = "price_mkt", attrName = "priceMkt"),
		@Column(name = "price", attrName = "price"),
		@Column(name = "img", attrName = "img"),
		@Column(name = "content", attrName = "content"),
		@Column(name = "expiry_date", attrName = "expiryDate"),
		@Column(name = "is_show", attrName = "isShow"),
		@Column(name = "sort", attrName = "sort"),
		@Column(name = "sales", attrName = "sales"),
		@Column(name = "create_id", attrName = "createId"),
		@Column(name = "create_time", attrName = "createTime"),
		@Column(name = "update_id", attrName = "updateId"),
		@Column(name = "update_time", attrName = "updateTime"),
		@Column(name = "remark", attrName = "remark", queryType = QueryType.LIKE),
		@Column(includeEntity = BaseEntity.class)
	},
	joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = GoodsType.class, alias = "t", on = "t.id=a.type_id", columns = {
			@Column(name = "name", attrName = "typeName")
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysBeanData.class, alias = "b", on = "b.bean_key='com_goods_is_show' and b.bean_val = a.is_show", columns = {
			@Column(name = "bean_txt", attrName = "isShowName")
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysUser.class, alias = "u", on = "u.id = a.update_id", columns = {
			@Column(name = "name", attrName = "updateName", queryType = QueryType.LIKE)
		})
	},orderBy = "a.id DESC"
)
public class Goods extends DataEntity<Goods> {

	private static final long serialVersionUID = 1L;
	public static final String FILE_TYPE = "shopGoods_img";

	private String typeId; // 分类
	private String name; // 产品名称
	private Double priceMkt; // 市场价
	private Double price; // 零售价格
	private String img; // 图片
	private String content; // 详细
	private Date expiryDate; // 商品有效期
	private String isShow; // 是否上架(0下架，1上架)
	private Long sort; // 排序
	private Long sales; // 销量
	
	// 业务字段
	private String typeName;  // 分类名称
	private String isShowName;  // 是否上架

	@NotEmpty(message="分类不能为空")
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	@NotEmpty(message="产品名称不能为空")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPriceMkt() {
		return priceMkt;
	}
	public void setPriceMkt(Double priceMkt) {
		this.priceMkt = priceMkt;
	}
	@NotNull(message="销售价格不能为空")
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	public Long getSort() {
		return sort;
	}
	public void setSort(Long sort) {
		this.sort = sort;
	}
	public Long getSales() {
		return sales;
	}
	public void setSales(Long sales) {
		this.sales = sales;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getIsShowName() {
		return isShowName;
	}
	public void setIsShowName(String isShowName) {
		this.isShowName = isShowName;
	}

}