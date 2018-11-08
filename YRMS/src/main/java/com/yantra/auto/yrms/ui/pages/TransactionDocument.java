package com.yantra.auto.yrms.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yantra.auto.yrms.apirequest.RestRequest;
import com.yantra.auto.yrms.driver.BaseClass;
import com.yantra.auto.yrms.driver.CommonFunctions;
import com.yantra.auto.yrms.driver.GlobalKeys;
import com.yantra.auto.yrms.driver.GlobalSettings;

public class TransactionDocument 
{
	GlobalSettings gs=new GlobalSettings();
	public final static String transactionDocPage=GlobalSettings.getProperty(GlobalKeys.transactionDocumentPageLink);
	public By transactionDocPageLink=By.xpath(transactionDocPage);
	final WebDriver _driver;
	WebDriverWait wait;
	public TransactionDocument(final WebDriver driver)
	{
		this._driver=driver;
		wait=new WebDriverWait(_driver, 1000);
	}
	public void loginToTransactionDocument()
	{
		wait.until(ExpectedConditions.elementToBeClickable(transactionDocPageLink));
		CommonFunctions.clickField(_driver, transactionDocPageLink);
	}
	public void getTransactionDocuments() throws InterruptedException
	{
		String url=_driver.getCurrentUrl();
		String asset[]=url.split("#");
		String newUrl=asset[0]+"?format=&max=50&sort=id&order=desc";
		_driver.navigate().to(newUrl);
		String[] totalResult=CommonFunctions.getText(_driver, By.xpath("//div[@role='status']")).split(" ");
		System.out.println(totalResult[0]);
		List<WebElement> documentList=_driver.findElements(By.xpath(".//*[@id='list-transactionDocument']/table/tbody/tr"));
		//RestRequest.formRestRequest();
		for(int i=0;i<documentList.size();i++)
		{
			List<WebElement> documentEntry=documentList.get(i).findElements(By.tagName("td"));
			List<WebElement> columnText=documentEntry.get(3).findElements(By.tagName("p"));
			System.out.println(columnText.get(0).getText());
			if(columnText.get(0).getText().equalsIgnoreCase("100120840700000001001"))
			{
				int rowCount=i+1;
				By documentLink=By.xpath(".//*[@id='list-transactionDocument']/table/tbody/tr["+rowCount+"]/td[1]/a");
				WebElement transactionDocumentLink=CommonFunctions.findWebElement(_driver, documentLink);
				transactionDocumentLink.click();
				break;
			}
		}
		
	}
	

}
