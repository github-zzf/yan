package com.junkj.common.shiro;

import java.io.Serializable;
import java.util.Map;

/**
 * 登录会话对象
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2016-5-22
 * @version: 1.0.0
 */
public class ShiroUser implements Serializable {

	private static final long serialVersionUID = 1L;

	// 用户编码
	private String id;
	// 用户名称
	private String username;

	private Map<String, Object> params;

	public ShiroUser(String id, String username, Map<String, Object> params) {
		super();
		this.id = id;
		this.username = username;
		this.params = params;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}