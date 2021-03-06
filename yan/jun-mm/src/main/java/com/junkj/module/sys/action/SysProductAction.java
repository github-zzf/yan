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
import com.junkj.module.sys.biz.SysProductBiz;
import com.junkj.module.sys.entity.SysProduct;

/**
 * 平台产品action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/sysProduct")
public class SysProductAction extends BaseAction {

	@Autowired
	private SysProductBiz sysProductBiz;

	@RequiresPermissions("sys:sysProduct:view")
    @RequestMapping("")
	public String index() {
		return "/module/sys/sysProduct";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("sys:sysProduct:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<SysProduct> listPage(SysProduct sysProduct) {
		Page<SysProduct> page = sysProductBiz.findPage(sysProduct);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("sys:sysProduct:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<SysProduct> findList(SysProduct sysProduct) {
		List<SysProduct> list = sysProductBiz.findList(sysProduct);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("sys:sysProduct:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated SysProduct sysProduct, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		sysProductBiz.save(sysProduct);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("sys:sysProduct:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(SysProduct sysProduct) {
		sysProductBiz.delete(sysProduct);
		return sendOk("删除成功！");
	}

}