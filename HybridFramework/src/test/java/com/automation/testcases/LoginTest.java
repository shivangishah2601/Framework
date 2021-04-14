package com.automation.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;

public class LoginTest extends BaseClass {
	
	
	@Test
	public void appLogin()
	{	
		logger = report.createTest("Login to Attendance Portal");
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Application started");
		
		loginpage.login(excel.getStringData("Login", 1, 0), excel.getStringData("Login", 1, 1));
		
		logger.pass("Login successful");
		
	}
	
	
}
 