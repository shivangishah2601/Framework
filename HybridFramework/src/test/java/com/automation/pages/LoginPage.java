package com.automation.pages;

import org.openqa.selenium.WebDriver;

import com.automation.constants.LoginPageCont;

public class LoginPage extends LoginPageCont{
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	public void login(String appUsername, String appPassword)
	{
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			
			e.printStackTrace();
		}
		uname.sendKeys(appUsername);
		pwd.sendKeys(appPassword);
	}
	
}
