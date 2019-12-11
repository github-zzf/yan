package com.junkj.module.company.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.junkj.common.lang.StrUtils;
import com.junkj.module.company.entity.Course;

public class CourseSql {

	public String findWeekKecheng(Map<String, Object> params) {

		String str = new SQL() {
			{
				SELECT("a.id AS 'id'");
				SELECT("a.teacher_id AS 'teacherId'");
				SELECT("a.assistant_id AS 'assistantId'");
				SELECT("c.name AS 'assistantName'");
				SELECT("a.parent_id AS 'parentId'");
				SELECT("a.name AS 'name'");
				SELECT("a.course_date AS 'courseDate'");
				SELECT("a.start_time AS 'startTime'");
				SELECT("a.end_time AS 'endTime'");
				SELECT("a.people_max AS 'peopleMax'");
				SELECT("a.cards_type_id AS 'cardsTypeId'");
				SELECT("a.card_num AS 'cardNum'");
				SELECT("a.is_week AS 'isWeek'");
				SELECT("a.is_check AS 'isCheck'");
				SELECT("a.create_id AS 'createId'");
				SELECT("a.create_time AS 'createTime'");
				SELECT("a.update_id AS 'updateId'");
				SELECT("a.update_time AS 'updateTime'");
				SELECT("a.com_id AS 'comId'");
				SELECT("b.name as teacherName ");
				SELECT("(select COUNT(*) from com_course_enroll where course_id = a.id and status <> 2 and status <> 3 and status <> 9) as enrollNum ");
				SELECT("(select type_name from com_cards_type where id = a.cards_type_id) as cardsTypeName");
				
				FROM("com_course a");
				LEFT_OUTER_JOIN("sys_user b on a.teacher_id=b.id");
				LEFT_OUTER_JOIN("sys_user c on a.assistant_id=c.id");
				
				WHERE("a.com_id = #{comId}");
				if(StrUtils.notBlank(params.get("name"))){
					WHERE("a.name like #{name}");
				}
				if(StrUtils.notBlank(params.get("teacherId"))){
					WHERE("a.teacher_id = #{teacherId}");
				}

				if(StrUtils.notBlank(params.get("courseDate"))){
					WHERE("(a.is_week=1 or a.course_date = #{courseDate})");
				}else{
					if(StrUtils.notBlank(params.get("startTime")) && StrUtils.notBlank(params.get("endTime"))){
						WHERE("(a.is_week=1 or (a.course_date >= #{startTime} and a.course_date <= #{endTime}) )");
					}else{
						WHERE("a.is_week=1");
					}
				}

				ORDER_BY("course_date, start_time");
			}
		}.toString();

		return str;
	}
	
	public String getByCate(String comId, String cdate) {
		
		String str = new SQL() {
			{
				SELECT("a.staff_id");
				FROM("com_leave a");
				WHERE("a.checkState=3");
				WHERE("a.com_id = #{comId}");
				WHERE("date_format(a.start_time,'%Y-%m-%d') <= #{cdate}");
				WHERE("date_format(a.end_time,'%Y-%m-%d') >= #{cdate}");
			}
		}.toString();
		
		return str;
	}
	
	public String updateCourseCardIdNull(String id) {
		
		String str = new SQL() {
			{
				UPDATE("com_course");
				SET("card_id = null");
				SET("card_num = 0");
				WHERE("id = #{id}");
			}
		}.toString();
		
		return str;
	}

	/**
	 * 查询有课程的教师
	 */
	public String findListTeacher(String comId) {
		
		String str = new SQL() {
			{
				SELECT("a.id");
				SELECT("a.name");
				FROM("sys_user a");
				WHERE("a.status = 0");
				WHERE("a.id in (select DISTINCT teacher_id from com_course where com_id=#{comId})");
			}
		}.toString();
		
		return str;
	}
	
	/**
	 * 查询有课程的教师
	 */
	public String listMyCourse(Course course) {
		
		String str = new SQL() {
			{
				SELECT("a.*");
				SELECT("(select COUNT(*) from com_course_enroll where course_id=a.id and status <> 2 and status <> 9) as enrollNum");
				SELECT("(select COUNT(*) from com_course_enroll where course_id=a.id and (status = 4 or status = 5)) as signNum");
				SELECT("(select COUNT(*) from com_course_enroll where course_id=a.id and status = 5) as completeNum");
				FROM("com_course a");
				WHERE("(a.teacher_id = #{teacherId} or a.assistant_id = #{assistantId})");
				WHERE("DATE_FORMAT(a.course_date,'%Y-%m-%d') = DATE_FORMAT(#{courseDate},'%Y-%m-%d')");
			}
		}.toString();
		
		return str;
	}
	
	/**
	 * 查询有课程的教师
	 */
	public String infoMyCourseById(Course course) {
		
		String str = new SQL() {
			{
				SELECT("a.*");
				SELECT("(select COUNT(*) from com_course_enroll where course_id=a.id and status <> 2 and status <> 9) as enrollNum");
				SELECT("(select COUNT(*) from com_course_enroll where course_id=a.id and (status = 4 or status = 5)) as signNum");
				SELECT("(select COUNT(*) from com_course_enroll where course_id=a.id and status = 5) as completeNum");
				FROM("com_course a");
				WHERE("a.id = #{id}");
			}
		}.toString();
		
		return str;
	}

}
