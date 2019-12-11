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
import com.junkj.module.member.biz.CardUserBiz;
import com.junkj.module.member.entity.CardUser;

/**
 * 会员卡消费明细表action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "${adminPath}/cardUser")
public class CardUserAction extends BaseAction {

	@Autowired
	private CardUserBiz cardUserBiz;

	@RequiresPermissions("member:cardUser:view")
    @RequestMapping("")
	public String index() {
		return "/module/member/cardUser";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("member:cardUser:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<CardUser> listPage(CardUser cardUser) {
		Page<CardUser> page = cardUserBiz.findPage(cardUser);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("member:cardUser:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<CardUser> findList(CardUser cardUser) {
		List<CardUser> list = cardUserBiz.findList(cardUser);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("member:cardUser:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(CardUser cardUser) {
		cardUserBiz.save(cardUser);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("member:cardUser:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(CardUser cardUser) {
		cardUserBiz.delete(cardUser);
		return sendOk("删除成功！");
	}

}