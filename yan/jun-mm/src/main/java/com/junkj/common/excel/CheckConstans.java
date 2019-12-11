package com.junkj.common.excel;


public class CheckConstans {
	
	/** 业务名称 **/
	//会员表
	public final static String APP_MEMBER = "APP_MEMBER";
	
	/** 验证规则 **/
	//非空校验
	public static String RULE_NAME_NOTNULL = "NotNull";
	//最小长度
	public static String RULE_NAME_MINSIZE = "MinSize";
	//最大长度
	public static String RULE_NAME_MAXSIZE = "MaxSize";
	//最小数值
	public static String RULE_NAME_MIN = "Min";
	//最大数值
	public static String RULE_NAME_MAX = "Max";
	//电子邮件
	public static String RULE_NAME_EMAIL = "Email";
	//正则
	public static String RULE_NAME_REGEXP = "Regexp";
	//性别
	public static String RULE_NAME_SEX = "Sex";
	//日期
	public static String RULE_NAME_DATE = "Date";
	//是否
	public static String RULE_NAME_YES = "YES";
	//数字
	public static String RULE_NAME_NUM = "Number";
	//小数
	public static String RULE_NAME_DOU = "Double";
	
	/** 错误提示 **/
	public static String ERROR_EXCEL_NULL="excel中数据为空!<br>";
	public static String ERROR_EXCEL_COLUMN_NOT_EQUAL="xml列数与excel列数不相符，请检查!<br>";
	public static String ERROR_EXCEL_DATA_TYPE = "数据类型错误";
	

}
