package com.junkj.module.company.action;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.common.entity.Page;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.company.biz.CardsTypeBiz;
import com.junkj.module.company.entity.CardsType;

/**
 * 会员卡分类action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月05日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/cardsType")
public class CardsTypeAction extends BaseAction {

	@Autowired
	private CardsTypeBiz cardsTypeBiz;

	@RequiresPermissions("company:cardsType:view")
    @RequestMapping("")
	public String index() {
		return "/module/company/cardsType";
	}

	/**
	 * 分页数据
	 */
	@RequiresPermissions("company:cardsType:view")
	@RequestMapping(value = "listPage")
	@ResponseBody
	public Page<CardsType> listPage(CardsType cardsType) {
		Page<CardsType> page = cardsTypeBiz.findPage(cardsType);
		return page;
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("company:cardsType:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<CardsType> findList(CardsType cardsType) {
		List<CardsType> list = cardsTypeBiz.findList(cardsType);
		return list;
	}

	/**
	 * 添加或更新
	 */
	@RequiresPermissions("company:cardsType:edit")
	@RequestMapping(value = "save")
	@ResponseBody
	public JsonVo save(CardsType cardsType) {
		cardsTypeBiz.save(cardsType);
		return sendOk("保存成功！");
	}

	/**
	 * 删除
	 */
	@RequiresPermissions("company:cardsType:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonVo delete(CardsType cardsType) {
		cardsTypeBiz.delete(cardsType);
		return sendOk("删除成功！");
	}

}