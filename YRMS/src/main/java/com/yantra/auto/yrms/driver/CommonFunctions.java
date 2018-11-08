package com.yantra.auto.yrms.driver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonFunctions 
{
	public static void clickField(final WebDriver driver,By by)
	{
		driver.findElement(by).click();
	}
	public static void populateTextField(final WebDriver driver,By by,String string)
	{
		driver.findElement(by).sendKeys(Keys.HOME+string);
	}
	public static String getText(final WebDriver driver,By by)
	{
		String text=driver.findElement(by).getText();
		return text;
	}
	public static WebElement findWebElement(final WebDriver driver,By by)
	{
		return driver.findElement(by);
	}
	public static List<WebElement> findWebElements(final WebDriver driver,By by)
	{
		return driver.findElements(by);
	}
	public static List<WebElement> findWebElements(final WebDriver driver,List<WebElement> listElement,By by,int i)
	{
		return listElement.get(i).findElements(by);
	}
	
}
