package com.yantra.auto.yrms.apirequest;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.remote.internal.ApacheHttpClient;

import com.yantra.auto.yrms.driver.GlobalSettings;

public class RestService 
{
	public RestService(){	GlobalSettings gs=new GlobalSettings();	}
	private static CloseableHttpClient client;
	private static HttpPost postRequest;
	private static CloseableHttpResponse response;
	private static HttpEntity entity;
	private static InputStream content;
    public static void postYrmsRequest(String json) throws ClientProtocolException, IOException
    {
      	client=HttpClients.createDefault();
      	postRequest=new HttpPost(GlobalSettings.getProperty("yrmsurl")+File.separator+GlobalSettings.getProperty("apipath"));
      	//postRequest=new HttpPost("http://localhost:8040/YRMS/rest/transaction/riskScore");
       	postRequest.setEntity(new StringEntity(json));
      	response = client.execute(postRequest);
		entity = response.getEntity();
		content = entity.getContent();
		response.close();
		System.out.println(response.getStatusLine());
	}
//    public static void main(String args[]) throws ClientProtocolException, IOException
//    {
//    	GlobalSettings gs=new GlobalSettings();
//    	
//    	RestService.postYrmsRequest("");
//    }
}
