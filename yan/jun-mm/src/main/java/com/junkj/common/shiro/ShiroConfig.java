package com.junkj.common.shiro;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.io.ResourceUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.junkj.common.config.Global;

import net.sf.ehcache.CacheManager;

@Configuration
public class ShiroConfig {

	@Bean(name = "adminUser")
	public ShiroFilterFactoryBean adminUser(SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		shiroFilter.setSecurityManager(securityManager);
		// 默认的登陆访问url
		shiroFilter.setLoginUrl(Global.getAdminPath()+"/login");

		// 登陆成功后跳转的url
		shiroFilter.setSuccessUrl(Global.getAdminPath()+"/index");

		// 没有权限跳转的url
		shiroFilter.setUnauthorizedUrl("/403");

		// 拦截器.
		Map<String, String> hashMap = new LinkedHashMap<String, String>();
		// anon匿名地址
		hashMap.put("/static/**", "anon");
		hashMap.put(Global.getAdminPath()+"/combo/**", "anon");
		hashMap.put(Global.getAdminPath()+"/login", "anon");
		hashMap.put(Global.getAdminPath()+"/logout", "anon");
		hashMap.put(Global.getAdminPath()+"/message/saveMessage", "anon");

		// authc需要认证地址
		hashMap.put(Global.getAdminPath()+"/**", "authc");

		shiroFilter.setFilterChainDefinitionMap(hashMap);
		return shiroFilter;
	}

	@Bean
	public ShiroRealm myShiroRealm() {
		ShiroRealm myShiroRealm = new ShiroRealm();
		return myShiroRealm;
	}

	@Bean("cacheManager")
	public CacheManager cacheManager() {
		CacheManager cacheManager = CacheManager.getCacheManager("es");
		if (cacheManager == null) {
			try {
				cacheManager = CacheManager.create(ResourceUtils.getInputStreamForPath("classpath:ehcache-shiro.xml"));
			} catch (IOException e) {
				throw new RuntimeException("initialize cacheManager failed");
			}
		}
		return cacheManager;
	}

	@Bean
	public EhCacheManager ehCacheManager() {
		EhCacheManager em = new EhCacheManager();
		em.setCacheManager(cacheManager());
		return em;
	}

	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setSessionManager(sessionManager());
		securityManager.setCacheManager(ehCacheManager());
		securityManager.setRealm(myShiroRealm());
		return securityManager;
	}

	@Bean
	public SessionDAO sessionDAO() {
		return new MemorySessionDAO();// 使用默认的MemorySessionDAO
	}

	/**
	 * shiro session的管理
	 */
	@Bean
	public DefaultWebSessionManager sessionManager() {
		// 配置默认的sesssion管理器
		DefaultWebSessionManager manager = new DefaultWebSessionManager();
		// 删除过期的session
		manager.setDeleteInvalidSessions(true);
		// 设置全局session超时时间
		manager.setGlobalSessionTimeout(7200000);
		// 去掉 JSESSIONID
		manager.setSessionIdUrlRewritingEnabled(false);
		// 是否定时检查session
		manager.setSessionValidationSchedulerEnabled(true);
		// 自定义SessionDao
		manager.setSessionDAO(sessionDAO());
		return manager;
	}

	/**
	 * 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}

//	// 异常处理
//	@Bean(name = "simpleMappingExceptionResolver")
//	public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
//		SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
//		Properties mappings = new Properties();
//		mappings.setProperty("DatabaseException", "databaseError");// 数据库异常处理
//		mappings.setProperty("UnauthorizedException", "403");
//		r.setExceptionMappings(mappings); // None by default
//		r.setDefaultErrorView("error"); // No default
//		r.setExceptionAttribute("ex"); // Default is "exception"
//		// r.setWarnLogCategory("example.MvcLogger"); // No default
//		return r;
//	}

}