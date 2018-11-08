package firsttestngpackage;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTestNGFile {
  @Test
  public void f() {
	  
	  // Create a new instance of the Firefox driver
	  WebDriver driver = new FirefoxDriver();
	  //  Wait For Page To Load
	  // Put a Implicit wait, this means that any search for elements on the page
	  //could take the time the implicit wait is set for before throwing exception 
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  // Navigate to URL
	  driver.get("https://mail.google.com/");
	  // Maximize the window.
	  driver.manage().window().maximize();
	  // Enter UserName
	  driver.findElement(By.id("Email")).sendKeys(" adhithyasrinivasan@gmail.com");
	  // Enter Password
	  driver.findElement(By.id("next")).click();
	  driver.findElement(By.id("Passwd")).sendKeys("adhithya1234srinivasan");
	  // Wait For Page To Load
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  // Click on 'Sign In' button
	  driver.findElement(By.id("signIn")).click();
	  //Click on Compose Mail.
	 // driver.findElement(By.xpath("//div[@class='z0']/div")).click();
	  // Click on the image icon present in the top right navigational Bar
	  driver.findElement(By.cssSelector("span.gb_2a.gbii")).click();
	  // driver.findElement(By.xpath("//div[@class='gb_Ea gb_oe gb_ve gb_qb']/div/a")).click();
	  //Click on 'Logout' Button
	  driver.findElement(By.xpath("//*[@id='gb_71']")).click();
	  //Close the browser.
	  driver.close();
	  }

  }

