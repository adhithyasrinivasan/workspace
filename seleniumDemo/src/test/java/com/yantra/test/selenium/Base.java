package com.yantra.test.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Base {
	public static WebDriver driver;
	public WebDriverWait wait;
	@BeforeSuite
	public void setup()
	{
		System.out.println("Entering into beforesuite in base");
		System.setProperty("webdriver.chrome.driver","/home/adhithya/workspace/yrms/config/webdrivers/chrome");
		ChromeOptions options=new ChromeOptions();
		options.setBinary("/usr/bin/google-chrome");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		wait=new WebDriverWait(driver, 2);
	}
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
}
