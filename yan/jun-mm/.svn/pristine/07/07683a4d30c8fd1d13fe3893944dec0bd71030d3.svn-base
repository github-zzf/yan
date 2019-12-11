package com.junkj.module.sys.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.common.lang.DateUtils;
import com.junkj.module.sys.dao.SysLogDao;
import com.junkj.module.sys.entity.SysLog;

/**
 * 操作日志biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019-08-25
 * @version: 1.0.0
 */
@Service
public class SysLogBiz extends CrudBiz<SysLogDao, SysLog> {

	public Page<SysLog> findPage(SysLog log) {
		// 设置默认时间范围，默认当前月
		if (log.getBeginDate() == null) {
			log.setBeginDate(DateUtils.setDays(DateUtils.parseDate(DateUtils.getDate()), 1));
		}
		if (log.getEndDate() == null) {
			log.setEndDate(DateUtils.addMonths(log.getBeginDate(), 1));
		}
		return super.findPage(log);
	}

	/**
	 * 不使用数据库事务，执行插入日志
	 */
	@Transactional(readOnly = false, propagation = Propagation.NOT_SUPPORTED)
	public void insertLog(SysLog entity) {
		dao.insert(entity);
	}
}
