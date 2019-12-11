package com.junkj.module.sys.action;

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
import com.junkj.module.sys.biz.SysBeanDataBiz;
import com.junkj.module.sys.biz.SysBeanTypeBiz;
import com.junkj.module.sys.entity.SysBeanData;
import com.junkj.module.sys.entity.SysBeanType;

/**
 * 数据字典类型action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/sysBeanType")
public class SysBeanTypeAction extends BaseAction {

	@Autowired
	private SysBeanTypeBiz sysBeanTypeBiz;
	@Autowired
	private SysBeanDataBiz sysBeanDataBiz;

	@RequiresPermissions("sys:sysBeanType:view")
	@RequestMapping("")
	public String index() {
		return "/module/sys/sysBeanType";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("sys:sysBeanType:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<SysBeanType> listPage(SysBeanType sysBeanType) {
		Page<SysBeanType> page = sysBeanTypeBiz.findPage(sysBeanType);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("sys:sysBeanType:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<SysBeanType> findList(SysBeanType sysBeanType) {
		List<SysBeanType> list = sysBeanTypeBiz.findList(sysBeanType);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("sys:sysBeanType:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated SysBeanType sysBeanType, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		SysBeanType old = sysBeanTypeBiz.getByBeanKey(sysBeanType.getBeanKey());
		if (sysBeanType.getIsNewT()) {
			if (StrUtils.notBlank(old)) {
				return sendError("重复添加，该字典已添加设置");
			}
		} else {
			if (StrUtils.notBlank(old) && !old.getId().equals(sysBeanType.getId())) {
				return sendError("重复添加，该字典已添加设置");
			}
		}
		for (SysBeanData item : sysBeanType.getSysBeanData()) {
			if (!SysBeanData.STATUS_DELETE.equals(item.getStatus())){
				for (SysBeanData item2 : sysBeanType.getSysBeanData()) {
					if (!SysBeanData.STATUS_DELETE.equals(item2.getStatus())){
						if (item.getBeanVal().equals(item2.getBeanVal()) && item2.getId() != item.getId()) {
							return sendError("重复添加，字典值已存在");
						}
					}
				}
				SysBeanData oldData = sysBeanDataBiz.getByBeanVal(sysBeanType.getBeanKey(), item.getBeanVal());
				if (item.getIsNewT()){
					if (StrUtils.notBlank(oldData)) {
						return sendError("重复添加，字典值已存在");
					}
				} else {
					if (StrUtils.notBlank(oldData) && !oldData.getId().equals(item.getId())) {
						return sendError("重复添加，字典值已存在");
					}
				}
			}
		}
		sysBeanTypeBiz.save(sysBeanType);
		return sendOk("保存成功！");
	}

	/**
	 * 子表数据
	 */
	@RequiresPermissions("sys:sysBeanType:view")
	@RequestMapping(value = "listChild")
	@ResponseBody
	public List<SysBeanData> listChild(SysBeanData sysBeanData) {
		List<SysBeanData> page = sysBeanTypeBiz.findChild(sysBeanData);
		return page;
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("sys:sysBeanType:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(SysBeanType sysBeanType) {
		SysBeanData sysBeanData = new SysBeanData();
		sysBeanData.setBeanKey(sysBeanTypeBiz.getByEntity(sysBeanType).getBeanKey());
		// 根据key获取子表数据
		List<SysBeanData> page = sysBeanTypeBiz.findChild(sysBeanData);
		for (SysBeanData item : page) {
			sysBeanDataBiz.delete(item);
		}
		sysBeanTypeBiz.delete(sysBeanType);
		return sendOk("删除成功！");
	}

}