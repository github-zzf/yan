package com.junkj.module.stock.biz;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.entity.Page;
import com.junkj.module.stock.dao.StockRecordItemDao;
import com.junkj.module.stock.entity.StockRecordItem;

/**
 * 出入库明细biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月16日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class StockRecordItemBiz extends CrudBiz<StockRecordItemDao, StockRecordItem> {
	
	/**
	 * 分页数据
	 */
	@Override
	public Page<StockRecordItem> findPage(StockRecordItem stockRecordItem) {
		return super.findPage(stockRecordItem);
	}
	
	/**
	 * 列表数据
	 */
	@Override
	public List<StockRecordItem> findList(StockRecordItem stockRecordItem) {
		return super.findList(stockRecordItem);
	}
	
	/**
	 * 添加或更新
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(StockRecordItem stockRecordItem) {
		super.save(stockRecordItem);
	}
	
}
