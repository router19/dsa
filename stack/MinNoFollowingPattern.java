import java.util.Scanner;
import java.util.Stack;

/**
 * Number following a pattern 
Given a pattern containing only I's and D's. I for increasing and D for decreasing.
Devise an algorithm to print the minimum number following that pattern.
Digits from 1-9 and digits can't repeat.

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is a string, which contains only I's and D's in capital letter.

Output:
Print the minimum number following that pattern.

Constraints:
1 ≤ T ≤ 100
1 ≤ Length of String ≤ 8

Example:
Input
5
D
I
DD
IIDDD
DDIDDIID

Output
21
12
321
126543
321654798

@author vinitku
 *
 */
public class MinNoFollowingPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		String s = "";
		while(n-- >0)
		{
		    s = in.nextLine();
		    System.out.println(minNumFollowingPattern(s));
		    
		}
		

	}
	
	// Function to decode the given sequence to construct
	// minimum number without repeated digits
	public static String minNumFollowingPattern(String in)
	{
		// result store output string
	    StringBuilder result = new StringBuilder();
	    
	    // create an empty stack of integers
	    Stack<Integer> st = new Stack<Integer>();
	    
	    // run n+1 times where n is length of input sequence
	    for(int i=0;i<= in.length();i++)
	    {
	    	// push number i+1 into the stack
	        st.push(i+1);
	        
	        // if all characters of the input sequence are
            // processed or current character is 'I'
            // (increasing)
	        if(i == in.length() || in.charAt(i) =='I')
	        {
	        	// run till stack is empty
	        	while(!st.isEmpty())
	            {
	        		// remove top element from the stack and
                    // add it to solution
		            result.append(st.peek());
		            st.pop();
	            }
	        }
	    }
	    return result.toString();
	}

}
