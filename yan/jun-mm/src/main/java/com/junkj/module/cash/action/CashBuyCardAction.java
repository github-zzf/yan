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
import com.junkj.module.cash.biz.CashBuyCardBiz;
import com.junkj.module.cash.entity.CashBuyCard;

/**
 * 消费明细action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月28日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "${adminPath}/cashBuyCard")
public class CashBuyCardAction extends BaseAction {

	@Autowired
	private CashBuyCardBiz cashBuyCardBiz;

	@RequiresPermissions("cash:cashBuyCard:view")
    @RequestMapping("")
	public String index() {
		return "/module/cash/cashBuyCard";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("cash:cashBuyCard:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<CashBuyCard> listPage(CashBuyCard cashBuyCard) {
		Page<CashBuyCard> page = cashBuyCardBiz.findPage(cashBuyCard);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("cash:cashBuyCard:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<CashBuyCard> findList(CashBuyCard cashBuyCard) {
		List<CashBuyCard> list = cashBuyCardBiz.findList(cashBuyCard);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("cash:cashBuyCard:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(CashBuyCard cashBuyCard) {
		cashBuyCardBiz.save(cashBuyCard);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("cash:cashBuyCard:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(CashBuyCard cashBuyCard) {
		cashBuyCardBiz.delete(cashBuyCard);
		return sendOk("删除成功！");
	}

}