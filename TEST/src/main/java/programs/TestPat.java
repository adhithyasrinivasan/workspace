package programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestPat 
{
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		int a,b;
		String test="A";
		String res=null;
		int temp=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		a=Integer.parseInt(br.readLine());
		b=Integer.parseInt(br.readLine());
		int count=b;
		for(int i=0;i<a;i++)
		{
			if(count==0)
			{
				System.out.print(test);
			}
			else
			{
				for(int k=i;k<count;k++)
				{
					if(k==temp){
						res="B"+test;
						temp++;}
					else{
						if(temp>k)
							res="B"+test+test+"B";}
					
				}
				System.out.print(res);	
			}
			
		}
		
	}
}
