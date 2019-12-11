package com.junkj.module.sys.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.sys.dao.SysComOrdersProductDao;
import com.junkj.module.sys.entity.SysComOrdersProduct;

/**
 * 消费记录biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class SysComOrdersProductBiz extends CrudBiz<SysComOrdersProductDao, SysComOrdersProduct> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<SysComOrdersProduct> findPage(SysComOrdersProduct sysComOrdersProduct) {
		return super.findPage(sysComOrdersProduct);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<SysComOrdersProduct> findList(SysComOrdersProduct sysComOrdersProduct) {
		return super.findList(sysComOrdersProduct);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SysComOrdersProduct sysComOrdersProduct) {
		super.save(sysComOrdersProduct);
	}
	
}
