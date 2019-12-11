package com.junkj.module.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.sys.entity.SysComMsg;
import com.junkj.module.sys.entity.SysComProduct;
import com.junkj.module.sys.sql.SysComProductSql;

/**
 * 消费记录dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@MyBatisDao
public interface SysComProductDao extends CrudDao<SysComProduct> {

	@SelectProvider(type = SysComProductSql.class, method = "newsSysComProduct")
	public List<SysComMsg> newsSysComProduct(String sendTime, String endTime);
}
