package com.junkj.module.company.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.company.entity.ComConfig;
import com.junkj.module.company.sql.ComConfigSql;

/**
 * 参数配置dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月17日
 * @version: 1.0.0
 */
@MyBatisDao
public interface ComConfigDao extends CrudDao<ComConfig> {

	@SelectProvider(type = ComConfigSql.class, method = "findList")
	List<ComConfig> findList(ComConfig comConfig);
	@SelectProvider(type = ComConfigSql.class, method = "findConfig")
	List<ComConfig> findConfig(Map<String,Object> map);
}
