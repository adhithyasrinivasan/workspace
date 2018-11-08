package com.yantra.auto.yrms.scripts;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.yantra.auto.yrms.driver.AutomationBase;
import com.yantra.auto.yrms.driver.BaseClass;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.ui.pages.Homepage;

public class HomePage_Script extends BaseClass
{
	@Test(priority=0)
	public void testLoadUrl()
	{
		_home.navigatetoUrl();
	}
	@Test(priority=1)
	public void login() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
	}
	@Test(priority=2)
	public void totalTransactionData() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_home.checkTransVolume();
	}
}
