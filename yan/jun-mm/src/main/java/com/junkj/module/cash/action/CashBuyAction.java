package com.junkj.module.cash.action;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.common.entity.Page;
import com.junkj.common.form.FormToken;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.cash.biz.CashBuyBiz;
import com.junkj.module.cash.biz.CashBuyCardBiz;
import com.junkj.module.cash.biz.CashBuyGoodsBiz;
import com.junkj.module.cash.biz.CashBuyUserBiz;
import com.junkj.module.cash.entity.CashBuy;
import com.junkj.module.cash.entity.CashBuyCard;
import com.junkj.module.cash.entity.CashBuyGoods;
import com.junkj.module.cash.entity.CashBuyUser;
import com.junkj.module.demo.entity.DemoItem;
import com.junkj.module.stock.biz.StockBiz;
import com.junkj.module.stock.entity.Stock;

/**
 * 消费记录action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月28日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "${adminPath}/cashBuy")
public class CashBuyAction extends BaseAction {

	@Autowired
	private CashBuyBiz cashBuyBiz;
	@Autowired
	private CashBuyGoodsBiz cashBuyGoodsBiz;
	@Autowired
	private CashBuyCardBiz cashBuyCardBiz;
	@Autowired
	private CashBuyUserBiz cashBuyUserBiz;
	@Autowired
	private StockBiz stockBiz;

	@RequiresPermissions("cash:cashBuy:view")
	@RequestMapping("")
	public String index() {
		return "/module/cash/cashBuy";
	}

	/**
	 * 子表商品
	 */
	@RequiresPermissions("cash:cashBuy:view")
	@RequestMapping(value = "listChildGoods")
	@ResponseBody
	public List<CashBuyGoods> listChildGoods(CashBuyGoods cashBuyGoods) {
		List<CashBuyGoods> page = cashBuyGoodsBiz.findList(cashBuyGoods);
		return page;
	}

	/**
	 * 子表会员卡
	 */
	@RequiresPermissions("cash:cashBuy:view")
	@RequestMapping(value = "listChildCard")
	@ResponseBody
	public List<CashBuyCard> listChildCard(CashBuyCard cashBuyCard) {
		List<CashBuyCard> page = cashBuyCardBiz.findList(cashBuyCard);
		return page;
	}

	/**
	 * 子表服务人员
	 */
	@RequiresPermissions("cash:cashBuy:view")
	@RequestMapping(value = "listChildUser")
	@ResponseBody
	public List<CashBuyUser> listChildUser(CashBuyUser cashBuyUser) {
		List<CashBuyUser> page = cashBuyUserBiz.findList(cashBuyUser);
		return page;
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("cash:cashBuy:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<CashBuy> listPage(CashBuy cashBuy) {
		Page<CashBuy> page = cashBuyBiz.findPage(cashBuy);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("cash:cashBuy:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<CashBuy> findList(CashBuy cashBuy) {
		List<CashBuy> list = cashBuyBiz.findList(cashBuy);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("cash:cashBuy:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated CashBuy cashBuy, BindingResult result) {
		if (result.hasErrors()) {
			return sendError(result.getFieldError().getDefaultMessage());
		}
		// 库存验证
		// 保存商品明细
		for (CashBuyGoods item : cashBuy.getCashBuyGoods()) {
			if (!DemoItem.STATUS_DELETE.equals(item.getStatus())) {
				Stock where = new Stock();
				where.setGoodsId(item.getGoodsId());
				Stock stock = stockBiz.getByEntity(where);
				if (stock == null) {
					return sendError(item.getGoodsName() + "库存不足！");
				}
				if (stock.getNum() < item.getNum()) {
					return sendError(item.getGoodsName() + "库存不足！");
				}
			}
		}
		cashBuyBiz.save(cashBuy);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("cash:cashBuy:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(CashBuy cashBuy) {
		cashBuyBiz.delete(cashBuy);
		return sendOk("删除成功！");
	}

}