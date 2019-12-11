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
import com.junkj.module.sys.biz.SysComProductBiz;
import com.junkj.module.sys.entity.SysComProduct;

/**
 * 消费记录action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/sysComProduct")
public class SysComProductAction extends BaseAction {

	@Autowired
	private SysComProductBiz sysComProductBiz;

	@RequiresPermissions("sys:sysComProduct:view")
    @RequestMapping("")
	public String index() {
		return "/module/sys/sysComProduct";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("sys:sysComProduct:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<SysComProduct> listPage(SysComProduct sysComProduct) {
		Page<SysComProduct> page = sysComProductBiz.findPage(sysComProduct);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("sys:sysComProduct:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<SysComProduct> findList(SysComProduct sysComProduct) {
		List<SysComProduct> list = sysComProductBiz.findList(sysComProduct);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("sys:sysComProduct:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(SysComProduct sysComProduct) {
		sysComProductBiz.save(sysComProduct);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("sys:sysComProduct:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(SysComProduct sysComProduct) {
		sysComProductBiz.delete(sysComProduct);
		return sendOk("删除成功！");
	}

}