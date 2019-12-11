package com.junkj.module.shop.entity;

import javax.validation.constraints.NotEmpty;

import com.junkj.common.entity.BaseEntity;
import com.junkj.common.entity.TreeEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;

/**
 * 消耗项目分类实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月27日
 */
@Table(name = "shop_goods_type", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "name", attrName = "name"),
		@Column(includeEntity = BaseEntity.class),
		@Column(includeEntity = TreeEntity.class)
	}, joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = GoodsType.class, alias = "b", on = "b.id = a.parent_id", columns = {
			@Column(name = "name", attrName = "parentName", queryType = QueryType.LIKE)
		}),
	}, orderBy = "a.tree_sorts, a.com_id"
)
public class GoodsType extends TreeEntity<GoodsType> {

	private static final long serialVersionUID = 1L;

	private String name; // 分类名称

	@NotEmpty(message="分类名不能为空")
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