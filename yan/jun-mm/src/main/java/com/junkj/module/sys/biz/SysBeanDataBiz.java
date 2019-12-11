package com.junkj.module.sys.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.sys.dao.SysBeanDataDao;
import com.junkj.module.sys.entity.SysBeanData;

/**
 * 数据字典数据biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class SysBeanDataBiz extends CrudBiz<SysBeanDataDao, SysBeanData> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<SysBeanData> findPage(SysBeanData sysBeanData) {
		return super.findPage(sysBeanData);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<SysBeanData> findList(SysBeanData sysBeanData) {
		return super.findList(sysBeanData);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SysBeanData sysBeanData) {
		super.save(sysBeanData);
	}

	/**
	 * 查重
	 */
	public SysBeanData getByBeanVal(String beanKey,String beanVal) {
		SysBeanData where = new SysBeanData();
		where.setBeanKey(beanKey);
		where.setBeanVal(beanVal);
		return super.getByEntity(where);
	}
	
}
