package com.junkj.common.form;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.junkj.common.action.http.ServletUtils;

/**
 * @description 防止表单重复提交拦截器
 */
@Aspect
@Component
public class FormTokenAspect {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	public static final String FORM_TOKEN_KEY = "form_token_key_";

	@Pointcut("execution(public * com.junkj.module..*(..))")
	public void webLog() {
	}

	@Before("webLog() && @annotation(token)")
	public void before(final JoinPoint joinPoint, FormToken token) throws FormTokenException {
		if (token != null) {
			HttpServletRequest request = ServletUtils.getRequest();
			boolean isSave = token.save();
			if (isSave) {
				String key = FORM_TOKEN_KEY.concat(joinPoint.getSignature().getName());
				Object t = request.getSession().getAttribute(key);
				Long now = System.currentTimeMillis() / 1000;
				if (null == t) {
					request.getSession().setAttribute(key, now);
				} else {
					Long oldTime = Long.valueOf(t.toString());
					if(now - oldTime  > 15L){
						request.getSession().setAttribute(key, now);
					}else{
						throw new FormTokenException("请勿重复提交");
					}
				}
			}
		}
	}

	@AfterReturning("webLog() && @annotation(token)")
	public void doAfterReturning(JoinPoint joinPoint, FormToken token) {
		logger.error("出方法：");
		if (token != null) {
			HttpServletRequest request = ServletUtils.getRequest();
			boolean isSave = token.save();
			if (isSave) {
				String key = FORM_TOKEN_KEY.concat(joinPoint.getSignature().getName());
				Object t = request.getSession().getAttribute(key);
				if (null != t && token.type() == FormToken.REQUEST) {
					request.getSession(false).removeAttribute(key);
				}
			}
		}
	}

	/**
	 * 异常
	 */
	@AfterThrowing(pointcut = "webLog() && @annotation(token)", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e, FormToken token) {
		if (null != token && e instanceof FormTokenException == false) {

			HttpServletRequest request = ServletUtils.getRequest();
			boolean isSave = token.save();
			if (isSave) {
				String key = FORM_TOKEN_KEY.concat(joinPoint.getSignature().getName());
				Object t = request.getSession().getAttribute(key);
				if (null != t) {
					request.getSession(false).removeAttribute(key);
				}
			}
		}
	}
}
