package com.junkj.common.utils;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.junkj.common.config.Global;
import com.junkj.common.exception.SpringUtils;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.shiro.ShiroUser;
import com.junkj.module.sys.biz.SysMenuBiz;
import com.junkj.module.sys.biz.SysRoleBiz;
import com.junkj.module.sys.biz.SysUserBiz;
import com.junkj.module.sys.entity.SysMenu;
import com.junkj.module.sys.entity.SysRole;
import com.junkj.module.sys.entity.SysUser;

/**
 * 用户工具类
 * 
 * @author ThinkGem
 * @version 2013-12-05
 */
public class UserUtils {

	private static SysUserBiz sysUserBiz = SpringUtils.getBean(SysUserBiz.class);
	private static SysRoleBiz sysRoleBiz = SpringUtils.getBean(SysRoleBiz.class);
	private static SysMenuBiz sysMenuBiz = SpringUtils.getBean(SysMenuBiz.class);

	public static final String USER_CACHE_ID_ = "uid_";
	public static final String USER_CACHE_USERNAME_ = "uname_";

	public static final String SESSION_PERMISSIONS_LIST = "permissionsList";
	public static final String SESSION_ROLE_LIST = "roleList";
	public static final String SESSION_MENU_LIST = "menuList";
	public static final String SESSION_OAUTH2_TOKEN = "oauth2_token";

	public static boolean isSuperAdmin(String id) {
		return id != null && StrUtils.inString(id, Global.getConfig("user.superAdmin").split(","));
	}

	/**
	 * 根据ID获取用户
	 * 
	 * @param id
	 * @return 取不到返回null
	 */
	public static SysUser get(String id) {
		SysUser user = (SysUser) CacheUtils.get(CacheUtils.USER_CACHE, USER_CACHE_ID_ + id);
		if (user == null) {
			user = sysUserBiz.get(id);
			if (user == null) {
				return null;
			}
			CacheUtils.put(CacheUtils.USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheUtils.put(CacheUtils.USER_CACHE, USER_CACHE_USERNAME_ + user.getUsername(), user);
		}
		return user;
	}

	/**
	 * 根据登录名获取用户
	 * 
	 * @param loginName
	 * @return 取不到返回null
	 */
	public static SysUser getByLoginName(String loginName) {
		SysUser user = (SysUser) CacheUtils.get(CacheUtils.USER_CACHE, USER_CACHE_USERNAME_ + loginName);
		if (user == null) {
			user = sysUserBiz.getByUsername(loginName);
			if (user == null) {
				return null;
			}
			CacheUtils.put(CacheUtils.USER_CACHE, USER_CACHE_ID_ + user.getId(), user);
			CacheUtils.put(CacheUtils.USER_CACHE, USER_CACHE_USERNAME_ + user.getUsername(), user);
		}
		return user;
	}

	/**
	 * 清除指定用户缓存
	 * 
	 * @param user
	 */
	public static void clearCache(SysUser sysUser) {
		SysUser user = UserUtils.get(sysUser.getId());
		if (StrUtils.notBlank(user)) {
			CacheUtils.remove(CacheUtils.USER_CACHE, USER_CACHE_ID_ + user.getId());
			CacheUtils.remove(CacheUtils.USER_CACHE, USER_CACHE_USERNAME_ + user.getUsername());
		}
	}

	/**
	 * 获取当前用户
	 * 
	 * @return 取不到返回 new User()
	 */
	public static SysUser getUser() {
		ShiroUser principal = getPrincipal();
		if (principal != null) {
			SysUser user = get(principal.getId());
			if (user != null) {
				return user;
			}
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new SysUser();
	}

	public static boolean isLogin() {
		return getSubject().isAuthenticated();
	}

	/**
	 * 获取授权主要对象
	 */
	private static Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	/**
	 * 获取当前登录者对象
	 */
	public static ShiroUser getPrincipal() {
		try {
			Subject subject = getSubject();
			ShiroUser principal = (ShiroUser) subject.getPrincipal();
			if (principal != null) {
				return principal;
			}
		} catch (UnavailableSecurityManagerException e) {

		} catch (InvalidSessionException e) {

		}
		return null;
	}

	// ============== User Session Cache ==============
	public static Session getSession() {
		try {
			Subject subject = getSubject();
			Session session = subject.getSession(false);
			if (session == null) {
				session = subject.getSession();
			}
			if (session != null) {
				return session;
			}
		} catch (UnavailableSecurityManagerException e) {
			
		} catch (InvalidSessionException e) {

		}
		return null;
	}

	/**
	 * 获取当前用户授权权限
	 */
	public static List<String> getPermission() {
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) getSessionCache(SESSION_PERMISSIONS_LIST);
		if (list == null) {
			list = sysMenuBiz.findPermissions();
			putSessionCache(SESSION_PERMISSIONS_LIST, list);
		}
		return list;
	}

	/**
	 * 获取当前用户授权菜单
	 */
	public static List<SysMenu> getMenuList() {
		@SuppressWarnings("unchecked")
		List<SysMenu> menuList = (List<SysMenu>) getSessionCache(SESSION_MENU_LIST);
		if (menuList == null) {
			menuList = sysMenuBiz.findMenuList();
			putSessionCache(SESSION_MENU_LIST, menuList);
		}
		return menuList;
	}

	/**
	 * 获取当前用户角色列表
	 */
	public static List<SysRole> getRoleList() {
		@SuppressWarnings("unchecked")
		List<SysRole> roleList = (List<SysRole>) getSessionCache(SESSION_ROLE_LIST);
		if (roleList == null) {
			SysUser user = getUser();
			if (user.isAdmin()) {
				roleList = sysRoleBiz.findAll();
			} else {
				roleList = sysRoleBiz.findByRoleIds(user.getRoleIds());
			}
			putSessionCache(SESSION_ROLE_LIST, roleList);
		}
		return roleList;
	}

	/**
	 * 清除当前用户缓存
	 */
	public static void clearSessionCache() {
		removeSessionCache(SESSION_PERMISSIONS_LIST);
		removeSessionCache(SESSION_ROLE_LIST);
		removeSessionCache(SESSION_MENU_LIST);
		UserUtils.clearCache(getUser());
	}

	public static Object getSessionCache(String key) {
		return getSessionCache(key, null);
	}

	public static Object getSessionCache(String key, Object defaultValue) {
		Object obj = getSession().getAttribute(key);
		return obj == null ? defaultValue : obj;
	}

	public static void putSessionCache(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static void removeSessionCache(String key) {
		getSession().removeAttribute(key);
	}

}
