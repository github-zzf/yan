package com.junkj.common.shiro;

import java.util.Map;

import org.apache.shiro.authc.UsernamePasswordToken;

public class ShiroToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> params;

	public ShiroToken() {
	}

	public ShiroToken(String username, String password, Map<String, Object> params) {
		super(username, password);
		this.params = params;
	}

	public ShiroToken(String username, char[] password, Map<String, Object> params) {
		super(username, password);
		this.params = params;
	}

	public void setPassword(String password) {
		this.setPassword(password != null ? password.toCharArray() : null);
	}

	public Map<String, Object> getParams() {
		return this.params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}
