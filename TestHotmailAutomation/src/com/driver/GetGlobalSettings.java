package com.driver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import org.testng.Assert;

public class GetGlobalSettings
{
public static Properties GlobalSettings = new Properties();
public final static String BASEURL="baseurl";
public final static String EMAILFIELD="emailfield";
public final static String PASSWDFIELD="passfield";
public final static String SIGNINFIELD="signInButton";
public final static String SIGNINERRORFIELD="signInErrorXpath";
public final static String SIGNINERROR="signInErrorText";
public final static String USERNAMEXPATH="userNameXpath";

public final static  String GLOBALSETTINGS= "config/global_settings.properties";
//create a property method
//load the property method with property files.
public GetGlobalSettings() 
{
	try
	{
		GlobalSettings.load(new FileInputStream(GLOBALSETTINGS));	
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
}
//get the property
public static String getProperty(String key)
{
	String property=GlobalSettings.getProperty(key);
	return property != null?property.trim():property;
}
public static void main(String args[]) throws IOException
{
	GetGlobalSettings gs=new GetGlobalSettings();
}
}
