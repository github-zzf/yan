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
import com.junkj.common.lang.StrUtils;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.sys.biz.SysAreaBiz;
import com.junkj.module.sys.entity.SysArea;

/**
 * 行政区action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/sysArea")
public class SysAreaAction extends BaseAction {

	@Autowired
	private SysAreaBiz sysAreaBiz;

	@RequiresPermissions("sys:sysArea:view")
    @RequestMapping("")
	public String index() {
		return "/module/sys/sysArea";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("sys:sysArea:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<SysArea> listPage(SysArea sysArea) {
		Page<SysArea> page = sysAreaBiz.findPage(sysArea);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("sys:sysArea:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<SysArea> findList(SysArea sysArea) {
		if (StrUtils.isBlank(sysArea.getParentId())) {
			sysArea.setParentId(SysArea.ROOT_ID);
		}
		if (StrUtils.notBlank(sysArea.getId())){
			sysArea.setParentId(null);
		}
		if (StrUtils.notBlank(sysArea.getName())){
			sysArea.setParentId(null);
		}
		List<SysArea> list = sysAreaBiz.findList(sysArea);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("sys:sysArea:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated SysArea sysArea, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		sysAreaBiz.save(sysArea);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("sys:sysArea:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(SysArea sysArea) {
		sysAreaBiz.delete(sysArea);
		return sendOk("删除成功！");
	}

}