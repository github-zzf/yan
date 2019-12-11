package com.junkj.module.demo.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.TreeBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.demo.dao.DemoTreeDao;
import com.junkj.module.demo.entity.DemoTree;

/**
 * 示例树biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月07日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class DemoTreeBiz extends TreeBiz<DemoTreeDao, DemoTree> {
	
	/**
	 * 获取单条数据
	 */
	@Override
	public DemoTree get(DemoTree demoTree) {
		return super.get(demoTree);
	}
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<DemoTree> findPage(DemoTree demoTree) {
		return super.findPage(demoTree);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(DemoTree demoTree) {
		super.save(demoTree);
	}
	
	/**
	 * 更新状态
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(DemoTree demoTree) {
		super.updateStatus(demoTree);
	}
	
	/**
	 * 删除
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(DemoTree demoTree) {
		super.delete(demoTree);
	}
}
