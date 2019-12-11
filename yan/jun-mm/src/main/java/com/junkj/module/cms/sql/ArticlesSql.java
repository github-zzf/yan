package com.junkj.module.cms.sql;

import org.apache.ibatis.jdbc.SQL;

import com.junkj.common.lang.StrUtils;

public class ArticlesSql {

	public String listStaffArticles(String type, String comId,Integer srow,Integer erow) {
		String str = new SQL() {
			{
				SELECT("a.*");
				SELECT("DATE_FORMAT(a.send_time,'%Y-%m-%d') as sendTime");
				SELECT("b.name as staffName");
				FROM("cms_articles a");
				WHERE("type_id in (select id from cms_arttype where type_type='3')");
				WHERE("a.com_id = #{comId}");
				LEFT_OUTER_JOIN("sys_user b on a.create_id=b.id");
				if(StrUtils.notBlank(type)){
					ORDER_BY("a.send_time asc LIMIT #{srow},#{erow}");
				}else{
					if(StrUtils.notBlank(srow) && StrUtils.notBlank(erow)){
						ORDER_BY("a.send_time asc LIMIT #{srow},#{erow}");
					}
				}
			}
		}.toString();

		return str;
	}

}
