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
import com.junkj.module.sys.biz.SysComOrdersBiz;
import com.junkj.module.sys.entity.SysComOrders;
import com.junkj.module.sys.entity.SysComOrdersProduct;

/**
 * 消费记录action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/sysComOrders")
public class SysComOrdersAction extends BaseAction {

	@Autowired
	private SysComOrdersBiz sysComOrdersBiz;

	@RequiresPermissions("sys:sysComOrders:view")
    @RequestMapping("")
	public String index() {
		return "/module/sys/sysComOrders";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("sys:sysComOrders:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<SysComOrders> listPage(SysComOrders sysComOrders) {
		Page<SysComOrders> page = sysComOrdersBiz.findPage(sysComOrders);
		return page;
	}

	/**
	 * 子表数据
	 */
	@RequiresPermissions("sys:sysComOrders:view")
	@RequestMapping(value = "listSysComOrdersProduct")
	@ResponseBody
	public List<SysComOrdersProduct> listSysComOrdersProduct(SysComOrdersProduct sysComOrdersProduct) {
		List<SysComOrdersProduct> page = sysComOrdersBiz.listSysComOrdersProduct(sysComOrdersProduct);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("sys:sysComOrders:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<SysComOrders> findList(SysComOrders sysComOrders) {
		List<SysComOrders> list = sysComOrdersBiz.findList(sysComOrders);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("sys:sysComOrders:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated SysComOrders sysComOrders, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		sysComOrdersBiz.save(sysComOrders);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("sys:sysComOrders:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(SysComOrders sysComOrders) {
		sysComOrdersBiz.delete(sysComOrders);
		return sendOk("删除成功！");
	}

}