package com.junkj.module.sys.entity;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.junkj.common.collect.MapUtils;
import com.junkj.common.entity.DataEntity;
import com.junkj.common.lang.StrUtils;
import com.junkj.common.mybatis.annotation.Column;
import com.junkj.common.mybatis.annotation.Table;

/**
 * 日志实体
 * 
 * @copyright 大连骏骁网络科技有限公司
 * @author 骏骁(cxmail@qq.com)
 * @createDate 2019-08-26
 * @version: 1.0.0
 */
@Table(name = "sys_log", alias = "a", columns = {
		@Column(name = "id", attrName = "id", isPK = true),
		@Column(name = "log_type", attrName = "logType"),
		@Column(name = "log_title", attrName = "logTitle"),
		@Column(name = "create_id", attrName = "createId"),
		@Column(name = "create_name", attrName = "createName"),
		@Column(name = "create_time", attrName = "createTime"),
		@Column(name = "request_uri", attrName = "requestUri"),
		@Column(name = "request_method", attrName = "requestMethod"),
		@Column(name = "request_params", attrName = "requestParams"),
		@Column(name = "biz_id", attrName = "bizId"),
		@Column(name = "biz_type", attrName = "bizType"),
		@Column(name = "server_addr", attrName = "serverAddr"),
		@Column(name = "is_exception", attrName = "isException"),
		@Column(name = "exception", attrName = "exception"),
		@Column(name = "user_id", attrName = "userIp"),
		@Column(name = "user_agent", attrName = "userAgent"),
		@Column(name = "device_name", attrName = "deviceName"),
		@Column(name = "browser_name", attrName = "browserName"),
		@Column(name = "run_time", attrName = "runTime")
	}, orderBy = "a.id DESC"
)
public class SysLog extends DataEntity<SysLog> {

	private static final long serialVersionUID = 1L;
	private String logType; // 日志类型
	private String logTitle; // 日志标题
	private String requestUri; // 操作的URI
	private String requestMethod; // 操作的方式
	private String requestParams; // 操作提交的数据
	private String bizId; // 业务主键
	private String bizType; // 业务类型
	private String serverAddr; // 服务器地址
	private String isException; // 是否异常
	private String exception; // 异常信息
	private String userIp; // 用户IP地址
	private String userAgent; // 用户代理信息
	private String deviceName; // 设备名称/操作系统
	private String browserName; // 浏览器名称
	private Long runTime; // 执行时间
	private Date beginDate; // 开始时间
	private Date endDate; // 结束时间

	// 日志类型
	public static final String TYPE_ACCESS = "access";
	public static final String TYPE_INSERT = "insert";
	public static final String TYPE_UPDATE = "update";
	public static final String TYPE_DELETE = "delete";
	public static final String TYPE_SELECT = "select";
	public static final String TYPE_LOGIN = "select";
	public static final String TYPE_LOGIN_LOGOUT = "loginLogout";
	
	private Map<String, String[]> paramsMap; 		// 操作提交的数据，临时存储用

	public SysLog() {
		super();
	}

	public SysLog(String id) {
		super(id);
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getLogTitle() {
		return logTitle;
	}

	public void setLogTitle(String logTitle) {
		this.logTitle = logTitle;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getRequestParams() {
		return requestParams;
	}

	public void setRequestParams(String requestParams) {
		this.requestParams = requestParams;
	}

	public void setRequestParams(Map<String, String[]> paramsMap) {
		if (paramsMap == null){
			return;
		}
		if (this.paramsMap == null){
			this.paramsMap = MapUtils.newHashMap();
		}
		StringBuilder params = new StringBuilder();
		for (Map.Entry<String, String[]> param : ((Map<String, String[]>)paramsMap).entrySet()){
			params.append(("".equals(params.toString()) ? "" : "&") + param.getKey() + "=");
			String paramValue = (param.getValue() != null && param.getValue().length > 0 ? param.getValue()[0] : "");
			params.append(StrUtils.abbr(StrUtils.endsWithIgnoreCase(param.getKey(), "password") ? "*" : paramValue, 1000));
			this.paramsMap.put(param.getKey(), param.getValue());
		}
		this.requestParams = params.toString();
	}

	/**
	 * 根据名称获取参数（只有先执行setParams(Map)后才有效）
	 */
	public String getRequestParam(String name) {
		if (paramsMap == null){
			return null;
		}
        String[] values = (String[])paramsMap.get(name);
        return values != null && values.length > 0 ? values[0] : null;
    }

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getServerAddr() {
		return serverAddr;
	}

	public void setServerAddr(String serverAddr) {
		this.serverAddr = serverAddr;
	}

	public String getIsException() {
		return isException;
	}

	public void setIsException(String isException) {
		this.isException = isException;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}

	public Long getRunTime() {
		return runTime;
	}

	public void setRunTime(Long runTime) {
		this.runTime = runTime;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public static String getTypeUpdate() {
		return TYPE_UPDATE;
	}

	public static String getTypeSelect() {
		return TYPE_SELECT;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}