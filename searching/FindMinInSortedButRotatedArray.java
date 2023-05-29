/*
A sorted array is rotated at some unknown point, find the minimum element in it.

Following solution assumes that all elements are distinct.

Examples:


Input: {5, 6, 1, 2, 3, 4}
Output: 1

Input: {1, 2, 3, 4}
Output: 1

Input: {2, 1}
Output: 1


ALGO : 
We can do it in O(Logn) using Binary Search. If we take a closer look at above examples, we can easily figure out
 following pattern:

The minimum element is the only element whose previous is greater than it. If there is no previous element element,
 then there is no rotation (first element is minimum). We check this condition for middle element by comparing
  it with (mid-1)’th and (mid+1)’th elements.
If minimum element is not at middle (neither mid nor mid + 1), then minimum element lies in either left half
 or right half.
    i) If middle element is smaller than last element, then the minimum element lies in left half
    ii) Else minimum element lies in right half.

 */
public class FindMinInSortedButRotatedArray {

	public static int findMin(int a[],int low,int high)
	{
		if(low == high ) return a[low];
		
		if(high < low ) return a[0];
		
		int mid = low + (high - low)/2;
		if(mid < high && a[mid+1] < a[mid])
			return a[mid+1];
		
		if(mid < low && a[mid] < a[mid-1])
			return a[mid];
		
		if(a[high] > a[mid])
			return findMin(a, low, mid -1);
		return findMin(a, mid+1, high);
	}
	public static void main(String[] args) {
		

	}

}
