package com.yantra.auto.yrms.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.gargoylesoftware.htmlunit.javascript.host.media.presentation.PresentationConnection;
import com.yantra.auto.yrms.apirequest.RestTransaction;
import com.yantra.auto.yrms.driver.AutomationBase;
import com.yantra.auto.yrms.driver.CommonFunctions;
import com.yantra.auto.yrms.driver.GlobalKeys;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.driver.MongoDBConnector;

public class Homepage 
{
	GlobalSettings gs=new GlobalSettings();
	private final static String usernamefield=GlobalSettings.getProperty(GlobalSettings.usernametextbox);
	private final static String username=GlobalSettings.getProperty(GlobalSettings.username);
	private final static String passwordfield=GlobalSettings.getProperty(GlobalSettings.passwordtextbox);
	private final static String password=GlobalSettings.getProperty(GlobalSettings.password);
	private final static String submitbutton=GlobalSettings.getProperty(GlobalSettings.submit_button);
	private final static String dailyvolume=GlobalSettings.getProperty(GlobalSettings.dailyvolume);
	private final static String dailycount=GlobalSettings.getProperty(GlobalSettings.dailycount);
	private final static String adminLink=GlobalSettings.getProperty(GlobalKeys.adminLink);
	public By usernametext=By.id(usernamefield);
	public By passwordtext=By.id(passwordfield);
	public By submit=By.id(submitbutton);
	public By daily_volume=By.id(dailyvolume);
	public By daily_count=By.id(dailycount);
	public By admin_link=By.xpath(adminLink);
	final WebDriver _driver;
	private String url=AutomationBase.getYrmsUrl();
	WebDriverWait wait;
	public Homepage(final WebDriver driver)
	{
		this._driver=driver;
		wait=new WebDriverWait(this._driver, 10);
	}
	public void navigatetoUrl()
	{
		_driver.get(url);
	}
	public void loginToRms() throws InterruptedException
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(usernametext));
		CommonFunctions.populateTextField(_driver,usernametext,username);
		wait.until(ExpectedConditions.presenceOfElementLocated(passwordtext));
		CommonFunctions.populateTextField(_driver,passwordtext,password);
		wait.until(ExpectedConditions.presenceOfElementLocated(submit));
		CommonFunctions.clickField(_driver,submit);
		if(ExpectedConditions.presenceOfElementLocated(By.xpath(GlobalSettings.getProperty(GlobalSettings.otp_label))) != null)
		{
			navigatetoUrl();
		}
	}
	public void clickAdminLink() throws Exception
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(admin_link));
		CommonFunctions.clickField(_driver, admin_link);
	}
	public void checkTransVolume() throws Exception
	{
		Thread.sleep(1000);
		Assert.assertEquals(_driver.getCurrentUrl(),url+"/search/index");
		wait.until(ExpectedConditions.presenceOfElementLocated(daily_volume));
		String dailyvolume=CommonFunctions.getText(_driver, daily_volume);
		System.out.println("Daily transaction volume is : "+dailyvolume);
		RestTransaction.initiateYrmsTransaction();
		String dailycount=CommonFunctions.getText(_driver, daily_count);
		System.out.println(" ");
		System.out.println("Daily transaction count is : "+dailycount);
		
	}
}
