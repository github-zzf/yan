package com.junkj.module.sale.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.lang.NumUtils;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.utils.ComUtils;
import com.junkj.common.utils.UserUtils;
import com.junkj.module.company.biz.ComConfigBiz;
import com.junkj.module.company.entity.ComConfig;
import com.junkj.module.sale.dao.SalePerformanceDao;

/**
 * 导购客户biz
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月11日
 * @version: 1.0.0
 */
@Service
@Transactional(readOnly = true)
public class SalePerformanceBiz{
	@Autowired
	private SalePerformanceDao salePerformanceDao;
	@Autowired
	private ComConfigBiz comConfigBiz;
	/**
	 * 列表数据
	 */
	public List<Map<String,Object>> findList(Map<String, Object> map) {
		map.put("comId", ComUtils.getCurrentComId());
		ComConfig where = new ComConfig();
		where.setConfigKey("sale_ratio_1");
		ComConfig comConfig = comConfigBiz.getByEntity(where);
		Double value1 = 0D;
		Double value2 = 0D;
		if (StrUtils.notBlank(comConfig)) {
			value1 = NumUtils.toDouble(comConfig.getConfigValue(), 0)==0?0:NumUtils.toDouble(comConfig.getConfigValue(), 0)/100;
			where.setConfigKey("sale_ratio_2");
			comConfig = comConfigBiz.getByEntity(where);
			value2 = NumUtils.toDouble(comConfig.getConfigValue(), 0)==0?0:NumUtils.toDouble(comConfig.getConfigValue(), 0)/100;
		}
		List<Map<String, Object>> list = salePerformanceDao.findList(map);
		for (Map<String, Object> map2 : list) {
			map2.put("saleMoney", NumUtils.multiply(Double.valueOf(map2.get("dgMoney").toString()),value1));
			map2.put("teamMoney", NumUtils.multiply(Double.valueOf(map2.get("tuanMoney").toString()),value2));
			map2.put("zMoney", NumUtils.add(Double.valueOf(map2.get("saleMoney").toString()), Double.valueOf(map2.get("teamMoney").toString())));
		}
		return list;
	}
	
	
	
}
