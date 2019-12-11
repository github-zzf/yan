package com.junkj.module.shop.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.TreeBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.shop.dao.GiftTypeDao;
import com.junkj.module.shop.entity.GiftType;

/**
 * 积分商品分类biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Service
@Transactional(readOnly = true)
public class GiftTypeBiz extends TreeBiz<GiftTypeDao, GiftType> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<GiftType> findPage(GiftType giftType) {
		return super.findPage(giftType);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<GiftType> findList(GiftType giftType) {
		return super.findList(giftType);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(GiftType giftType) {
		super.save(giftType);
	}
	
}
