package com.junkj.module.weixin.action;

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
import com.junkj.module.weixin.biz.WxConfigBiz;
import com.junkj.module.weixin.entity.WxConfig;

/**
 * 微信公众号配置action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月22日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/wxConfig")
public class WxConfigAction extends BaseAction {

	@Autowired
	private WxConfigBiz wxConfigBiz;

	@RequiresPermissions("weixin:wxConfig:view")
    @RequestMapping("")
	public String index() {
		return "/module/sys/wxConfig";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("weixin:wxConfig:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<WxConfig> listPage(WxConfig wxConfig) {
		Page<WxConfig> page = wxConfigBiz.findPage(wxConfig);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("weixin:wxConfig:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<WxConfig> findList(WxConfig wxConfig) {
		List<WxConfig> list = wxConfigBiz.findList(wxConfig);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("weixin:wxConfig:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(WxConfig wxConfig) {
		WxConfig where = new WxConfig();
		where.setComId(wxConfig.getComId());
		where = wxConfigBiz.getByEntity(where);
		if(where != null && !where.getId().equals(wxConfig.getId())){
			return sendError("一个企业只能添加一个公众号!");
		}
		wxConfigBiz.save(wxConfig);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("weixin:wxConfig:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(WxConfig wxConfig) {
		wxConfigBiz.delete(wxConfig);
		return sendOk("删除成功！");
	}

}