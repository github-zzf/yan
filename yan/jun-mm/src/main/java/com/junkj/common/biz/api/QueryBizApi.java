package com.junkj.common.biz.api;

import java.util.List;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.entity.Page;

public interface QueryBizApi<T extends DataEntity<?>> extends BaseBizApi {

	T get(String id);

	T get(T entity);
	
	T getByEntity(T entity);

	List<T> findList(T entity);

	Page<T> findPage(T entity);

	Page<T> findPage(T entity, List<T> list);
	
	long findCount(T entity);

}
