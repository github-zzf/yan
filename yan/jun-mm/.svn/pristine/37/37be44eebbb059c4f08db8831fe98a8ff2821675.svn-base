package com.junkj.module.sys.dao;

import org.apache.ibatis.annotations.SelectProvider;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.sys.entity.SysComOrders;
import com.junkj.module.sys.sql.SysComOrdersSql;

/**
 * 消费记录dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@MyBatisDao
public interface SysComOrdersDao extends CrudDao<SysComOrders> {

	@SelectProvider(type = SysComOrdersSql.class, method = "getCode")
	public String getCode(String year);
}
