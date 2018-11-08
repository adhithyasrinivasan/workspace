package extra;

public class Palindrome {
	public static void main(String[] args) 
	{
		String orig="Capgemein";
		String rev="";
		for(int i=orig.length()-1;i>=0;i--)
		{
			rev=rev+orig.charAt(i);
		}
		if(orig.equalsIgnoreCase(rev))
		{
			System.out.println(true);;
		}
		else
			System.out.println(false);;
		
			
		int n=121,orig1=n,rem;
		int revN=0;
		while(n>0)
		{
			rem=n%10;
			revN=revN*10+rem;
			n=n/10;
		}
		System.out.println(revN);	
		if(orig1==revN)
		{
			System.out.println("Palindrome number");
		}
			
	}

}
