package com.junkj.module.company.sql;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.junkj.common.lang.StrUtils;
import com.junkj.module.company.entity.ComConfig;

public class ComConfigSql {

	/**
	 * 查询企业配置
	 */
	public String findList(ComConfig comConfig){
		String str = new SQL() {
			{
				SELECT("a.id AS 'id'");
				SELECT("a.c_value AS 'configValue'");
				SELECT("a.c_type AS 'configType'");
				SELECT("a.com_id AS 'comId'");
				SELECT("b.bean_txt AS 'configName'");
				SELECT("b.bean_val AS 'configKey'");
				SELECT("b.remark AS 'remark'");
				FROM("com_config AS a");
				RIGHT_OUTER_JOIN("sys_bean_data AS b on(a.com_id = #{comId} and b.bean_val = a.c_key)");
				WHERE("b.bean_key = 'company_config'");
				
				if(StrUtils.notBlank(comConfig.getConfigName())){
					WHERE("b.bean_txt LIKE CONCAT('%',#{configName},'%')");
				}
			}
		}.toString();

		return str;
	}
	/**
	 * 查询企业配置
	 */
	public String findConfig(Map<String,Object> map){
		String str = new SQL() {
			{
				SELECT("a.id AS 'id'");
				SELECT("a.c_value AS 'configValue'");
				SELECT("a.c_type AS 'configType'");
				SELECT("a.com_id AS 'comId'");
				SELECT("b.bean_txt AS 'configName'");
				SELECT("b.bean_val AS 'configKey'");
				SELECT("b.remark AS 'remark'");
				FROM("com_config AS a");
				RIGHT_OUTER_JOIN("sys_bean_data AS b on(a.com_id = #{comId} and b.bean_val = a.c_key)");
				WHERE("b.bean_key = 'company_config'");
				if(map.size()==2){
					WHERE("b.bean_val =#{configKey1}");
				}
				if(map.size()==3){
					WHERE("b.bean_val =#{configKey1} or b.bean_val =#{configKey2}");
				}
				if(map.size()==4){
					WHERE("b.bean_val =#{configKey1} or b.bean_val =#{configKey2} or b.bean_val =#{configKey3}");
				}
			}
		}.toString();

		return str;
	}

}
