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
import com.junkj.module.cash.biz.CashBuyUserBiz;
import com.junkj.module.cash.entity.CashBuyUser;

/**
 * 消费提成比例action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月28日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "${adminPath}/cashBuyUser")
public class CashBuyUserAction extends BaseAction {

	@Autowired
	private CashBuyUserBiz cashBuyUserBiz;

	@RequiresPermissions("cash:cashBuyUser:view")
    @RequestMapping("")
	public String index() {
		return "/module/cash/cashBuyUser";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("cash:cashBuyUser:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<CashBuyUser> listPage(CashBuyUser cashBuyUser) {
		Page<CashBuyUser> page = cashBuyUserBiz.findPage(cashBuyUser);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("cash:cashBuyUser:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<CashBuyUser> findList(CashBuyUser cashBuyUser) {
		List<CashBuyUser> list = cashBuyUserBiz.findList(cashBuyUser);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("cash:cashBuyUser:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(CashBuyUser cashBuyUser) {
		cashBuyUserBiz.save(cashBuyUser);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("cash:cashBuyUser:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(CashBuyUser cashBuyUser) {
		cashBuyUserBiz.delete(cashBuyUser);
		return sendOk("删除成功！");
	}

}