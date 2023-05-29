/*
 * Bubble sort repeatedly compares and swaps(if needed) adjacent elements in every pass. In i-th pass of Bubble Sort (ascending order), last (i-1) elements are already sorted, and i-th largest element is placed at (N-i)-th position, i.e. i-th last position. 
 */

/*
 * Time Complexity:

    Best Case Sorted array as input. Or almost all elements are in proper place. [ O(N) ]. O(1) swaps.
    Worst Case: Reversely sorted / Very few elements are in proper place. [ O(N2) ] . O(N2) swaps.
    Average Case: [ O(N2) ] . O(N2) swaps.

 */
public class BubbleSort {

	static void sort(int a[]) {
		int n = a.length;
		for(int i =0; i < n-1; i++)
		{
			for(int j = 0; j < n-i-1;j++) {
				if(a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	
/*
 * Optimization of Algorithm: Check if there happened any swapping operation in the inner loop (pass execution loop)
 * or not. If there is no swapping in any pass, it means the array is now fully sorted, hence no need to continue,
 * stop the sorting operation. So we can optimize the number of passes when the array gets sorted before the
 * completion of all passes. And it can also detect if the given / input array is sorted or not, in the first pass.	
 */
	static void optimizedBubbleSort(int arr[], int n) 
    { 
        int i, j, temp; 
        boolean swapped; 
        for (i = 0; i < n - 1; i++)  
        { 
            swapped = false; 
            for (j = 0; j < n - i - 1; j++)  
            { 
                if (arr[j] > arr[j + 1])  
                { 
                    // swap arr[j] and arr[j+1] 
                    temp = arr[j]; 
                    arr[j] = arr[j + 1]; 
                    arr[j + 1] = temp; 
                    swapped = true; 
                } 
            } 
  
            // IF no two elements were  
            // swapped by inner loop, then break 
            if (swapped == false) 
                break; 
        } 
    } 
	
	public static void main(String[] args) {
		int a[] = {4,3,7,9,12,15,9,4,3,0,-1};
		sort(a);
		
		for(int i = 0; i < a.length;i++)
			System.out.print(a[i] +" ");

	}

}
