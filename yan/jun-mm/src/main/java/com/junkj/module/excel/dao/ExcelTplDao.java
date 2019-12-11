package com.junkj.module.excel.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.SelectProvider;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.excel.entity.ExcelTpl;
import com.junkj.module.excel.sql.ExcelTplSql;

@MyBatisDao
public interface ExcelTplDao extends CrudDao<ExcelTpl> {

	@SelectProvider(type = ExcelTplSql.class, method = "getTemplateCol")
	public List<Map<String, Object>> getTemplateCol(Integer tableCode);

	@SelectProvider(type = ExcelTplSql.class, method = "getTemplateRule")
	public List<Map<String, Object>> getTemplateRule(String tableCode);

	@SelectProvider(type = ExcelTplSql.class, method = "getExcelTplByCode")
	public ExcelTpl getExcelTplByCode(String tableCode);
}
