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
import com.junkj.module.member.biz.GrowupBiz;
import com.junkj.module.member.entity.Growup;

/**
 * 成长记录action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "${adminPath}/growup")
public class GrowupAction extends BaseAction {

	@Autowired
	private GrowupBiz growupBiz;

	@RequiresPermissions("member:growup:view")
    @RequestMapping("")
	public String index() {
		return "/module/member/growup";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("member:growup:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<Growup> listPage(Growup growup) {
		Page<Growup> page = growupBiz.findPage(growup);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("member:growup:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<Growup> findList(Growup growup) {
		List<Growup> list = growupBiz.findList(growup);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("member:growup:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(Growup growup) {
		growupBiz.save(growup);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("member:growup:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(Growup growup) {
		growupBiz.delete(growup);
		return sendOk("删除成功！");
	}

}