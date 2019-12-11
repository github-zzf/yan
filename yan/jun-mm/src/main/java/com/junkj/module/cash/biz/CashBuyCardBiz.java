package com.junkj.module.cash.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.cash.dao.CashBuyCardDao;
import com.junkj.module.cash.entity.CashBuyCard;

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
public class CashBuyCardBiz extends CrudBiz<CashBuyCardDao, CashBuyCard> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<CashBuyCard> findPage(CashBuyCard cashBuyCard) {
		return super.findPage(cashBuyCard);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<CashBuyCard> findList(CashBuyCard cashBuyCard) {
		return super.findList(cashBuyCard);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CashBuyCard cashBuyCard) {
		super.save(cashBuyCard);
	}
	
}
