package com.junkj.common.utils;

import com.junkj.common.exception.SpringUtils;
import com.junkj.module.sys.biz.SysConfigBiz;

/**
 * 配置工具类
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月12日
 * @version: 1.0.0
 */
public class ConfigUtils {

	private static SysConfigBiz sysConfigBiz = SpringUtils.getBean(SysConfigBiz.class);

	public static final String CONFIG_CACHE_COM = "com_";
	public static final String CONFIG_CACHE_SYS = "sys_";

	/**
	 * 通过key查询,企业配置
	 */
	public static String getValByKey(String key) {
		key = CONFIG_CACHE_COM + ComUtils.getCurrentComId() + "_" + key;
		String value = getCache(key);
		if (value == null) {
			value = sysConfigBiz.getValByKey(key);
			if (value == null) {
				return null;
			}
			putCache(key, value);
		}
		return value;
	}

	/**
	 * 通过key查询,系统配置
	 */
	public static String getSysValByKey(String key) {
		key = CONFIG_CACHE_SYS + key;
		String value = getCache(key);
		if (value == null) {
			value = sysConfigBiz.getSysValByKey(key);
			if (value == null) {
				return null;
			}
			putCache(key, value);
		}
		return value;
	}

	/**
	 * 清除缓存
	 */
	public static void clearCache(String key) {
		removeCache(CONFIG_CACHE_SYS + key);
		removeCache(CONFIG_CACHE_COM + ComUtils.getCurrentComId() + "_" + key);
	}

	@SuppressWarnings("unchecked")
	private static <V> V getCache(String key) {
		return (V) CacheUtils.get(CacheUtils.CONFIG_CACHE, key);
	}

	private static <V> void putCache(String key, V value) {
		CacheUtils.put(CacheUtils.CONFIG_CACHE, key, value);
	}

	private static void removeCache(String key) {
		CacheUtils.remove(CacheUtils.CONFIG_CACHE, key);
	}

}
