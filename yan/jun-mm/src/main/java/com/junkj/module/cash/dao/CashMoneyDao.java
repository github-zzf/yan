package com.junkj.module.cash.dao;

import org.apache.ibatis.annotations.Delete;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.cash.entity.CashMoney;

/**
 * 销售金额dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月28日
 * @version: 1.0.0
 */
@MyBatisDao
public interface CashMoneyDao extends CrudDao<CashMoney> {

	@Delete("delete from cash_money where biz_type=#{bizType} and biz_id=#{bizId} and buy_type=#{buyType}")
	void deleteByBizType(String bizType, String bizId, String buyType);

}
