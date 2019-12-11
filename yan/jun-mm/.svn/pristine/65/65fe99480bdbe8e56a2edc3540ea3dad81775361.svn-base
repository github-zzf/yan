package com.junkj.module.company.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junkj.common.action.BaseAction;

@Controller
@RequestMapping(value = "/${adminPath}")
public class ViewAction extends BaseAction {


	/**
	 * 活动提前取消时间
	 */
	@RequiresPermissions("company:activityCancelTime:view")
    @RequestMapping("activityCancelTime")
	public String activityCancelTime() {
		return "/module/company/activityCancelTime";
	}

	/**
	 * 卡余额提示
	 */
	@RequiresPermissions("company:cardsRemind:view")
    @RequestMapping("cardsRemind")
	public String cardsRemind() {
		return "/module/company/cardsRemind";
	}

	/**
	 * 课程提前取消时间
	 */
	@RequiresPermissions("company:courseCancelTime:view")
    @RequestMapping("courseCancelTime")
	public String courseCancelTime() {
		return "/module/company/courseCancelTime";
	}
	
	/**
	 * 电话地图
	 */
	@RequiresPermissions("company:phoneCcoordinate:view")
    @RequestMapping("phoneCcoordinate")
	public String phoneCcoordinate() {
		return "/module/company/phoneCcoordinate";
	}
	
	/**
	 * 导购分成比例
	 */
	@RequiresPermissions("company:saleRatio:view")
    @RequestMapping("saleRatio")
	public String saleRatio() {
		return "/module/company/saleRatio";
	}

	/**
	 * 积分比例设置
	 */
	@RequiresPermissions("company:sendPoints:view")
    @RequestMapping("sendPoints")
	public String sendPoints() {
		return "/module/company/sendPoints";
	}

	/**
	 * 奖金统计方式
	 */
	@RequiresPermissions("company:bonusMode:view")
    @RequestMapping("bonusMode")
	public String bonusMode() {
		return "/module/company/bonusMode";
	}
}