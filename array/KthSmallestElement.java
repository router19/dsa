import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallestElement {

	static int findKthSmallestElement(int a[],int k)
	{
		PriorityQueue<Integer>  q = new PriorityQueue<Integer>();
		
		
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 int t,a[],n,k,i;
		 Scanner in = new Scanner(System.in);
		 t = in.nextInt();
		 PriorityQueue<Integer> queue;
		 while(t-- > 0)
		 {
			 n = in.nextInt();
			 queue = new PriorityQueue<Integer>();
			 a = new int[n];
			 
			 for(i=0;i<n;i++)
				 queue.offer(in.nextInt());
			 
			 k= in.nextInt();
			 while(k-- > 1)
				 queue.poll();
			 
			 System.out.println(queue.poll());
		 }

	}

}
