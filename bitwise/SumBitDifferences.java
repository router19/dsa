/**
 * 
Sum of bit differences among all pairs

Given an integer array of n integers, find sum of bit differences in all pairs that can be formed from array elements. Bit difference of a pair
 (x, y) is count of different bits at same positions in binary representations of x and y.
For example, bit difference for 2 and 7 is 2. Binary representation of 2 is 010 and 7 is 111 ( first and last bits differ in two numbers).

Examples :

Input: arr[] = {1, 2}
Output: 4
All pairs in array are (1, 1), (1, 2)
                       (2, 1), (2, 2)
Sum of bit differences = 0 + 2 +
                         2 + 0
                      = 4

Input:  arr[] = {1, 3, 5}
Output: 8
All pairs in array are (1, 1), (1, 3), (1, 5)
                       (3, 1), (3, 3) (3, 5),
                       (5, 1), (5, 3), (5, 5)
Sum of bit differences =  0 + 1 + 1 +
                          1 + 0 + 2 +
                          1 + 2 + 0 
                       = 8

 * @author vinitku
 *
 *Naive Solution –
A Simple Solution is to run two loops to consider all pairs one by one. For every pair, count bit differences. 
Finally return sum of counts. Time complexity of this solution is O(n2)
 
  ** An Efficient Solution 
    can solve this problem in O(n) time using the fact that all numbers are represented using 32 bits (or some fixed number of bits). 
 The idea is to count differences at individual bit positions. We traverse from 0 to 31 and count numbers with i’th bit set.
 Let this count be ‘count’. There would be “n-count” numbers with i’th bit not set. So count of differences at i’th bit would be “count * (n-count) * 2”, 
 the reason for this formula is as every pair having one element which has set bit at i’th position and second element having unset bit at i’th position
 contributes exactly 1 to sum, therefore total permutation count will be count*(n-count) and multiply by 2 is due to one more repetition of all this type 
 of pair as per given condition for making pair 1<=i, j<=N.
 */
public class SumBitDifferences {
	
	//O(n) * fixed length bits
	static int sumofBitDifferences(int ap[], int n)
	{
		int result = 0;
		//number of ith bit set in all integers of an array 
		int count =0;
		
		//for 32 fixed bit length integer
		for(int i = 0 ; i < 32; i++)
		{
			count = 0;
			for(int j=0;j < n ;j++)
			{
				//count the ith bit set for all numbers in the array
				if((ap[j] &  1 << i) > 0)
					count++;
			}
			//count = no. of integers with a bit set.
			//n-count = no. of integers with bit unset.
			// count * (n-count) * 2 = no. of complementary bit pairs
			result += (n - count) * count * 2;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 3, 6 }; 
        int n = arr.length; 
  
        System.out.println(sumofBitDifferences( 
            arr, n)); 
	}

}
