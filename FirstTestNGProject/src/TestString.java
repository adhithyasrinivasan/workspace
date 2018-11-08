import java.util.Random;
public class TestString
{
   public static String getRandom() 
   {
	   String[] toppings = {"Cheese", "Pepperoni", "Black Olives"};
	   int rnd = new Random().nextInt(toppings.length);
	   System.out.println(toppings[rnd]);
	   return toppings[rnd];
   }
   public static void main(String[] args)
   {
	   TestString.getRandom();
   }
}


	

