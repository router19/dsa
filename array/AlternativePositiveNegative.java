/*
 * Rearrange array in alternating positive & negative items with O(1) extra space

Input:  arr[] = {1, 2, 3, -4, -1, 4}
Output: arr[] = {-4, 1, -1, 2, 3, 4}


Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}

Solution Algo : 
The idea is to process array from left to right. While processing, find the first out of place element in the remaining
 unprocessed array. An eleleetcodement is out of place if it is negative and at odd index, or it is positive and at even index.
 Once we find an out of place element,  we find the first element after it with opposite sign. 
 We right rotate the subarray between these two elements (including these two).
 */


public class AlternativePositiveNegative {

	static int[] reArrangeArray(int nums[])
	{
		int a = 0;
		int b = 1;
		int arr[] = new int[nums.length];
		for(int i=0;i<nums.length;i++){
			if(nums[i]>0){
				arr[a] = nums[i];
				a = a+2;
			}
			else{
				arr[b] = nums[i];
				b = b+2;
			}
		}
		return arr;
	}


	static void reArrange(int a[]) {
		int outOfPlace = -1;
		
		for(int i = 0; i < a.length; i++)
		{
		   if(outOfPlace >= 0)
			{
				if((a[outOfPlace] < 0 && a[i] > 0 ) ||
						(a[outOfPlace] > 0 && a[i] < 0))
				{
					rightRotate(a, outOfPlace, i);
					if(i - outOfPlace > 2)
						outOfPlace = outOfPlace + 2;
					else
						outOfPlace = -1;
				}
				
			}
			
			if(outOfPlace == -1)
			{
				if((i%2 == 0 && a[i] > 0) ||
						(i%2 ==1 && a[i] < 0))
				{
					outOfPlace = i;
				}
			}
		}
		
		for(int i =0; i < a.length;i++)
		{
			System.out.print(a[i] + " ");
		}
	}
	static void rightRotate(int a[], int start,int end) {
		int temp = a[end];
		for(int i = end;i > start;i--)
		{
			a[i] = a[i -1];
		}
		a[start] = temp;
		
		
	}
	public static void main(String args[]) {
		int a[] = {1,4,-1,3,-9,-7,0,10};
		reArrange(a);
	}

}
