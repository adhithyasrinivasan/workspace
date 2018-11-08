package com.yantra.auto.yrms.driver;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class BaseClass //extends AutomationBase 
{
	public static WebDriverWait wait;
	GlobalSettings settings=new GlobalSettings();
	@BeforeSuite
	public void setup()
	{
		AutomationBase.setup(AutomationBase.getBrowser());
		wait=new WebDriverWait(AutomationBase.driver, 5);
	}
	@AfterSuite
	public void tearDown()
	{
		AutomationBase.driver.quit();
	}
}
