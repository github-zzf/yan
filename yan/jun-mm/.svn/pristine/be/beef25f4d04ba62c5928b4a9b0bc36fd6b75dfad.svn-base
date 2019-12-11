package com.junkj.module.sys.action;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.common.entity.Page;
import com.junkj.common.form.FormToken;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.sys.biz.SysCompanyBiz;
import com.junkj.module.sys.entity.SysCompany;

/**
 * 企业action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/sysCompany")
public class SysCompanyAction extends BaseAction {

	@Autowired
	private SysCompanyBiz sysCompanyBiz;

	@RequiresPermissions("sys:sysCompany:view")
    @RequestMapping("")
	public String index() {
		return "/module/sys/sysCompany";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("sys:sysCompany:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<SysCompany> listPage(SysCompany sysCompany) {
		Page<SysCompany> page = sysCompanyBiz.findPage(sysCompany);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("sys:sysCompany:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<SysCompany> findList(SysCompany sysCompany) {
		List<SysCompany> list = sysCompanyBiz.findList(sysCompany);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("sys:sysCompany:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated SysCompany sysCompany, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		sysCompanyBiz.save(sysCompany);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("sys:sysCompany:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(SysCompany sysCompany) {
		sysCompanyBiz.delete(sysCompany);
		return sendOk("删除成功！");
	}

}