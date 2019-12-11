package com.junkj.module.sys.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.sys.dao.SysBeanDataDao;
import com.junkj.module.sys.dao.SysBeanTypeDao;
import com.junkj.module.sys.entity.SysBeanData;
import com.junkj.module.sys.entity.SysBeanType;

/**
 * 数据字典类型biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class SysBeanTypeBiz extends CrudBiz<SysBeanTypeDao, SysBeanType> {
	
	@Autowired
	private SysBeanDataDao sysBeanDataDao;
	/**
	 * 分页数据
	 */
	@Override
	public Page<SysBeanType> findPage(SysBeanType sysBeanType) {
		return super.findPage(sysBeanType);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<SysBeanType> findList(SysBeanType sysBeanType) {
		return super.findList(sysBeanType);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SysBeanType sysBeanType) {
		super.save(sysBeanType);
		// 保存子表
		for (SysBeanData item : sysBeanType.getSysBeanData()){
			if (!SysBeanData.STATUS_DELETE.equals(item.getStatus())){
				item.setBeanKey(sysBeanType.getBeanKey());
				if (item.getIsNewT()){
					item.preInsert();
					sysBeanDataDao.insert(item);
				}else{
					item.preUpdate();
					sysBeanDataDao.update(item);
				}
			}else{
				sysBeanDataDao.delete(item);
			}
		}
	}
	/**
	 * 获取子表数据
	 */
	public List<SysBeanData> findChild(SysBeanData sysBeanData) {
		return sysBeanDataDao.findList(sysBeanData);
	}
	/**
	 * 查重
	 */
	public SysBeanType getByBeanKey(String beanKey) {
		SysBeanType where = new SysBeanType();
		where.setBeanKey(beanKey);
		return super.getByEntity(where);
	}
}
