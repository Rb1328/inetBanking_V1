package com.inetbanking.Utilities;


import java.awt.datatransfer.SystemFlavorMap;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class reporting extends TestListenerAdapter{
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext) {
		
		String timeStamp=new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
		System.out.println(timeStamp);
		String repName="rahul-.html";
		
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		
		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
			System.out.println("extent-config.xml FILE LOAD");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("extent-config.xml FILE NOT LOADED");
			e.printStackTrace();
		}
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name","localhost");
		extent.setSystemInfo("Enviroment", "QA");
		extent.setSystemInfo("USer", "Rahul");
		
		htmlReporter.config().setDocumentTitle("Extent Ex");
		htmlReporter.config().setReportName("Rahul");
		htmlReporter.config().setTheme(Theme.DARK);
		
	}
	
	public void onTestSuccess(ITestResult tr) {
		System.out.println("test success method running");
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		System.out.println("test success method PASSED");
		
	}
	public void onTestFailure(ITestResult tr) {
		System.out.println("test FAILD method running");
		logger=extent.createTest(tr.getName());
		System.out.println("onFailure test reporting ");
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		System.out.println("SC Added2");
		String screenShotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		File f=new File(screenShotPath);
		if(f.exists()) {
			try {
				logger.fail("Screenshot is below: "+logger.addScreenCaptureFromPath(screenShotPath));
				System.out.println("SCreen shot Added");
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}	
		}	
	}
	
	public void onTestSkipped(ITestResult tr) {
		System.out.println("test SKIPPED method running");
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	public void onFinish(ITestResult tr) {
		extent.flush();
	}
}
