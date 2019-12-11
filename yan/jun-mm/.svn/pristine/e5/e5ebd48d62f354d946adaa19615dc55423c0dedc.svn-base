package com.junkj.module.weixin.sql;

import org.apache.ibatis.jdbc.SQL;

public class WxConfigSql {

	public String getByComId(String tokenId) {
		String str = new SQL() {
			{
				SELECT("com_id as 'comId'");
				SELECT("appid");
				SELECT("appname");
				SELECT("appsecret");
				SELECT("mch_id as 'mchId'");
				SELECT("mch_key as 'mchKey'");
				SELECT("mch_cert as 'mchCert'");
				SELECT("remark");
				FROM("wx_config");
				WHERE("com_id=#{comId}");
			}
		}.toString();

		return str;
	}
	
}
