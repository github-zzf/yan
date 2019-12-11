package com.junkj.module.sys.action;

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
import com.junkj.module.sys.biz.SysBeanDataBiz;
import com.junkj.module.sys.entity.SysBeanData;

/**
 * 数据字典数据action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/sysBeanData")
public class SysBeanDataAction extends BaseAction {

	@Autowired
	private SysBeanDataBiz sysBeanDataBiz;

	@RequiresPermissions("sys:sysBeanData:view")
    @RequestMapping("")
	public String index() {
		return "/module/sys/sysBeanData";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("sys:sysBeanData:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<SysBeanData> listPage(SysBeanData sysBeanData) {
		Page<SysBeanData> page = sysBeanDataBiz.findPage(sysBeanData);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("sys:sysBeanData:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<SysBeanData> findList(SysBeanData sysBeanData) {
		List<SysBeanData> list = sysBeanDataBiz.findList(sysBeanData);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("sys:sysBeanData:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(SysBeanData sysBeanData) {
		sysBeanDataBiz.save(sysBeanData);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("sys:sysBeanData:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(SysBeanData sysBeanData) {
		sysBeanDataBiz.delete(sysBeanData);
		return sendOk("删除成功！");
	}

}