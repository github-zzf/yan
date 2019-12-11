package com.junkj.module.sys.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.common.entity.Page;
import com.junkj.module.sys.biz.SysLogBiz;
import com.junkj.module.sys.entity.SysLog;

/**
 * 操作日志action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2016-01-29
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "${adminPath}/sysLog")
public class SysLogAction extends BaseAction {

	@Autowired
	private SysLogBiz sysLogBiz;

	@RequiresPermissions("sys:sysLog:view")
	@GetMapping("")
	public String index() {
		return "/module/sys/sysLog";
	}

	/**
	 * 分页查询
	 */
	@RequiresPermissions("sys:sysLog:view")
	@PostMapping("/findLog")
	@ResponseBody
	public Page<SysLog> findLog(SysLog sysLog) {
		Page<SysLog> page = sysLogBiz.findPage(sysLog);
		return page;
	}

}
