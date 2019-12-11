package com.junkj.module.base;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.common.collect.ListUtils;
import com.junkj.common.collect.MapUtils;
import com.junkj.common.entity.Page;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.vo.JsonVo;
import com.junkj.module.cms.biz.ArttypeBiz;
import com.junkj.module.cms.entity.Arttype;
import com.junkj.module.company.biz.CardsBiz;
import com.junkj.module.company.biz.CourseBiz;
import com.junkj.module.company.entity.Cards;
import com.junkj.module.company.entity.Course;
import com.junkj.module.demo.biz.DemoTreeBiz;
import com.junkj.module.demo.entity.DemoTree;
import com.junkj.module.member.biz.CardChangeBiz;
import com.junkj.module.member.biz.MemberBiz;
import com.junkj.module.member.biz.MemberCardBiz;
import com.junkj.module.member.entity.CardChange;
import com.junkj.module.member.entity.Member;
import com.junkj.module.member.entity.MemberCard;
import com.junkj.module.sale.biz.SaleTeamBiz;
import com.junkj.module.sale.entity.SaleTeam;
import com.junkj.module.shop.biz.GiftTypeBiz;
import com.junkj.module.shop.biz.GoodsBiz;
import com.junkj.module.shop.biz.GoodsTypeBiz;
import com.junkj.module.shop.entity.GiftType;
import com.junkj.module.shop.entity.Goods;
import com.junkj.module.shop.entity.GoodsType;
import com.junkj.module.statistics.biz.StatisticsBiz;
import com.junkj.module.stock.biz.StockRecordItemBiz;
import com.junkj.module.stock.entity.StockRecordItem;
import com.junkj.module.sys.biz.SysAreaBiz;
import com.junkj.module.sys.biz.SysCompanyBiz;
import com.junkj.module.sys.biz.SysMenuBiz;
import com.junkj.module.sys.biz.SysProductBiz;
import com.junkj.module.sys.biz.SysUserBiz;
import com.junkj.module.sys.entity.SysArea;
import com.junkj.module.sys.entity.SysCompany;
import com.junkj.module.sys.entity.SysMenu;
import com.junkj.module.sys.entity.SysProduct;
import com.junkj.module.sys.entity.SysUser;

@Controller
@RequestMapping(value = "${adminPath}/list")
public class ListAction extends BaseAction {

	@Autowired
	private SysUserBiz sysUserBiz;
	@Autowired
	private MemberBiz memberBiz;
	@Autowired
	private GoodsTypeBiz goodsTypeBiz;
	@Autowired
	private GiftTypeBiz giftTypeBiz;
	@Autowired
	private SaleTeamBiz saleTeamBiz;
	@Autowired
	private SysMenuBiz sysMenuBiz;
	@Autowired
	private SysAreaBiz sysAreaBiz;
	@Autowired
	private DemoTreeBiz demoTreeBiz;
	@Autowired
	private CourseBiz courseBiz;
	@Autowired
	private CardsBiz cardsBiz;
	@Autowired
	private MemberCardBiz cardBiz;
	@Autowired
	private CardChangeBiz cardChangeBiz;
	@Autowired
	private StockRecordItemBiz stockRecordItemBiz;
	@Autowired
	private GoodsBiz goodsBiz;
	@Autowired
	private SysProductBiz sysProductBiz;
	@Autowired
	private SysCompanyBiz sysCompanyBiz;
	@Autowired
	private StatisticsBiz statisticsBiz;
	@Autowired
	private ArttypeBiz arttypeBiz;
	
	/**
	 * 选择员工数据
	 */
	@PostMapping("/findSysUserPage")
	@ResponseBody
	public Page<SysUser> findSysUserPage(SysUser sysUser) {
		sysUser.setUserType(SysUser.USER_TYPE_STAFF);
		Page<SysUser> page = sysUserBiz.findPage(sysUser);
		return page;
	}
	
