package com.junkj.module.sys.sql;

import org.apache.ibatis.jdbc.SQL;

public class ComboSql {

	public String findCols(String tableCode) {
		String str = new SQL() {
			{
				SELECT("a.tableCode");
				SELECT("a.colCode");
				SELECT("a.colName");
				SELECT("a.colWidth");
				SELECT("a.colSort");
				FROM("excel_out a");
				WHERE("a.tableCode = #{tableCode}");
				ORDER_BY("a.colSort asc");
			}
		}.toString();

		return str;
	}

	public String findBeanType(String beanKey) {
		String str = new SQL() {
			{
				SELECT("a.bean_val as val");
				SELECT("a.bean_txt as txt");
				FROM("sys_bean_data a");
				WHERE("a.bean_key= #{beanKey}");
				ORDER_BY("a.bean_sort asc");
			}
		}.toString();

		return str;
	}

	public String findBeanTypeLabel(String beanKey) {
		String str = new SQL() {
			{
				SELECT("a.bean_val as value");
				SELECT("a.bean_txt as label");
				FROM("sys_bean_data a");
				WHERE("a.bean_key= #{beanKey}");
				ORDER_BY("a.bean_sort asc");
			}
		}.toString();

		return str;
	}
	
	public String findMemberLevel(String comId) {
		String str = new SQL() {
			{
				SELECT("a.id");
				SELECT("a.name");
				FROM("member_level a");
				WHERE("a.com_id=#{comId}");
			}
		}.toString();

		return str;
	}
	
	public String findMemberLevelValue(String comId, String name) {
		String str = new SQL() {
			{
				SELECT("a.id");
				FROM("member_level a");
				WHERE("a.com_id=#{comId}");
				WHERE("a.name=#{name}");
			}
		}.toString();
		
		return str;
	}
	
	public String findComCards(String comId) {
		String str = new SQL() {
			{
				SELECT("a.id");
				SELECT("a.name");
				FROM("com_cards a");
				WHERE("a.com_id=#{comId}");
			}
		}.toString();

		return str;
	
	}
	
	public String findStaff(String comId, String search) {
		String str = new SQL() {
			{
				SELECT("a.id");
				SELECT("a.name");
				FROM("sys_user a");
				WHERE("a.user_type='staff'");
				WHERE("a.com_id=#{comId}");
				WHERE("a.name like CONCAT('%',#{search},'%')");
			}
		}.toString();
		
		return str;
	}
	
	public String findCardsType(String comId, String search) {
		String str = new SQL() {
			{
				SELECT("a.id");
				SELECT("a.type_name as typeName");
				FROM("com_cards_type a");
				WHERE("a.com_id=#{comId}");
				WHERE("a.type_name like CONCAT('%',#{search},'%')");
			}
		}.toString();
		
		return str;
	}

}
