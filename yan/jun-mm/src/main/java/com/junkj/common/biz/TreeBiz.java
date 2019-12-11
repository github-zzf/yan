package com.junkj.common.biz;

import org.springframework.transaction.annotation.Transactional;

import com.junkj.common.biz.api.CrudBizApi;
import com.junkj.common.dao.CrudDao;
import com.junkj.common.entity.Page;
import com.junkj.common.entity.TreeEntity;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.mybatis.MapperHelper;

@Transactional(readOnly = true)
public abstract class TreeBiz<D extends CrudDao<T>, T extends TreeEntity<?>> extends QueryBiz<D, T>
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
		if (StrUtils.isBlank(entity.getParentId())) {
			entity.setParentId("0");
		}

		if (StrUtils.isBlank(entity.getTreeSort())) {
			T last = getLastByParentId(entity);
			if (StrUtils.notBlank(last)) {
				entity.setTreeSort(last.getTreeSort() + 1);
			} else {
				entity.setTreeSort(1D);
			}
		}

		if (entity.getParentId().equals("0")) {
			entity.setTreeLeaf("1");
			entity.setParentIds("0,");
			entity.setTreeLevel(0D);
			entity.setTreeNames(entity.getTreeName());
			entity.setTreeSorts(StrUtils.formatNum(entity.getTreeSort().intValue(), 8) + ",");
		} else {
			T parent = super.get(entity.getParentId());
			parent.setTreeLeaf("0");
			this.dao.update(parent);

			entity.setTreeLeaf("1");
			entity.setParentIds(parent.getParentIds() + parent.getId() + ",");
			entity.setTreeLevel(parent.getTreeLevel() + 1);
			entity.setTreeNames(parent.getTreeNames() + "/" + entity.getTreeName());
			entity.setTreeSorts(parent.getTreeSorts() + StrUtils.formatNum(entity.getTreeSort().intValue(), 8));
		}

		this.dao.insert(entity);
	}

	@Transactional(readOnly = false)
	public void update(T entity) {
		if (StrUtils.isBlank(entity.getId()))
			return;

		T old = get(entity.getId());
		if (!entity.getParentId().equals(old.getParentId())) {
			T last = getLastByParentId(entity);
			if (StrUtils.notBlank(last)) {
				entity.setTreeSort(last.getTreeSort() + 1);
			} else {
				entity.setTreeSort(1D);
			}
		}

		if (entity.getParentId().equals("0")) {
			entity.setParentIds("0,");
			entity.setTreeLevel(0D);
			entity.setTreeNames(entity.getTreeName());

			if (StrUtils.notBlank(entity.getTreeSort())) {
				entity.setTreeSorts(StrUtils.formatNum(entity.getTreeSort().intValue(), 8) + ",");
			}
		} else {
			T parent = super.get(entity.getParentId());
			parent.setTreeLeaf("0");
			this.dao.update(parent);

			entity.setParentIds(parent.getParentIds() + parent.getId() + ",");
			entity.setTreeLevel(parent.getTreeLevel() + 1);
			entity.setTreeNames(parent.getTreeNames() + "/" + entity.getTreeName());
			if (StrUtils.notBlank(entity.getTreeSort())) {
				entity.setTreeSorts(parent.getTreeSorts() + StrUtils.formatNum(entity.getTreeSort().intValue(), 8));
			}
		}
		this.dao.update(entity);
	}

	public T getLastByParentId(T entity) {
		if (StrUtils.notBlank(entity.getParentId())) {
			T t = newEntity();
			t.setParentId(entity.getParentId());
			t.setPage(new Page<Object>(1, 1).setOrderBy(MapperHelper.getTable(entity).alias() + ".tree_sort DESC"));
			Page<T> page = super.findPage(t);
			if (page.getList().size() > 0) {
				return page.getList().get(0);
			}
		}
		return null;
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
		entity = get(entity.getId());

		// 删除子级
		T t = newEntity();
		t.setParentIds(entity.getId() + ",");
		this.dao.deleteByEntity(t);

		// 删除
		this.dao.delete(entity);

		// 没有子级的父节点设为叶子
		T last = getLastByParentId(entity);
		if (StrUtils.isBlank(last)) {
			T parent = newEntity();
			parent.setId(entity.getParentId());
			parent.setTreeLeaf("1");
			this.dao.update(parent);
		}
	}

}
