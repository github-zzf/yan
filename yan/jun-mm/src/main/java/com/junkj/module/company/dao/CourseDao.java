package com.junkj.module.company.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.company.entity.Course;
import com.junkj.module.company.sql.CourseSql;
import com.junkj.module.sys.entity.SysUser;

/**
 * 排课表dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 * @version: 1.0.0
 */
@MyBatisDao
public interface CourseDao extends CrudDao<Course> {

	@SelectProvider(type = CourseSql.class, method = "findWeekKecheng")
	public List<Course> findWeekKecheng(Map<String, Object> params);
	
	@SelectProvider(type = CourseSql.class, method = "getByCate")
	public List<String> getByCate(String comId, String cdate);
	
	@UpdateProvider(type = CourseSql.class, method = "updateCourseCardIdNull")
	public void updateCourseCardIdNull(String id);

	@SelectProvider(type = CourseSql.class, method = "findListTeacher")
	public List<SysUser> findListTeacher(String comId);
	
	@SelectProvider(type = CourseSql.class, method = "listMyCourse")
	public List<Map<String, Object>> listMyCourse(Course course);
	
	@SelectProvider(type = CourseSql.class, method = "infoMyCourseById")
	public Map<String, Object> infoMyCourseById(Course course);

}
