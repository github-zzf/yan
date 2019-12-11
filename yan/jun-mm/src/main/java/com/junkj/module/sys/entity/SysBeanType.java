package com.junkj.module.sys.entity;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.junkj.common.collect.ListUtils;
import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;

/**
 * 数据字典类型实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月14日
 * @version: 1.0.0
 */
@Table(name = "sys_bean_type", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "bean_name", attrName = "beanName",queryType = QueryType.LIKE),
		@Column(name = "bean_key", attrName = "beanKey"),
		@Column(includeEntity = DataEntity.class)
	}, orderBy = "a.id DESC"
)
public class SysBeanType extends DataEntity<SysBeanType> {

	private static final long serialVersionUID = 1L;

	private String beanName; // 字典名称
	private String beanKey; // 字典类型

	private List<SysBeanData> sysBeanData = ListUtils.newArrayList();  // 子表数据
	
	public List<SysBeanData> getSysBeanData() {
		return sysBeanData;
	}
	public void setSysBeanData(List<SysBeanData> sysBeanData) {
		this.sysBeanData = sysBeanData;
	}
	
	@NotEmpty(message = "字典名称不能为空")
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	@NotEmpty(message = "字典类型不能为空")
	public String getBeanKey() {
		return beanKey;
	}
	public void setBeanKey(String beanKey) {
		this.beanKey = beanKey;
	}

}