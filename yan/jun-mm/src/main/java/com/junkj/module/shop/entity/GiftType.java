package com.junkj.module.shop.entity;

import javax.validation.constraints.NotEmpty;

import com.junkj.common.entity.BaseEntity;
import com.junkj.common.entity.TreeEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;

/**
 * 积分商品分类实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月27日
 * @version: 1.0.0
 */
@Table(name = "shop_gift_type", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "name", attrName = "name", queryType = QueryType.LIKE),
		@Column(includeEntity = BaseEntity.class),
		@Column(includeEntity = TreeEntity.class)
	}, 
	joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = GiftType.class, alias = "b", on = "b.id = a.parent_id", columns = {
			@Column(name = "name", attrName = "parentName", queryType = QueryType.LIKE)
		})
	}, orderBy = "a.id DESC"
)
public class GiftType extends TreeEntity<GiftType> {

	private static final long serialVersionUID = 1L;

	private String name; // 分类名称

	@NotEmpty(message="分类名称不能为空")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getTreeName() {
		return this.name;
	}

}