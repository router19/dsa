
public class MedianofTwoSortedArray {

	//O(n) approach
	public static int median(int a[],int b[])
	{
		
		int l1 = a.length;
		int l2= b.length;
		int l3 = l1 + l2;
		int i = 0,j =0;
		int index = 0;
		while(i < l1 && j < l2 && index < (l3/2 -1))
		{
			if(a[i] < b[j])
				i++;
			else
				j++;
			index++;
		}
		if(l3%2 == 0)
			return (a[i] + b[j])/2;
		else
		{
			if(a[i] < b[j])
				i++;
			else 
				j++;
			return (a[i] < b[j] ? a[i] : b[j]);
		}
			
	}
	
	//Below two methods are used for getting median of an array
	
	//O(logn) approach
	
	
	/*
	 * ALGORITHM : 
	 * 1) Calculate the medians m1 and m2 of the input arrays ar1[] 
   		  and ar2[] respectively.
	   2) If m1 and m2 both are equal then we are done.
     	  return m1 (or m2)
	   3) If m1 is greater than m2, then median is present in one 
   	      of the below two subarrays.
    	  a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
    	  b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
	   4) If m2 is greater than m1, then median is present in one    
   		 of the below two subarrays.
   	a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
   b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
5) Repeat the above process until size of both the subarrays 
   becomes 2.
6) If size of the two arrays is 2 then use below formula to get 
  the median.
    Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2

Examples :

   ar1[] = {1, 12, 15, 26, 38}
   ar2[] = {2, 13, 17, 30, 45}

For above two arrays m1 = 15 and m2 = 17

For the above ar1[] and ar2[], m1 is smaller than m2. So median is present in one of the following two subarrays.

   [15, 26, 38] and [2, 13, 17]

Let us repeat the process for above two subarrays:

    m1 = 26 m2 = 13.

m1 is greater than m2. So the subarrays become

  [15, 26] and [13, 17]
Now size is 2, so median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
                       = (max(15, 13) + min(26, 17))/2 
                       = (15 + 17)/2
                       = 16

	 */
	static int median(int a[],int start,int end)
	{
		int n = end - start + 1;
		if(n%2 == 0)
			return (a[start + n/2] + a[start + (n/2 -1)])/2;
		else
			return a[start + n/2];
		
	}
	public static int median(int a[],int b[],int startA,int endA,int startB,int endB)
	{
		if(endA - startA  == 1)
		{
			return (Math.max(a[0], b[0]) + Math.min(a[1], b[1])) /2;
		}
		
		int medianA = median(a, startA, endA);
		
		int medianB = median(b, startB, endB);
		
		if(medianA == medianB)
			return medianA;
		else if(medianA < medianB)
		{
			return median(a, b, (startA + endA +1)/2, endA, startB, (startB + endB + 1 )/2);
		}
		else 
		{
			return median(a, b, startA, (startA + endA + 1)/2, (startB + endB +1)/2, endB);
		}
	}
	public static void main(String[] args) {
		int a[] = {2,3,4,6,6};
		int b[] = {3,6,7,8,9};
		//O(n) approach
		System.out.println(median(a, b));
		
		//O(logn) approach
		System.out.println(median(a, b, 0, a.length -1, 0, b.length -1));
	}

}
