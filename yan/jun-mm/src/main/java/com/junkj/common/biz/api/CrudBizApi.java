package com.junkj.common.biz.api;

import com.junkj.common.entity.DataEntity;

public interface CrudBizApi<T extends DataEntity<?>> extends QueryBizApi<T> {

	void save(T entity);

	void insert(T entity);
	
	void update(T entity);

	void delete(T entity);
	
}
