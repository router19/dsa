import java.util.HashMap;

/**
 * Code the String as shown below ; 
 * aaccbbcce as -> a2c2b2c2e1
 * @author vinitku
 *
 */
public class StringEncoding {

	static String encode(String str) {
		char a[] = str.toCharArray();
        StringBuilder final_string = new StringBuilder();
        int currIndex = 0,count =1;
        for(int i =1;i <= str.length();i++ )
        {
              
              if(i< str.length() && a[i] == a[currIndex])
                  count++;
              else {
            	  final_string.append(a[currIndex]);
            	  final_string.append(count);
            	  currIndex = i;
            	  count = 1;
              }
              
              
        }
        return final_string.toString();
	}
	
	static String CountOccurrences(String S){
        // Your code goes here
        HashMap<Character,Integer> charCountMap = new HashMap<>();
        HashMap<Character,Boolean> visitedMap = new HashMap<>();
        char ca[] = S.toCharArray();
        for (char c : ca) { 
            if (charCountMap.containsKey(c)) { 
  
                // If char is present in charCountMap, 
                // incrementing it's count by 1 
                charCountMap.put(c, charCountMap.get(c) + 1); 
            } 
            else { 
  
                // If char is not present in charCountMap, 
                // putting this char to charCountMap with 1 as it's value 
                charCountMap.put(c, 1);
                visitedMap.put(c, false);
            } 
        }
        String s = "";
        for(char c : ca)
        {
        	if(!visitedMap.get(c))
        	{
        		s = s + Character.toString(c) + charCountMap.get(c);
        		visitedMap.put(c, true);
        	}
        		
        }
       
        return s;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "occurrences";
		//System.out.println(encode(s));
		System.out.println(CountOccurrences(s));
	}

}
