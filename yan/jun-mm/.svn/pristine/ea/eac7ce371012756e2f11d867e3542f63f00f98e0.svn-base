package com.junkj.module.sale.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.sale.dao.SaleMemberDao;
import com.junkj.module.sale.entity.SaleMember;

/**
 * 导购客户biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月11日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class SaleMemberBiz extends CrudBiz<SaleMemberDao, SaleMember> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<SaleMember> findPage(SaleMember saleMember) {
		return super.findPage(saleMember);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<SaleMember> findList(SaleMember saleMember) {
		return super.findList(saleMember);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SaleMember saleMember) {
		super.save(saleMember);
	}
	
}
