package com.inetbanking.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import com.inetbanking.Utilities.ReadConfig;

public class BaseClass {
	ReadConfig rc=new ReadConfig();
	String baseUrl=rc.getApplcationUrl();
	String uname=rc.getUsername();
	String pwd=rc.getPassword();
	WebDriver driver;
	

	@BeforeClass
	public void setup() {
//		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	
		System.setProperty("webdriver.chrome.driver",rc.getChromePath());

		driver=new ChromeDriver();
		System.out.println(baseUrl);

//		Logger logger=Logger.getLogger("ebanking");
//		PropertyConfigurator.configure("Log4j.properties");
		
		
	}

	public void tearDown() {
		driver.quit();
		
	}
	
}
