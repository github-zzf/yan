package com.junkj.module.member.entity;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.junkj.common.entity.BaseEntity;
import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;
import com.junkj.module.sys.entity.SysUser;

/**
 * 会员级别实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月27日
 */
@Table(name = "member_level", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "name", attrName = "name", queryType = QueryType.LIKE),
		@Column(name = "ratio", attrName = "ratio"),
		@Column(name = "remark", attrName = "remark"),
		@Column(name = "create_id", attrName = "createId"),
		@Column(name = "create_time", attrName = "createTime"),
		@Column(name = "update_id", attrName = "updateId"),
		@Column(name = "update_time", attrName = "updateTime"),
		@Column(includeEntity = BaseEntity.class)
	},
	joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysUser.class, alias = "b", on = "b.id = a.update_id", columns = {
			@Column(name = "name", attrName = "updateName", queryType = QueryType.LIKE)
		})
	}, orderBy = "a.id DESC"
)
public class Level extends DataEntity<Level> {

	private static final long serialVersionUID = 1L;

	private String name; // 等级名称
	private Double ratio; // 折扣率
	
	@NotEmpty(message="等级名称不能为空")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@NotNull(message="折扣率不能为空")
	public Double getRatio() {
		return ratio;
	}
	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

}