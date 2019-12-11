package com.junkj.module.weixin.sql;

import org.apache.ibatis.jdbc.SQL;

import com.junkj.module.weixin.entity.WxUser;

public class WxUserSql {

	public String getByStaffId(String staffId) {
		String str = new SQL() {
			{
				SELECT("company_id as 'companyId'");
				SELECT("openid");
				SELECT("appid");
				SELECT("member_id as 'memberId'");
				SELECT("staff_id as 'staffId'");
				SELECT("sale_id as 'saleId'");
				SELECT("phone");
				SELECT("head_img as 'headImg'");
				SELECT("nickname");
				FROM("wx_user");
				WHERE("staff_id=#{staffId}");
			}
		}.toString();

		return str;
	}

	public String getBySaleId(String saleId) {
		String str = new SQL() {
			{
				SELECT("company_id as 'companyId'");
				SELECT("openid");
				SELECT("appid");
				SELECT("member_id as 'memberId'");
				SELECT("staff_id as 'staffId'");
				SELECT("sale_id as 'saleId'");
				SELECT("phone");
				SELECT("head_img as 'headImg'");
				SELECT("nickname");
				FROM("wx_user");
				WHERE("sale_id=#{saleId}");
			}
		}.toString();

		return str;
	}
	public String updateMemberId(String comId, String memberId, String delMemberId) {
		String str = new SQL() {
			{
				UPDATE("cash_buy set member_id = #{memberId} where member_id = #{delMemberId};");
				UPDATE("UPDATE com_activity_enroll set member_id = #{memberId} where member_id = #{delMemberId};");
				UPDATE("UPDATE com_course_enroll set member_id = #{memberId} where member_id = #{delMemberId};");
				UPDATE("UPDATE member_card_change set member_id = #{memberId} where member_id = #{delMemberId};");
				UPDATE("UPDATE member_growup set member_id = #{memberId} where member_id = #{delMemberId};");
				UPDATE("UPDATE member_card set member_id = #{memberId} where member_id = #{delMemberId};");
				UPDATE("UPDATE member_points set member_id = #{memberId} where member_id = #{delMemberId};");
				UPDATE("UPDATE sale_member set member_id = #{memberId} where member_id = #{delMemberId};");
				UPDATE("UPDATE shop_gift_exchange set member_id = #{memberId} where member_id = #{delMemberId};");
				UPDATE("UPDATE sys_pay set member_id = #{memberId} where member_id = #{delMemberId};");
				
				UPDATE("delete from com_member where com_id = #{comId} and member_id = #{delMemberId};");
				UPDATE("UPDATE com_member set member_id = #{memberId} where member_id = #{delMemberId};");
				UPDATE("delete from member where id = #{delMemberId};");
				UPDATE("UPDATE com_member a set points = " + 
						" ((SELECT IFNULL(sum(num),0) from member_points b where b.com_id = #{comId} and b.member_id =#{memberId} and type='1')" + 
						" -(SELECT IFNULL(sum(num),0) from member_points c where c.com_id = #{comId} and c.member_id =#{memberId} and type='2'))" + 
						" where a.member_id =#{memberId} and a.com_id = #{comId};");
			}
		}.toString();

		return str;
	}

}
