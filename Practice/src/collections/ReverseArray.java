package collections;

public class ReverseArray {

	public static void main(String[] args) {
		int a[]={1,2,3,4,5,6};
		int start = 0;
		int end=a.length-1;
		while(start<end)
		{
			int tmp=a[start];
			a[start]=a[end];
			a[end]=tmp;
			start++;
			end--;
		}
		for(int a1:a)
		{
			System.out.println(a1);
		}
			
		
	}
}
