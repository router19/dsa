import java.util.Stack;

/*
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element 
on the right side of x in array. Elements for which no greater element exist, consider next greater element as -1.

Examples:

    For any array, rightmost element always has next greater element as -1.
    For an array which is sorted in decreasing order, all elements have next greater element as -1.
    For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.

Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1

 */


/*
 * SOLUTION 
 * 
    1. Push the first element to stack.
    2. Pick rest of the elements one by one and follow the following steps in loop.
       i) Mark the current element as next.
       ii) If stack is not empty, compare top element of stack with next.
       iii) If next is greater than the top element,Pop element from stack. next is the next greater element for the popped element.
       iv) Keep popping from the stack while the popped element is smaller than next. next becomes the next greater element for all such popped elements
    3. Finally, p	ush the next in the stack.
    4. After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.

 */

public class NextGreaterElement {

	/* prints element and NGE pair for  
    all elements of arr[] of size n */
	
	//Time complexity O(n)
	//*****  But does not print in same order ****
	public static void nge(int a[]) {
		
		Stack<Integer> s = new Stack<Integer>();
		
		/* push the first element to stack */
		s.push(a[0]);
		
		int next = -1,element;
		
		for(int i = 1; i < a.length; i++)
		{
			next = a[i];
			if(!s.isEmpty())
			{
				// if stack is not empty, then  
                // pop an element from stack 
				element = s.pop();
				
				/* If the popped element is smaller than  
                next, then a) print the pair b) keep  
                popping while elements are smaller and  
                stack is not empty */
				while(element < next)
				{
					System.out.println(element +" -> "+next);
					if(s.isEmpty())
						break;
					element = s.pop();
				}
				
				/* If element is greater than next, then  
                push the element back */
				if(element > next)
					s.push(element);
			}
			/* push next to stack so that we can find next 
            greater for it */
			s.push(next);
		}
		
		/* After iterating over the loop, the remaining  
        elements in stack do not have the next greater  
        element, so print -1 for them */
		while(!s.isEmpty())
		{
			next = -1;
			System.out.println(s.pop() +" -> "+ next);
		}
	}
	//The idea is to start from last instead.
	static void ngeInSameOrder(int a[])
	{
		int a1[] = new int[a.length];
		Stack<Integer> s = new Stack<Integer>();
		
		for(int i =  a.length -1 ;i >=0 ; i--)
		{
			while(!s.isEmpty() && s.peek() <= a[i])
				s.pop();
			
			if(s.isEmpty())
				a1[i] = -1;
			else
				a1[i] = s.peek();
			s.push(a[i]);	
		}
		for(int i=0;i< a.length; i++)
			System.out.println(a[i] +" -> " + a1[i]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a1[] = {4,3,2,1};
		int a2[] = {1,2,5,2,1,8,1};
//		nge(a1);
		ngeInSameOrder(a2);
	}

}
