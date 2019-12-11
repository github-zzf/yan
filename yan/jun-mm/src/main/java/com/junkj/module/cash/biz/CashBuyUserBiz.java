package com.junkj.module.cash.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.cash.dao.CashBuyUserDao;
import com.junkj.module.cash.entity.CashBuyUser;

/**
 * 消费提成比例biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月28日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class CashBuyUserBiz extends CrudBiz<CashBuyUserDao, CashBuyUser> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<CashBuyUser> findPage(CashBuyUser cashBuyUser) {
		return super.findPage(cashBuyUser);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<CashBuyUser> findList(CashBuyUser cashBuyUser) {
		return super.findList(cashBuyUser);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(CashBuyUser cashBuyUser) {
		super.save(cashBuyUser);
	}
	
}
