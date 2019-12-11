package com.junkj.module.company.entity;

import javax.validation.constraints.NotEmpty;

import com.junkj.common.entity.BaseEntity;
import com.junkj.common.entity.DataEntity;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.JoinTable;
import com.junkj.common.mybatis.annotation.Table;
import com.junkj.common.mybatis.query.QueryType;
import com.junkj.module.sys.entity.SysBeanData;

/**
 * 参数配置实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019年10月17日
 * @version: 1.0.0
 */
@Table(name = "com_config", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "c_name", attrName = "configName", queryType = QueryType.LIKE),
		@Column(name = "c_key", attrName = "configKey"),
		@Column(name = "c_value", attrName = "configValue"),
		@Column(name = "c_type", attrName = "configType"),
		@Column(name = "remark", attrName = "remark"),
		@Column(includeEntity= BaseEntity.class),
	}, orderBy = "a.id DESC"
)
public class ComConfig extends DataEntity<ComConfig> {

	private static final long serialVersionUID = 1L;

	private String configName; // 参数名称
	private String configKey; // 参数key
	private String configValue; // 参数值
	private String configType; // 参数类型（text/img/json/jsonObj/post/get）
	private String remark; // 参数说明
	
	public String getConfigName() {
		return configName;
	}
	public void setConfigName(String configName) {
		this.configName = configName;
	}
	public String getConfigKey() {
		return configKey;
	}
	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}
	
	@NotEmpty(message="参数值不能为空")
	public String getConfigValue() {
		return configValue;
	}
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	public String getConfigType() {
		return configType;
	}
	public void setConfigType(String configType) {
		this.configType = configType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}