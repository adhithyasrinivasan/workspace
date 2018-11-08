package com.yantra.auto.yrms.driver;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.yantra.auto.yrms.ui.pages.Homepage;
import com.yantra.auto.yrms.ui.pages.TransactionDocument;
import com.yantra.auto.yrms.ui.pages.Userspage;

public class BaseClass //extends AutomationBase 
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
		_transactionDocument=PageFactory.initElements(AutomationBase.driver, TransactionDocument.class);
		_users=PageFactory.initElements(AutomationBase.driver, Userspage.class);
		wait=new WebDriverWait(AutomationBase.driver, 5);
	}
	@AfterClass
	public void tearDown()
	{
		AutomationBase.driver.quit();
	}
}
