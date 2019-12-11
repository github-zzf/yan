package com.junkj.module.sys.sql;

import org.apache.ibatis.jdbc.SQL;

public class SysRoleSql {

	/**
	 * 查询角色用户
	 */
	public String countUsers(String roleIds){
		String str = new SQL() {
			{
				SELECT("count(0)");
				FROM("sys_user");
				WHERE("concat(',', role_ids, ',') like concat('%,', #{roleId}, ',%')");
			}
		}.toString();

		return str;
	}


}
