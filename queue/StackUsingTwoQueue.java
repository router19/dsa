package stack.using.two.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueue {

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	
	int pop()
	{
	    // if first queue is not empty
		if(!q1.isEmpty())
		{
			// take out the front element from first queue
			int r = q1.peek();
			q1.remove();
			return r;
		}
		return -1;
	}
	
	void push(int a)
	{
		
		// pop all the elements from the first queue and push it into the second queue
		while(!q1.isEmpty())
		{
			int k = q1.peek();
			q1.remove();
			q2.add(k);
		}
		
		// adding the element to first queue
		q1.add(a);
		
		// while second queue is not empty
		while(!q2.isEmpty())
		{
			// take out the front element from second queue
			int k = q2.peek();
			q2.remove();
			q1.add(k);
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
