package com.junkj.module.company.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.company.entity.ComTemplate;
import com.junkj.module.company.sql.ComTemplateSql;

/**
 * 企业模板消息dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年11月07日
 * @version: 1.0.0
 */
@MyBatisDao
public interface ComTemplateDao extends CrudDao<ComTemplate> {

	/**
	 * 查询企业模板
	 */
	@SelectProvider(type = ComTemplateSql.class, method = "findList")
	List<ComTemplate> findList(ComTemplate comTemplate);

}
