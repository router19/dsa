/*
 
Smallest subarray with sum greater than a given value

Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.

Examples:
arr[] = {1, 4, 45, 6, 0, 19}
   x  =  51
Output: 3
Minimum length subarray is {4, 45, 6}

arr[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Minimum length subarray is {10}

arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
    x = 280
Output: 4
Minimum length subarray is {100, 1, 0, 200}

arr[] = {1, 2, 4}
    x = 8
Output : Not Possible
Whole array sum is smaller than 8.

 */
public class SmallestSubArrayWithGreaterThanSum {
	
	// Returns length of smallest subarray with sum greater than x. 
	// If there is no subarray with given sum, then returns n+1 
	//it handles array with negative numbers as well.
	static public int minSubArrayWithSum(int a[],int n,int sum)
	{
		// Initialize starting and ending indexes 
		int start= 0,end =0;
		
		// Initialize current sum and minimum length
		int min_length = n+1, curr_sum =0;
		
		
		while(end < n )
		{
			// Keep adding array  
	        // elements while current  
	        // sum is smaller than x 
			while(curr_sum < sum && end < n )
			{
				// Ignore subarrays with  
	            // negative sum if x is 
	            // positive. 
				if(curr_sum < 0 && sum > 0)
				{
					start = end;
					curr_sum = 0;
				}
				
				curr_sum += a[end++];
				
			}
			// If current sum becomes  
	        // greater than x. 
			// now lets find the solution
			while(curr_sum >= sum && start < n)
			{
				if(end - start < min_length)
					min_length = end - start;
				
				curr_sum -= a[start++];
			}
		}
		//System.out.println("start is " + start + " len is "+ min_length);
		if(min_length <= n )
		{
			System.out.print("Elements are : ");
			for(int j = start -1; j < start + min_length - 1; j++)
				System.out.print(a[j] + " ");
			System.out.println();
		}
		
		return min_length;
	}
	public static void main(String[] args) {
		int a[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
		System.out.println(minSubArrayWithSum(a, a.length, 251));
	}

}
