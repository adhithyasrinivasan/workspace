package firsttestngpackage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestGlobal {
public static Properties gg=new Properties();
public final static String test ="config/test.properties";
public final static String ADHITHYA="adhithya"; 

public TestGlobal() throws FileNotFoundException,IOException 
{
	gg.load(new FileInputStream(test));
}
public final static String getGlobal(String key)
{
	String prp=gg.getProperty(key);
	return prp !=null?prp.trim():prp;
}
public static void main(String args[]) throws IOException
{
	TestGlobal ee=new TestGlobal();
	final String a= ee.getGlobal(ADHITHYA);
	System.out.println(a);
}
}
