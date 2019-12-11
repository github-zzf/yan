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
import com.junkj.common.lang.StrUtils;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.company.biz.StaffMoneySettingBiz;
import com.junkj.module.company.entity.StaffMoneySetting;

/**
 * 提成设置action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月12日
 */
@Controller
@RequestMapping(value = "/${adminPath}/staffMoneySetting")
public class StaffMoneySettingAction extends BaseAction {

	@Autowired
	private StaffMoneySettingBiz staffMoneySettingBiz;

	@RequiresPermissions("company:staffMoneySetting:view")
	@RequestMapping("")
	public String index() {
		return "/module/company/staffMoneySetting";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("company:staffMoneySetting:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<StaffMoneySetting> listPage(StaffMoneySetting staffMoneySetting) {
		Page<StaffMoneySetting> page = staffMoneySettingBiz.findPage(staffMoneySetting);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("company:staffMoneySetting:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<StaffMoneySetting> findList(StaffMoneySetting staffMoneySetting) {
		List<StaffMoneySetting> list = staffMoneySettingBiz.findList(staffMoneySetting);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("company:staffMoneySetting:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated StaffMoneySetting staffMoneySetting, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		StaffMoneySetting old = staffMoneySettingBiz.getByUserId(staffMoneySetting.getUserId());
		if (staffMoneySetting.getIsNewT()) {
			if (StrUtils.notBlank(old)) {
				return sendError("重复添加，该导购已添加设置");
			}
		} else {
			if (StrUtils.notBlank(old) && !old.getId().equals(staffMoneySetting.getId())) {
				return sendError("重复添加，该导购已添加设置");
			}
		}
		staffMoneySettingBiz.save(staffMoneySetting);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("company:staffMoneySetting:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(StaffMoneySetting staffMoneySetting) {
		staffMoneySettingBiz.delete(staffMoneySetting);
		return sendOk("删除成功！");
	}

}