package com.inetbanking.testcases;


import java.util.logging.Logger;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() {
		driver.get(baseUrl);
	
		
		LoginPage lg=new LoginPage(driver);
		lg.setUserName(uname);
		lg.setPassword(pwd); 
		lg.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			Assert.assertTrue(true);
		
		}
		else  {
//			lg.AlertMethod();
//		System.out.println("Into Alert ");
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
		}
			
//		else{
//			Assert.assertTrue(false);
//			
//		}
	}	
	

}
