package com.junkj.module.sys.sql;

import org.apache.ibatis.jdbc.SQL;

public class SysMenuSql {

	public String findPermissions(String menuIds) {
		String str = new SQL() {
			{
				SELECT("permission");
				FROM("sys_menu");
				WHERE("permission is not null");
				if(menuIds != null){
					WHERE("FIND_IN_SET(id, #{menuIds})");
				}
			}
		}.toString();

		return str;
	}

}
