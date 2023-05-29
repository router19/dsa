

/**
Algorithm
 Sort an arr[] of size n
insertionSort(arr, n)
Loop from i = 1 to n-1.
……a) Pick element arr[i] and insert it into sorted sequence arr[0…i-1] 

 */
public class InserionSort {

	static void sort(int a[]) {
		for (int i = 1; i < a.length;i++) {
			int j = i-1;
			int key = a[i];
			
			/* Move elements of arr[0..i-1], that are 
            greater than key, to one position ahead 
            of their current position */
			
			while(j>=0 && a[j] > key) {
				a[j+1] = a[j];
				j= j-1;
			}
			a[j+1] = key;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {12,2,6,89,10,14,18,4,2,2,2,4,4,4};
		sort(a);
		
		for(int i =0; i < a.length;i++)
			System.out.print(a[i] + " ");
	}

}
