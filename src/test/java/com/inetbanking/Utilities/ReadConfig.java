package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;



public class ReadConfig {
	Properties props;
	public ReadConfig() {
		
	File src=new File("./Configuration/config.properties");
	  try {
		
		FileInputStream fis=new FileInputStream(src);
		props =new Properties();
		props.load(fis);
	}
	  catch(Exception e) {
		  System.out.println("Exception"+e.getMessage());
		
	}
	  }
	
	public String getApplcationUrl() {
		String url=props.getProperty("baseUrl");
		return url;
	}
	public String getUsername() {
		String uname=props.getProperty("uname");
		return uname;
						
	}
	public String getPassword() {
		String pwd=props.getProperty("pwd");
		return pwd;
	}
	public String getChromePath() {
		String chrome=props.getProperty("chrome");
		return chrome;
	}
	
}
