package firsttestngpackage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import firsttestngpackage.Test1;
public class Test2 {
public static void main(String args[]) throws FileNotFoundException, IOException
{
	Test1 prop=new Test1();
	String a = Test1.getProperty(Test1.testee);
	System.out.println(a);
}

}
