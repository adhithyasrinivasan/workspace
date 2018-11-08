package com.yantra.test.selenium;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
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
import com.yantra.test.selenium.driver.*;

public class BaseTest extends Base 
{
	@Test(priority=0)
	public void testLoadPage()
	{
		driver.get("http://172.17.0.7:8080/");
		AssertJUnit.assertEquals(driver.getCurrentUrl().split("#")[1], "/login");
	}
	@SuppressWarnings("deprecation")
	@Test(priority=1)
	public void testLogin()
	{
		System.out.println("Entering into test1");
		CommonFunctions.sendKeys(driver, By.id("j_username"),"admin@yantra.com");
		CommonFunctions.sendKeys(driver, By.id("j_password"),"Test@123");
		CommonFunctions.click(driver, By.xpath("/html/body/app-root/html/body/div[1]/div/div/app-login/html/body/div/div/form/div/div[6]/button"));
		//wait.until(ExpectedConditions.textToBePresentInElement(By.cssSelector("div.logoutbtn:nth-child(2) > div:nth-child(1) > a:nth-child(1)"), "Change Password"));
	}
	@Test(priority=2)
	public void testNavigateToInstitutionPage() throws Exception
	{
		List<WebElement> menuListElements = CommonFunctions.getAllElements(driver, By.cssSelector("mat-list.mat-list>mat-list-item"));
		if(menuListElements.size()>=2)
		{
			for(WebElement element : menuListElements)
			{
				WebElement menuName = element.findElement(By.xpath("div[@class='mat-list-item-content']/a"));
				if(CommonFunctions.getAttributeFromElement(menuName, "innerText").equalsIgnoreCase("Institution"))
				{
					menuName.click();
				}
			}
		}
	}
}
