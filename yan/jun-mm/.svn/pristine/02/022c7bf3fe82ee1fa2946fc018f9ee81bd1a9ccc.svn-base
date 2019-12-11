package com.junkj.module.stock.action;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.common.entity.Page;
import com.junkj.common.form.FormToken;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.stock.biz.StockRecordItemBiz;
import com.junkj.module.stock.entity.StockRecordItem;

/**
 * 出入库明细action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月16日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/stockRecordItem")
public class StockRecordItemAction extends BaseAction {

	@Autowired
	private StockRecordItemBiz stockRecordItemBiz;

	@RequiresPermissions("stock:stockRecordItem:view")
    @RequestMapping("")
	public String index() {
		return "/module/stock/stockRecordItem";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("stock:stockRecordItem:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<StockRecordItem> listPage(StockRecordItem stockRecordItem) {
		Page<StockRecordItem> page = stockRecordItemBiz.findPage(stockRecordItem);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("stock:stockRecordItem:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<StockRecordItem> findList(StockRecordItem stockRecordItem) {
		List<StockRecordItem> list = stockRecordItemBiz.findList(stockRecordItem);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("stock:stockRecordItem:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(StockRecordItem stockRecordItem) {
		stockRecordItemBiz.save(stockRecordItem);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("stock:stockRecordItem:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(StockRecordItem stockRecordItem) {
		stockRecordItemBiz.delete(stockRecordItem);
		return sendOk("删除成功！");
	}

}