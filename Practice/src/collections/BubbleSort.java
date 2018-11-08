package collections;

public class BubbleSort {
	public static void main(String[] args) {
		int a[]={12,21,87,55,65,44,87};
		int tmp;
		System.out.println("Before sort : ");
		for(int i=0;i<a.length-1;i++)
		{
			System.out.println(a[i]);
		}
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=0;j<a.length-i-1;j++)
			{
				
			if(a[j]>a[j+1]){
				tmp=a[j];
				a[j]=a[j+1];
				a[j+1]=tmp;
			}
			}
		}
			
		System.out.println("after sort : ");
		for(int i=0;i<a.length-1;i++)
		{
			System.out.println(a[i]);
		}
		
	}

}
