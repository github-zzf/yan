package com.junkj.module.member.dao;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.member.entity.Points;

/**
 * 积分记录dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 * @version: 1.0.0
 */
@MyBatisDao
public interface PointsDao extends CrudDao<Points> {

}
