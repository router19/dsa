import java.util.Arrays;

/*

Given an array arr[] of N elements. The task is to find the maximum number of the contiguous prime numbers in the given 
array.

Examples:

Input: arr[] = {3, 5, 2, 66, 7, 11, 8}
Output: 3
Maximum contiguous prime number sequence is {2, 3, 5}

Input: arr[] = {1, 0, 2, 11, 32, 8, 9}
Output: 2
Maximum contiguous prime number sequence is {2, 11}
 */
public class MaxSubArrayWithPrimeNumbers {
	
	static void SievOfEratosthenes(boolean prime[], int size)
	{
		prime[0] = false;
		prime[1] = false;
		
		for(int i =2; i*i <=size; i++)
		{
			if(prime[i])
			{
				for(int j = i*2; j<= size;j+=i )
					prime[j] = false;
			}
		}
	}
	static int maxPrimeSubarray(int a[],int n)
	{
		int max_ele = Arrays.stream(a).max().getAsInt();
		boolean prime[] = new boolean[max_ele +1];
		Arrays.fill(prime, true);
		SievOfEratosthenes(prime,max_ele);
		
		int curr_max =0,max_so_far =0;
		
		for(int i =0; i < n ;i++)
		{
			if(prime[a[i]] == false)
				curr_max =0;
			else
			{
				curr_max++;
				max_so_far = Math.max(curr_max, max_so_far);
			}
		}
		return max_so_far;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 0, 2, 4, 3, 29, 11, 7, 8, 9 }; 
	    int n = arr.length; 
	    System.out.print(maxPrimeSubarray(arr, n)); 
	}

}
