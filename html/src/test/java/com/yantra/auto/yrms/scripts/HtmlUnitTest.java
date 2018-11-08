package com.yantra.auto.yrms.scripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class HtmlUnitTest 
{
	/*@Test
	public void homePage() throws Exception 
	{
	    try (final WebClient webClient = new WebClient()) 
	    {
	        final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
	        Assert.assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());
	        final String pageAsXml = page.asXml();
	        Assert.assertTrue(pageAsXml.contains("<body class=\"composite\">"));
	        final String pageAsText = page.asText();
	        Assert.assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
	    }
	}*/
	@Test
	public void test() throws Exception
	{
		WebClient webClient = new WebClient();
		HtmlPage page = webClient.getPage("http://localhost:8085");
	}
}
