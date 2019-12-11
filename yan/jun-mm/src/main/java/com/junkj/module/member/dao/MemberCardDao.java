package com.junkj.module.member.dao;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.member.entity.MemberCard;
import com.junkj.module.member.sql.MemberCardSql;

/**
 * 会员卡记录dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 * @version: 1.0.0
 */
@MyBatisDao
public interface MemberCardDao extends CrudDao<MemberCard> {

	@SelectProvider(type = MemberCardSql.class, method = "getMemberCardList")
	public List<MemberCard> getMemberCardList(MemberCard card);

	/**
	 * 获取会员未失效的会员卡
	 */
	@SelectProvider(type = MemberCardSql.class, method = "getOkCard")
	public MemberCard getOkCard(String comId, String memberId, String cardId);

}
