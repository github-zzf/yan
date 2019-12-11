package com.junkj.module.demo.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.demo.dao.DemoItemDao;
import com.junkj.module.demo.entity.DemoItem;

/**
 * 子表示例biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月07日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class DemoItemBiz extends CrudBiz<DemoItemDao, DemoItem> {
	
	/**
	 * 获取单条数据
	 */
	@Override
	public DemoItem get(DemoItem demoItem) {
		return super.get(demoItem);
	}
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<DemoItem> findPage(DemoItem demoItem) {
		return super.findPage(demoItem);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(DemoItem demoItem) {
		super.save(demoItem);
	}
	
	/**
	 * 更新状态
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(DemoItem demoItem) {
		super.updateStatus(demoItem);
	}
	
	/**
	 * 删除
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(DemoItem demoItem) {
		super.delete(demoItem);
	}
}
