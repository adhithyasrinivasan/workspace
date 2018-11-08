package extra;

public class PatternReverse {
	public static void main(String[] args) {
		int n=5;
		int k;
		k=5;
		for(int i=1;i<=n;i++)
		{
			k=i;
			for(int j=1;j<=i;j++)
			{
				System.out.print(k);
				k=k-1;
			}
			System.out.println();
		}
	}
}
