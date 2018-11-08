package com.yantra.auto.yrms.scripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.yantra.auto.yrms.driver.AutomationBase;
import com.yantra.auto.yrms.driver.BaseClass;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.ui.pages.Homepage;
import com.yantra.auto.yrms.ui.pages.TransactionDocument;
import com.yantra.auto.yrms.ui.pages.Userspage;

public class HomePage_Script //extends BaseClass
{
	public Homepage _home;
	public static WebDriverWait wait;
	GlobalSettings settings=new GlobalSettings();
	@BeforeMethod
	public void setup()
	{
		AutomationBase.setup(AutomationBase.getBrowser());
		_home=PageFactory.initElements(AutomationBase.driver,Homepage.class);
		wait=new WebDriverWait(AutomationBase.driver, 15);
	}
	@Test(priority=0, testName="LOAD_RMS_URL_YES")
	public void testLoadUrl()
	{
		_home.navigatetoUrl();
	}
	@Test(priority=1, testName="LOGIN_TO_RMS_YES")
	public void login() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
	}
	@Test(priority=2, testName="CHECK_TOTAL_TRANSACTION_DATA_YES")
	public void totalTransactionData() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_home.checkTransVolume();
	}
	@AfterMethod
	public void tearDown()
	{
		AutomationBase.driver.quit();
	}
}
