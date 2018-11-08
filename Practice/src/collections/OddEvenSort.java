package collections;

public class OddEvenSort {
	static int tmp;
	static int a[]={12,55,14,11,65,98,54,4};
public static void main(String[] args) {
	
	
	boolean res=false;
	while(!res)
	{
		res=true;
		for(int i=1;i<a.length-1;i+=2)
		{
			if(a[i]>a[i+1])
			{
				swap(i, i+1,a);
				res=false;
			}
		}
		
	}
	for(int i = 0; i < a.length-1; i += 2)
    {
      if(a[i] > a[i+1])
      {
        swap(i, i+1,a);
        res = false;
      }
    }
	System.out.println("After");
	for(int i=0;i<a.length-1;i++)
	{
		System.out.println(a[i]);
	}
}
public static void swap(int i,int j, int a[])
{
	tmp=a[i];
	a[i]=a[i+1];
	a[i+1]=tmp;
}
}
