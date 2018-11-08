package com.yantra.auto.yrms.apirequest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yantra.auto.yrms.data.YrmsRiskResult;
import com.yantra.auto.yrms.driver.GlobalSettings;
import com.yantra.auto.yrms.driver.InputData;

public class RestTransaction 
{
	public static void initiateYrmsTransaction() throws ClientProtocolException, IOException, UnsupportedOperationException
	{
		RestService service=new RestService();
		//try 
		//{
			RMSRequest.formRequest();
			RestService.postYrmsRequest(RMSRequest.formRequest());
			String isApi=GlobalSettings.getProperty("isApi");
			if(isApi.equalsIgnoreCase("true"))
			{
				RestService.callOfacApi(YrmsRiskResult.getTransactionNumber());	
			}
			
		//} 
		//catch (Exception e) 
		//{
			// TODO Auto-generated catch block
			//System.out.print("Error occured while initiating the yrms transaction. The cause is "+e.getCause());
		//} 
	}
	public static void main(String args[]) throws Exception
	{
		InputData.loadInputData();
		GlobalSettings gs = new GlobalSettings();
		initiateYrmsTransaction();
	}
}
