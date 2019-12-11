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
import com.junkj.module.company.biz.ComTemplateBiz;
import com.junkj.module.company.entity.ComTemplate;

/**
 * 企业模板消息action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月07日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/comTemplate")
public class ComTemplateAction extends BaseAction {

	@Autowired
	private ComTemplateBiz comTemplateBiz;

	@RequiresPermissions("company:comTemplate:view")
    @RequestMapping("")
	public String index() {
		return "/module/company/comTemplate";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("company:comTemplate:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<ComTemplate> listPage(ComTemplate comTemplate) {
		Page<ComTemplate> page = comTemplateBiz.findPage(comTemplate);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("company:comTemplate:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<ComTemplate> findList(ComTemplate comTemplate) {
		List<ComTemplate> list = comTemplateBiz.findList(comTemplate);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@RequiresPermissions("company:comTemplate:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(ComTemplate comTemplate) {
		comTemplateBiz.save(comTemplate);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("company:comTemplate:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(ComTemplate comTemplate) {
		comTemplateBiz.delete(comTemplate);
		return sendOk("删除成功！");
	}

}