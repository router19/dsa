import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 Given an input string and a dictionary of words, find out if the input string can be segmented into a
  space-separated sequence of dictionary words. See following examples for more details.
This is a famous Google interview question, also being asked by many other companies now a days.

Example
Consider the following dictionary 
{ i, like, sam, sung, samsung, mobile, ice, 
  cream, icecream, man, go, mango}

Input:  ilike
Output: Yes 
The string can be segmented as "i like".

Input:  ilikesamsung
Output: Yes
The string can be segmented as "i like samsung" 
or "i like sam sung".

 */
public class WordBreakProblem {

	private static  Set<String> dictionary = new HashSet<>();
	
	// returns true if the word can be segmented into parts such 
    // that each part is contained in dictionary 
	static boolean wordBreak(String word) {
		int size = word.length();
		
		// base case
		if(size == 0)
			return true;
		
		//else check for all words
		for(int i =1;i <= size; i++)
		{
			// Now we will first divide the word into two parts , 
            // the prefix will have a length of i and check if it is  
            // present in dictionary ,if yes then we will check for  
            // suffix of length size-i recursively. if both prefix and  
            // suffix are present the word is found in dictionary. 
			if(dictionary.contains(word.substring(0, i)) &&
					wordBreak(word.substring(i, size)))
				return true;
		}
		// if all cases failed then return false 
		return false;
	}
	
	// Returns true if string can be segmented into space separated 
	// words, otherwise returns false 
	static boolean wordBreakDP(String word) {
		int size = word.length();
		
		if(size == 0) return true;
		
		// Create the DP table to store results of subproblems. The value wb[i] 
	    // will be true if str[0..i-1] can be segmented into dictionary words, 
	    // otherwise false. 
		boolean wb[] = new boolean[size+1];
		
		// Initialize all values as false.
		Arrays.fill(wb, false);
		
		for(int i=1;i<=size;i++)
		{
			// if wb[i] is false, then check if current prefix can make it true. 
	        // Current prefix is "str.substr(0, i)" 
			if(wb[i] == false && dictionary.contains(word.substring(0, i)))
				wb[i] = true;
			
			// wb[i] is true, then check for all substrings starting from 
	        // (i+1)th character and store their results. 
			if(wb[i] == true)
			{
				// If we reached the last prefix  
				if(i== size)
					return true;
				
				for(int j=i+1;j<=size;j++)
				{
					// Update wb[j] if it is false and can be updated 
	                // Note the parameter passed to dictionaryContains() is 
	                // substring starting from index 'i' and upto index j 
					if(wb[j] == false && dictionary.contains(word.substring(i, j)))
						wb[j] = true;
					
					// If we reached the last character
					if(j==size && wb[j]==true)
						return true;
					
				}
			}
		}
		/* Uncomment these lines to print DP table "wb[]" 
	     for (int i = 1; i <= size; i++) 
	        cout << " " << wb[i]; */
		
		// If we have tried all prefixes and none of them worked 
		return false;
	}
	public static void main(String []args) 
    { 
          
        // array of strings to be added in dictionary set. 
        String temp_dictionary[] = {"mobile","samsung","sam","sung",  
                            "man","mango","icecream","and",  
                            "go","i","like","ice","cream"}; 
                              
        // loop to add all strings in dictionary set  
        for (String temp :temp_dictionary) 
        { 
            dictionary.add(temp); 
        } 
          
        // sample input cases 
        System.out.println(wordBreak("ilikesamsung")); 
        System.out.println(wordBreak("iiiiiiii")); 
        System.out.println(wordBreak("")); 
        System.out.println(wordBreak("ilikelikeimangoiii")); 
        System.out.println(wordBreak("samsungandmango")); 
        System.out.println(wordBreak("samsungandmangok")); 
        
        
        //sample input case for DP solution
        System.out.println(wordBreakDP("ilikesamsung")); 
        System.out.println(wordBreakDP("iiiiiiii")); 
        System.out.println(wordBreakDP("")); 
        System.out.println(wordBreakDP("ilikelikeimangoiii")); 
        System.out.println(wordBreakDP("samsungandmango")); 
        System.out.println(wordBreakDP("samsungandmangok")); 
    } 

}
