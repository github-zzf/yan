package com.junkj.common.config;

import java.util.Map;

import com.junkj.common.collect.MapUtils;
import com.junkj.common.io.PropertiesUtils;
import com.junkj.common.lang.ObjectUtils;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.utils.PathUtils;

/**
 * 全局配置类
 */
public class Global {

	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> config = MapUtils.newHashMap();

	/**
	 * 是/否
	 */
	public static final String YES = "1";
	public static final String NO = "0";

	/**
	 * 上传文件基础虚拟路径
	 */
	public static final String UPLOAD_PATH = "/upload/";

	/**
	 * token过期时间，单位为毫秒
	 */
	public static long tokenExpire = 18000L;

	static {
		tokenExpire = ObjectUtils.toLong(getConfig("web.tokenExpire"));
	}

	/**
	 * 获取配置
	 */
	public static String getConfig(String key) {
		String value = config.get(key);
		if (value == null) {
			value = PropertiesUtils.getInstance().getProperty(key);
			config.put(key, value != null ? value : StrUtils.EMPTY);
		}
		return value;
	}

	/**
	 * 获取管理端根路径
	 */
	public static String getAdminPath() {
		return getConfig("adminPath");
	}

	/**
	 * 管理端域名
	 */
	public static String adminUri() {
		return getConfig("adminUri");
	}

	/**
	 * 移动端域名
	 */
	public static String mobileUri() {
		return getConfig("mobileUri");
	}

	/**
	 * 测试地址
	 */
	public static String devUri() {
		return getConfig("devUri");
	}

	/**
	 * 测试用户
	 */
	public static String devUser() {
		return getConfig("devUser");
	}

	/**
	 * 文件域名
	 */
	public static String fileUri() {
		return getConfig("fileUri");
	}

	/**
	 * 是否是开发环境
	 */
	public static Boolean isDev() {
		String dev = getConfig("dev");
		return "true".equals(dev);
	}

	/**
	 * 是否是多用户
	 */
	public static Boolean isSaas() {
		if (getConfig("isSaas") != null) {
			return ObjectUtils.toBoolean(getConfig("isSaas"));
		}
		return false;
	}

	/**
	 * 上传文件的物理路径
	 */
	public static String getFileDir(String path) {
		return getUploadBasePath() + UPLOAD_PATH + path;
	}

	/**
	 * 上传文件的物理路径
	 */
	public static String getUploadBasePath() {
		String dir = getConfig("upload.basePath");
		if (StrUtils.isBlank(dir)) {
			try {
				dir = PathUtils.getRootPath();
			} catch (Exception e) {
				return "";
			}
		}
		return dir;
	}

	/**
	 * 上传文件的物理根目录
	 */
	public static String getFilePath() {
		return getUploadBasePath() + UPLOAD_PATH;
	}

	/**
	 * 文件访问地址
	 */
	public static String getFileUrl(String path) {
		return Global.fileUri() + UPLOAD_PATH + path;
	}

}
