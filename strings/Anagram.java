import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * Write a program to return a list of anagram of a given array of strings 
 * e.g. 
 * 
Input:
	N = 5
	words[] = {act,god,cat,dog,tac}
Output: 
	god dog
	act cat tac
Explanation:
 	There are 2 groups of
	anagrams god, dog make group 1.
	act, cat, tac make group 2.
	Anagram of a string contains same set of characters as of input string.
 */
public class Anagram {

	
	
	static boolean isAnagram(String str1, String str2)
	{
		int count[] = new int[256];
		if(str1.length() != str2.length())
			return false;
		for(int i=0; i < str1.length(); i++)
		{
			count[str1.charAt(i)]++;
			count[str2.charAt(i)]--;
		}
		
		for(int i =0; i < 256; i++)
		{
			if(count[i] != 0)
				return false;
		}
		return true;
	}
	
	static void printAnagram(String a[], int n)
	{
		
		for(int i=0; i < n;i++)
		{
			for(int j =i+1; j < n; j++)
			{
				if(isAnagram(a[i], a[j]))
				{
					System.out.println(a[i] +" is anagram of "+ a[j]);					
				}
			}
		}			
	}
	
	public static List<List<String>> Anagrams(String[] str) {
        int n=str.length;
        
        HashMap<String,List<String>> hm=new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
			String word = str[i];
			char letters[] = word.toCharArray();
			Arrays.sort(letters);
			String newword = new String(letters);
			if (hm.containsKey(newword))
				hm.get(newword).add(word);
			else {
				List<String> words = new ArrayList<>();
				words.add(word);
				hm.put(newword, words);
			}
		}
		List<List<String>> res = new ArrayList<>();
		for (Map.Entry<String, List<String>> me : hm.entrySet())
		{
			List<String> list = me.getValue();
			if(list.size() > 1)
				res.add(me.getValue());
		}
		return res;
	}

	public static void main(String[] args) {
		
		String a[] = {"cat", "tac", "dog","act","god"};
//		printAnagram(a, 5);
		String a1[] = {"cat", "tac", "dog","act"};
		List<List<String>> listoflist = Anagrams(a);
		int i =0;
		for(List<String> list : listoflist)
		{
			i++;
			System.out.print("Anagram "+i + " ");
			if(!list.isEmpty())
			{
				Iterator<String> s = list.iterator();
				while(s.hasNext())
					System.out.print(s.next() +" ");
			}
			System.out.println();
		}
	}

}
