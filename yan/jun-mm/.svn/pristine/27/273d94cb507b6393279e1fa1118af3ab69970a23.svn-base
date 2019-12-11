package com.junkj.module.weixin.dao;

import org.apache.ibatis.annotations.SelectProvider;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.weixin.entity.WxConfig;
import com.junkj.module.weixin.sql.WxConfigSql;

/**
 * 微信公众号配置dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月26日
 */
@MyBatisDao
public interface WxConfigDao extends CrudDao<WxConfig> {

	/**
	 * 通过comId查询公众号配置
	 */
	@SelectProvider(type = WxConfigSql.class, method = "getByComId")
	WxConfig getByComId(String comId);

}
