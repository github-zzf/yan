package com.junkj.module.demo.entity;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.Table;

/**
 * 子表示例实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年09月07日
 * @version: 1.0.0
 */
@Table(name = "demo_item", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "base_id", attrName = "baseId"),
		@Column(name = "course", attrName = "course"),
		@Column(name = "num", attrName = "num"),
		@Column(name = "rank", attrName = "rank"),
	}, orderBy = "a.id ASC"
)
public class DemoItem extends DataEntity<DemoItem> {

	private static final long serialVersionUID = 1L;

	private String baseId; // 父表主键
	private String course; // 课程
	private Long num; // 分数
	private String rank; // 排名

	public String getBaseId() {
		return baseId;
	}
	public void setBaseId(String baseId) {
		this.baseId = baseId;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}

}