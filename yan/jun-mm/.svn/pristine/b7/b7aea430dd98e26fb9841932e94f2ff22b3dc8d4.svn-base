package com.junkj.module.demo.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.demo.dao.DemoBaseDao;
import com.junkj.module.demo.dao.DemoItemDao;
import com.junkj.module.demo.entity.DemoBase;
import com.junkj.module.demo.entity.DemoItem;
import com.junkj.module.file.utils.FileUploadUtils;

/**
 * 增删改查示例biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月06日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class DemoBaseBiz extends CrudBiz<DemoBaseDao, DemoBase> {

	@Autowired
	private DemoItemDao demoItemDao;
	
	/**
	 * 获取子表数据
	 */
	public List<DemoItem> findChild(DemoItem demoItem) {
		return demoItemDao.findList(demoItem);
	}
	
	/**
	 * 获取单条数据
	 */
	@Override
	public DemoBase get(DemoBase demoBase) {
		return super.get(demoBase);
	}
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<DemoBase> findPage(DemoBase demoBase) {
		return super.findPage(demoBase);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(DemoBase demoBase) {
		super.save(demoBase);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(demoBase.getId(), DemoBase.FILE_TYPE);
		// 保存子表
		for (DemoItem item : demoBase.getDemoItem()){
			if (!DemoItem.STATUS_DELETE.equals(item.getStatus())){
				item.setBaseId(demoBase.getId());
				if (item.getIsNewT()){
					item.preInsert();
					demoItemDao.insert(item);
				}else{
					item.preUpdate();
					demoItemDao.update(item);
				}
			}else{
				demoItemDao.delete(item);
			}
		}
	}
	
	/**
	 * 更新状态
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(DemoBase demoBase) {
		super.updateStatus(demoBase);
	}
	
	/**
	 * 删除
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(DemoBase demoBase) {
		super.delete(demoBase);
	}
}
