package com.testcase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.TestNG;

import com.driver.GetGlobalSettings;
import com.test.*;
import org.testng.annotations.Listeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.lang.*;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class loginTest //extends Automation_base
{
	protected static WebDriver _driver;
	final FirefoxProfile firefoxProfile = new FirefoxProfile();
    //firefoxProfile.setPreference("xpinstall.signatures.required", false);
    login lg;
    @BeforeMethod
	@Parameters("browser")
	public void setup(String browser) throws Exception
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			_driver = new FirefoxDriver(firefoxProfile);
			lg=PageFactory.initElements(_driver, login.class);
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("test failed as no browser is specified");
		}
	}
    @Test(testName="NAVIGATE_TO_URL_YES",enabled=false,priority=0)
	public void logintestcase() 
	{
		try
		{
			lg.navigatetopageandwait();
			Assert.assertEquals(true,lg.assertloginpage());
		}
		catch(AssertionError e)
		{
			System.out.println(e);
		}
	}
	@Test(testName="SIGN_IN_YES",priority=1)
	public void signin() throws Exception 
	{
		lg.navigatetopageandwait();
		lg.log();
		//AssertJUnit.assertEquals("Please enter your phone number or your email address in the format someone@example.com.", lg.assertLoginErrorMessage(_driver, By.xpath(".//*[@id='usernameError']")));
		//AssertJUnit.assertEquals(GetGlobalSettings.getProperty(GetGlobalSettings.SIGNINERROR), lg.assertLoginErrorMessage(_driver, lg.SIGNINERRORFIELD));//By.xpath(".//*[@id='usernameError']")));
		_driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
	}
	@Test(priority=2)
	public void editProfile() throws InterruptedException
	{
		lg.navigatetopageandwait();
		lg.log();
		lg.editprofile();
	}
	@AfterMethod
	public void tearDown()
	{
		_driver.quit();
	}
}