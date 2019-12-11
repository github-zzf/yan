package com.junkj.module.company.sql;

import org.apache.ibatis.jdbc.SQL;

public class ActivityEnrollSql {
	
	public String getByMember(String activityId, String memberId) {
		
		String str = new SQL() {
			{
				SELECT("a.id");
				SELECT("a.activity_id as activityId");
				SELECT("a.member_id as memberId");
				SELECT("a.enroll_status as enrollStatus");
				SELECT("a.enroll_time as enrollTime");
				SELECT("a.wait_num as waitNum");
				SELECT("a.is_sign as isSign");
				SELECT("a.sign_time as signTime");
				SELECT("a.pay_state as payState");
				FROM("com_activity_enroll a");
				WHERE("a.activity_id = #{activityId}");
				WHERE("a.member_id = #{memberId}");
				WHERE("a.enroll_status <> 1");
			}
		}.toString();
		
		return str;
	}
	
	public String findUpperLimit(String activityId) {
		
		String str = new SQL() {
			{
				SELECT("count(*)");
				FROM("com_activity_enroll a");
				WHERE("a.activity_id = #{activityId}");
				WHERE("a.enroll_status <> 1");
			}
		}.toString();
		
		return str;
	}
	
	public String updateActivityEnroll(String id) {
		
		String str = new SQL() {
			{
				UPDATE("com_activity_enroll");
				SET("wait_num = null");
				SET("enroll_status = 0");
				WHERE("id = #{id}");
			}
		}.toString();
		
		return str;
	}
	
}
