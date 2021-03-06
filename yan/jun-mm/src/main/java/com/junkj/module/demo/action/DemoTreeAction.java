package com.junkj.module.demo.action;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.common.collect.ListUtils;
import com.junkj.common.collect.MapUtils;
import com.junkj.common.form.FormToken;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.demo.biz.DemoTreeBiz;
import com.junkj.module.demo.entity.DemoTree;

/**
 * 示例树action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月07日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "${adminPath}/demoTree")
public class DemoTreeAction extends BaseAction {

	@Autowired
	private DemoTreeBiz demoTreeBiz;

	@RequiresPermissions("demo:demoTree:view")
    @RequestMapping("")
	public String index() {
		return "/module/demo/demoTree";
	}
	
	/**
	 * 树数据
	 */
	@RequiresPermissions("demo:demoTree:view")
	@RequestMapping(value = "treeData")
	@ResponseBody
	public JsonVo treeData(DemoTree demoTree) {
		List<Map<String, Object>> mapList = ListUtils.newArrayList();
		demoTree.setStatus("0");
		List<DemoTree> list = demoTreeBiz.findList(demoTree);
		for (DemoTree tree : list) {
			Map<String, Object> map = MapUtils.newHashMap();
			map.put("id", tree.getComId());
			map.put("pId", tree.getParentId());
			map.put("name", StrUtils.getTreeNodeName(null, tree.getComId(), tree.getComName()));
			mapList.add(map);
		}
		return sendData(mapList);
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("demo:demoTree:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public List<DemoTree> listData(DemoTree demoTree) {
		if (StrUtils.isBlank(demoTree.getParentId())) {
			demoTree.setParentId(DemoTree.ROOT_ID);
		}
		if (StrUtils.notBlank(demoTree.getComId())){
			demoTree.setParentId(null);
		}
		if (StrUtils.notBlank(demoTree.getComName())){
			demoTree.setParentId(null);
		}
		List<DemoTree> list = demoTreeBiz.findList(demoTree);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("demo:demoTree:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(DemoTree demoTree) {
		demoTreeBiz.save(demoTree);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("demo:demoTree:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(DemoTree demoTree) {
		demoTreeBiz.delete(demoTree);
		return sendOk("删除成功！");
	}

}