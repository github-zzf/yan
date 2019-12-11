package com.junkj.module.company.action;

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
import com.junkj.module.company.biz.WorkMsgBiz;
import com.junkj.module.company.entity.WorkMsg;

/**
 * 消息通知action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月23日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/workMsg")
public class WorkMsgAction extends BaseAction {

	@Autowired
	private WorkMsgBiz workMsgBiz;

	@RequiresPermissions("company:workMsg:view")
    @RequestMapping("")
	public String index() {
		return "/module/company/workMsg";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("company:workMsg:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<WorkMsg> listPage(WorkMsg workMsg) {
		Page<WorkMsg> page = workMsgBiz.findPage(workMsg);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("company:workMsg:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<WorkMsg> findList(WorkMsg workMsg) {
		List<WorkMsg> list = workMsgBiz.findList(workMsg);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("company:workMsg:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(WorkMsg workMsg) {
		workMsgBiz.save(workMsg);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("company:workMsg:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(WorkMsg workMsg) {
		workMsgBiz.delete(workMsg);
		return sendOk("删除成功！");
	}

}