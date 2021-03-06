package com.junkj.module.member.action;

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
import com.junkj.module.member.biz.CardChangeBiz;
import com.junkj.module.member.entity.CardChange;

/**
 * 会员卡消费明细表action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Controller
@RequestMapping(value = "${adminPath}/cardChange")
public class CardChangeAction extends BaseAction {

	@Autowired
	private CardChangeBiz cardChangeBiz;

	@RequiresPermissions("member:cardChange:view")
    @RequestMapping("")
	public String index() {
		return "/module/member/cardChange";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("member:cardChange:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<CardChange> listPage(CardChange cardChange) {
		Page<CardChange> page = cardChangeBiz.findPage(cardChange);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("member:cardChange:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<CardChange> findList(CardChange cardChange) {
		List<CardChange> list = cardChangeBiz.findList(cardChange);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("member:cardChange:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(CardChange cardChange) {
		cardChangeBiz.save(cardChange);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("member:cardChange:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(CardChange cardChange) {
		cardChangeBiz.delete(cardChange);
		return sendOk("删除成功！");
	}

}