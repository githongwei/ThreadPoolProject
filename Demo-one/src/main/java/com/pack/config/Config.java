package com.pack.config;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Properties;


/**
 * 配置初始化
 * @author Jack
 *
 */
@Component("Config")
public class Config {

	/**参数初始化 */
	public void init() {
		try {
			Properties prop =  new  Properties();    
			InputStream in = this.getClass().getResourceAsStream("/config.properties");
			prop.load(in);    
			Const.Page.currentPage=Integer.parseInt(prop.getProperty("currentPage"));
			Const.Page.pageSize=Integer.parseInt(prop.getProperty("pageSize"));
			Const.RSA.modulus=prop.getProperty("modulus");
			Const.RSA.privateExponent=prop.getProperty("privateExponent");
			Const.RSA.publicExponent=prop.getProperty("publicExponent");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
