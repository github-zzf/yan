package com.junkj.module.sys.dao;

import org.apache.ibatis.annotations.SelectProvider;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.sys.entity.SysRole;
import com.junkj.module.sys.sql.SysRoleSql;

/**
 * 用户角色dao实现
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019-08-25
 * @version: 1.0.0
 */
@MyBatisDao
public interface SysRoleDao extends CrudDao<SysRole> {

	/**
	 * 查询角色用户
	 */
	@SelectProvider(type = SysRoleSql.class, method = "countUsers")
	public int countUsers(String roleIds);
}
