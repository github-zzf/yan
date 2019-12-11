package com.junkj.module.weixin.dao;

import org.apache.ibatis.annotations.SelectProvider;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.weixin.entity.WxUser;
import com.junkj.module.weixin.sql.WxUserSql;

/**
 * 微信用户dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月22日
 * @version: 1.0.0
 */
@MyBatisDao
public interface WxUserDao extends CrudDao<WxUser> {

	/**
	 * 通过staffId查询会员
	 */
	@SelectProvider(type = WxUserSql.class, method = "getByStaffId")
	WxUser getByStaffId(String staffId);

	/**
	 * 通过saleId查询会员
	 */
	@SelectProvider(type = WxUserSql.class, method = "getBySaleId")
	WxUser getBySaleId(String saleId);
	/**
	 * 绑定微信
	 */
	@SelectProvider(type = WxUserSql.class, method = "updateMemberId")
	void updateMemberId(String comId, String memberId,String delMemberId);
}
