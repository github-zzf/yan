package com.junkj.module.company.action;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.junkj.common.action.BaseAction;
import com.junkj.common.form.FormToken;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.company.biz.ComConfigBiz;
import com.junkj.module.company.entity.ComConfig;

/**
 * 参数配置action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月17日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/comConfig")
public class ComConfigAction extends BaseAction {

	@Autowired
	private ComConfigBiz comConfigBiz;

	@RequiresPermissions("company:comConfig:view")
    @RequestMapping("")
	public String index() {
		return "/module/company/comConfig";
	}

	/**
	 * 列表数据配置
	 */
	@RequestMapping(value = "findConfig")
	@ResponseBody
	public List<ComConfig> findConfig(String configKey1,String configKey2,String configKey3) {
		List<ComConfig> list = comConfigBiz.findConfig(configKey1,configKey2,configKey3);
		return list;
	}
	/**
	 * 添加或更新
	 */
	@FormToken
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated ComConfig comConfig, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		String val =  HtmlUtils.htmlUnescape(comConfig.getConfigValue());
		comConfig.setConfigValue(val);
		comConfigBiz.save(comConfig);
		return sendOk("保存成功！");
	}


}