package com.junkj.module.company.entity;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.Table;

/**
 * 会员卡分类实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月05日
 * @version: 1.0.0
 */
@Table(name = "com_cards_type", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "type_name", attrName = "typeName"),
		@Column(name = "com_Id", attrName = "comId"),
	}, orderBy = "a.id DESC"
)
public class CardsType extends DataEntity<CardsType> {

	private static final long serialVersionUID = 1L;

	private String typeName; // 分类名称


	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}