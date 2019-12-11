package com.junkj.module.shop.action;

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
import com.junkj.module.shop.biz.GiftBiz;
import com.junkj.module.shop.entity.Gift;

/**
 * 积分商品action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Controller
@RequestMapping(value = "${adminPath}/gift")
public class GiftAction extends BaseAction {

	@Autowired
	private GiftBiz giftBiz;

	@RequiresPermissions("shop:gift:view")
    @RequestMapping("")
	public String index() {
		return "/module/shop/gift";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("shop:gift:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<Gift> listPage(Gift gift) {
		Page<Gift> page = giftBiz.findPage(gift);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("shop:gift:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<Gift> findList(Gift gift) {
		List<Gift> list = giftBiz.findList(gift);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("shop:gift:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated Gift gift, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		giftBiz.save(gift);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("shop:gift:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(Gift gift) {
		giftBiz.delete(gift);
		return sendOk("删除成功！");
	}

}