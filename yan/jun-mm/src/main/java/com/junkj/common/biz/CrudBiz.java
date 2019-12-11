package com.junkj.common.biz;

import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.api.CrudBizApi;
import com.junkj.common.dao.CrudDao;
import com.junkj.common.entity.DataEntity;
import com.junkj.common.lang.StrUtils;

@Transactional(readOnly = true)
public abstract class CrudBiz<D extends CrudDao<T>, T extends DataEntity<?>> extends QueryBiz<D, T>
		implements CrudBizApi<T> {

	@Transactional(readOnly = false)
	public void save(T entity) {
		if (entity.getIsNewT()) {
			entity.preInsert();
			insert(entity);
			return;
		}
		entity.preUpdate();
		update(entity);
	}

	@Transactional(readOnly = false)
	public void insert(T entity) {
		this.dao.insert(entity);
	}

	@Transactional(readOnly = false)
	public void update(T entity) {
		if (StrUtils.isBlank(entity.getId()))
			return;
		this.dao.update(entity);
	}

	@Transactional(readOnly = false)
	public void updateStatus(T entity) {
		if (StrUtils.isBlank(entity.getId())) {
			return;
		}
		this.dao.updateStatus(entity);
	}

	@Transactional(readOnly = false)
	public void delete(T entity) {
		if (StrUtils.isBlank(entity.getId()))
			return;
		this.dao.delete(entity);
	}

}
