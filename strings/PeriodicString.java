import java.util.Optional;

/**
 * 
 * Find whether string S is periodic.
    Periodic indicates S = nP.
    e.g.
    S = "ababab", then n = 3, and P = "ab"
    S = "xxxxxx", then n = 1, and P = "x"
    S = "aabbaaabba", then n = 2, and P = "aabba"
    follow up:
    Given string S, find out the P (repetitive pattern) of S.
    
 * @author vinitku
 *
 */
public class PeriodicString {
	
	
	  // The algorithm is to concatenate the string to itself, take the result without
	  // the first and the last characters and look for the string inside this result.
	  // If present - the string is periodic.
	  // To find the pattern, take the index of the string in the result, cut the result
	  // up until this index and add the first character of the original string in 
	  // the beginning.
	  // Example:   
	  //   original: aabbaaabba                    
	  //   result to look in:            [a]abbaaabbaaabbaaabb[a]
	  //   found the original at index 4:   0123|--------|  
	  //   prefix: abba, add back the first character -> aabba
	  // Another example : take original str abcabc , P = abc , n=2
	 //  str + str = abcabcabcabc , [a]bcabcabcab[c]
	  // index = 2, 01|--------|, is answer is [a] + bc = abc 
	
	public static Optional<String> findPattern(String str) {
	    String test = str + str;
	    String sub = test.substring(1, test.length() - 1);
	    int index = sub.indexOf(str);
	    if (index < 0) {
	      return Optional.empty();
	    }
	    return Optional.of(str.charAt(0) + sub.substring(0, index));
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabc";
		System.out.println(findPattern(s));
	}

}
