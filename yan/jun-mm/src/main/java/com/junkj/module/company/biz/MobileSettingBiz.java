package com.junkj.module.company.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.common.lang.StrUtils;
import com.junkj.module.company.dao.MobileSettingDao;
import com.junkj.module.company.entity.MobileSetting;
import com.junkj.module.file.utils.FileUploadUtils;

/**
 * 官网设置biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月17日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class MobileSettingBiz extends CrudBiz<MobileSettingDao, MobileSetting> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<MobileSetting> findPage(MobileSetting mobileSetting) {
		return super.findPage(mobileSetting);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<MobileSetting> findList(MobileSetting mobileSetting) {
		return super.findList(mobileSetting);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MobileSetting mobileSetting) {
		super.save(mobileSetting);
		// 保存上传图片
		String img = FileUploadUtils.saveFileUpload(mobileSetting.getId(), MobileSetting.FILE_TYPE);
		if(StrUtils.notBlank(img)){
			mobileSetting.setImg(img);
			super.update(mobileSetting);
		}
	}
	
}
