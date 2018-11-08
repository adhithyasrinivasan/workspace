package extra;

public class Pattern10 {
public static void main(String[] args) {
	int n=5,p,q;
	int v=1;
	int v1=0;
	for(int i=0;i<5;i++)
	{
		for(int j=1;j<=i;j++)
		{
			System.out.print(((i%2)+j)%2);
		}
		System.out.println();
	}

}
}