	/**
	 * 消费项目树数据
	 */
	@RequestMapping("/treeGoodsTypeData")
	@ResponseBody
	public JsonVo treeGoodsTypeData(GoodsType goodsType) {
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
	 * 积分商品树数据
	 */
	@RequestMapping("/treeGiftTypeData")
	@ResponseBody
	public JsonVo treeGiftTypeData(GiftType giftType) {
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
	 * 导购团队树数据
	 */
	@RequestMapping("/treeSaleTeamData")
	@ResponseBody
	public JsonVo treeSaleTeamData(SaleTeam saleTeam) {
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
	 * 菜单管理树数据
	 */
	@RequestMapping("/treeSysAreaData")
	@ResponseBody
	public JsonVo treeSysAreaData(SysArea sysArea) {
		List<Map<String, Object>> mapList = ListUtils.newArrayList();
		sysArea.setStatus("0");
		List<SysArea> list = sysAreaBiz.findList(sysArea);
		for (SysArea tree : list) {
			Map<String, Object> map = MapUtils.newHashMap();
			map.put("id", tree.getId());
			map.put("pId", tree.getParentId());
			map.put("name", StrUtils.getTreeNodeName(null, tree.getId(), tree.getName()));
			mapList.add(map);
		}
		return sendData(mapList);
	}
	/**
	 * 行政区管理树数据
	 */
	@RequestMapping("/treeSysMenuData")
	@ResponseBody
	public JsonVo treeSysMenuData(SysMenu sysMenu) {
		List<Map<String, Object>> mapList = ListUtils.newArrayList();
		sysMenu.setStatus("0");
		List<SysMenu> list = sysMenuBiz.findList(sysMenu);
		for (SysMenu tree : list) {
			Map<String, Object> map = MapUtils.newHashMap();
			map.put("id", tree.getId());
			map.put("pId", tree.getParentId());
			map.put("name", StrUtils.getTreeNodeName(null, tree.getId(), tree.getName()));
			mapList.add(map);
		}
		return sendData(mapList);
	}
	/**
	 * Demo树数据
	 */
	@RequestMapping("/treeDemoTreeData")
	@ResponseBody
	public JsonVo treeDemoTreeData(DemoTree demoTree) {
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
	 * 分页数据排课表
	 */
	@RequestMapping("/listCoursePage")
	@ResponseBody
	public Page<Course> listCoursePage(Course course) {
		Page<Course> page = courseBiz.findPage(course);
		return page;
	}

	/**
	 * 分页数据储次卡
	 */
	@RequestMapping("/listCardsPage")
	@ResponseBody
	public Page<Cards> listCardsPage(Cards cards) {
		Page<Cards> page = cardsBiz.findPage(cards);
		return page;
	}

	/**
	 * 分页数据会员卡记录
	 */
	@RequestMapping("/listCardPage")
	@ResponseBody
	public Page<MemberCard> listCardPage(MemberCard card) {
		Page<MemberCard> page = cardBiz.findPage(card);
		return page;
	}
	
	/**
	 * 会员卡消费明细表
	 */
	@RequestMapping("/listCardChangePage")
	@ResponseBody
	public Page<CardChange> listCardChangePage(CardChange cardChange) {
		Page<CardChange> page = cardChangeBiz.findPage(cardChange);
		return page;
	}
	
	/**
	 * 出入库明细表
	 */
	@RequestMapping("/listStockRecordItemPage")
	@ResponseBody
	public Page<StockRecordItem> listStockRecordItemPage(StockRecordItem stockRecordItem) {
		Page<StockRecordItem> page = stockRecordItemBiz.findPage(stockRecordItem);
		return page;
	}

	/**
	 * 分页条件查询商品
	 */
	@PostMapping("/listPageGoods")
	@ResponseBody
	public Page<Goods> listPageGoods(Goods goods) {
		goods.setWhere(" is_show <> 0 ");
		Page<Goods> page = goodsBiz.findPage(goods);
		return page;
	}
	/**
	 * 分页条件查询产品
	 */
	@PostMapping("/listPageSysProduct")
	@ResponseBody
	public Page<SysProduct> listPageProduct(SysProduct sysProduct) {
		Page<SysProduct> page = sysProductBiz.findPage(sysProduct);
		return page;
	}
	/**
	 * 分页条件查询会员
	 */
	@PostMapping("/listPageMember")
	@ResponseBody
	public Page<Member> listPageMember(Member member) {
		Page<Member> page = memberBiz.findPage(member);
		return page;
	}
	
	/**
	 * 分页条件查询导购
	 */
	@RequestMapping("/listPageSaleUser")
	@ResponseBody
	public Page<SysUser> listPageSaleUser(SysUser sysUser, String type) {
		sysUser.setUserType(SysUser.USER_TYPE_SALE); // 员工
		// 导购客户弹窗显示未添加导购
		if(SysUser.USER_TYPE_SALE.equals(type)){
			sysUser.setWhere("a.id not in (select DISTINCT user_id from sale_team where com_id=a.com_id)");
		}
		Page<SysUser> page = sysUserBiz.findPage(sysUser);
		return page;
	}

	/**
	 * 分页数据
	 */
	@RequestMapping(value = "/listSysCompanyPage")
	@ResponseBody
	public Page<SysCompany> listSysCompanyPage(SysCompany sysCompany) {
		Page<SysCompany> page = sysCompanyBiz.findPage(sysCompany);
		return page;
	}
	
	/**
	 * 分页数据
	 */
	@RequestMapping(value = "/findCommentContent")
	@ResponseBody
	public Object findCommentContent(@RequestParam Map<String, Object> map) {
		return statisticsBiz.findCommentContent(map);
	}

	/**
	 * 树数据
	 */
	@RequestMapping(value = "treeArttypeData")
	@ResponseBody
	public JsonVo treeArttypeData(Arttype arttype) {
		List<Map<String, Object>> mapList = ListUtils.newArrayList();
		arttype.setStatus("0");
		List<Arttype> list = arttypeBiz.findList(arttype);
		for (Arttype tree : list) {
			Map<String, Object> map = MapUtils.newHashMap();
			map.put("id", tree.getId());
			map.put("pId", tree.getParentId());
			map.put("name", StrUtils.getTreeNodeName(null, tree.getId(), tree.getTypeName()));
			mapList.add(map);
		}
		return sendData(mapList);
	}

	
	/**
	 * 树数据
	 */
	@RequestMapping(value = "treeSysMenu")
	@ResponseBody
	public JsonVo treeData() {
		List<Map<String, Object>> mapList = ListUtils.newArrayList();
		List<SysMenu> list = sysMenuBiz.findSetMenu();
		for (SysMenu tree : list) {
			Map<String, Object> map = MapUtils.newHashMap();
			map.put("id", tree.getId());
			map.put("pId", tree.getParentId());
			map.put("name", StrUtils.getTreeNodeName(null, tree.getComId(), tree.getName()));
			mapList.add(map);
		}
		return sendData(mapList);
	}
}
