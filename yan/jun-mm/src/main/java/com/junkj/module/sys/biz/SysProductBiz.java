package com.junkj.module.sys.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.sys.dao.SysProductDao;
import com.junkj.module.sys.entity.SysProduct;

/**
 * 平台产品biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class SysProductBiz extends CrudBiz<SysProductDao, SysProduct> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<SysProduct> findPage(SysProduct sysProduct) {
		return super.findPage(sysProduct);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<SysProduct> findList(SysProduct sysProduct) {
		return super.findList(sysProduct);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SysProduct sysProduct) {
		super.save(sysProduct);
	}
	
}
