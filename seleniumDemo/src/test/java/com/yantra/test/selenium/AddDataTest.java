package com.yantra.test.selenium;

import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import org.openqa.selenium.By.ById;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AddDataTest extends Base 
{
	@Test(priority=3)
	public void testAddInstitution() throws Exception
	{
		System.out.println("Entering into test 3");
		driver.findElement(By.xpath("/html/body/app-root/html/body/div[2]/div/div/app-institution-list/div[2]/div[1]/a")).click();
	}
	
	
}
