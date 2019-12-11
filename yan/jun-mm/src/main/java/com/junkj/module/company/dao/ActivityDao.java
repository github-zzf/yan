package com.junkj.module.company.dao;

import org.apache.ibatis.annotations.UpdateProvider;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.company.entity.Activity;
import com.junkj.module.company.sql.ActivitySql;

/**
 * 活动dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@MyBatisDao
public interface ActivityDao extends CrudDao<Activity> {

	/**
	 * 清空会员卡
	 */
	@UpdateProvider(type = ActivitySql.class, method = "updateActivityCardIdNull")
	public void updateActivityCardIdNull(String id);

	/**
	 * 定时更新活动状态
	 */
	@UpdateProvider(type = ActivitySql.class, method = "updateAllStatus")
	public void updateAllStatus();
}
