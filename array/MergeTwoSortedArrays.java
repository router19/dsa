import java.util.Scanner;

public class MergeTwoSortedArrays {

	
	//Using extra space
	static int[] mergeArray(int a[],int b[])
	{
		int n = a.length;
		int m = b.length;
		int c[] = new int[n+m];
		int i=0,j=0,k=0;
		while(i < n && j < m)
		{
			if(a[i] < b[j])
				c[k++] = a[i++];
			else
				c[k++] = b[j++];
		}
		
		while(i < n )
			c[k++] =a[i++];
		while(j < m)
			c[k++] = b[j++];
		
		return c;
		
	}
	/*
	 * Time Complexity: The worst case time complexity of code/algorithm is O(m*n).
	 * The worst case occurs when all elements of ar1[] are greater than all elements of ar2[].
	 */
	static void mergeArraysWithoutUsingExtraSpace(int[] arr1, int[] arr2) 
    { 
        // Iterate through all elements of ar2[] starting from 
        // the last element 
		int m = arr1.length;
		int n = arr2.length;
        for (int i=n-1; i>=0; i--) 
        { 
            /* Find the smallest element greater than ar2[i]. Move all 
               elements one position ahead till the smallest greater 
               element is not found 
               
               3,5,7      2,5,6       => 2,3,5,5,6,7      
               */
            int j, last = arr1[m-1]; //last = 7
            for (j=m-2; j >= 0 && arr1[j] > arr2[i]; j--) 
                arr1[j+1] = arr1[j]; 
       
            // If there was a greater element 
            if (j != m-2 || last > arr2[i]) 
            { 
                arr1[j+1] = arr2[i]; 
                arr2[i] = last; 
            } 
        } 
    } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int t,n1,n2;
		int a[],b[];
		
		Scanner in = new Scanner(System.in);
		
		t = in.nextInt();
		
		while(t-- > 0)
		{
			n1 = in.nextInt();
			n2 = in.nextInt();
			
			a = new int[n1];
			b = new int[n2];
			int i;
			for(i =0; i < n1; i++)
			{
			    a[i] = in.nextInt();	
			}
			for(i =0; i < n2; i++)
			{
				b[i] = in.nextInt();
			}
			
			//Using extra space
//			int c[] = mergeArray(a,b);
//			for(i =0; i < n1 + n2;i++)
//			{
//				System.out.print(c[i] + " ");
//			}
//			System.out.println();
			
			
			mergeArraysWithoutUsingExtraSpace(a, b);
			
			for(i = 0; i < n1;i++)
			{
				System.out.print(a[i] + " ");	
			}
			for(i=0;i < n2;i++)
			{
				System.out.print(b[i] + " ");
			}
			
			
			
		}

	}

}
