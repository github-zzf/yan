package com.junkj.module.shop.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.file.utils.FileUploadUtils;
import com.junkj.module.shop.dao.GoodsDao;
import com.junkj.module.shop.entity.Goods;

/**
 * 消费项目biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Service
@Transactional(readOnly = true)
public class GoodsBiz extends CrudBiz<GoodsDao, Goods> {

	/**
	 * 分页数据
	 */
	@Override
	public Page<Goods> findPage(Goods goods) {
		return super.findPage(goods);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<Goods> findList(Goods goods) {
		return super.findList(goods);
	}

	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(Goods goods) {
		super.save(goods);
		FileUploadUtils.saveFileUpload(goods.getId(), Goods.FILE_TYPE);
	}

}
