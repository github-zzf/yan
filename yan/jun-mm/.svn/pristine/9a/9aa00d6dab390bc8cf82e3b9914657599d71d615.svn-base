package com.junkj.module.sys.dao;

import org.apache.ibatis.annotations.SelectProvider;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.sys.entity.SysConfig;
import com.junkj.module.sys.sql.SysConfigSql;

/**
 * 参数配置dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月12日
 * @version: 1.0.0
 */
@MyBatisDao
public interface SysConfigDao extends CrudDao<SysConfig> {
	/**
	 * 
	 * 通过key查询
	 */
	@SelectProvider(type = SysConfigSql.class, method = "getValByKey")
	public String getValByKey(SysConfig sysConfig);

}
