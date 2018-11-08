package firsttestngpackage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Test1 {
private static Properties test=new Properties();
public final static String rest="config/test.properties";
public final static String ADHITHYA="adhithya";
public final static String testee="TESTING";

public Test1() throws FileNotFoundException, IOException
{
	test.load(new FileInputStream(rest));
}
public static String getProperty(String key)
{
String property = test.getProperty(key);
	//String property = Global_Settings.getProperty(key);
	return property != null ? property.trim() : property;
}

public static void main(String args[]) throws IOException
{
	Test1 a=new Test1();
	final String abb= a.getProperty(testee);
	System.out.println(abb);
}
	

}
