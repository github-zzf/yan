package com.junkj.module.company.action;

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
import com.junkj.module.company.biz.MobileSettingBiz;
import com.junkj.module.company.entity.MobileSetting;

/**
 * 官网设置action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月17日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/mobileSetting")
public class MobileSettingAction extends BaseAction {

	@Autowired
	private MobileSettingBiz mobileSettingBiz;

	@RequiresPermissions("company:mobileSetting:view")
    @RequestMapping("")
	public String index() {
		return "/module/company/mobileSetting";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("company:mobileSetting:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<MobileSetting> listPage(MobileSetting mobileSetting) {
		Page<MobileSetting> page = mobileSettingBiz.findPage(mobileSetting);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("company:mobileSetting:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<MobileSetting> findList(MobileSetting mobileSetting) {
		List<MobileSetting> list = mobileSettingBiz.findList(mobileSetting);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("company:mobileSetting:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated MobileSetting mobileSetting, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		mobileSettingBiz.save(mobileSetting);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("company:mobileSetting:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(MobileSetting mobileSetting) {
		mobileSettingBiz.delete(mobileSetting);
		return sendOk("删除成功！");
	}

}