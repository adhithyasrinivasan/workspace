package programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci  
{	
	public static void main(String args[])
	{
		int a=0,b=1,c=0,n=10;
		for(int i=0;i<n;i++)
		{
			a=b;
			b=c;
			c=a+b;
			System.out.println(c);

		}
	}
	
}

