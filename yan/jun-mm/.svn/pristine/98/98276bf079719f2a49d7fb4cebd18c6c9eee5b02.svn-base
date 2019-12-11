package com.junkj.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.junkj.common.mybatis.mapper.SqlUtils;

public interface QueryDao<T> {

	@SelectProvider(type = SqlUtils.class, method = "get")
	T get(T entity);

	@SelectProvider(type = SqlUtils.class, method = "getByEntity")
	T getByEntity(T entity);

	@SelectProvider(type = SqlUtils.class, method = "findList")
	List<T> findList(T entity);

	@SelectProvider(type = SqlUtils.class, method = "findCount")
	long findCount(T entity);
}
