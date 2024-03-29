/**
 * KADENE's Algorithm
 * 
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers which 
 * has the largest sum. 
 * 
 * Aka Largest sum contiguous subarray
 * --------------------------------
 * 
 * ALGO 
 * ----------
Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far


 * Example 
 ------------------------
  Lets take the example:
    {-2, -3, 4, -1, -2, 1, 5, -3}

    max_so_far = max_ending_here = 0

    for i=0,  a[0] =  -2
    max_ending_here = max_ending_here + (-2)
    Set max_ending_here = 0 because max_ending_here < 0

    for i=1,  a[1] =  -3
    max_ending_here = max_ending_here + (-3)
    Set max_ending_here = 0 because max_ending_here < 0

    for i=2,  a[2] =  4
    max_ending_here = max_ending_here + (4)
    max_ending_here = 4
    max_so_far is updated to 4 because max_ending_here greater 
    than max_so_far which was 0 till now

    for i=3,  a[3] =  -1
    max_ending_here = max_ending_here + (-1)
    max_ending_here = 3

    for i=4,  a[4] =  -2
    max_ending_here = max_ending_here + (-2)
    max_ending_here = 1

    for i=5,  a[5] =  1
    max_ending_here = max_ending_here + (1)
    max_ending_here = 2

    for i=6,  a[6] =  5
    max_ending_here = max_ending_here + (5)
    max_ending_here = 7
    max_so_far is updated to 7 because max_ending_here is 
    greater than max_so_far

    for i=7,  a[7] =  -3
    max_ending_here = max_ending_here + (-3)
    max_ending_here = 4
 * @author vinitku
 *
 */

public class KadenesAlgrorithm {

	
	static int maxSubArraySum(int a[])
	{
		int max_so_far =Integer.MIN_VALUE,max_ending_here =0;
		
		for(int i =0; i < a.length;i++)
		{
			max_ending_here += a[i];
			
			if(max_ending_here < 0)
				max_ending_here = 0;
			
			if(max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		
		return max_so_far;
	}
	
	//handles all negative array
	static int maxSum(int a[])
	{
		int max_so_far = a[0];
		int max_ending_here = a[0];
		
		for(int i =1;i < a.length;i++)
		{
			max_ending_here = Math.max(a[i], max_ending_here + a[i]);
			max_so_far = Math.max(max_ending_here, max_so_far);
		}
		return max_so_far;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] =  {-2, -3, 4, -1, 2, -1, 5, -3};
		System.out.println(maxSum(arr));
		
	}

}
