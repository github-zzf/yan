package com.junkj.module.sale.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.junkj.common.lang.StrUtils;

public class SalePerformanceSql {

	public String findList(Map<String, Object> map) {
		String str = new SQL() {
			{
				SELECT("a.name");
				SELECT("(select ifnull(sum(cb.pay_money),0) from sale_member sm left join cash_buy cb on(cb.member_id = sm.member_id) where cb.status = 0 and sm.user_id = a.id) as dgMoney");
				SELECT("(select ifnull(sum(cb.pay_money),0) from sale_member sm \r\n" + 
						"left join cash_buy cb on(cb.member_id = sm.member_id)\r\n" + 
						"where sm.user_id in (select user_id from sale_team st left join sys_user su on (su.id = st.user_id) where su.status = 0 and st.parent_id = (SELECT id from sale_team where user_id = a.id))\r\n" + 
						") as tuanMoney");
				FROM(" sys_user a ");
				WHERE("a.status=0 and a.user_type='sale' and a.com_id = #{comId}");
				if(StrUtils.notBlank(map.get("userName"))){
					WHERE("a.name like CONCAT('%',#{userName},'%')");
				}
			}
		}.toString();
		
		return str;
	}
	
	public String findSalePer(Map<String, Object> params) {
		String str = new SQL() {
			{
				SELECT("m.`name`,cb.pay_money as xmoney,cb.update_time as time");
				FROM(" sale_member sm ");
				LEFT_OUTER_JOIN("cash_buy cb ON (cb.member_id = sm.member_id)");
				LEFT_OUTER_JOIN("member m ON (m.id = sm.member_id)");
				WHERE("cb.STATUS = 0 and sm.user_id = #{userId}");
				if(StrUtils.notBlank(params.get("ymDate"))){
					WHERE("DATE_FORMAT(cb.update_time ,'%Y-%m') = #{ymDate}");
				}
				if(StrUtils.notBlank(params.get("startTime"))){
					WHERE("DATE_FORMAT(cb.update_time ,'%Y-%m-%d %H:%i') >= DATE_FORMAT(#{startTime},'%Y-%m-%d %H:%i')");
				}
				if(StrUtils.notBlank(params.get("endTime"))){
					WHERE("DATE_FORMAT(cb.update_time ,'%Y-%m-%d %H:%i') <= DATE_FORMAT(#{endTime},'%Y-%m-%d %H:%i')");
				}
				if(StrUtils.notBlank(params.get("name"))){
					WHERE("m.name = #{name}");
				}
				if(StrUtils.notBlank(params.get("minMoney"))){
					WHERE("cb.pay_money >= #{minMoney}");
				}
				if(StrUtils.notBlank(params.get("maxMoney"))){
					WHERE("cb.pay_money <= #{maxMoney}");
				}
			}
		}.toString();
		
		return str;
	}
	public String findTeamSalePer(Map<String, Object> params) {
		String str = new SQL() {
			{
				SELECT("su.name as name,SUM(pay_money) as xmoney,COUNT(pay_money) as num");
				FROM(" sale_member sm");
				LEFT_OUTER_JOIN("cash_buy cb ON (cb.member_id = sm.member_id)");
				LEFT_OUTER_JOIN("sys_user su ON (su.id = sm.user_id)");
				
				StringBuffer str = new StringBuffer();
				str.append("sm.user_id IN (");
				str.append(" SELECT user_id FROM sale_team st");
				str.append(" LEFT JOIN sys_user su ON (su.id = st.user_id)");
				str.append(" WHERE su.STATUS = 0");
				str.append(" AND st.parent_id = (SELECT id	FROM sale_team WHERE user_id = #{userId}))");
				
				WHERE(str.toString());

				if(StrUtils.notBlank(params.get("ymDate"))){
					WHERE("DATE_FORMAT(cb.update_time ,'%Y-%m') = #{ymDate}");
				}else {
					if(StrUtils.notBlank(params.get("startTime"))){
						WHERE("DATE_FORMAT(cb.update_time ,'%Y-%m-%d %H:%i') >= DATE_FORMAT(#{startTime},'%Y-%m-%d %H:%i')");
					}
					if(StrUtils.notBlank(params.get("endTime"))){
						WHERE("DATE_FORMAT(cb.update_time ,'%Y-%m-%d %H:%i') <= DATE_FORMAT(#{endTime},'%Y-%m-%d %H:%i')");
					}
				}
				if(StrUtils.notBlank(params.get("name"))){
					WHERE("su.name = #{name}");
				}
				GROUP_BY("su.name");
				if(StrUtils.notBlank(params.get("minMoney"))){
					HAVING("xmoney >= #{minMoney}");
				}
				if(StrUtils.notBlank(params.get("maxMoney"))){
					HAVING("xmoney <= #{maxMoney}");
				}
			}
		}.toString();
		
		return str;
	}

}
