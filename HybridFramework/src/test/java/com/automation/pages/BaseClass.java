package com.automation.pages;

import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ConfigDataProvider;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {

	public WebDriver driver; 
	public ExtentReports report;
	public ExtentHtmlReporter extent;
	public ExtentTest logger ;
	public ExcelDataProvider excel;
	public ConfigDataProvider pro;
	
	@BeforeSuite
	public void setupSuite()
	{
		Reporter.log("Setting up reports and test is getting ready",true);
		try
		{
			excel = new ExcelDataProvider();
			pro = new ConfigDataProvider();
//			extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/reports/AttendancePortal_" + Helper.getCurrentDateTime() + ".html"));
			extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/reports/AttendancePortal.html"));
			report = new ExtentReports();
			report.attachReporter(extent);
			
			Reporter.log("Configuration done and test is ready to start",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

	}
	
	@Parameters({"browser","appURL"})
	@BeforeClass
	public void setup(String browser, String appURL)
	{
		Reporter.log("Trying to initialize and start the browser",true);
		
//		driver = BrowserFactory.startApplication(driver, pro.getBrowser(), pro.getURL());
		
		driver = BrowserFactory.startApplication(driver, browser, appURL);
		
		Reporter.log("Browser and application is up and running",true);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to end",true);
		
		if(result.getStatus() == ITestResult.FAILURE)
		{
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			logger.skip("Test skipped ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		report.flush();
		
		Reporter.log("Test completed and reports generated",true);
	}
	

	@AfterClass
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}
	
}
