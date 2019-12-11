package com.junkj.module.company.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.company.entity.WorkMsg;
import com.junkj.module.company.sql.WorkMsgSql;

/**
 * 消息通知dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月23日
 * @version: 1.0.0
 */
@MyBatisDao
public interface WorkMsgDao extends CrudDao<WorkMsg> {
	
	@SelectProvider(type = WorkMsgSql.class, method = "findWorkMsgPage")
	public List<WorkMsg> findWorkMsgPage(Object userId, Integer srow,Integer erow, String type);
	
	@UpdateProvider(type = WorkMsgSql.class, method = "updateWorkMsgCheckStatus")
	public void updateWorkMsgCheckStatus(WorkMsg workMsg);
	
	@DeleteProvider(type = WorkMsgSql.class, method = "deleteWorkMsg")
	public void deleteWorkMsg(WorkMsg workMsg);

}
