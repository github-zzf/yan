package com.junkj.common.vo;

import java.util.HashMap;

/**
 * 操作消息
 * 
 * @author 骏骁
 */
public class JsonVo extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	/**
	 * 初始化一个消息对象
	 */
	public JsonVo() {
	}

	/**
	 * 返回成功消息
	 */
	public static JsonVo sendOk() {
		return JsonVo.sendOk("操作成功");
	}

	/**
	 * 返回成功消息
	 */
	public static JsonVo sendOk(String msg) {
		JsonVo json = new JsonVo();
		json.put("code", 1);
		json.put("msg", msg);
		return json;
	}

	/**
	 * 返回成功数据
	 */
	public static JsonVo sendData(Object data) {
		JsonVo json = new JsonVo();
		json.put("code", 1);
		json.put("data", data);
		return json;
	}

	/**
	 * 返回错误消息
	 */
	public static JsonVo sendError() {
		return sendError(0, "操作失败");
	}

	/**
	 * 返回错误消息
	 */
	public static JsonVo sendError(String msg) {
		return sendError(0, msg);
	}

	/**
	 * 返回错误消息
	 */
	public static JsonVo sendError(int code, String msg) {
		JsonVo json = new JsonVo();
		json.put("code", code);
		json.put("msg", msg);
		return json;
	}

	@Override
	public JsonVo put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
