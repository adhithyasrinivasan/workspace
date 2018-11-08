package extra;

public class ArraySort {

	public static void main (String args[])
	{
		int a[]={52,51,23,16,21};
		for(int i=0;i<a.length;i++)
		{System.out.println("iteration i "+i);
			for(int j=0;j<a.length-1;j++)
			{
				//System.out.println("iteration j "+j);
				if(a[j]>a[i])
				{
					System.out.println("before a[j] "+a[j]+" a[i] "+a[i]);
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
					//System.out.println("after a[j] "+a[j]+" a[i] "+a[i]);
				}
			}
			/*for(int k=0;i<a.length;i++)
			{
				System.out.println(a[i]);
			}*/
		}
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
	}
	
}
