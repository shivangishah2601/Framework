 package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() throws IOException
	{
		
		File src = new File("./config/Config.properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		}
		catch(Exception e)
		{
			System.out.print("Unable to read config file" + e.getMessage());
		}
		
	}
	
	public String getDataFromConfig(String dataKey)
	{
		return pro.getProperty(dataKey);
	}
	
	public String getBrowser( )
	{
		return pro.getProperty("Browser");
	}
	
	public String getURL()
	{
		return pro.getProperty("TestURL");
	}

}
