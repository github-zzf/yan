package com.junkj.module.statistics.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.module.statistics.biz.StatisticsBiz;

/**
 * 积分商品action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月16日
 */
@Controller
@RequestMapping(value = "${adminPath}/statistics")
public class StatisticsAction extends BaseAction {
	
	@Autowired
	private StatisticsBiz statisticsBiz;
	
	/**
	 * 我的统计
	 * @return
	 */
    @RequestMapping("/myStatistics")
	public String myStatistics() {
    	return "/module/tongJi/myStatistics";
	}
    
    /**
     * 管理员统计
     * @return
     */
    @RequestMapping("/adminStatistics")
    public String adminStatistics() {
    	return "/module/tongJi/adminStatistics";
    }
    /**
     * 课时奖金统计
     * @return
     */
    @RequestMapping("/classStatistics")
    public String classStatistics() {
    	return "/module/tongJi/classStatistics";
    }
    /**
     * 每天统计
     * @return
     */
    @RequestMapping("/dayStatistics")
    public String dayStatistics() {
    	return "/module/tongJi/dayStatistics";
    }
    
    /**
     * 我的统计数据查询
     * @return
     */
	@RequestMapping(value = "/findMyStatistics")
	@ResponseBody
	public Object findMyStatistics(@RequestParam Map<String, Object> map) {
		return statisticsBiz.findMyStatistics(map);
	}
    
    /**
     * 管理员统计数据查询
     * @return
     */
	@RequestMapping(value = "/findAdminStatistics")
	@ResponseBody
	public Object findAdminStatistics(@RequestParam Map<String, Object> map) {
		return statisticsBiz.findAdminStatistics(map);
	}
	
	/**
	 * 管理员统计表数据查询
	 * @return
	 */
	@RequestMapping(value = "/findAdminStatisticsTable")
	@ResponseBody
	public List<Map<String,Object>> findAdminStatisticsTable(@RequestParam Map<String, Object> map) {
		return statisticsBiz.findAdminStatisticsTable(map);
	}
    
    /**
     * 每天统计数据查询
     * @return
     */
	@RequestMapping(value = "/findDayStatistics")
	@ResponseBody
	public Object findDayStatistics(@RequestParam Map<String, Object> map) {
		return statisticsBiz.findDayStatistics(map);
	}

}
