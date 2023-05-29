import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class HashMapConcepts {

	public static void main(String a[])
	{
		Map<String,String> map = new HashMap<>();
		map.put("id", "vinit");
		map.put("id", "t");
		Scanner in = new Scanner(System.in);
		in.nextLine();
		String s[] = "test 10".split(" ");////s")
		
		HashSet set = new HashSet();
		LinkedHashSet linkedSet = new LinkedHashSet();
		
		TreeSet treeSet = new TreeSet();
		List<Integer> list = new ArrayList<>();
		System.out.println(list.size());
		list.add(1);
		System.out.println(list.size());
		System.out.println(list.get(list.size()-1));
//		for(Map.Entry<String, String> entry: map.entrySet() )	
//		{
//			System.out.println(entry.getValue()); 
//		}
	}
}
