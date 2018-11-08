package programs;

public class Pattern {
	public static void main(String[] args) 
	{
		int rows=7,sum=0;
		for(int i=1;i<=rows;i++)
		{
			sum++;
			for(int j=rows;j>=i;j--)
			{
				System.out.print(" ");
			}
			for(int k=0;k<2*i-1;k++)
			{
				System.out.print(sum);
			}
			System.out.println();
			
		}
		for(int i=rows;i>=1;i--)
		{
			for(int j=rows;j>=i;j--)
			{
				System.out.print(" ");
			}
			for(int k=0;k<2*i-1;k++)
			{
				System.out.print(sum);
			}
			System.out.println();
			sum--;
		}
		
		
	}
}
