package com.junkj.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.util.ResourceUtils;

import com.junkj.common.config.Global;

/**
 * 路径工具类
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2016-08-17
 * @version: 1.0.0
 */
public class PathUtils {

	/**
	 * 获取项目在服务其中的真实路径，这是在web项目中，获取项目实际路径的最佳方式，在windows和linux系统下均可正常使用
	 */
	public static String getRootPath() {
		String rootPath = null;
		try {
			rootPath = ResourceUtils.getURL("classpath:static").getPath().replace("%20", " ");
			// windows下
			if ("\\".equals(File.separator)) {
				rootPath = rootPath.substring(1).replace("/", "\\").replace("\\static", "");
			}
			// linux下
			if ("/".equals(File.separator)) {
				rootPath = rootPath.replace("\\", "/").replace("/static", "");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return rootPath;
	}

	/**
	 * 路径转换为对应windows和linux的路径
	 */
	public static String formatPath(String path) {
		// windows下
		if ("\\".equals(File.separator)) {
			path = path.replace("/", "\\");
		}
		// linux下
		if ("/".equals(File.separator)) {
			path = path.replace("\\", "/");
		}
		return path;
	}

	// web根路径
	public static String getWebPath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName();
	}

	// 管理端域名验证
	public static boolean noAdminUri(HttpServletRequest request) {
		if (Global.isDev()) {
			return false;
		}
		String path = getWebPath(request);
		if (!path.startsWith(Global.adminUri())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 日期路径yyyyMM
	 */
	public static final String getDatePath() {
		return DateFormatUtils.format(new Date(), "yyyyMM/");
	}

}
