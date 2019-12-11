package com.junkj.common.mybatis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.junkj.common.collect.ListUtils;
import com.junkj.common.collect.MapUtils;
import com.junkj.common.entity.BaseEntity;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;

public class MapperHelper {

	private static Map<String, List<Column>> columnCache = MapUtils.newHashMap();
	private static Map<String, List<Column>> pkCache = MapUtils.newHashMap();

	public static Table getTable(BaseEntity<?> entity) {
		return getTable(entity.getClass());
	}

	public static Table getTable(Class<?> entityClass) {
		return (Table) entityClass.getAnnotation(Table.class);
	}

	public static String getTableName(BaseEntity<?> entity) {
		return getTableName(getTable(entity));
	}

	public static String getTableName(Table table) {
		return table.name();
	}

	public static List<Column> getPk(BaseEntity<?> entity) {
		return getPk(entity.getClass(), getTable(entity));
	}

	public static List<Column> getColumns(Class<?> entityClass) {
		return getColumns(entityClass, getTable(entityClass));
	}

	public static List<Column> getColumns(BaseEntity<?> entity) {
		return getColumns(entity.getClass(), getTable(entity));
	}

	public static List<Column> getColumns(Class<?> clazz, Table table) {
		String str = (new StringBuilder()).insert(0, clazz.getName()).append(table.hashCode()).toString();
		List<Column> a = columnCache.get(str);
		if (a != null) {
			return a;
		}
		a = ListUtils.newArrayList();
		getColumns(clazz, table, a);
		columnCache.put(str, a);
		return a;
	}

	public static List<Column> getColumns(Class<?> clazz, Table table, List<Column> a) {

		// getSupClass(clazz).forEach(c -> {
		// getColumns(getTable(c), a);
		// });

		getColumns(table, a);

		return a;
	}

	public static void getColumns(Table table, List<Column> a) {

		if (table != null) {

			Column[] cs = table.columns();

			for (Column c : cs) {
				if (c.includeEntity().equals(Class.class)) {
					a.add(c);
				} else {
					a.addAll(getColumns(c.includeEntity()));
				}
			}
		}
	}

	public static List<Class<?>> getSupClass(Class<?> calzz) {
		List<Class<?>> listSuperClass = new ArrayList<Class<?>>();
		Class<?> superclass = calzz.getSuperclass();
		while (superclass != null) {
			if (superclass.getName().equals("java.lang.Object")) {
				break;
			}
			listSuperClass.add(superclass);
			superclass = superclass.getSuperclass();
		}
		return listSuperClass;
	}

	public static String getColumnName(Column c) {
		return c.name();
	}

	public static List<Column> getPk(Class<?> clazz, Table table) {
		String str = (new StringBuilder()).insert(0, clazz.getName()).append(table.hashCode()).toString();
		List<Column> a = pkCache.get(str);
		if (a != null) {
			return a;
		}
		a = ListUtils.newArrayList();
		Column c;
		for (Iterator<Column> iterator = getColumns(clazz, table).iterator(); iterator.hasNext();) {
			if ((c = iterator.next()).isPK()) {
				a.add(c);
			}
		}
		pkCache.put(str, a);
		return a;
	}

	public static String getAttrName(JoinTable t) {
		return (String) StrUtils.defaultIfBlank(t.attrName(), StrUtils.uncap(t.entity().getSimpleName()));
	}

	public static String getAttrName(Column c) {
		return (String) StrUtils.defaultIfBlank(c.attrName(), StrUtils.camelCase(c.name()));
	}

	public static void clearCache() {
		columnCache.clear();
		pkCache.clear();
	}

	public static boolean hasStatus(BaseEntity<?> entity) {
		for (Column col : MapperHelper.getColumns(entity)) {
			if(col.attrName().equals("status")){
				return true;
			}
		}
		return false;
	}

	public static boolean hasStatus(Class<?> calzz) {
		for (Column col : MapperHelper.getColumns(calzz)) {
			if(col.attrName().equals("status")){
				return true;
			}
		}
		return false;
	}

}
