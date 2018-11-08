package com.yantra.test.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.yantra.test.selenium.driver.CommonFunctions;

public class TestDataProvider extends Base 
{
	@Test(dataProvider="empLogin")
	public void loginwithData(String username,String password) throws InterruptedException
	{
		driver.get("http://172.17.0.7:8080/");
		CommonFunctions.sendKeys(driver, By.id("j_username"),username);
		CommonFunctions.sendKeys(driver, By.id("j_password"),password);
		CommonFunctions.click(driver, By.xpath("/html/body/app-root/html/body/div[1]/div/div/app-login/html/body/div/div/form/div/div[6]/button"));
		Thread.sleep(2000);
	}
	@DataProvider(name="empLogin")
	public Object[][] loginData() throws IOException 
	{
		Object[][] arrayObject = getExcelData("/home/adhithya/Desktop/test.xls","Sheet1");
		return arrayObject;
	}
	public Object[][] getExcelData(String fileName, String sheetName) throws IOException 
	{
		String[][] arrayExcelData = null;
		File file = new File(fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		workbook = new HSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum()
				- sheet.getFirstRowNum();
		List<List<String>> rowList = new ArrayList<List<String>>();
		for (int i = 1; i < rowCount + 1; i++) 
		{
			Row row = sheet.getRow(i);
			rowList.add(new ArrayList<String>());
			for (int j = 0; j < row.getLastCellNum(); j++) 
			{
				if(row.getCell(j)!=null)
					rowList.get(i-1).add(row.getCell(j).toString());
				else
					rowList.get(i-1).add(row.getCell(j,Row.CREATE_NULL_AS_BLANK).toString());
			}
		}
		Object[][] arrayData=new Object[rowList.size()][]; 
		workbook.close();
		for(int i=0;i<rowList.size();i++)
		{
			arrayData[i]=rowList.get(i).toArray();
			System.out.println(arrayData[i]);
		}
		return arrayData;
	}
}
