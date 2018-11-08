package extra;

public class Pattern {
	
	public static void main(String[] args) {
		int n=5;
		int k=1;
		for(int i=0;i<n;i++)
		{
			long l=5;
			for(int j=0;j<=i;j++)
			{
				System.out.print(l);
				l=l*l;
			}
			System.out.println();
		}
	}

}
