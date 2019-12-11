package com.junkj.module.sys.sql;

import org.apache.ibatis.jdbc.SQL;

public class SysComOrdersSql {

	public String getCode(String year) {
		String str = new SQL() {
			{
				SELECT("max(a.code)");
				FROM("sys_com_orders a");
				WHERE("DATE_FORMAT(a.create_time,'%Y') = #{year}");
			}
		}.toString();

		return str;
	}
}
