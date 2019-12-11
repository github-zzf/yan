package com.junkj.module.cash.action;

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
import com.junkj.module.cash.biz.CashBuyGoodsBiz;
import com.junkj.module.cash.entity.CashBuyGoods;

/**
 * 消费明细action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月28日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "${adminPath}/cashBuyGoods")
public class CashBuyGoodsAction extends BaseAction {

	@Autowired
	private CashBuyGoodsBiz cashBuyGoodsBiz;

	@RequiresPermissions("cash:cashBuyGoods:view")
    @RequestMapping("")
	public String index() {
		return "/module/cash/cashBuyGoods";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("cash:cashBuyGoods:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<CashBuyGoods> listPage(CashBuyGoods cashBuyGoods) {
		Page<CashBuyGoods> page = cashBuyGoodsBiz.findPage(cashBuyGoods);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("cash:cashBuyGoods:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<CashBuyGoods> findList(CashBuyGoods cashBuyGoods) {
		List<CashBuyGoods> list = cashBuyGoodsBiz.findList(cashBuyGoods);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("cash:cashBuyGoods:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(CashBuyGoods cashBuyGoods) {
		cashBuyGoodsBiz.save(cashBuyGoods);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("cash:cashBuyGoods:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(CashBuyGoods cashBuyGoods) {
		cashBuyGoodsBiz.delete(cashBuyGoods);
		return sendOk("删除成功！");
	}

}