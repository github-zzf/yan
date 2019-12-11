package com.junkj.module.sale.action;

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
import com.junkj.module.sale.biz.SaleTeamBiz;
import com.junkj.module.sale.entity.SaleTeam;

/**
 * 销售团队action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月11日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/saleTeam")
public class SaleTeamAction extends BaseAction {

	@Autowired
	private SaleTeamBiz saleTeamBiz;

	@RequiresPermissions("sale:saleTeam:view")
    @RequestMapping("")
	public String index() {
		return "/module/sale/saleTeam";
	}
	/**
	 * 树数据
	 */
	@RequiresPermissions("sale:saleTeam:view")
	@RequestMapping(value = "treeData")
	@ResponseBody
	public JsonVo treeData(SaleTeam saleTeam) {
		List<Map<String, Object>> mapList = ListUtils.newArrayList();
		saleTeam.setStatus("0");
		List<SaleTeam> list = saleTeamBiz.findList(saleTeam);
		for (SaleTeam tree : list) {
			Map<String, Object> map = MapUtils.newHashMap();
			map.put("id", tree.getId());
			map.put("pId", tree.getParentId());
			map.put("name", StrUtils.getTreeNodeName(null, tree.getId(), tree.getSaleName()));
			mapList.add(map);
		}
		return sendData(mapList);
	}
	/**
	 * 分页数据
	 */
	@RequiresPermissions("sale:saleTeam:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<SaleTeam> listPage(SaleTeam saleTeam) {
		Page<SaleTeam> page = saleTeamBiz.findPage(saleTeam);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("sale:saleTeam:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<SaleTeam> findList(SaleTeam saleTeam) {
		if (StrUtils.isBlank(saleTeam.getParentId())) {
			saleTeam.setParentId(DemoTree.ROOT_ID);
		}
		if (StrUtils.notBlank(saleTeam.getId())){
			saleTeam.setParentId(null);
		}
		if (StrUtils.notBlank(saleTeam.getSaleName())){
			saleTeam.setParentId(null);
		}
		List<SaleTeam> list = saleTeamBiz.findList(saleTeam);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@FormToken
	@RequiresPermissions("sale:saleTeam:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(@Validated SaleTeam saleTeam, BindingResult result) {
		if(result.hasErrors()){
			return sendError(result.getFieldError().getDefaultMessage());
        }
		SaleTeam where = new SaleTeam();
		where.setUserId(saleTeam.getUserId());
		where.setComId(saleTeam.getComId());
		where = saleTeamBiz.getByEntity(where);
		if(saleTeam.getIsNewT()){
			if (where != null) {
				return sendError("用户已存在!");
			}
		}else{
			if (where != null && !where.getId().equals(saleTeam.getId())) {
				return sendError("用户已存在!");
			}
		}
		saleTeamBiz.save(saleTeam);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("sale:saleTeam:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(SaleTeam saleTeam) {
		saleTeamBiz.delete(saleTeam);
		return sendOk("删除成功！");
	}

}