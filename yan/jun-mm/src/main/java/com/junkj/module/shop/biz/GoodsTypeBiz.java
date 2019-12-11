package com.junkj.module.shop.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.TreeBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.shop.dao.GoodsTypeDao;
import com.junkj.module.shop.entity.GoodsType;

/**
 * 消耗项目分类biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Service
@Transactional(readOnly = true)
public class GoodsTypeBiz extends TreeBiz<GoodsTypeDao, GoodsType> {

	/**
	 * 分页数据
	 */
	@Override
	public Page<GoodsType> findPage(GoodsType goodsType) {
		return super.findPage(goodsType);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<GoodsType> findList(GoodsType goodsType) {
		return super.findList(goodsType);
	}

	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(GoodsType goodsType) {
		super.save(goodsType);
	}

}
