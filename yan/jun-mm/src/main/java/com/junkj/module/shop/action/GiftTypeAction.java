package com.junkj.module.shop.action;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.common.collect.ListUtils;
import com.junkj.common.collect.MapUtils;
import com.junkj.common.entity.Page;
import com.junkj.common.form.FormToken;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.demo.entity.DemoTree;
import com.junkj.module.shop.biz.GiftTypeBiz;
import com.junkj.module.shop.entity.GiftType;

/**
 * 积分商品分类action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Controller
@RequestMapping(value = "${adminPath}/giftType")
public class GiftTypeAction extends BaseAction {

	@Autowired
	private GiftTypeBiz giftTypeBiz;

	@RequiresPermissions("shop:giftType:view")
    @RequestMapping("")
	public String index() {
		return "/module/shop/giftType";
	}
	
	/**
	 * 树数据
	 */
	@RequiresPermissions("shop:giftType:view")
	@RequestMapping(value = "treeData")
	@ResponseBody
	public JsonVo treeData(GiftType giftType) {
		List<Map<String, Object>> mapList = ListUtils.newArrayList();
		giftType.setStatus("0");
		List<GiftType> list = giftTypeBiz.findList(giftType);
		for (GiftType tree : list) {
			Map<String, Object> map = MapUtils.newHashMap();
			map.put("id", tree.getId());
			map.put("pId", tree.getParentId());
			map.put("name", StrUtils.getTreeNodeName(null, tree.getId(), tree.getName()));
			mapList.add(map);
		}
		return sendData(mapList);
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("shop:giftType:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<GiftType> listPage(GiftType giftType) {
		Page<GiftType> page = giftTypeBiz.findPage(giftType);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("shop:giftType:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<GiftType> findList(GiftType giftType) {
		if (StrUtils.isBlank(giftType.getParentId())) {
			giftType.setParentId(DemoTree.ROOT_ID);
		}
		if (StrUtils.notBlank(giftType.getId())){
			giftType.setParentId(null);
		}
		if (StrUtils.notBlank(giftType.getName())){
			giftType.setParentId(null);
		}
		List<GiftType> list = giftTypeBiz.findList(giftType);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("shop:giftType:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated GiftType giftType, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		giftTypeBiz.save(giftType);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("shop:giftType:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(GiftType giftType) {
		giftTypeBiz.delete(giftType);
		return sendOk("删除成功！");
	}

}