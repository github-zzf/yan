package com.junkj.module.stock.biz;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.CrudBiz;
import com.junkj.common.collect.ListUtils;
import com.junkj.common.entity.Page;
import com.junkj.common.lang.DateUtils;
import com.junkj.common.lang.NumUtils;
import com.junkj.common.utils.ComUtils;
import com.junkj.module.cash.entity.CashBuyGoods;
import com.junkj.module.demo.entity.DemoItem;
import com.junkj.module.stock.dao.StockRecordDao;
import com.junkj.module.stock.entity.Stock;
import com.junkj.module.stock.entity.StockRecord;
import com.junkj.module.stock.entity.StockRecordItem;

import freemarker.template.utility.NumberUtil;

/**
 * 出入库记录biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月16日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class StockRecordBiz extends CrudBiz<StockRecordDao, StockRecord> {

	@Autowired
	private StockRecordItemBiz stockRecordItemBiz;
	@Autowired
	private StockBiz stockBiz;

	/**
	 * 分页数据
	 */
	@Override
	public Page<StockRecord> findPage(StockRecord stockRecord) {
		return super.findPage(stockRecord);
	}

	/**
	 * 列表数据
	 */
	@Override
	public List<StockRecord> findList(StockRecord stockRecord) {
		return super.findList(stockRecord);
	}

	/**
	 * 添加
	 */
	@Override
	@Transactional(readOnly = false)
	public void save(StockRecord stockRecord) {
		stockRecord.setCode(getCode());
		super.save(stockRecord);
		for (StockRecordItem item : stockRecord.getStockRecordItem()) {
			if (!DemoItem.STATUS_DELETE.equals(item.getStatus())) {
				item.setRecordId(stockRecord.getId());
				item.preInsert();

				// 更新库存
				updateStock(item, stockRecord.getRecordType());

				// 保存明细
				stockRecordItemBiz.insert(item);
			}
		}

		super.save(stockRecord);
	}

	// 库存加减
	private void updateStock(StockRecordItem item, String recordType) {
		Stock where = new Stock();
		where.setGoodsId(item.getGoodsId());
		Stock stock = stockBiz.getByEntity(where);
		if (stock == null) {
			stock = new Stock();
			stock.setGoodsId(item.getGoodsId());
			stock.setNum(0D);
		}
		// 入库
		if (StockRecord.RECORD_TYPE_1.endsWith(recordType)) {
			item.setNumType(StockRecordItem.NUM_TYPE_1);
			Double num = NumUtils.add(stock.getNum(), item.getNum());
			stock.setNum(num);
			item.setNumNew(num);
			// 出库
		} else if (StockRecord.RECORD_TYPE_2.endsWith(recordType)) {
			item.setNumType(StockRecordItem.NUM_TYPE_2);
			Double num = NumUtils.subtract(stock.getNum(), item.getNum());
			stock.setNum(num);
			item.setNumNew(num);
			// 报损
		} else if (StockRecord.RECORD_TYPE_3.endsWith(recordType)) {
			item.setNumType(StockRecordItem.NUM_TYPE_2);
			Double num = NumUtils.subtract(stock.getNum(), item.getNum());
			stock.setNum(num);
			item.setNumNew(num);
			// 盘点
		} else if (StockRecord.RECORD_TYPE_4.endsWith(recordType)) {
			item.setNumType(StockRecordItem.NUM_TYPE_3);
			stock.setNum(item.getNum());
			item.setNumNew(item.getNum());
		}
		stockBiz.save(stock);
	}

	// 生成单据编号
	public String getCode() {
		String comId = ComUtils.getCurrentComId();
		Date now = new Date();
		String year = DateUtils.format(now, "yyyy");
		String day = DateUtils.format(now, "yyyyMMdd");
		String code = "";

		StockRecord where = new StockRecord();
		where.setPageNum(1);
		where.setOrderBy("code desc");
		where.setWhere("year(a.create_time)=#{year}");
		where.setYear(year);
		List<StockRecord> list = dao.findList(where);
		if (list.size() > 0) {
			String maxCode = list.get(0).getCode();
			String str = maxCode.substring(maxCode.length() - 6);
			Long num = Long.valueOf(str) + 1;
			code = comId + "_" + day + String.format("%06d", num);
		} else {
			code = comId + "_" + day + "000001";
		}
		return code;
	}

}
