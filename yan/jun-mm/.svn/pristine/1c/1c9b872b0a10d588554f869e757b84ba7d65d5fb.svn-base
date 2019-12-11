package com.junkj.common.log;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.method.HandlerMethod;

import com.junkj.common.action.http.UserAgentUtils;
import com.junkj.common.config.Global;
import com.junkj.common.entity.BaseEntity;
import com.junkj.common.exception.SpringUtils;
import com.junkj.common.lang.ExceptionUtils;
import com.junkj.common.lang.ObjectUtils;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.mybatis.MapperHelper;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.utils.IpUtils;
import com.junkj.module.sys.biz.SysLogBiz;
import com.junkj.module.sys.biz.SysMenuBiz;
import com.junkj.module.sys.entity.SysLog;
import com.junkj.module.sys.entity.SysUser;

import eu.bitwalker.useragentutils.UserAgent;

/**
 * 日志工具类
 * 
 * @author ThinkGem
 * @version 2017-11-7
 */
public class LogUtils {

	/**
	 * 静态内部类，延迟加载，懒汉式，线程安全的单例模式
	 */
	private static final class Static {
		private static SysLogBiz sysLogBiz = SpringUtils.getBean(SysLogBiz.class);
		private static SysMenuBiz sysMenuBiz = SpringUtils.getBean(SysMenuBiz.class);
	}

	// 参数名获取工具
	private static ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();

	/**
	 * 保存日志
	 */
	public static void saveLog(SysUser user, HttpServletRequest request, String logTitle, String logType) {
		saveLog(user, request, null, null, logTitle, logType, 0L);
	}

	/**
	 * 保存日志
	 */
	public static void saveLog(SysUser user, HttpServletRequest request, Object handler, Exception ex, String logTitle,
			String logType, long executeTime) {
		if (user == null || request == null) {
			return;
		}
		SysLog log = new SysLog();
		log.setLogType(getLogType(request, logType));
		log.setLogTitle(logTitle);
		log.setRequestUri(StrUtils.abbr(request.getRequestURI(), 255));
		log.setRequestParams(request.getParameterMap());
		log.setRequestMethod(request.getMethod());

		log.setServerAddr(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort());
		log.setUserIp(IpUtils.getRealIp(request));
		log.setUserAgent(request.getHeader("User-Agent"));
		UserAgent userAgent = UserAgentUtils.getUserAgent(request);
		log.setDeviceName(userAgent.getOperatingSystem().getName());
		log.setBrowserName(userAgent.getBrowser().getName());

		log.setRunTime(Long.valueOf(executeTime));
		log.setCurrentUser(user);
		log.preInsert();

		Throwable throwable = null;
		if (ex != null) {
			throwable = ExceptionUtils.getThrowable(request);
		}

		new SaveLogThread(log, handler, request.getContextPath(), throwable).start();
	}

	private static String getLogType(HttpServletRequest request, String logType) {
		if (StrUtils.isBlank(logType)) {
			String sqlCommandTypes = ObjectUtils.toString(request.getAttribute(SqlCommandType.class.getName()));
			if (StrUtils.contains("," + sqlCommandTypes + ",", ",INSERT,")) {
				return SysLog.TYPE_INSERT;
			} else if (StrUtils.contains("," + sqlCommandTypes + ",", ",UPDATE,")) {
				return SysLog.TYPE_UPDATE;
			} else if (StrUtils.contains("," + sqlCommandTypes + ",", ",DELETE,")) {
				return SysLog.TYPE_DELETE;
			} else if (StrUtils.contains("," + sqlCommandTypes + ",", ",SELECT,")) {
				return SysLog.TYPE_SELECT;
			} else {
				return SysLog.TYPE_ACCESS;
			}
		}
		return logType;
	}

	public static class SaveLogThread extends Thread {
		private SysLog log;
		private Object handler;
		private String contextPath;
		private Throwable throwable;

		public SaveLogThread(SysLog log, Object handler, String contextPath, Throwable throwable) {
			super(SaveLogThread.class.getSimpleName());
			this.log = log;
			this.handler = handler;
			this.contextPath = contextPath;
			this.throwable = throwable;
		}

		public void run() {
			// 获取日志标题
			if (StrUtils.isBlank(log.getLogTitle())) {
				String permission = "";
				if (handler instanceof HandlerMethod) {
					HandlerMethod hm = ((HandlerMethod) handler);
					Method m = hm.getMethod();

					// 获取权限字符串
					RequiresPermissions rp = (RequiresPermissions) m.getAnnotation(RequiresPermissions.class);
					permission = (rp != null) ? StrUtils.join(rp.value(), ",") : "";

					// 尝试获取BaseEntity的设置的主键值
					for (Class<?> type : m.getParameterTypes()) {
						try {
							// 判断是否是BaseEntity的子类
							Class<?> superClass = type.getSuperclass();
							while (superClass != null && superClass != BaseEntity.class) {
								superClass = superClass.getSuperclass();
							}
							
							// 如果是BaseEntity的子类，则获取主键名
							if (superClass != null) {
								Table t = type.getAnnotation(Table.class);
								for (Column c : t.columns()) {
									if (c.isPK()) {
										try {
											String attrName = MapperHelper.getAttrName(c);
											if (attrName != null) {
												log.setBizId(log.getRequestParam(attrName));
												log.setBizType(type.getSimpleName());
											}
										} catch (Exception e) {
											break;
										}
									}
								}
							}
						} catch (Exception e) {
							break;
						}
					}

					// 尝试获取标注为@ModelAttribute注解的方法，第一个参数名一般为主键名
					if (StrUtils.isBlank(log.getBizId())) {
						for (Method me : hm.getBeanType().getMethods()) {
							ModelAttribute ma = AnnotationUtils.findAnnotation(me, ModelAttribute.class);
							if (ma != null) {
								String[] ps = pnd.getParameterNames(me);
								if (ps != null && ps.length > 0) {
									log.setBizId(StrUtils.abbr(log.getRequestParam(ps[0]), 64));
									log.setBizType(me.getReturnType().getSimpleName());
									break;
								}
							}
						}
					}
				}
				String href = log.getRequestUri();
				if (StrUtils.startsWith(href, contextPath)) {
					href = StrUtils.substringAfter(href, contextPath);
				}
				if (StrUtils.startsWith(href, Global.getAdminPath())) {
					href = StrUtils.substringAfter(href, Global.getAdminPath());
				}
				log.setLogTitle(Static.sysMenuBiz.getMenuNamePath(href, permission));
			}
			if (StrUtils.isBlank(log.getLogTitle())) {
				log.setLogTitle("未知操作");
			}
			// 如果有异常，设置异常信息（将异常对象转换为字符串）
			log.setIsException(throwable != null ? Global.YES : Global.NO);
			log.setException(ExceptionUtils.getStackTraceAsString(throwable));
			// 如果无地址并无异常日志，则不保存信息
			if (StrUtils.isBlank(log.getRequestUri()) && StrUtils.isBlank(log.getException())) {
				return;
			}
			// 保存日志信息
			Static.sysLogBiz.insertLog(log);
		}
	}
}
