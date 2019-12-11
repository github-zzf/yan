package com.junkj.module.cash.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.cash.dao.CashBuyGoodsDao;
import com.junkj.module.cash.entity.CashBuyGoods;

/**
 * 消费明细biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月28日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class CashBuyGoodsBiz extends CrudBiz<CashBuyGoodsDao, CashBuyGoods> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<CashBuyGoods> findPage(CashBuyGoods cashBuyGoods) {
		return super.findPage(cashBuyGoods);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<CashBuyGoods> findList(CashBuyGoods cashBuyGoods) {
		return super.findList(cashBuyGoods);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CashBuyGoods cashBuyGoods) {
		super.save(cashBuyGoods);
	}
	
}
