package com.junkj.module.sys.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.cache.Cache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junkj.common.action.BaseAction;
import com.junkj.common.collect.ListUtils;
import com.junkj.common.collect.MapUtils;
import com.junkj.common.utils.CacheUtils;
import com.junkj.common.utils.JsonUtils;
import com.junkj.common.vo.JsonVo;

/**
 * 缓存管理action
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月18日
 * @version: 1.0.0
 */
@Controller
@RequestMapping(value = "/${adminPath}/sysCache")
public class SysCacheAction extends BaseAction {

	@RequestMapping("")
	public String index() {
		return "/module/sys/sysCache";
	}

	/**
	 * 缓存名称数据
	 */
	@RequestMapping(value = "findList")
	@ResponseBody
	public Object findList() {
		List<Map<String,String>> list = ListUtils.newArrayList();
		Map<String,String> map = MapUtils.newHashMap();
		map.put("cacheName", CacheUtils.SYS_CACHE);
		list.add(map);
		
		map = MapUtils.newHashMap();
		map.put("cacheName", CacheUtils.COM_CACHE);
		list.add(map);

		map = MapUtils.newHashMap();
		map.put("cacheName", CacheUtils.CONFIG_CACHE);
		list.add(map);
		
		map = MapUtils.newHashMap();
		map.put("cacheName", CacheUtils.USER_CACHE);
		list.add(map);
		
		return list;
	}

	/**
	 * 缓存Key数据
	 */
	@RequestMapping(value = "findKeyList")
	@ResponseBody
	public Object findKeyList(String key) {
		Cache<String, Object> aa = CacheUtils.getCache(key);
		if (aa.keys() != null && aa.keys().size() > 0) {
			List<Map<String, Object>> list = new ArrayList<>();
			for (Object key1 : aa.keys()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("cache", key1);
				list.add(map);
			}
			return list;
		}
		return new ArrayList<>();
	}

	/**
	 * 缓存Key内容
	 */
	@RequestMapping(value = "getKetNeirong")
	@ResponseBody
	public JsonVo getKetNeirong(String cacheName, String key) {
		Object obj = CacheUtils.get(cacheName, key);
		if (obj != null) {
			return sendData(JsonUtils.toString(obj));
		}
		return sendData("");
	}

	/**
	 * 从缓存中移除
	 */
	@RequestMapping(value = "remove")
	@ResponseBody
	public JsonVo remove(String cacheName, String key) {
		CacheUtils.remove(cacheName, key);
		return sendOk("删除成功！");
	}

	/**
	 * 从缓存中移除所有
	 */
	@RequestMapping(value = "removeAll")
	@ResponseBody
	public JsonVo removeAll(String cacheName) {
		CacheUtils.removeAll(cacheName);
		return sendOk("删除成功！");
	}

}
