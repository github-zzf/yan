package com.junkj.module.sale.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import com.junkj.common.action.BaseAction;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.utils.JsonUtils;
import com.junkj.module.sale.biz.SalePerformanceBiz;

/**
 * 导购业绩action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月11日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/salePerformance")
public class SalePerformanceAction extends BaseAction {

	@Autowired
	private SalePerformanceBiz salePerformanceBiz;

	@RequiresPermissions("sale:salePerformance:view")
	@RequestMapping("")
	public String index() {
		return "/module/sale/salePerformance";
	}

	/**
	 * 列表数据
	 */
	@RequiresPermissions("sale:salePerformance:view")
	@RequestMapping(value = "findList")
	@ResponseBody
	public List<Map<String, Object>> findList(@RequestParam Map<String, Object> map) {
		List<Map<String, Object>> list = salePerformanceBiz.findList(map);
		return list;
	}

	/**
	 * 总账导出
	 */
	@RequestMapping(value = "/excelDownload", method = RequestMethod.GET)
	@ResponseBody
	public void excelDownload(HttpServletResponse response, @RequestParam Map<String, Object> params) {
		String data = HtmlUtils.htmlUnescape(params.get("col").toString());
		if (StrUtils.notBlank(params.get("col"))) {
			List<Map<String, Object>> colList = JsonUtils.toObject(data, List.class);
			String[] headerColumns = new String[colList.size()];
			String[] fieldColumns = new String[colList.size()];
			for (int index = 0; index < colList.size(); index++) {
				Map<String, Object> map = colList.get(index);
				headerColumns[index] = "" + map.get("name").toString() + "_#_" + map.get("width").toString() + "";
				fieldColumns[index] = "" + map.get("col").toString();
			}
			excelDownloadT(response, salePerformanceBiz.findList(params), "导购业绩", headerColumns, fieldColumns);
		}
	}

}