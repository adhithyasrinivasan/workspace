package programs;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		int a=0;
		int m=n/2;
		int flag=0;
		for(a=2;a<=m;a++)
		{
			if(n%a==0)
			{
				flag=1;
			}
		}
		if(flag==0)
		{
			System.out.println("is prime");
		}
		else{
		System.out.println(("is not a prime"));	
		}
		
			
	}

}
