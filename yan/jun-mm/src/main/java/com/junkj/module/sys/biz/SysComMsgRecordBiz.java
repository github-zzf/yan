package com.junkj.module.sys.biz;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.sys.dao.SysComMsgRecordDao;
import com.junkj.module.sys.entity.SysComMsgRecord;

/**
 * 系统消息发送记录biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月11日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class SysComMsgRecordBiz extends CrudBiz<SysComMsgRecordDao, SysComMsgRecord> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<SysComMsgRecord> findPage(SysComMsgRecord sysComMsgRecord) {
		return super.findPage(sysComMsgRecord);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<SysComMsgRecord> findList(SysComMsgRecord sysComMsgRecord) {
		return super.findList(sysComMsgRecord);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SysComMsgRecord sysComMsgRecord) {
		super.save(sysComMsgRecord);
	}
	
	/**
	 * 标记为已读
	 */
	@Transactional(readOnly=false)
	public void updateSysComMsgRecordStates(SysComMsgRecord sysComMsgRecord) {
		sysComMsgRecord.setReadState(SysComMsgRecord.READSTATE_3);
		sysComMsgRecord.setReadTime(new Date());
		super.update(sysComMsgRecord);
	}
	
}
