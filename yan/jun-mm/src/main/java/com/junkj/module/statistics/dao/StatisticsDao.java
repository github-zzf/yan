package com.junkj.module.statistics.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.company.entity.WorkMsg;
import com.junkj.module.statistics.sql.StatisticsSql;

/**
 * 统计dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月16日
 */
@MyBatisDao
public interface StatisticsDao {

	@SelectProvider(type = StatisticsSql.class, method = "findMyStatistics")
	public Map<String, Object> findMyStatistics(Map<String, Object> map);
	
	@SelectProvider(type = StatisticsSql.class, method = "findDayStatistics")
	public Map<String, Object> findDayStatistics(Map<String, Object> map);
	
	@SelectProvider(type = StatisticsSql.class, method = "findAdminStatistics")
	public Map<String, Object> findAdminStatistics(Map<String, Object> map);
	
	@SelectProvider(type = StatisticsSql.class, method = "findAdminStatisticsTable")
	public List<Map<String, Object>> findAdminStatisticsTable(Map<String, Object> map);
	
	@SelectProvider(type = StatisticsSql.class, method = "findCommentContent")
	public List<Map<String, Object>> findCommentContent(Map<String, Object> map);
	
	@SelectProvider(type = StatisticsSql.class, method = "dayStatisticsJob")
	public List<WorkMsg> dayStatisticsJob();

}
