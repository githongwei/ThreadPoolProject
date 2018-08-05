package com.pack.pejectutil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类
 * @author Jack
 *
 */
public final class Tools{

	public static final boolean isNull(Object object){
		if (object==null) return true;
		if(object.toString().trim().equals(""))return true;
		return false;
	}

	public static final boolean isBigDecimal(Object object){
		if(Tools.isNull(object)) return false;
		try {
			new BigDecimal(object.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static final boolean notNull(Object object){
		if(object==null) return false;
		if(object.toString().equals(""))return false;
		return true;
	}

	public static final boolean notEmpty(String string){
		if(string==null) return false;
		if(string.equals(""))return false;
		return true;
	}

	public static final boolean isEmpty(String string){
		if(string==null) return true;
		if(string.trim().equals(""))return true;
		return false;
	}

	/**
	 * object数组集合转为map集合
	 * @param list 需要转换的集合对象
	 * @param nameMapper 名称映射数组
	 * @return 结果集合对象
	 */
	public static final List<Map<String, Object>> objArr2Map(List<Object[]> list,String... nameMapper){
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		if(list==null)return result;
		if(nameMapper==null||nameMapper.length==0)throw new RuntimeException("映射的名称不能为空");
		for (Object[] objects : list) {
			if(objects.length<nameMapper.length) throw new RuntimeException("映射名称与指定的数组不对应!");
			Map<String, Object> value = new HashMap<String,Object>();
			for(int i = 0;i<nameMapper.length;i++){
				value.put(nameMapper[i], objects[i]);
			}
			result.add(value);
		}
		return result;
	}

	/**
	 * 加密
	 * @param data 需要加密的字符
	 * @return 已加密的结果
	 * @throws Exception 
	 */
	public static final String rsaEncrypt(String data) throws Exception{
		return RSAUtils.encrypt(data);
	}

	/**
	 * 解密
	 * @param data 需要解密密的字符
	 * @return 已解密的结果
	 * @throws Exception 
	 */
	public static final String rsDdecode(String data) throws Exception{
		return RSAUtils.decrypt(data);
	}

	private static final String MD5_GO(String s) throws Exception {
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
		byte[] btInput = s.getBytes();
		MessageDigest mdInst = MessageDigest.getInstance("MD5");
		mdInst.update(btInput);
		byte[] md = mdInst.digest();
		int j = md.length;
		char str[] = new char[j * 2];
		int k = 0;
		for (int i = 0; i < j; i++) {
			byte byte0 = md[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(str);
	}
	
	private static final String MD5_GO(byte[] btInput) throws Exception {
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
		MessageDigest mdInst = MessageDigest.getInstance("MD5");
		mdInst.update(btInput);
		byte[] md = mdInst.digest();
		int j = md.length;
		char str[] = new char[j * 2];
		int k = 0;
		for (int i = 0; i < j; i++) {
			byte byte0 = md[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
		}
		return new String(str);
	}

	/**
	 * MD5加密
	 * @param s
	 * @param encry 加密基数
	 * @return
	 * @throws Exception 
	 */
	public static final String MD5(String str,String encry) throws Exception{
		StringBuffer stringBuffer = new StringBuffer(str);
		if (encry!=null) {
			stringBuffer.append(encry);
		}
		return MD5_GO(stringBuffer.toString());
	}

	/**
	 * MD5加密
	 * @param s
	 * @return
	 * @throws Exception 
	 */
	public static final String MD5(String str) throws Exception{
		StringBuffer stringBuffer = new StringBuffer(str);
		return MD5_GO(stringBuffer.toString());
	}
	
	/**
	 * MD5加密
	 * @param s
	 * @return
	 * @throws Exception 
	 */
	public static final String MD5(byte[] bs) throws Exception{
		return MD5_GO(bs);
	}

	public static final boolean isInteger(Object object){
		if(isNull(object)) return false;
		try {
			Integer.parseInt(object.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static final boolean isLong(Object object){
		if(isNull(object)) return false;
		try {
			Long.parseLong(object.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static final boolean isDouble(Object object){
		if(isNull(object)) return false;
		try {
			Double.parseDouble(object.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		//System.out.println(MD5("liujian","1314"));
		Object[] param = new Object[]{12,23,"234",345};
		String string = Arrays.deepToString(param);
		System.out.println(string);
	}


	/**
	 * 将byte数组转为对象
	 * @param bytes
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static final <T> T byteArrToObj(byte[] bytes){
		if(bytes==null) return null;
		ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			Object object = objectInputStream.readObject();
			if(objectInputStream!=null) objectInputStream.close();
			if(inputStream!=null) inputStream.close();
			return (T) object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	/**
	 * 时间转换函数,将时间格式的字符串转为util时间
	 * @param dateStr 时间格式的字符串
	 * @param pattern 字符串格式
	 * @return
	 */
	public static final Date strToUtilDate(String dateStr,DatePattern pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern.getValue());
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
	/**
	 * 时间转换函数,将时间格式的字符串转为util时间(格式为yyyy-MM-dd)
	 * @param dateStr 时间格式的字符串
	 * @return
	 */
	public static final Date strToUtilDate(String dateStr){
		SimpleDateFormat sdf = new SimpleDateFormat(DatePattern.YYYYMMDD.getValue());
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 将sql时间转为util时间
	 * @param date sql时间
	 * @return
	 */
	public static final Date sqlDate2UtilDate(java.sql.Date date){
		return new Date(date.getTime());
	}
	
	/**
	 * 将util时间转为sql时间
	 * @param date util时间
	 * @return
	 */
	public static final java.sql.Date utilDate2SqlDate(Date date){
		return new java.sql.Date(date.getTime());
	}

	/**
	 * 对象转为byte数组
	 * @param object
	 * @return
	 */
	public static final byte[] ObjToByteArr(Object object){
		if(object==null) return null;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(object);
			return outputStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Record> listObjArr2Record(List<Object[]> list,String... keys){
		if(list==null) return null;
		List<Record> records = new ArrayList<>();
		for (Object[] objects : list) {
			Record record = new Record();
			for (int i = 0; i < keys.length; i++) {
				record.put(keys[i], objects[i]);
			}
			records.add(record);
		}
		return records;
	}

	public static <T> List<T> listObjArr2Entity(List<Object[]> list,Class<T> clazz,String... keys){
		List<Record> records = listObjArr2Record(list, keys);
		Field[] fields = clazz.getDeclaredFields();
		List<T> ts = new ArrayList<>();
		for (Record record : records) {
			try {
				T t = clazz.newInstance();
				for (Field field : fields) {
					field.setAccessible(true);
					if(record.get(field.getName())!=null)
						field.set(t, record.get(field.getName()));
				}
				ts.add(t);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ts;
	}

	public static Date addDay(Date date, Integer day) {
		Date result = new Date(date.getTime()+day*24*60*60*1000);
		return result;
	}

	/**
	 * 
	 * @Title 检查两个时间是否为同一天
	 * @Desc 
	 * @param date1
	 * @param date2
	 * @return 
	 */
	@SuppressWarnings("deprecation")
	public static final boolean checkDateIsDay(Date date1,Date date2){
		return date1.getYear()==date2.getYear()
				&&date1.getMonth()==date2.getMonth()
				&&date1.getDate()==date2.getDate();
	}

	/**
	 * 
	 * @Title 检查是否等于其中一项
	 */
	public static boolean in(Object value,Object... objects) {
		if(value==null || objects==null)
			return false;
		for(Object obj : objects){
			if(value.equals(obj)) return true;
		}
		return false;
	}

	/**
	 * 时间转为字符串
	 * @Title 
	 * @Desc 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static final String date2String(Date date, DatePattern pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern.getValue());
		return format.format(date);
	}
	
	  /** 
     *校验手机号
     */  
    public static boolean checkPhone(String phone){  
    	if(Tools.isEmpty(phone))
    		return false;
        String regExp = "^[1][3,4,5,7,8][0-9]{9}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(phone);  
        return m.matches();  
    }  

}
