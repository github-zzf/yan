package com.junkj.module.member.action;

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
import com.junkj.module.member.biz.LevelBiz;
import com.junkj.module.member.entity.Level;

/**
 * 会员级别action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Controller
@RequestMapping(value = "${adminPath}/level")
public class LevelAction extends BaseAction {

	@Autowired
	private LevelBiz levelBiz;

	@RequiresPermissions("member:level:view")
    @RequestMapping("")
	public String index() {
		return "/module/member/level";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("member:level:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<Level> listPage(Level level) {
		Page<Level> page = levelBiz.findPage(level);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("member:level:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<Level> findList(Level level) {
		List<Level> list = levelBiz.findList(level);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("member:level:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated Level level, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		levelBiz.save(level);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("member:level:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(Level level) {
		levelBiz.delete(level);
		return sendOk("删除成功！");
	}

}