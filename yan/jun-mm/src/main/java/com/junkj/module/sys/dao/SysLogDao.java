package com.junkj.module.sys.dao;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.sys.entity.SysLog;

/**
 * 操作日志dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019-08-25
 * @version: 1.0.0
 */
@MyBatisDao
public interface SysLogDao extends CrudDao<SysLog> {
	
}
