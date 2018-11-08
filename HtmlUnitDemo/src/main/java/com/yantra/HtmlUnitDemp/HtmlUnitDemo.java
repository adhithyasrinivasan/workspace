package com.yantra.HtmlUnitDemp;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.warrenstrange.googleauth.GoogleAuthenticator;

public class HtmlUnitDemo 
{
	public static void main(String[] args) throws Exception 
	{
        WebDriver driver = new HtmlUnitDriver();
        //((HtmlUnitDriver) driver).setJavascriptEnabled(true);
        driver.get("https://dbupload.yantracard.com:8443/uploadapp/");
        WebElement element = driver.findElement(By.xpath("//input[@ng-model='username']"));	
        element.sendKeys("s.adhithya@finateltech.in");
        element = driver.findElement(By.xpath("//input[@ng-model='password']"));	
        element.sendKeys("YeO5XIAAhv7");
        element = driver.findElement(By.xpath("//input[@ng-model='totp']"));	
        element.sendKeys(Integer.toString(generateTotp()));
        driver.findElement(By.xpath("/html/body/div/div[1]/div/form/button")).click();
        WebDriverWait wait=new WebDriverWait(driver,15000);
        wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("/html/body/div/div[2]/button"),"Upload"));
        WebElement Webtable=driver.findElement(By.className("table.table-hover.table-bordered"));
        List<WebElement> TotalRowCount=Webtable.findElements(By.xpath("//tr[@ng-repeat='f in filess']"));
        for(WebElement rows:TotalRowCount)
        {
        	List<WebElement> TotalColumnCount=rows.findElements(By.xpath("td[1]"));
        	for(WebElement column:TotalColumnCount)
        	{
        		
        	}
        }
        
        driver.quit();			
	}
	public static void takeScreenshot(WebDriver _driver,String fileName) throws Exception 
    {
            /*File scrFile = ((TakesScreenshot)_driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("/home/adhithya/Desktop/"+fileName+".png"));*/
	}
	public static int generateTotp()
    {
    	GoogleAuthenticator gAuth = new GoogleAuthenticator();
    	int code = gAuth.getTotpPassword("OZQ4BLXDVBK2SH3N");
    	System.out.println(code);
    	return code;
    }
}
