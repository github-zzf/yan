package com.junkj.module.sale.entity;

import com.junkj.common.entity.BaseEntity;
import com.junkj.common.entity.DataEntity;
import com.junkj.common.entity.TreeEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;
import com.junkj.module.sys.entity.SysUser;

/**
 * 销售团队实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月11日
 * @version: 1.0.0
 */
@Table(name = "sale_team", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "user_id", attrName = "userId"),
		@Column(name = "create_id", attrName = "createId"),
		@Column(name = "create_time", attrName = "createTime", isQuery = false),
		@Column(name = "update_id", attrName = "updateId", isUpdate = true),
		@Column(name = "update_time", attrName = "updateTime", isUpdate = true, isQuery = false),
		@Column(includeEntity= BaseEntity.class),
		@Column(includeEntity = TreeEntity.class)
	}, joinTable = {
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysUser.class, alias = "u", on = "u.id = a.user_id", columns = {
			@Column(name = "name", attrName = "saleName", queryType = QueryType.LIKE)
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SaleTeam.class, alias = "p", on = "p.id = a.parent_id", columns = {
			@Column(name = "user_id", attrName = "parentUserId", queryType = QueryType.LIKE)
		}),
		@JoinTable(type = JoinTable.Type.LEFT_JOIN, entity = SysUser.class, alias = "pu", on = "pu.id = p.user_id", columns = {
			@Column(name = "name", attrName = "parentName", queryType = QueryType.LIKE)
		})
	},  orderBy = "a.id DESC"
)
public class SaleTeam extends TreeEntity<SaleTeam> {

	private static final long serialVersionUID = 1L;

	private String userId; // 用户
	
	// 业务字段
	private String saleName; // 导购
	private String parentUserId; // 父节点用户id

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSaleName() {
		return saleName;
	}
	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}
	public String getParentUserId() {
		return parentUserId;
	}
	public void setParentUserId(String parentUserId) {
		this.parentUserId = parentUserId;
	}
	@Override
	public String getTreeName() {
		return this.saleName;
	}
	
	

}