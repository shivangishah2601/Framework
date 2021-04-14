package com.automation.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String captureScreenshots(WebDriver driver)
	{
		String screenshotPath = null;
		try
		{
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			screenshotPath = System.getProperty("user.dir")+"/screenshots/AttendancePortal_"+getCurrentDateTime()+ ".png";
			FileHandler.copy(src,new File(screenshotPath));
			System.out.println("Screenshot captured");
		}
		catch(Exception e)
		{
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
		
		return screenshotPath;
		
	}  
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_SS");
		Date currentDt = new Date();
		return customFormat.format(currentDt);
	}
	
	public void handleFrames()
	{
		
	}
	
	public void handleAlerts() 
	{
		
	}
	
	public void handleMultipleWindows()
	{
		
	}

}
