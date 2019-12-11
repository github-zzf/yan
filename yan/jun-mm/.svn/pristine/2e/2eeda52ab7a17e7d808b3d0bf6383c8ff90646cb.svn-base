package com.junkj.module.company.action;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.common.entity.Page;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.company.biz.ComMemberBiz;
import com.junkj.module.company.entity.ComMember;

/**
 * 企业会员action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月04日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/comMember")
public class ComMemberAction extends BaseAction {

	@Autowired
	private ComMemberBiz comMemberBiz;

	@RequiresPermissions("company:comMember:view")
    @RequestMapping("")
	public String index() {
		return "/module/company/comMember";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("company:comMember:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<ComMember> listPage(ComMember comMember) {
		Page<ComMember> page = comMemberBiz.findPage(comMember);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("company:comMember:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<ComMember> findList(ComMember comMember) {
		List<ComMember> list = comMemberBiz.findList(comMember);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@RequiresPermissions("company:comMember:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(ComMember comMember) {
		comMemberBiz.save(comMember);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("company:comMember:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(ComMember comMember) {
		comMemberBiz.delete(comMember);
		return sendOk("删除成功！");
	}

}