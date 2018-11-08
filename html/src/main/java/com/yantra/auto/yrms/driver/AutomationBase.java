package com.yantra.auto.yrms.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AutomationBase 
{
	protected GlobalSettings globalSettings = new GlobalSettings();
	public static String browserName=null;
	public static WebDriver driver=null;
	private static String browser=null;
	private static String yrmsurl=null;
	private static String gecko_driver=GlobalSettings.getProperty(GlobalSettings.gecko_driver);
	private static String chrome_driver=GlobalSettings.getProperty(GlobalSettings.chrome_driver);
	public static void setup(final String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", gecko_driver);
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", chrome_driver);
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("html"))
		{
			//To be implemented
		}
		else if(browser.equalsIgnoreCase("safari"))
		{
			//To be implemented
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			//To be implemented
		}
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    browserName = cap.getBrowserName().toLowerCase();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.MILLISECONDS);
	}
	public static String getBrowser()
	{
		if(browser==null)
		{
				browser=GlobalSettings.getProperty("browser");
		}
		return browser;
	}
	public static String getYrmsUrl()
	{
		if(yrmsurl==null)
		{
			yrmsurl=GlobalSettings.getProperty("yrmsurl");
		}
		return yrmsurl;
	}
}
