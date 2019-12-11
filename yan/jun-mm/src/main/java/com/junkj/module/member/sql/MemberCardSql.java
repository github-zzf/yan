package com.junkj.module.member.sql;

import org.apache.ibatis.jdbc.SQL;

import com.junkj.module.member.entity.MemberCard;

public class MemberCardSql {

	public String getMemberCardList(MemberCard card) {
		String str = new SQL() {
			{
				SELECT("a.*");
				SELECT("a.stored_num as storedNum");
				FROM("member_card a");
				LEFT_OUTER_JOIN("com_cards b on a.card_id=b.id");
				WHERE("b.cards_type_id = #{cardsTypeId}");
				WHERE("a.com_id = #{comId}");
				WHERE("a.member_id = #{memberId}");
				WHERE("a.stored_num > 0");
				WHERE("DATE_FORMAT(a.invalid_time,'%Y-%m-%d-%H-%i-%S') > date_format(now(),'%Y-%m-%d-%H-%i-%S')");
				ORDER_BY("a.create_time asc");
			}
		}.toString();
		return str;
	}

	public String getOkCard(String comId, String memberId, String cardId) {
		String str = new SQL() {
			{
				SELECT("a.id");
				SELECT("a.com_id as 'comId'");
				SELECT("a.member_id as 'memberId'");
				SELECT("a.card_id as 'cardId'");
				SELECT("a.card_name as 'cardName'");
				SELECT("a.stored_all as 'storedAll'");
				SELECT("a.stored_num as 'storedNum'");
				SELECT("a.invalid_time as 'invalidTime'");
				FROM("member_card a");
				WHERE("a.com_id = #{comId}");
				WHERE("a.member_id = #{memberId}");
				WHERE("a.card_id = #{cardId}");
				WHERE("DATE_FORMAT(a.invalid_time,'%Y-%m-%d-%H-%i-%S') > date_format(now(),'%Y-%m-%d-%H-%i-%S')");
			}
		}.toString();
		return str;
	}

}
