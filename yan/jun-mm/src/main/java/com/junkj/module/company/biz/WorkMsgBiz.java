package com.junkj.module.company.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.company.dao.WorkMsgDao;
import com.junkj.module.company.entity.WorkMsg;

/**
 * 消息通知biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月23日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class WorkMsgBiz extends CrudBiz<WorkMsgDao, WorkMsg> {
	
	@Autowired
	private WorkMsgDao WorkMsgDao;
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<WorkMsg> findPage(WorkMsg workMsg) {
		return super.findPage(workMsg);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<WorkMsg> findList(WorkMsg workMsg) {
		return super.findList(workMsg);
	}
	
	/**
	 * 我的消息
	 */
	public List<WorkMsg> findWorkMsgPage(Object userId, Integer srow,Integer erow, String type) {
		return WorkMsgDao.findWorkMsgPage(userId, srow, erow, type);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(WorkMsg workMsg) {
		super.save(workMsg);
	}
	
	/**
	 * 修改审批状态
	 */
	@Transactional(readOnly=false)
	public void updateWorkMsgCheckStatus(WorkMsg workMsg) {
		dao.updateWorkMsgCheckStatus(workMsg);
	}
	
	
	/**
	 * 删除
	 */
	@Transactional(readOnly=false)
	public void deleteWorkMsg(WorkMsg workMsg) {
		dao.deleteWorkMsg(workMsg);
	}
	
}
