package com.junkj.common.biz;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.junkj.common.action.http.ServletUtils;
import com.junkj.common.biz.api.QueryBizApi;
import com.junkj.common.dao.QueryDao;
import com.junkj.common.entity.DataEntity;
import com.junkj.common.entity.Page;
import com.junkj.common.exception.BizException;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class QueryBiz<D extends QueryDao<T>, T extends DataEntity<?>> extends BaseBiz implements QueryBizApi<T> {

	@Autowired
	protected D dao;

	protected Class<T> entityClass;

	public QueryBiz() {
		Class<T> tp = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		setEntityClass(tp);

	}

	protected T newEntity() {
		T a = null;
		try {
			a = this.entityClass.newInstance();
		} catch (Exception e) {
			throw new BizException(e);
		}
		return a;
	}

	@Override
	public T get(String id) {
		T entity = newEntity();
		entity.setId(id);
		T x = get(entity);
		return x;
	}

	@Override
	public T get(T entity) {
		return this.dao.get(entity);
	}

	@Override
	public T getByEntity(T entity) {
		return this.dao.getByEntity(entity);
	}

	@Override
	public List<T> findList(T entity) {
		return this.dao.findList(entity);
	}

	@Override
	public Page<T> findPage(T entity) {
		Page a = entity.getPage();
		if (a == null) {
			a = new Page(ServletUtils.getParameterToInt("pageNum", 1), ServletUtils.getParameterToInt("pageSize", 20));
		}
		PageHelper.startPage(a.getPageNum(), a.getPageSize());
		a.setList(findList(entity));
		a.setTotal(new PageInfo(a.getList()).getTotal());
		return a;
	}
	
	public void startPage(T entity){
		Page a = entity.getPage();
		if (a == null) {
			a = new Page(ServletUtils.getParameterToInt("pageNum", 1), ServletUtils.getParameterToInt("pageSize", 20));
		}
		PageHelper.startPage(a.getPageNum(), a.getPageSize());
	}

	@Override
	public Page<T> findPage(T entity, List<T> list) {
		Page a = entity.getPage();
		if (a == null) {
			a = new Page(ServletUtils.getParameterToInt("pageNum", 1), ServletUtils.getParameterToInt("pageSize", 20));
		}
		a.setList(list);
		a.setTotal(new PageInfo(a.getList()).getTotal());
		return a;
	}

	@Override
	public long findCount(T entity) {
		return this.dao.findCount(entity);
	}

	public void setEntityClass(Class entityClass) {
		this.entityClass = entityClass;
	}

}
