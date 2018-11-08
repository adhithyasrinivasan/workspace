package com.yantra.auto.yrms.scripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class TransactionDocument_Script //extends BaseClass
{
	public Homepage _home;
	public TransactionDocument _transactionDocument;
	public static WebDriverWait wait;
	GlobalSettings settings=new GlobalSettings();
	@BeforeMethod
	public void setup()
	{
		AutomationBase.setup(AutomationBase.getBrowser());
		_home=PageFactory.initElements(AutomationBase.driver,Homepage.class);
		_transactionDocument=PageFactory.initElements(AutomationBase.driver, TransactionDocument.class);
		wait=new WebDriverWait(AutomationBase.driver, 5);
	}
	@Test(priority=0,testName="NAVIGATE_TO_TRANSACTION_DOCUMENT")
	public void navigateToTransactionDocument() throws Exception
	{
		try {
		_home.navigatetoUrl();
		_home.loginToRms();
		_transactionDocument.loginToTransactionDocument();
		Thread.sleep(2000);
		_transactionDocument.getTransactionDocuments();
		}
		catch(InterruptedException ie )
		{
			
		}
	}
	@AfterMethod
	public void tearDown()
	{
		AutomationBase.driver.quit();
	}
	
}
