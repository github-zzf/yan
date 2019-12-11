package com.junkj.module.company.sql;

import org.apache.ibatis.jdbc.SQL;

public class ActivitySql {

	/**
	 * 清空会员卡
	 */
	public String updateActivityCardIdNull(String id) {
		
		String str = new SQL() {
			{
				UPDATE("com_activity");
				SET("card_id = null");
				SET("card_num = 0");
				WHERE("id = #{id}");
			}
		}.toString();
		
		return str;
	}

	/**
	 * 定时更新活动状态
	 */
	public String updateAllStatus(String id) {
		StringBuffer sql = new StringBuffer();
		sql.append("update com_activity set status = 3 where status<3 and end_time < now();");
		sql.append("update com_activity set status = 2 where status=3 and end_time > now();");
		sql.append("update com_activity set status = 2 where status<2 and enroll_end < now();");
		sql.append("update com_activity set status = 1 where status<2 and enroll_end > now() and enroll_start < now();");
		sql.append("update com_activity set status = 0 where status=1 and enroll_start > now();");
		sql.append("update com_activity set status = 0 where status is null;");
		return sql.toString();
	}

}
