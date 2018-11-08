package collections;

import java.util.HashMap;
import java.util.Map;

public class DuplicateElements {
public static void main(String[] args) {
	int a[] = {1,2,3,1,4,2,5};
	Map<Integer,Integer> countMap = new HashMap<>();
	for(int i=0;i<a.length;i++)
	{
		if(countMap.containsKey(a[i]))
		{
			countMap.put(a[i], countMap.get(a[i])+1);
		}
		else
		{
			countMap.put(a[i], 1);
		}
	}
	for(Integer b:countMap.keySet())
	{
		System.out.println(b+" "+countMap.get(b));
	}
}
}
