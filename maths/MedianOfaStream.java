import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MedianOfaStream {

	//simplest Approach, see commented code for complete flow
	static int median(int a[],int n)
    {
        if(n == 1)
            return a[0];
        Arrays.sort(a,0,n);    
        if(n % 2 == 1)
           return a[n/2];
        else
        {
            int mid = n/2;
//            System.out.println("a[mid - 1]"+a[mid -1]);
//            System.out.println("a[mid]"+a[mid]);
            return (a[mid -1] + a[mid] ) /2;
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Simple solution but not acceptable
		int n;
		
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		int a[] = new int[n];
		int i =0;
		while(n-- > 0)
		{
		    a[i++] = in.nextInt();
		    System.out.println(median(a,i));
		}*/
		
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    
	    
/*
We can use a max heap on left side to represent elements that are less than effective median, and a min heap 
on right side to represent elements that are greater than effective median.

After processing an incoming element, the number of elements in heaps differ utmost by 1 element.
When both heaps contain same number of elements, we pick average of heaps root data as effective median. 
When the heaps are not balanced, we select effective median from the root of heap containing more elements.
 */
	    
	    //to store element a....median , ie. left sorted side
	    Queue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
	    
	    //to store median ... z , ie. right of median side of the array
	    
	    //for e.g. for input stream 5 15 1 20 --> max heap will contain 5 , then ...
	    //atlast [5,1] and min heap will have [15,20]
	    Queue<Integer> min_heap = new PriorityQueue<>();
	    for(int i = 0; i < n; i++)
	    {
	        int e = sc.nextInt();
	        
	        max_heap.add(e);
	        min_heap.add(max_heap.poll());
	        if(max_heap.size() < min_heap.size())
	            max_heap.add(min_heap.poll());
	            
	       if(max_heap.size() == min_heap.size())
	            System.out.println((max_heap.peek() + min_heap.peek())/2);
	       else
	            System.out.println(max_heap.peek());
	    }
	}

}
