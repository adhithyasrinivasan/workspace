package collections;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class TestString {
	
	public static void main(String[] args) 
	{
		char a[]="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		
			String t="";
			Set ttt=new HashSet();
			Calendar cal = Calendar.getInstance();
			long startTime = cal.getTimeInMillis();
			for(int i=0;i<a.length;i++)
			{
				StringBuilder tt= new StringBuilder();
				for(int j=0;j<a.length;j++)
				{
					for(int k=0;k<a.length;k++)
					{
						for(int l=0;l<a.length;l++)
						{
							for(int m=0;m<a.length;m++)
							{
								if(i==j || i==k || i==l || i==m || j==k || j==l || j==m || l==m)
								{
									t=t+a[i]+a[j]+a[k]+a[l]+a[m];
									//System.out.println(tt);
									ttt.add(t);
									t="";
								}
							}
						}
					}
				}
			}
				Calendar cal1 = Calendar.getInstance();
			long endTime=cal1.getTimeInMillis();
			System.out.println("Start "+startTime);
			System.out.println("End "+endTime);
			System.out.println("Total "+(endTime-startTime));
		System.out.println(ttt.size());	
		
		
		
	}

}
