package com.junkj.module.sys.entity;

import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.Table;

/**
 * 数据字典数据实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Table(name = "sys_bean_data", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "bean_key", attrName = "beanKey"),
		@Column(name = "bean_val", attrName = "beanVal"),
		@Column(name = "bean_txt", attrName = "beanTxt"),
		@Column(name = "bean_sort", attrName = "beanSort"),
		@Column(includeEntity = DataEntity.class)
	}, orderBy = "a.bean_sort"
)
public class SysBeanData extends DataEntity<SysBeanData> {

	private static final long serialVersionUID = 1L;

	private String beanKey; //类型 
	private String beanVal; //值 
	private String beanTxt; //标签
	private Long beanSort; // 排序

	public String getBeanKey() {
		return beanKey;
	}
	public void setBeanKey(String beanKey) {
		this.beanKey = beanKey;
	}

	public String getBeanVal() {
		return beanVal;
	}
	public void setBeanVal(String beanVal) {
		this.beanVal = beanVal;
	}

	public String getBeanTxt() {
		return beanTxt;
	}
	public void setBeanTxt(String beanTxt) {
		this.beanTxt = beanTxt;
	}

	public Long getBeanSort() {
		return beanSort;
	}
	public void setBeanSort(Long beanSort) {
		this.beanSort = beanSort;
	}

}