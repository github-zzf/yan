package com.junkj.module.company.sql;

import org.apache.ibatis.jdbc.SQL;

public class CourseEnrollSql {
	
	public String countByMember(String keChengId, String memberId) {
		
		String str = new SQL() {
			{
				SELECT("a.id");
				SELECT("a.course_id as courseId");
				SELECT("a.member_id as memberId");
				SELECT("a.sign_time as signTime");
				SELECT("a.comment_time as commentTime");
				SELECT("a.comment_level as commentLevel");
				SELECT("a.comment_content as commentContent");
				SELECT("a.status");
				SELECT("a.status_remark as statusRemark");
				SELECT("a.create_time as createTime");
				FROM("com_course_enroll a");
				WHERE("a.course_id = #{keChengId}");
				WHERE("a.member_id = #{memberId}");
				WHERE("a.status <> 2");
				WHERE("a.status <> 3");
				WHERE("a.status <> 9");
			}
		}.toString();
		
		return str;
	}
	
	public String findUpperLimit(String courseId) {
		
		String str = new SQL() {
			{
				SELECT("count(*)");
				FROM("com_course_enroll a");
				WHERE("a.course_id = #{courseId}");
				WHERE("a.status <> 2");
				WHERE("a.status <> 3");
				WHERE("a.status <> 9");
			}
		}.toString();
		
		return str;
	}
	
	public String getByWorkNum(String userId) {
		
		String str = new SQL() {
			{
				SELECT("count(CASE status WHEN 4 THEN 1 END) AS evaluateNum");
				SELECT("count(CASE status WHEN 1 THEN 1 END ) AS signNum");
				SELECT("count(CASE status WHEN 5 THEN 1 END ) AS completeNum");
				FROM("com_course_enroll");
				WHERE("course_id in (select id from com_course where (teacher_id = #{userId} or assistant_id = #{userId})");
				WHERE("DATE_FORMAT(course_date,'%Y-%m-%d') = DATE_FORMAT(NOW(),'%Y-%m-%d'))");
			}
		}.toString();
		
		return str;
	}

	// 查询待评价数据
	public String findPingjia() {
		
		String str = new SQL() {
			{
				SELECT("m.open_id as openId");
				SELECT("c.com_id as comId");
				SELECT("c.name as courseName");
				SELECT("c.course_date as courseDate");
				SELECT("c.end_time as endTime");
				SELECT("u.name as teacherName");
				FROM("com_course_enroll a");
				LEFT_OUTER_JOIN("member m on (m.id = a.member_id)");
				LEFT_OUTER_JOIN("com_course c on (c.id = a.course_id)");
				LEFT_OUTER_JOIN("sys_user u on (u.id = c.teacher_id)");
				WHERE("a.sign_time is not null");
				WHERE("a.comment_time is null");
				WHERE("m.open_id is not null");
			}
		}.toString();
		
		return str;
	}
}
