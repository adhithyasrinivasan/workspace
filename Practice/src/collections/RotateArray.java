package collections;

public class RotateArray {

	public static void main(String[] args) {
		int a[]={1,2,3,4,5,6};
		for(int j=0;j<a.length;j++)
		{
		for(int i=0;i<a.length-1;i++)
		{
			int tmp=a[i];
			a[i]=a[i+1];
			a[i+1]=tmp;
		}
		System.out.println("After "+j+" iteration");
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}}
		
	}
	
}
