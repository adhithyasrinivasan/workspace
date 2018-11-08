package com.yantra.test.selenium.driver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonFunctions {
	
	public static void click(final WebDriver driver, By by)
	{
		driver.findElement(by).click();
	}
	public static void sendKeys(final WebDriver driver, By by, String message)
	{
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(message);
	}
	public static String getText(final WebDriver driver, By by)
	{
		return driver.findElement(by).getText();
	}
	public static void selectByIndex(final WebDriver driver,By by,int index)
	{
		WebElement element = driver.findElement(by);
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public static void selectByValue(final WebDriver driver,By by,String value)
	{
		WebElement element = driver.findElement(by);
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public static void selectByVisibleText(final WebDriver driver,By by,String text)
	{
		WebElement element = driver.findElement(by);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public static String getAttribute(final WebDriver driver,By by,String key)
	{
		return driver.findElement(by).getAttribute(key);
	}
	public static String getAttributeFromElement(final WebElement element,String key)
	{
		return element.getAttribute(key);
	}
	public static List<WebElement> getAllElements(final WebDriver driver,By by)
	{
		return driver.findElements(by);
	}
}
