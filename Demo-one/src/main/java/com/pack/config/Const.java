package com.pack.config;

/**
 * 参数配置常量类
 * @author Jack
 *
 */
public class Const {

	/**
	 * Redis配置相关
	 * @author liuJack
	 *
	 */
	public static final class Redis{
		
		/**登录超时时间 毫秒*/
		public static final long login_dated = 1000*60*60*10;

	}

	public static final class Page{

		/**默认页大小*/
		public static Integer pageSize;

		/**默认当前页*/
		public static Integer currentPage;
	}

	public static final class RSA{

		/**系数*/
		public static String modulus;
		
		/**公钥指数*/
		public static String publicExponent;
		
		/**私钥指数*/
		public static String privateExponent;

	}
	
	public static final class ServletConfig{
		/**作用域中,登录后保存用户的名称*/
		public static final String SessionUser = "session_user";
	}
	
	/**
	 * 短信配置
	 * @author Jack
	 *
	 */
	public static final class SMS {
		
		//企业ID
		public static final Integer ID = 9759;
		//密码
		public static final String PASSWORD = "";
		//企业名称
		public static final String ACCOUNT = "";
		
		// 请求地址
		public static final String URL = "http://121.43.192.197:8888/sms.aspx"; 
		
		/**验证码失效时间*/
		public static final long code_dated = 1000*60*60;
		
	}
	
	/**
	 * redis缓存相关
	 * @author Jack
	 *
	 */
	public static final class Application {
		
		/**地址字典数据*/
		public static final String ADDRESS_DIC = "ADDRESS_DIC";
		
		/**工作类型字典数据*/
		public static final String JOB_TYPE_DIC = "JOB_TYPE_DIC";
		
		/**0元购类型字典数据*/
		public static final String ZERO_BUY_TYPE_DIC = "ZERO_BUY_TYPE_DIC";

		/**结算方式字典数据*/
		public static final String PAYMENTS_TYPE = "PAYMENTS_TYPE";
		
		/**薪资范围字典数据*/
		public static final String JOB_MONEY_DIC = "JOB_MONEY_DIC";
		
		/**福利信息字典数据*/
		public static final String JOB_WELFARE_DIC = "JOB_WELFARE_DIC";

	}
	
	/**
	 * 文件上传,下载相关
	 * @author Jack
	 *
	 */
	public static final class FTP{
		
		/**文件获取地址--linux*/
		public static final String FILE_DOWN_URL = "http://127.0.0.1/static_images/";
		
		/**ftp服务器地址*/
		public static final String FTP_IP = "127.0.0.1";
		
		/**登录账号*/
		public static final String FTP_USER_NAME = "ftp";
		
		/**端口号*/
		public static final int FTP_PROT = 21;
		
		/**登录密码*/
		public static final String FTP_USER_PASSWORD = "";
		
	}
	
	/**
	 * 当前发布模式
	 */
	public static final boolean IS_TEST = true;
	
	/**
	 * 用户默认密码
	 */
	public static final String USER_DEFAULT_PWD = "123456";
	
	/**
	 * 是否初始化字典
	 */
	public static final boolean isInitCache = false;
	
	/**
	 * 默认查询城市id
	 */
	public static final int Default_Addr_id = 273;
	
}
