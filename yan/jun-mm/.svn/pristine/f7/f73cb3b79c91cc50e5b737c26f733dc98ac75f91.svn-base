package com.junkj.common.mybatis.query;

import com.junkj.common.lang.StrUtils;
import com.junkj.common.mybatis.mapper.SqlUtils;

public enum QueryType {
	EQ, LIKE, IS_NULL, IS_NOT_NULL, IN, FIND_IN_SET;

	public String getSql(String colName, String attrName) {
		return getSql(null, colName, attrName, null);
	}

	public String getSql(String alias, String colName, String attrName) {
		return getSql(alias, colName, attrName, null);
	}

	public String getSql(String alias, String colName, String attrName, String joinAlias) {
		String sql;
		switch (this) {
		case EQ:
			sql = eqSql(alias, colName, attrName, joinAlias);
			break;
		case LIKE:
			sql = likeSql(alias, colName, attrName, joinAlias);
			break;
		case IS_NULL:
			sql = isNullSql(alias, colName, attrName, joinAlias);
			break;
		case IS_NOT_NULL:
			sql = isNotNullSql(alias, colName, attrName, joinAlias);
			break;
		case IN:
			sql = in(alias, colName, attrName, joinAlias);
			break;
		case FIND_IN_SET:
			sql = findInSet(alias, colName, attrName, joinAlias);
			break;
		default:
			sql = null;
		}
		return sql;
	}

	private String eqSql(String alias, String colName, String attrName, String joinAlias) {
		StringBuffer sql = new StringBuffer();
		if (StrUtils.notBlank(alias)) {
			sql.append(alias);
			sql.append(SqlUtils.SPOT);
		}
		sql.append(colName);
		sql.append(SqlUtils.P_LEFT_EQ);
		sql.append(StrUtils.isBlank(joinAlias) ? "" : joinAlias + SqlUtils.SPOT);
		sql.append(attrName);
		sql.append(SqlUtils.P_RIGHT);

		return sql.toString();
	}

	private String likeSql(String alias, String colName, String attrName, String joinAlias) {
		StringBuffer sql = new StringBuffer();
		if (StrUtils.notBlank(alias)) {
			sql.append(alias);
			sql.append(SqlUtils.SPOT);
		}
		sql.append(colName);
		sql.append(SqlUtils.LIKE_LEFT);
		sql.append(StrUtils.isBlank(joinAlias) ? "" : joinAlias + SqlUtils.SPOT);
		sql.append(attrName);
		sql.append(SqlUtils.LIKE_RIGHT);

		return sql.toString();
	}

	private String isNullSql(String alias, String colName, String attrName, String joinAlias) {
		StringBuffer sql = new StringBuffer();
		if (StrUtils.notBlank(alias)) {
			sql.append(alias);
			sql.append(SqlUtils.SPOT);
		}
		sql.append(StrUtils.isBlank(joinAlias) ? "" : joinAlias + SqlUtils.SPOT);
		sql.append(colName);
		sql.append(SqlUtils.IS_NULL);

		return sql.toString();
	}

	private String isNotNullSql(String alias, String colName, String attrName, String joinAlias) {
		StringBuffer sql = new StringBuffer();
		if (StrUtils.notBlank(alias)) {
			sql.append(alias);
			sql.append(SqlUtils.SPOT);
		}
		sql.append(StrUtils.isBlank(joinAlias) ? "" : joinAlias + SqlUtils.SPOT);
		sql.append(colName);
		sql.append(SqlUtils.IS_NOT_NULL);

		return sql.toString();
	}

	private String in(String alias, String colName, String attrName, String joinAlias) {
		StringBuffer sql = new StringBuffer();
		if (StrUtils.notBlank(alias)) {
			sql.append(alias);
			sql.append(SqlUtils.SPOT);
		}
		sql.append(colName);
		sql.append(SqlUtils.IN_LEFT);
		sql.append(StrUtils.isBlank(joinAlias) ? "" : joinAlias + SqlUtils.SPOT);
		sql.append(attrName);
		sql.append(SqlUtils.IN_RIGHT);

		return sql.toString();
	}

	private String findInSet(String alias, String colName, String attrName, String joinAlias) {
		StringBuffer sql = new StringBuffer();
		sql.append(SqlUtils.FIND_IN_SET_LEFT);
		if (StrUtils.notBlank(alias)) {
			sql.append(alias);
			sql.append(SqlUtils.SPOT);
		}
		sql.append(colName);
		sql.append(SqlUtils.FIND_IN_SET_CENTER);
		sql.append(StrUtils.isBlank(joinAlias) ? "" : joinAlias + SqlUtils.SPOT);
		sql.append(attrName);
		sql.append(SqlUtils.FIND_IN_SET_RIGHT);

		return sql.toString();
	}

}
