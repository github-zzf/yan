package com.junkj.module.sys.sql;

import org.apache.ibatis.jdbc.SQL;

import com.junkj.common.lang.StrUtils;
import com.junkj.module.sys.entity.SysConfig;

public class SysConfigSql {

	/**
	 * 通过key查询
	 */
	public String getValByKey(SysConfig sysConfig) {
		String str = new SQL() {
			{
				SELECT("c_value");
				FROM("sys_config");
				WHERE("c_key = #{configKey}");
				WHERE("is_sys = #{isSys}");
				if (StrUtils.notBlank(sysConfig.getComId())) {
					WHERE("com_id = #{comId}");
				}
			}
		}.toString();

		return str;
	}

}
