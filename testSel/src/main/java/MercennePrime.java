import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.nullValue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;



import com.mongodb.internal.connection.PowerOfTwoBufferPool;

public class MercennePrime 
{
	static int fact;
	public static void main(String args[])
	{
		for(int i=1;i<14;i++)
		{
			int k=getPrime(i,i);
			if(k!=0)
				{System.out.println("prime "+k); 
				System.out.println(callMercenne(i));}
		}
	}

	private static BigInteger callMercenne(int k) 
	{
		// TODO Auto-generated method stub
		int j=(int) java.lang.Math.pow(2, k);
		BigInteger bigInt=new BigInteger("2");
		BigInteger pow=bigInt.pow(k);
		//if(j>=0)
			long mercenne=j-1;
			BigInteger bigMercennePow=new BigInteger(pow.toString());
			BigInteger biggerMercenne=bigMercennePow.subtract(new BigInteger("1"));
			return biggerMercenne;
	}

	private static int getPrime(int i2,int i3) 
	{
		int prime=0;
		for(int i=i2;i<=i3;i++)
		{
			fact=0;
			for(int j=1; j<=i3; j++)
	        {
	            if(i%j==0)
	                fact++;
	        }
	        if(fact==2)
	        {
	        	prime=i;
	        }
	    }
		return prime;
	}
	/*private static boolean checkPrime(BigInteger biggerMercenne)
	{
		BigInteger bigTwo=new BigInteger("2");
		boolean isprime=true;
		for(bigTwo; bigTwo.compareTo(biggerMercenne.divide(bigTwo)) <= 0; ++i)
		{
			if(biggerMercenne.compareTo(bigTwo)BigInteger.ZERO)
		    {
		        isprime = false;
		        break;
		    }
		}
		return isprime;
	}*/
}
