package com.inetbanking.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
	    ldriver=rdriver;
	    PageFactory.initElements(rdriver,this);
	}
	public void AlertMethod() {
		 Alert alert = ldriver.switchTo().alert();
		 alert.accept();
		
	}
	
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	
	public void setUserName(String uname) {
		System.out.println("Be");
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		System.out.println("Be");
		txtPassword.sendKeys(pwd);
		System.out.println("Af");	 
	}
	
	
	
	
	public void clickSubmit() {
		System.out.println("Be");
		btnLogin.click();
		System.out.println("Af");
	}
	
	

}
