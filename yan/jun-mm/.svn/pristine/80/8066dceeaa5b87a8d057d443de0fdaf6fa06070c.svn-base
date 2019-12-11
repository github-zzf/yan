package com.junkj.common.dao;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.junkj.common.mybatis.mapper.SqlUtils;

public interface CrudDao<T> extends QueryDao<T> {

	@InsertProvider(type = SqlUtils.class, method = "insert")
	long insert(T entity);

	@UpdateProvider(type = SqlUtils.class, method = "update")
	long update(T entity);
	
	@UpdateProvider(type = SqlUtils.class, method = "updateStatus")
	long updateStatus(T entity);

	@UpdateProvider(type = SqlUtils.class, method = "delete")
	long delete(T entity);

	@UpdateProvider(type = SqlUtils.class, method = "deleteByEntity")
	long deleteByEntity(T entity);

}
