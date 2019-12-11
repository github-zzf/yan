package com.junkj.module.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.sys.sql.ComboSql;

@MyBatisDao
public interface ComboDao {

	@SelectProvider(type = ComboSql.class, method = "findCols")
	public List<Map<String, Object>> findCols(String tableCode);

	@SelectProvider(type = ComboSql.class, method = "findBeanType")
	public List<Map<String, Object>> findBeanType(String tKey);
	
	@SelectProvider(type = ComboSql.class, method = "findMemberLevel")
	public List<Map<String, Object>> findMemberLevel(String comId);
	
	@SelectProvider(type = ComboSql.class, method = "findMemberLevelValue")
	public String findMemberLevelValue(String comId, String name);
	
	@SelectProvider(type = ComboSql.class, method = "findComCards")
	public List<Map<String, Object>> findComCards(String comId);

	@SelectProvider(type = ComboSql.class, method = "findBeanTypeLabel")
	public List<Map<String, Object>> findBeanTypeLabel(String tKey);
	
	@SelectProvider(type = ComboSql.class, method = "findStaff")
	public List<Map<String, Object>> findStaff(String comId, String search);
	
	@SelectProvider(type = ComboSql.class, method = "findCardsType")
	public List<Map<String, Object>> findCardsType(String comId, String search);
	
}
