package com.junkj.module.sys.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.biz.TreeBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.sys.dao.SysAreaDao;
import com.junkj.module.sys.entity.SysArea;

/**
 * 行政区biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class SysAreaBiz extends TreeBiz<SysAreaDao, SysArea> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<SysArea> findPage(SysArea sysArea) {
		return super.findPage(sysArea);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<SysArea> findList(SysArea sysArea) {
		return super.findList(sysArea);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SysArea sysArea) {
		super.save(sysArea);
	}
	
}
