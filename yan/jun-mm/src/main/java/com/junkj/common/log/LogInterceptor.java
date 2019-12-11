package com.junkj.common.log;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.junkj.common.biz.BaseBiz;
import com.junkj.common.lang.ByteUtils;
import com.junkj.common.lang.DateUtils;
import com.junkj.common.lang.TimeUtils;
import com.junkj.common.utils.IpUtils;
import com.junkj.common.utils.UserUtils;

/**
 * 日志拦截器
 * @author ThinkGem
 * @version 2018-08-11
 */
public class LogInterceptor extends BaseBiz implements HandlerInterceptor {

	private static final ThreadLocal<Long> startTimeThreadLocal =
			new NamedThreadLocal<Long>("LogInterceptor StartTime");
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
		long beginTime = System.currentTimeMillis();// 1、开始时间  
		startTimeThreadLocal.set(beginTime);		// 线程绑定变量（该数据只有当前请求的线程可见）  
		if (logger.isDebugEnabled()){
	        logger.debug("开始计时: {}  URI: {}  IP: {}", new SimpleDateFormat("hh:mm:ss.SSS")
	        	.format(beginTime), request.getRequestURI(), IpUtils.getRealIp(request));
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
			ModelAndView modelAndView) throws Exception {
		if (modelAndView != null){
			logger.info("ViewName: " + modelAndView.getViewName() + " <<<<<<<<< " + request.getRequestURI() + " >>>>>>>>> " + handler);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object handler, Exception ex) throws Exception {
		long beginTime = startTimeThreadLocal.get();// 得到线程绑定的局部变量（开始时间）
		long endTime = System.currentTimeMillis(); 	// 2、结束时间
		long executeTime = endTime - beginTime;	// 3、获取执行时间
		startTimeThreadLocal.remove(); // 用完之后销毁线程变量数据
		
		// 保存日志
		LogUtils.saveLog(UserUtils.getUser(), request, handler, ex, null, null, executeTime);
		
		// 打印JVM信息。
		if (logger.isDebugEnabled()){
			Runtime runtime = Runtime.getRuntime();
	        logger.debug("计时结束: {}  用时: {}  URI: {}  总内存: {}  已用内存: {}",
	        		DateUtils.formatDate(endTime, "hh:mm:ss.SSS"), TimeUtils.formatDateAgo(executeTime), request.getRequestURI(), 
					ByteUtils.formatByteSize(runtime.totalMemory()), ByteUtils.formatByteSize(runtime.totalMemory()-runtime.freeMemory())); 
		}
		
	}

}