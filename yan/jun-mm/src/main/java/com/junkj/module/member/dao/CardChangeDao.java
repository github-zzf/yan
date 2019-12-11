package com.junkj.module.member.dao;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.member.entity.CardChange;

/**
 * 会员卡消费明细表dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@MyBatisDao
public interface CardChangeDao extends CrudDao<CardChange> {

}
