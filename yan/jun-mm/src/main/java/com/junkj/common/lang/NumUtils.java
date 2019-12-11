package com.junkj.common.lang;

import java.math.BigDecimal;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * 商业计算工具类
 */
public class NumUtils extends NumberUtils {

	/**
	 * 判断字符串是否是整数
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 判断字符串是否是浮点数
	 */
	public static boolean isDouble(String value) {
		try {
			Double.parseDouble(value);
			if (value.contains("."))
				return true;
			return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 判断字符串是否是数字
	 */
	public static boolean isNumber(String value) {
		return isInteger(value) || isDouble(value);
	}
	
	/**
	 * 加法
	 */
	public static double add(Double value1, Double value2) {
		value1 = value1 != null ? value1 : 0D;
		value2 = value2 != null ? value2 : 0D;
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 多参数加法
	 */
	public static double adds(Double... value) {
		double result = 0d;
		for (Double val : value) {
			val = val != null ? val : 0d;
			BigDecimal b1 = new BigDecimal(Double.toString(result));
			BigDecimal b2 = new BigDecimal(Double.toString(val));
			result = b1.add(b2).doubleValue();
		}
		return result;
	}

	/**
	 * 减法
	 */
	public static double subtract(Double value1, Double value2) {
		value1 = value1 != null ? value1 : 0D;
		value2 = value2 != null ? value2 : 0D;
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 多参数减法
	 */
	public static double subtracts(double value, double... values) {
		double result = value;
		for (double val : values) {
			BigDecimal b1 = new BigDecimal(Double.toString(result));
			BigDecimal b2 = new BigDecimal(Double.toString(val));
			result = b1.subtract(b2).doubleValue();
		}
		return result;
	}

	/**
	 * 乘法
	 */
	public static double multiply(double value1, double value2) {
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 除法(保留两位小数，四舍五入)
	 */
	public static double divide(double value1, double value2) {
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 除法(保留一位小数，四舍五入)
	 */
	public static double divideOne(double value1, double value2) {
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.divide(b2, 1, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 计算百分比
	 */
	public static double percentage(double value1, double value2) {
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		BigDecimal b3 = new BigDecimal(100);
		return b1.divide(b2, 3, BigDecimal.ROUND_HALF_UP).multiply(b3).doubleValue();
	}

	/**
	 * 按比例相乘
	 * 
	 * @param money
	 * @param ratio
	 *            比例
	 * @param base
	 *            基数
	 * @return
	 */
	public static double proportion(double money, double ratio, Object base) {
		BigDecimal b1 = new BigDecimal(Double.toString(money));
		BigDecimal b2 = new BigDecimal(Double.toString(ratio));
		BigDecimal b3 = new BigDecimal(base.toString());
		return b1.multiply(b2).divide(b3, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 两浮点数比较
	 * 
	 * @return -1 小于 0 等于 1 大于
	 */
	public static int compare(double value1, double value2) {
		BigDecimal b1 = new BigDecimal(Double.toString(value1));
		BigDecimal b2 = new BigDecimal(Double.toString(value2));
		return b1.compareTo(b2);
	}

	/**
	 * 百分比计算
	 * 
	 * @return
	 */
	public static String formatScale(double one, long total) {
		BigDecimal bg = new BigDecimal(one * 100 / total);
		return bg.setScale(0, BigDecimal.ROUND_HALF_UP).toString();
	}

}
