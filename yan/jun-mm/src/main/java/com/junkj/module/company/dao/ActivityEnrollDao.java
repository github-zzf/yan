package com.junkj.module.company.dao;

import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.company.entity.ActivityEnroll;
import com.junkj.module.company.sql.ActivityEnrollSql;

/**
 * 活动报名dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 * @version: 1.0.0
 */
@MyBatisDao
public interface ActivityEnrollDao extends CrudDao<ActivityEnroll> {
	
	@SelectProvider(type = ActivityEnrollSql.class, method = "getByMember")
	public ActivityEnroll getByMember(String activityId, String memberId);
	
	// 查询人数上限
	@SelectProvider(type = ActivityEnrollSql.class, method = "findUpperLimit")
	public Double findUpperLimit(String activityId);
	
	@UpdateProvider(type = ActivityEnrollSql.class, method = "updateActivityEnroll")
	public void updateActivityEnroll(String id);
	
}
