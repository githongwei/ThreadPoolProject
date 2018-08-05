package com.pack.pejectutil;

/**
 * 时间格式枚举
 * @author LiuJack
 *
 */
public enum DatePattern {
	/**
	 * yyyy-MM-dd
	 */
	YYYYMMDD("yyyy-MM-dd"),
	
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	YYYYMMDDHHMMSS("yyyy-MM-dd HH:mm:ss"),
	
	/**
	 * yyyy-MM
	 */
	YYYYMM("yyyy-MM"),
	
	/**
	 * yyyy年MM月dd日 HH:mm
	 */
	YYYY年MM月DD日HHMM("yyyy年MM月dd日 HH:mm")
	;
	
	private String value;
	
	private DatePattern(String value) {
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
}
