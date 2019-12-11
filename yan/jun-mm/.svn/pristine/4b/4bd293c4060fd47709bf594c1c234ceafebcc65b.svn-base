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
import com.junkj.module.shop.biz.GoodsTypeBiz;
import com.junkj.module.shop.entity.GoodsType;

/**
 * 消耗项目分类action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@Controller
@RequestMapping(value = "${adminPath}/goodsType")
public class GoodsTypeAction extends BaseAction {

	@Autowired
	private GoodsTypeBiz goodsTypeBiz;

	@RequiresPermissions("shop:goodsType:view")
	@RequestMapping("")
	public String index() {
		return "/module/shop/goodsType";
	}

	/**
	 * 树数据
	 */
	@RequiresPermissions("shop:goodsType:view")
	@RequestMapping(value = "treeData")
	@ResponseBody
	public JsonVo treeData(GoodsType goodsType) {
		List<Map<String, Object>> mapList = ListUtils.newArrayList();
		goodsType.setStatus("0");
		List<GoodsType> list = goodsTypeBiz.findList(goodsType);
		for (GoodsType tree : list) {
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
	@RequiresPermissions("shop:goodsType:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<GoodsType> listPage(GoodsType goodsType) {
		Page<GoodsType> page = goodsTypeBiz.findPage(goodsType);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("shop:goodsType:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<GoodsType> findList(GoodsType goodsType) {
		if (StrUtils.isBlank(goodsType.getParentId())) {
			goodsType.setParentId(DemoTree.ROOT_ID);
		}
		if (StrUtils.notBlank(goodsType.getId())) {
			goodsType.setParentId(null);
		}
		if (StrUtils.notBlank(goodsType.getName())) {
			goodsType.setParentId(null);
		}
		List<GoodsType> list = goodsTypeBiz.findList(goodsType);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("shop:goodsType:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated GoodsType goodsType, BindingResult result) {
		if (result.hasErrors()) {
			return sendError(result.getFieldError().getDefaultMessage());
		}
		goodsTypeBiz.save(goodsType);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("shop:goodsType:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(GoodsType goodsType) {
		goodsTypeBiz.delete(goodsType);
		return sendOk("删除成功！");
	}

}