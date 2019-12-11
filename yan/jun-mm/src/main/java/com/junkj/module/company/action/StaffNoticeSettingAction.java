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
import com.junkj.module.company.biz.StaffNoticeSettingBiz;
import com.junkj.module.company.entity.StaffNoticeSetting;

/**
 * 通知设置action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月12日
 */
@Controller
@RequestMapping(value = "/${adminPath}/staffNoticeSetting")
public class StaffNoticeSettingAction extends BaseAction {

	@Autowired
	private StaffNoticeSettingBiz staffNoticeSettingBiz;

	@RequiresPermissions("company:staffNoticeSetting:view")
    @RequestMapping("")
	public String index() {
		return "/module/company/staffNoticeSetting";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("company:staffNoticeSetting:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<StaffNoticeSetting> listPage(StaffNoticeSetting staffNoticeSetting) {
		Page<StaffNoticeSetting> page = staffNoticeSettingBiz.findPage(staffNoticeSetting);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("company:staffNoticeSetting:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<StaffNoticeSetting> findList(StaffNoticeSetting staffNoticeSetting) {
		List<StaffNoticeSetting> list = staffNoticeSettingBiz.findList(staffNoticeSetting);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("company:staffNoticeSetting:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated StaffNoticeSetting staffNoticeSetting, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		StaffNoticeSetting old = staffNoticeSettingBiz.getByUserId(staffNoticeSetting.getUserId());
		if(staffNoticeSetting.getIsNewT()){
			if(StrUtils.notBlank(old)){
				return sendError("重复添加，该导购已添加设置");
			}
		}else{
			if(StrUtils.notBlank(old) && !old.getId().equals(staffNoticeSetting.getId())){
				return sendError("重复添加，该导购已添加设置");
			}
		}
		staffNoticeSettingBiz.save(staffNoticeSetting);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("company:staffNoticeSetting:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(StaffNoticeSetting staffNoticeSetting) {
		staffNoticeSettingBiz.delete(staffNoticeSetting);
		return sendOk("删除成功！");
	}

}