package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortMapByEntryInteger {
	public static void main(String[] args) {
		Map<String,Integer> testMap = new HashMap<String,Integer>();
		testMap.put("key1",54);
		testMap.put("key2",12);
		testMap.put("key3",225);
		testMap.put("key4",21);
		Set<Entry<String,Integer>> testSet = testMap.entrySet();
		List<Entry<String,Integer>> testList=new ArrayList<Entry<String,Integer>>(testSet);
		Collections.sort(testList,new Comparator<Map.Entry<String,Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return (o2.getValue().compareTo(o1.getValue()));
			}
		});
		for(Map.Entry<String,Integer> lis:testList)
		{
			System.out.println("key: "+lis.getKey()+" value:"+lis.getValue());
		}
	}

}
