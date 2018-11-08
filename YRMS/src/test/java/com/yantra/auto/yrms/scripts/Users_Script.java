package com.yantra.auto.yrms.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.yantra.auto.yrms.driver.AutomationBase;
import com.yantra.auto.yrms.driver.BaseClass;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.ui.pages.Homepage;
import com.yantra.auto.yrms.ui.pages.TransactionDocument;
import com.yantra.auto.yrms.ui.pages.Userspage;

public class Users_Script 
{
	public Homepage _home;
	public TransactionDocument _transactionDocument;
	public Userspage _users;
	public static WebDriverWait wait;
	GlobalSettings settings=new GlobalSettings();
	@BeforeClass
	public void setup()
	{
		AutomationBase.setup(AutomationBase.getBrowser());
		_home=PageFactory.initElements(AutomationBase.driver,Homepage.class);
		_users=PageFactory.initElements(AutomationBase.driver,Userspage.class);
		wait=new WebDriverWait(AutomationBase.driver, 5);
	}
	@Test(priority=0)
	public void navigateToUsersPage() throws Exception
	{
		_home.navigatetoUrl();
		_home.loginToRms();
		_home.clickAdminLink();
		_users.loginToUserPage();
	}
	@AfterClass
	public void tearDown()
	{
		AutomationBase.driver.quit();
	}
	
}
