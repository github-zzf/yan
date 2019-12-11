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
import com.junkj.module.sys.biz.SysComOrdersProductBiz;
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
@RequestMapping(value = "/${adminPath}/sysComOrdersProduct")
public class SysComOrdersProductAction extends BaseAction {

	@Autowired
	private SysComOrdersProductBiz sysComOrdersProductBiz;

	@RequiresPermissions("sys:sysComOrdersProduct:view")
    @RequestMapping("")
	public String index() {
		return "/module/sys/sysComOrdersProduct";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("sys:sysComOrdersProduct:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<SysComOrdersProduct> listPage(SysComOrdersProduct sysComOrdersProduct) {
		Page<SysComOrdersProduct> page = sysComOrdersProductBiz.findPage(sysComOrdersProduct);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("sys:sysComOrdersProduct:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<SysComOrdersProduct> findList(SysComOrdersProduct sysComOrdersProduct) {
		List<SysComOrdersProduct> list = sysComOrdersProductBiz.findList(sysComOrdersProduct);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("sys:sysComOrdersProduct:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(SysComOrdersProduct sysComOrdersProduct) {
		sysComOrdersProductBiz.save(sysComOrdersProduct);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("sys:sysComOrdersProduct:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(SysComOrdersProduct sysComOrdersProduct) {
		sysComOrdersProductBiz.delete(sysComOrdersProduct);
		return sendOk("删除成功！");
	}

}