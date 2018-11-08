package extra;

public class Pattern1 {
public static void main(String[] args) {
	int n=5;
	int sum=n;
	int count;
	for(int i=1;i<=n;i++)
	{
		sum=n;
		count=sum;
		for(int j=1;j<=i;j++)
		{
			System.out.print(count);
			count=count*count;
		}
		System.out.println("");
	}
}
}
