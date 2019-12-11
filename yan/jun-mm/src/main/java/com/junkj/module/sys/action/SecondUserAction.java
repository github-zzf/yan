package com.junkj.module.sys.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.common.entity.Page;
import com.junkj.common.form.FormToken;
import com.junkj.common.utils.UserUtils;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.sys.biz.SysUserBiz;
import com.junkj.module.sys.entity.SysUser;

/**
 * 二级管理员action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019-08-25
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "${adminPath}/secondUser")
public class SecondUserAction extends BaseAction {

	@Autowired
	private SysUserBiz sysUserBiz;

	@GetMapping("")
	public Object index(HttpServletRequest request) {
		return "/module/sys/secondUser";
	}

	/**
	 * 分页条件查询
	 */
	@RequestMapping("/findPage")
	@ResponseBody
	public Page<SysUser> findPage(SysUser sysUser) {
		sysUser.setSysType(SysUser.SYS_TYPE_SECOND); // 二级管理员
		Page<SysUser> page = sysUserBiz.findPage(sysUser);
		return page;
	}

	/**
	 * 取消二级管理员
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(SysUser sysUser) {
		if (UserUtils.isSuperAdmin(sysUser.getId())) {
			return sendError("不允许操作此用户！");
		}
		if (!SysUser.USER_TYPE_STAFF.equals(sysUser.getUserType())) {
			return sendError("不允许操作此用户！");
		}
		// 取消二级管理员
		sysUser.setSysType(SysUser.SYS_TYPE_NONE);
		sysUserBiz.update(sysUser);
		return sendOk();
	}

	/**
	 * 设置为二级管理员
	 */
	@FormToken
	@RequestMapping("/save")
	@ResponseBody
	public JsonVo save(SysUser sysUser) {
		if (UserUtils.isSuperAdmin(sysUser.getId())) {
			return sendError("不允许操作此用户！");
		}
		SysUser u = sysUserBiz.get(sysUser.getId());
		if (!SysUser.USER_TYPE_STAFF.equals(u.getUserType())) {
			return sendError("不允许操作此用户！");
		}
		// 设置为二级管理员
		sysUser.setSysType(SysUser.SYS_TYPE_SECOND);
		sysUserBiz.update(sysUser);
		return sendOk();
	}

}