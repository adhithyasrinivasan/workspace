package collections;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		System.out.println("Enter number of elements in array");
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		int a[] = new int[n];
		System.out.println("Enter the elements of the array");
		for(int j=0;j<n;j++)
		{
			a[j]=scanner.nextInt();
		}
		scanner.close();
		System.out.println("Elements before reverse");
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}
		System.out.println("Elements after reverse");
		for(int k=n-1;k>=0;k--)
		{
			System.out.println(a[k]);
		}
	}
	
}
