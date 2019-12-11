package com.junkj.module.sys.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.sys.dao.SysCompanyDao;
import com.junkj.module.sys.entity.SysCompany;

/**
 * 企业biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class SysCompanyBiz extends CrudBiz<SysCompanyDao, SysCompany> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<SysCompany> findPage(SysCompany sysCompany) {
		return super.findPage(sysCompany);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<SysCompany> findList(SysCompany sysCompany) {
		return super.findList(sysCompany);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SysCompany sysCompany) {
		super.save(sysCompany);
	}
	
}
