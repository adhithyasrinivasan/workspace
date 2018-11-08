package com.test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.*;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.driver.*;
public class login 
{
	
	protected static GetGlobalSettings gg=new GetGlobalSettings();
	//public static String BASEURL=GetGlobalSettings.getProperty(GetGlobalSettings.BASEURL);
	public static String BASEURL=GetGlobalSettings.getProperty(GetGlobalSettings.BASEURL);
	public final static String EMAILFIELDXPATH=GetGlobalSettings.getProperty(GetGlobalSettings.EMAILFIELD);
	public final static String PASSWORDFIELDXPATH=GetGlobalSettings.getProperty(GetGlobalSettings.PASSWDFIELD);
	public final static String SIGNINXPATH=GetGlobalSettings.getProperty(GetGlobalSettings.SIGNINFIELD);
	public final static String SIGNINERRORXPATH=GetGlobalSettings.getProperty(GetGlobalSettings.SIGNINERRORFIELD);
	public final static String USERNAMEXPATH=GetGlobalSettings.getProperty(GetGlobalSettings.USERNAMEXPATH);
	public By EMAILFIELD=By.xpath(EMAILFIELDXPATH);
	public By PASSFIELD=By.xpath(PASSWORDFIELDXPATH);
	public By SIGNINERRORFIELD=By.xpath(SIGNINERRORXPATH);
	public By SIGNINBUTTON=By.xpath(SIGNINXPATH);
	public By USERNAMEBUTTON=By.xpath(USERNAMEXPATH);
		//public By signInError
	WebDriver dv;
	public login(final WebDriver driver) 
	{
		dv = driver;
	}
	public void navigatetopageandwait()
	{
		dv.get(BASEURL+"/");
	}
	public void log() throws InterruptedException
	{
		dv.findElement(EMAILFIELD).sendKeys("adhithyasrinivasan@outlook.com");
		//dv.findElement(By.xpath(".//*[@id='i0118']")).sendKeys("test");
		dv.findElement(PASSFIELD).sendKeys("Adhithya12");
		Thread.sleep(5000);
		dv.findElement(SIGNINBUTTON).click();
		Thread.sleep(5000);
		//String ad=dv.findElement(By.cssSelector("span.o365cs-me-userDisplayName.o365cs-display-Block.o365cs-me-bidi.o365cs-segoeSemiLight")).getText();
		//System.out.println(ad);
	}
	public void editprofile() throws InterruptedException
	{
		dv.findElement(USERNAMEBUTTON).click();
		Thread.sleep(1500);
		dv.findElement(By.xpath(".//span[@aria-label='Edit profile']")).click();
		Thread.sleep(10000);
	}
	public boolean assertloginpage()
	{
		//return iselementpresent(dv,By.xpath(".//*[@id='CredentialsInputPane']/div[4]/div[2]/div/fieldset/div[1]/div/div/div/div[2]/div/div[2]/div"));
		return iselementpresent(dv,SIGNINBUTTON);
	}
	public String assertLoginErrorMessage(WebDriver driver, By by)
	{
		return dv.findElement(by).getText();
	}
	public boolean iselementpresent(WebDriver driver, By by)
	{
		try
		{
			dv.findElement(by);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
}
