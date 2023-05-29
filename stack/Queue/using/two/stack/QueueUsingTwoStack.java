package Queue.using.two.stack;


/* ALGORITHM
 * 
 * enQueue(q,  x)
  1) Push x to s1 (assuming size of stacks is unlimited).
Here time complexity will be O(1)

deQueue(q)
  1) If both stacks are empty then error.
  2) If s2 is empty
       While s1 is not empty, push everything from s1 to s2.
  3) Pop the element from s2 and return it.
  4) Now push all elements from s2 to s1
Here time complexity will be O(n)

OR

enQueue(q, x)
  1) While s1 is not empty, push everything from s1 to s2.
  2) Push x to s1 (assuming size of stacks is unlimited).
  3) Push everything back to s1.
Here time complexity will be O(n)

deQueue(q)
  1) If s1 is empty then error
  2) Pop an item from s1 and return it
Here time complexity will be O(1)
 */
import java.util.Stack;

public class QueueUsingTwoStack {
	
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	void insert(int B)
	{
		s1.push(B);
	}
	
	int remove()
	{
		if(s2.isEmpty())
		{
			if(s1.isEmpty())
				return -1;
			
			
			while(!s1.isEmpty())
			{
				int r = s1.peek();
				s1.pop();
				s2.push(r);
			}
			int k = s2.peek();
			s2.pop();
			
			while(!s2.isEmpty())
			{
				int l = s2.peek();
				s2.pop();
				s1.push(l);
			}
			return k;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
