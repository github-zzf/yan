package com.junkj.module.shop.action;

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
import com.junkj.module.shop.biz.GiftExchangeBiz;
import com.junkj.module.shop.entity.GiftExchange;

/**
 * 商品兑换记录action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "${adminPath}/giftExchange")
public class GiftExchangeAction extends BaseAction {

	@Autowired
	private GiftExchangeBiz giftExchangeBiz;

	@RequiresPermissions("shop:giftExchange:view")
    @RequestMapping("")
	public String index() {
		return "/module/shop/giftExchange";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("shop:giftExchange:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<GiftExchange> listPage(GiftExchange giftExchange) {
		Page<GiftExchange> page = giftExchangeBiz.findPage(giftExchange);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("shop:giftExchange:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<GiftExchange> findList(GiftExchange giftExchange) {
		List<GiftExchange> list = giftExchangeBiz.findList(giftExchange);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("shop:giftExchange:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(GiftExchange giftExchange) {
		giftExchangeBiz.save(giftExchange);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("shop:giftExchange:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(GiftExchange giftExchange) {
		giftExchangeBiz.delete(giftExchange);
		return sendOk("删除成功！");
	}

}