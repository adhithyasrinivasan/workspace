package com.driver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
public class Annotationtransform implements IAnnotationTransformer 
{
	Properties props = new Properties();
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) 
	{
		try 
		{
			props.load(new FileInputStream("testcaserunmode/testcase_runmode.properties"));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		if (props.values().contains(annotation.getTestName())) 
		{
			annotation.setEnabled(true);
		}
	}
}