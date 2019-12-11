package com.junkj.module.sys.action;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.common.entity.Page;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.sys.biz.SysComMsgBiz;
import com.junkj.module.sys.entity.SysComMsg;

/**
 * 系统消息action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月11日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/sysComMsg")
public class SysComMsgAction extends BaseAction {

	@Autowired
	private SysComMsgBiz sysComMsgBiz;

	@RequiresPermissions("sys:sysComMsg:view")
    @RequestMapping("")
	public String index() {
		return "/module/sys/sysComMsg";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("sys:sysComMsg:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<SysComMsg> listPage(SysComMsg sysComMsg) {
		Page<SysComMsg> page = sysComMsgBiz.findPage(sysComMsg);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("sys:sysComMsg:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<SysComMsg> findList(SysComMsg sysComMsg) {
		List<SysComMsg> list = sysComMsgBiz.findList(sysComMsg);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@RequiresPermissions("sys:sysComMsg:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(SysComMsg sysComMsg) {
		sysComMsgBiz.save(sysComMsg);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("sys:sysComMsg:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(SysComMsg sysComMsg) {
		sysComMsgBiz.delete(sysComMsg);
		return sendOk("删除成功！");
	}

}