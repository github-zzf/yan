package com.junkj.common.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.junkj.common.lang.StrUtils;

/**
 * json工具类
 * 
 * @copyright © 2016 大连骏骁网络科技有限公司
 * @author 骏骁
 * @createDate 2016-1-24
 * @version: V1.0.0
 */
public class JsonUtils extends ObjectMapper {

	private static final long serialVersionUID = 1L;
	private static ObjectMapper mapper = new ObjectMapper();
	private final static SimpleDateFormat YMDHMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	static {
		// 日期格式化
		mapper.setDateFormat(YMDHMS);
		// 为Null时不序列化
		mapper.setSerializationInclusion(Include.NON_NULL);
		// 允许单引号
		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		// 允许不带引号的字段名称
		mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		// 有个别请求参数不对应,也会将请求参数正常解析为对象
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 时区
		mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
	}

	public static String toString(Object value) {
		try {
			return mapper.writeValueAsString(value);
		} catch (IOException e) {
		}
		return null;
	}

	public static <T> T toObject(String json, Class<T> clz) {
		if (StrUtils.isBlank(json))
			return null;
		try {
			return (T) mapper.readValue(json, clz);
		} catch (IOException e) {
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> toList(String json, Class<T> elementClasses) {
		if (json == null)
			return null;
		try {
			JavaType javaType = getCollectionType(ArrayList.class, elementClasses);
			return (ArrayList<T>) mapper.readValue(json, javaType);
		} catch (IOException e) {
		}
		return null;
	}

	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	public static ObjectMapper getMapper() {
		return mapper;
	}
}
