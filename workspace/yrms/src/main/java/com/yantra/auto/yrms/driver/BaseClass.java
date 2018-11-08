package com.yantra.auto.yrms.driver;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.yantra.auto.yrms.apirequest.RMSRequest;
import com.yantra.auto.yrms.ui.pages.Homepage;
import com.yantra.auto.yrms.ui.pages.RulesPage;
import com.yantra.auto.yrms.ui.pages.TransactionDocument;
import com.yantra.auto.yrms.ui.pages.Userspage;

public class BaseClass //extends AutomationBase 
{
	public Homepage _home;
	public TransactionDocument _transactionDocument;
	public Userspage _users;
	public RulesPage _rulesPage;
	public static WebDriverWait wait;
	GlobalSettings settings=new GlobalSettings();
	@BeforeMethod
	public void setup()
	{
		AutomationBase.setup(AutomationBase.getBrowser());
		MongoDBConnector.connectMongoDb();
		try 
		{
			InputData.loadInputData();
			RMSRequest.loadData();
		} 
		catch (IOException e) 
		{
			System.out.println("Error Loading Input File");
			e.printStackTrace();
		}
		_home=PageFactory.initElements(AutomationBase.driver,Homepage.class);
		_transactionDocument=PageFactory.initElements(AutomationBase.driver, TransactionDocument.class);
		_users=PageFactory.initElements(AutomationBase.driver, Userspage.class);
		_rulesPage=PageFactory.initElements(AutomationBase.driver, RulesPage.class);
		wait=new WebDriverWait(AutomationBase.driver, 15);
	}
	@AfterMethod
	public void tearDown()
	{
		AutomationBase.driver.quit();
	}
}
