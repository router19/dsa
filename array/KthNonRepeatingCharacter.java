import java.util.Arrays;

/*
 * 
Given a string and a number k, find the k’th non-repeating character in the string. Consider a large input string with lacs of characters and a small character set. How to find the character by only doing only one traversal of input string?

Examples:

Input : str = geeksforgeeks, k = 3
Output : r
First non-repeating character is f,
second is o and third is r.



ALGORITHM

The idea is to use two auxiliary arrays of size 256 (Assuming that characters are stored using 8 bits). The two arrays are:

count[x] : Stores count of character 'x' in str.
           If x is not present, then it stores 0.

index[x] : Stores indexes of non-repeating characters
           in str. If a character 'x' is not  present
           or x is repeating, then it stores  a value
           that cannot be a valid index in str[]. For 
           example, length of string.

    Initialize all values in count[] as 0 and all values in index[] as n where n is length of string.
    Traverse the input string str and do following for every character c = str[i].
        Increment count[x].
        If count[x] is 1, then store index of x in index[x], i.e., index[x] = i
        If count[x] is 2, then remove x from index[], i.e., index[x] = n
    Now index[] has indexes of all non-repeating characters. Sort index[] in increasing order so that we get k’th smallest element at index[k]. Note that this step takes O(1) time because there are only 256 elements in index[].

 */

//
///   IGNORE
///   Look for FirstNonRepeatingCharacter... it will give the solution
//

public class KthNonRepeatingCharacter {
	
	public static int MAX_CHAR = 256; 
    
    // Returns index of k'th non-repeating character in 
    // given string str[] 
    static int kthNonRepeating(String str, int k) 
    { 
        int n = str.length(); 
   
        // count[x] is going to store count of 
        // character 'x' in str. If x is not present, 
        // then it is going to store 0. 
        int[] count = new int[MAX_CHAR]; 
   
        // index[x] is going to store index of character 
        // 'x' in str.  If x is not  present or x is 
        // repeating, then it is going to store  a value 
        // (for example, length of string) that cannot be 
        // a valid index in str[] 
        int[] index = new int[MAX_CHAR]; 
   
        // Initialize counts of all characters and indexes 
        // of non-repeating  characters. 
        for (int i = 0; i < MAX_CHAR; i++) 
        { 
            count[i] = 0; 
            index[i] = n;  // A value more than any index 
                           // in str[] 
        } 
   
        // Traverse the input string 
        for (int i = 0; i < n; i++) 
        { 
            // Find current character and increment its 
            // count 
            char x = str.charAt(i); 
            ++count[x]; 
   
            // If this is first occurrence, then set value 
            // in index as index of it. 
            if (count[x] == 1) 
                index[x] = i; 
   
            // If character repeats, then remove it from 
            // index[] 
            if (count[x] == 2) 
                index[x] = n; 
        } 
   
        // Sort index[] in increasing order.  This step 
        // takes O(1) time as size of index is 256 only 
        Arrays.sort(index); 
   
        // After sorting, if index[k-1] is value, then  
        // return it, else return -1. 
        return (index[k-1] != n)? index[k-1] : -1; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "geeksforgeeks"; 
        int k = 3; 
        int res = kthNonRepeating(str, k); 
          
        System.out.println(res == -1 ? "There are less than k non-repeating characters" : 
                           "k'th non-repeating character is  " + str.charAt(res)); 

	}

}
