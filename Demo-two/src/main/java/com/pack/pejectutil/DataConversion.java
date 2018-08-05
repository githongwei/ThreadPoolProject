package com.pack.pejectutil;
 /**
  * 时间转换
  *<p>@Title:DataConversion</p>
  *<p>@Description:</p>
  * @author:zhaohongwei
  * @date:2018年1月3日下午2:21:37
  * @version 1.0
  */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DataConversion {
	
	/**
	 * 字符串转时间类型
	 *<p>@Title:StringForData</p>
	 *<p>@Description:</p>
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static Date StringForData(String data)throws Exception{
		String t = data;
		String t1 = t.replaceFirst("年","-");
		String t2 = t1.replaceAll("月", "-");
		String t3 = t2.replaceAll("日", "-");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(t3);
	}
	
	
	public static void main(String[] args) throws ParseException {
		//	2013年3月1日(String)    2013-3-1(data)
		SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
		String t = "2013年3月1日";
		String t1 = t.replaceFirst("年","-");
		String t2 = t1.replaceAll("月", "-");
		String t3 = t2.replaceAll("号", "-");
		System.out.println(format.parse(t3));
	}
}
