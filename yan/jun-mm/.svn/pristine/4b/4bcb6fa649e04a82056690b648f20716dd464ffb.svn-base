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
import com.junkj.module.sys.biz.SysTemplateBiz;
import com.junkj.module.sys.entity.SysTemplate;

/**
 * 参数配置action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月07日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/sysTemplate")
public class SysTemplateAction extends BaseAction {

	@Autowired
	private SysTemplateBiz sysTemplateBiz;

	@RequiresPermissions("sys:sysTemplate:view")
    @RequestMapping("")
	public String index() {
		return "/module/sys/sysTemplate";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("sys:sysTemplate:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<SysTemplate> listPage(SysTemplate sysTemplate) {
		Page<SysTemplate> page = sysTemplateBiz.findPage(sysTemplate);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("sys:sysTemplate:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<SysTemplate> findList(SysTemplate sysTemplate) {
		List<SysTemplate> list = sysTemplateBiz.findList(sysTemplate);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@RequiresPermissions("sys:sysTemplate:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(SysTemplate sysTemplate) {
		sysTemplateBiz.save(sysTemplate);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("sys:sysTemplate:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(SysTemplate sysTemplate) {
		sysTemplateBiz.delete(sysTemplate);
		return sendOk("删除成功！");
	}

}