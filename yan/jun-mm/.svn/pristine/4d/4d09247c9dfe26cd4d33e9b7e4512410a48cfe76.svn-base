package com.junkj.module.shop.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.shop.dao.GiftExchangeDao;
import com.junkj.module.shop.entity.GiftExchange;

/**
 * 商品兑换记录biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class GiftExchangeBiz extends CrudBiz<GiftExchangeDao, GiftExchange> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<GiftExchange> findPage(GiftExchange giftExchange) {
		return super.findPage(giftExchange);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<GiftExchange> findList(GiftExchange giftExchange) {
		return super.findList(giftExchange);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(GiftExchange giftExchange) {
		super.save(giftExchange);
	}
	
}
