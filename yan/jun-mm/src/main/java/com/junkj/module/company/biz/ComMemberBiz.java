package com.junkj.module.company.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.company.dao.ComMemberDao;
import com.junkj.module.company.entity.ComMember;

/**
 * 企业会员biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月04日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class ComMemberBiz extends CrudBiz<ComMemberDao, ComMember> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<ComMember> findPage(ComMember comMember) {
		return super.findPage(comMember);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<ComMember> findList(ComMember comMember) {
		return super.findList(comMember);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ComMember comMember) {
		super.save(comMember);
	}
	
}
