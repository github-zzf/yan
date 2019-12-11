package com.junkj.module.company.action;

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
import com.junkj.module.company.biz.CardsBiz;
import com.junkj.module.company.entity.Cards;

/**
 * 储次卡action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Controller
@RequestMapping(value = "${adminPath}/cards")
public class CardsAction extends BaseAction {

	@Autowired
	private CardsBiz cardsBiz;

	@RequiresPermissions("company:cards:view")
    @RequestMapping("")
	public String index() {
		return "/module/company/cards";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("company:cards:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<Cards> listPage(Cards cards) {
		Page<Cards> page = cardsBiz.findPage(cards);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("company:cards:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<Cards> findList(Cards cards) {
		List<Cards> list = cardsBiz.findList(cards);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("company:cards:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated Cards cards, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		cardsBiz.save(cards);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("company:cards:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(Cards cards) {
		cardsBiz.delete(cards);
		return sendOk("删除成功！");
	}

}