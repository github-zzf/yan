package com.junkj.module.shop.dao;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.shop.entity.Gift;

/**
 * 积分商品dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@MyBatisDao
public interface GiftDao extends CrudDao<Gift> {

}
