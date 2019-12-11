package com.junkj.module.cms.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.TreeBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.cms.dao.ArttypeDao;
import com.junkj.module.cms.entity.Arttype;

/**
 * 栏目表biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月18日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class ArttypeBiz extends TreeBiz<ArttypeDao, Arttype> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<Arttype> findPage(Arttype arttype) {
		return super.findPage(arttype);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<Arttype> findList(Arttype arttype) {
		return super.findList(arttype);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Arttype arttype) {
		super.save(arttype);
	}
	
}
