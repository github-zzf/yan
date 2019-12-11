package com.junkj.module.member.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.junkj.common.dao.CrudDao;
import com.junkj.common.mybatis.annotation.MyBatisDao;
import com.junkj.module.member.entity.Member;
import com.junkj.module.member.sql.MemberSql;

/**
 * 会员dao
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月26日
 */
@MyBatisDao
public interface MemberDao extends CrudDao<Member> {
	
	@SelectProvider(type=MemberSql.class,method="getMemberInfo")
	public Map<String, Object> getMemberInfo(String memberId, String comId);

	@Select("select * from member where phone = #{phone}")
	public Member getByPhone(String phone);

}
