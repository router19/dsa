import java.util.Arrays;

/*
 * Minimum number of sub-strings of a string such that all are power of 5.
 * 
 Given a binary string str. The task is to find the smallest positive integer C such that the binary string can be cut into C pieces (sub-strings)
  and  each sub-string should be a power of 5 with no leading zeros.

Examples:


    Input: str = “101101101”
    Output: 3
    The string “101101101” can be cut into three binary strings “101”, “101”, “101”
    each of which is a power of 5.

    Input: str = “1111101”
    Output: 1
    The string “1111101” can be cut into one binary string “1111101” which is
    125 in decimal and a power of 5.

    Input: str = “00000”
    Output: -1
    Strings of only zeroes is equivalent to 0 which is not a power of 5. 
 
 ALGORITHM : 
 
 ---------------------
 Approach: This problem is a simple variation of the longest increasing sub-sequence (https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/)
Iterate from i = 1 and for every str[j…i] where j = 0 & j < i, we check if the number formed from str[j..i] is a power of 5 then we update the dp[] array 
with the value of the lowest possible cut size value. After confirming that the number formed from str[j..i] in decimal is a power of 5 
we calculate dp[i] = min(dp[i], dp[j] + 1).
This technique is pretty similar to finding the longest increasing sub-sequence.


Algorithm 
Time : O(n^2)
Space : O(n)
 */
public class MinNoOfSubStringPowering5 {

	// Function that returns true 
    // if n is a power of 5 
    static boolean ispower(long n) 
    { 
        if (n < 125) 
        { 
            return (n == 1 || n == 5 || n == 25); 
        } 
        if (n % 125 != 0) 
        { 
            return false; 
        } 
        else
        { 
            return ispower(n / 125); 
        } 
    } 
  
    // Function to return the decimal 
    // value of binary equivalent 
    static long number(String s, int i, int j)  
    { 
        long ans = 0; 
        for (int x = i; x < j; x++)  
        { 
            ans = ans * 2 + (s.charAt(x) - '0'); 
        } 
        return ans; 
    } 
  
	// Function to return the minimum cuts required 
    static int minCuts(String s, int n) 
    { 
        int[] dp = new int[n + 1]; 
  
        // Alongocating memory for dp[] array 
        Arrays.fill(dp, n+1); 
        dp[0] = 0; 
  
        // From length 1 to n 
        for (int i = 1; i <= n; i++) 
        { 
  
            // If previous character is '0' then ignore 
            // to avoid number with leading 0s. 
            if (s.charAt(i - 1) == '0') 
            { 
                continue; 
            } 
            for (int j = 0; j < i; j++)  
            { 
  
                // Ignore s[j] = '0' starting numbers 
                if (s.charAt(j) == '0')  
                { 
                    continue; 
                } 
  
                // Number formed from s[j....i] 
                long num = number(s, j, i); 
  
                // Check for power of 5 
                if (!ispower(num))  
                { 
                    continue; 
                } 
  
                // Assigning min value to get min cut possible 
                dp[i] = Math.min(dp[i], dp[j] + 1); 
            } 
        } 
  
        // (n + 1) to check if all the Strings are traversed 
        // and no divisible by 5 is obtained like 000000 
        return ((dp[n] < n + 1) ? dp[n] : -1); 
    } 
    
	public static void main(String[] args) {
		String s = "101000"; 
        int n = s.length(); 
        System.out.println(minCuts(s, n)); 

	}

	
}
