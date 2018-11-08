package collections;

import java.util.Set;
import java.util.TreeSet;

public class SortNumber {

	public static void main(String[] args) {
		int[] array = {125,67,32,125,67,32,53,24};
		Set sorted = new TreeSet<>();
		for(int i=0;i<array.length;i++)
		{
			sorted.add(array[i]);
		}
		System.out.println(sorted);
	}
	
}

