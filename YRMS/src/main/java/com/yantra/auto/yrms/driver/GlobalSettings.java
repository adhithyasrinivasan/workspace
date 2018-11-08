package com.yantra.auto.yrms.driver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.yantra.auto.yrms.driver.util.GenerateUniqueData;

public class GlobalSettings
{
	public final static String gecko_driver="gecko";
	public final static String chrome_driver="chrome";
	public final static String otp_label="otp_label";
	public final static String usernametextbox="username_text";
	public final static String username="uname";
	public final static String passwordtextbox="password_text";
	public final static String password="passwd";
	public final static String submit_button="submit_button";
	public final static String dailyvolume="daily_trans_volume";
	public final static String dailycount="daily_trans_count";
	private final static Properties properties = new Properties();
	public GlobalSettings()
	{
		try
		{
			properties.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
			properties.load(this.getClass().getClassLoader().getResourceAsStream("db_properties.properties"));
			properties.load(this.getClass().getClassLoader().getResourceAsStream("homepage_properties.properties"));
			properties.load(this.getClass().getClassLoader().getResourceAsStream("transactionDocument_properties.properties"));
			properties.load(this.getClass().getClassLoader().getResourceAsStream("userspage_properties.properties"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static String getProperty(String key)
	{
		String prop = properties.getProperty(key);
		return prop!=null?prop.trim():prop;
	}
}