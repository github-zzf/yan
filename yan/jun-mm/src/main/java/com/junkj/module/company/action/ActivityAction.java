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
import com.junkj.module.company.biz.ActivityBiz;
import com.junkj.module.company.biz.ActivityEnrollBiz;
import com.junkj.module.company.entity.Activity;
import com.junkj.module.company.entity.ActivityEnroll;

/**
 * 活动action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Controller
@RequestMapping(value = "${adminPath}/activity")
public class ActivityAction extends BaseAction {

	@Autowired
	private ActivityBiz activityBiz;
	@Autowired
	private ActivityEnrollBiz activityEnrollBiz;

	@RequiresPermissions("company:activity:view")
    @RequestMapping("")
	public String index() {
		return "/module/company/activity";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("company:activity:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<Activity> listPage(Activity activity) {
		Page<Activity> page = activityBiz.findPage(activity);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("company:activity:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<Activity> findList(Activity activity) {
		List<Activity> list = activityBiz.findList(activity);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("company:activity:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated Activity activity, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		activityBiz.save(activity);
		return sendOk("保存成功！");
	}
	
	/**
	 * 清空会员卡
	 */
	@FormToken
	@RequiresPermissions("company:activity:edit")
	@RequestMapping(value = "updateActivityCardIdNull")
	@ResponseBody
	public JsonVo updateActivityCardIdNull(Activity activity) {
		activityBiz.updateActivityCardIdNull(activity);
		return sendOk("清空成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("company:activity:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(Activity activity) {
		ActivityEnroll where = new ActivityEnroll();
		where.setActivityId(activity.getId());
		List<ActivityEnroll> list = activityEnrollBiz.findList(where);
		if(list.size() > 0){
			return sendError("请先删除报名记录!");
		}
		activityBiz.delete(activity);
		return sendOk("删除成功！");
	}

}