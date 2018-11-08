package com.yantra.auto.yrms.driver.util;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil 
{
	public static DateFormat dateFormatter;
	public static String getCurrentDateTime(String dateFormat)
	{
		dateFormatter = new SimpleDateFormat(dateFormat);
		Calendar date=Calendar.getInstance();
		return dateFormatter.format(date.getTime());
	}
	public static Long getCurrentMilliTime()
	{
		dateFormatter = new SimpleDateFormat();
		Calendar date=Calendar.getInstance();
		return date.getTimeInMillis();
	}
	
}
