package com.yantra.auto.yrms.apirequest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.yantra.auto.yrms.driver.GlobalSettings;

public class RestTransaction 
{
	public static void initiateYrmsTransaction()
	{
		RestService service=new RestService();
		try 
		{
			RestService.postYrmsRequest(null);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.print("Error occured while initiating the yrms transaction. The cause is "+e.getCause());
		} 
	}
}
