package com.junkj.module.stock.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.stock.dao.StockDao;
import com.junkj.module.stock.entity.Stock;

/**
 * 库存biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月16日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class StockBiz extends CrudBiz<StockDao, Stock> {

	/**
	 * 分页数据
	 */
	@Override
	public Page<Stock> findPage(Stock stock) {
		return super.findPage(stock);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<Stock> findList(Stock stock) {
		return super.findList(stock);
	}

	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(Stock stock) {
		super.save(stock);
	}

}
