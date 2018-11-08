package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UniqueCount {

	public static void main(String[] args) {
		String input = "Geeks for geeks";
		//Replacing space
		input=input.replace(" ","");
		Map<Character,Integer> countMap = new HashMap<Character,Integer>();
		char[] array = input.toCharArray();
		for(char a: array)
		{
			if(countMap.containsKey(a))
			{
				int count=countMap.get(a);
				count=count++;
				countMap.put(a, countMap.get(a)+1);
			}
			else
			{
				countMap.put(a, 1);
			}
		}
		System.out.println("Unique count");
		for(char a:countMap.keySet())
		{
			System.out.println(a+" "+countMap.get(a));
		}
	}
	
}
