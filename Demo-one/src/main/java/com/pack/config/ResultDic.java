package com.pack.config;

/**
 * 错误代码字典
 * @author Jack
 *
 */
public enum ResultDic {

	/**请求成功*/
	SUCCESS(0,"请求成功"),
	
	/**数据传输有误*/
	DATA_WRONG(-100,"数据传输有误"),
	
	/**未登录*/
	NOT_LOGIN(-1,"登录已过期"),
	
	/**系统错误*/
	SYS_ERROR(-500,"系统错误"), LOGIN_TIME_OUT(-11,"登录已经过期,请重新登录");
	
	private Integer code;
	
	private String msg;
	
	ResultDic(Integer code,String msg){
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
