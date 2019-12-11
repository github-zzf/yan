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
import com.junkj.module.cash.biz.CashMoneyBiz;
import com.junkj.module.cash.entity.CashMoney;

/**
 * 销售金额action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月28日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "${adminPath}/cashMoney")
public class CashMoneyAction extends BaseAction {

	@Autowired
	private CashMoneyBiz cashMoneyBiz;

	@RequiresPermissions("cash:cashMoney:view")
    @RequestMapping("")
	public String index() {
		return "/module/cash/cashMoney";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("cash:cashMoney:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<CashMoney> listPage(CashMoney cashMoney) {
		Page<CashMoney> page = cashMoneyBiz.findPage(cashMoney);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("cash:cashMoney:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<CashMoney> findList(CashMoney cashMoney) {
		List<CashMoney> list = cashMoneyBiz.findList(cashMoney);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("cash:cashMoney:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(CashMoney cashMoney) {
		cashMoneyBiz.save(cashMoney);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("cash:cashMoney:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(CashMoney cashMoney) {
		cashMoneyBiz.delete(cashMoney);
		return sendOk("删除成功！");
	}

}