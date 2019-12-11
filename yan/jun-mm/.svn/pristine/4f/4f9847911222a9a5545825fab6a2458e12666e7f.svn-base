package com.junkj.module.cash.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.cash.dao.CashMoneyDao;
import com.junkj.module.cash.entity.CashMoney;

/**
 * 销售金额biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月28日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class CashMoneyBiz extends CrudBiz<CashMoneyDao, CashMoney> {

	/**
	 * 分页数据
	 */
	@Override
	public Page<CashMoney> findPage(CashMoney cashMoney) {
		return super.findPage(cashMoney);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<CashMoney> findList(CashMoney cashMoney) {
		return super.findList(cashMoney);
	}

	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(CashMoney cashMoney) {
		super.save(cashMoney);
	}

	/**
	 * 删除销售记录
	 */
	public void deleteByBizType(String bizType, String bizId, String buyType) {
		dao.deleteByBizType(bizType, bizId, buyType);
	}

}
