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
import com.junkj.module.shop.biz.GoodsBiz;
import com.junkj.module.shop.entity.Goods;

/**
 * 消费项目action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Controller
@RequestMapping(value = "${adminPath}/goods")
public class GoodsAction extends BaseAction {

	@Autowired
	private GoodsBiz goodsBiz;

	@RequiresPermissions("shop:goods:view")
    @RequestMapping("")
	public String index() {
		return "/module/shop/goods";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("shop:goods:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<Goods> listPage(Goods goods) {
		Page<Goods> page = goodsBiz.findPage(goods);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("shop:goods:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<Goods> findList(Goods goods) {
		List<Goods> list = goodsBiz.findList(goods);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("shop:goods:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated Goods goods, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		goodsBiz.save(goods);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("shop:goods:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(Goods goods) {
		goodsBiz.delete(goods);
		return sendOk("删除成功！");
	}

}