package com.junkj.module.member.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.common.entity.Page;
import com.junkj.common.form.FormToken;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.member.biz.MemberBiz;
import com.junkj.module.member.biz.PointsBiz;
import com.junkj.module.member.entity.Member;
import com.junkj.module.member.entity.Points;

/**
 * 会员action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Controller
@RequestMapping(value = "${adminPath}/memberPoints")
public class PointsAction extends BaseAction {

	@Autowired
	private MemberBiz memberBiz;
	@Autowired
	private PointsBiz pointsBiz;

	@RequiresPermissions("member:memberPoints:view")
    @RequestMapping("")
	public String index() {
		return "/module/member/points";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("member:memberPoints:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<Member> listPage(Member member) {
		Page<Member> page = memberBiz.findPage(member);
		return page;
	}

	/**
	 * 添加积分
	 */
	@FormToken
	@RequiresPermissions("member:memberPoints:edit")
	@RequestMapping(value = "updateAddPoints")
	@ResponseBody
	public JsonVo updateAddPoints(Member member) {
		memberBiz.updateAddPoints(member);
		return sendOk("添加成功！");
	}
	
	/**
	 * 积分明细
	 */
	@RequiresPermissions("member:memberPoints:view")
	@RequestMapping(value = "finfPointsList")
	@ResponseBody
	public Object finfPointsList(Points points) {
		return pointsBiz.findPage(points);
	}
	
	/**
	 * 积分兑换
	 */
	@FormToken
	@RequiresPermissions("member:memberPoints:edit")
	@RequestMapping(value = "updateReducePoints")
	@ResponseBody
	public JsonVo updateReducePoints(String id, String giftId) {
		return memberBiz.updateReducePoints(id, giftId);
	}

}
