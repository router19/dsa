import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallestElement {
	
	public static void kSmallestElements(int[] arr, int k)
	  
	{
	    // Max heap
	    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
	        Collections.reverseOrder());
	    if (k >= arr.length) {
	        for (int i : arr)
	            System.out.print(i + " ");
	        return;
	    }
	  
	    for (int i = 0; i < k; i++) {
	        pq.add(arr[i]);
	    }
	  
	    for (int i = k; i < arr.length; i++) {
	        int max = pq.peek();
	        if (arr[i] < max) {
	            pq.poll();
	            pq.add(arr[i]);
	        }
	    }
	  
	    for (int i = 0; i < k; i++) {
	        System.out.print(pq.poll() + " ");
	    }
	}
	public static void kSmallElements(int[] a, int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue();
		for(int i: a)
		{
			pq.add(i);			
		}
		
		for(int i =0; i< k;i++)
			System.out.println(pq.poll());
		
		
	}
	public static void main(String[] args) {
		int [] a = {6,3,6,2,2,4,7};
		kSmallElements(a,4);
		kSmallestElements(a,4);
	}

}
