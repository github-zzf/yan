package com.junkj.module.shop.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.file.utils.FileUploadUtils;
import com.junkj.module.shop.dao.GiftDao;
import com.junkj.module.shop.entity.Gift;

/**
 * 积分商品biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Service
@Transactional(readOnly = true)
public class GiftBiz extends CrudBiz<GiftDao, Gift> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<Gift> findPage(Gift gift) {
		return super.findPage(gift);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<Gift> findList(Gift gift) {
		return super.findList(gift);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Gift gift) {
		super.save(gift);
		FileUploadUtils.saveFileUpload(gift.getId(), Gift.FILE_TYPE);
	}
	
}
