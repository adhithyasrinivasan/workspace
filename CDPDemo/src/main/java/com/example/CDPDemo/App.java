package com.example.CDPDemo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.warrenstrange.googleauth.GoogleAuthenticator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, ClientProtocolException, IOException 
    {
    	//WebDriver driver;
    	System.setProperty("webdriver.chrome.driver", "/home/adhithya/pythonhead/chromedriver");
    	Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("download.default_directory", "/tmp/");
			prefs.put("download.prompt_for_download", false);
			prefs.put("download.directory_upgrade", true);
			prefs.put("safebrowsing.enabled", true);
			prefs.put("Browser.setDownloadBehavior", "allow");
		ChromeOptions options=new ChromeOptions();
			options.setHeadless(true);
			options.addArguments("--test-type");
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions"); 
		//driver = new ChromeDriver(options);
		ChromeDriverService driverService = ChromeDriverService.createDefaultService();
        ChromeDriver driver = new ChromeDriver(driverService, options);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		driver.get("https://dbupload.yantracard.com:8443/uploadapp/");
		driver.findElement(By.cssSelector("form.ng-invalid > div:nth-child(2) > input:nth-child(2)")).sendKeys("s.adhithya@finateltech.in");
		driver.findElement(By.cssSelector("div.form-group:nth-child(3) > input:nth-child(2)")).sendKeys("YeO5XIAAhv7");
		driver.findElement(By.cssSelector("form.ng-invalid > div:nth-child(4) > input:nth-child(2)")).sendKeys(Integer.toString(generateTotp()));
		driver.findElement(By.cssSelector("button.btn:nth-child(5)")).click();
		Thread.sleep(3000);
		 Map<String, Object> commandParams = new HashMap<>();
         commandParams.put("cmd", "Page.setDownloadBehavior");
         Map<String, String> params = new HashMap<>();
         params.put("behavior", "allow");
         params.put("downloadPath", "//home//adhithya//Desktop");
         commandParams.put("params", params);
         ObjectMapper objectMapper = new ObjectMapper();
         HttpClient httpClient = HttpClientBuilder.create().build();
         String command = objectMapper.writeValueAsString(commandParams);
         String u = driverService.getUrl().toString() + "/session/" + driver.getSessionId() + "/chromium/send_command";
         HttpPost request = new HttpPost(u);
         request.addHeader("content-type", "application/json");
         request.setEntity(new StringEntity(command));
         httpClient.execute(request);
         Thread.sleep(3000);
		List<WebElement> tableRows=driver.findElements(By.xpath("//table[@class='table table-hover table-bordered']/tbody/tr/td[1]"));
		
		/*for(int i=0;i<tableRows.size();i++)
		{
			System.out.println("I value"+i);
			System.out.println(tableRows.get(i).getText());
			System.out.println(i);
			if(tableRows.get(i).getText().equalsIgnoreCase("test.txt"))
			{
				String print =driver.findElement(By.xpath("//table[@class='table table-hover table-bordered']/tbody/tr["+i+"]/td[3]")).getText();
				System.out.println(print);
				System.out.println(i);
				break;
			}
		}*/
		for(WebElement row:tableRows)
		{
			System.out.println(row.getText());
			if(row.getText().equalsIgnoreCase("test.txt"))
			{
				row.findElement(By.xpath("../td/span")).click();
				break;
			}
		}
		Thread.sleep(3000);
		/*outerloop:
		for(WebElement row : tableRows)
		{	
			System.out.println(row.getText());
			List<WebElement> columns= row.findElements(By.cssSelector("tr.ng-scope:nth-child(3) > td:nth-child(1)"));
			for(WebElement column : columns)
				if(column.getAttribute("innerHTML")=="test.txt")
					System.out.println(column.getAttribute("innerHTML"));
					break outerloop;
		}*/
		driver.quit();
    }
    public static int generateTotp()
    {
    	GoogleAuthenticator gAuth = new GoogleAuthenticator();
    	int code = gAuth.getTotpPassword("OZQ4BLXDVBK2SH3N");
    	return code;
    }
    
}
