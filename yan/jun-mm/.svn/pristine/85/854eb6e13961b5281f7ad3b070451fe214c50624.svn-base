package com.junkj.module.company.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.company.entity.CourseEnroll;
import com.junkj.module.company.sql.CourseEnrollSql;

/**
 * 课程预约dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 * @version: 1.0.0
 */
@MyBatisDao
public interface CourseEnrollDao extends CrudDao<CourseEnroll> {
	
	@SelectProvider(type = CourseEnrollSql.class, method = "countByMember")
	public CourseEnroll countByMember(String keChengId, String memberId);
	
	// 查询课程人数
	@SelectProvider(type = CourseEnrollSql.class, method = "findUpperLimit")
	public Double findUpperLimit(String courseId);
	
	// 查询教师助教签到评价完成数量
	@SelectProvider(type = CourseEnrollSql.class, method = "getByWorkNum")
	public Map<String, Object> getByWorkNum(String userId);

	// 查询待评价数据
	@SelectProvider(type = CourseEnrollSql.class, method = "findPingjia")
	public List<CourseEnroll> findPingjia();
	
}
