import java.util.Stack;

public class GetMinmElementUsingStack {

	static int min = Integer.MIN_VALUE;
	static Stack<Integer> s = new Stack<>();
	
	static int getMin()
	{
		if(s.isEmpty())
			return Integer.MIN_VALUE;
		return min;
	}
	
	static int pop()
	{
		if(s.isEmpty())
			return Integer.MIN_VALUE;
		int y = s.peek();
		if(y>= min)
		{
			s.pop();
			return y;
		}
		else
		{
			int t = min;//real number which wasn't inserted.
			//e.g. 4 5 3 as i/p -> stack becomes 4 5 2 on insertion with min = 3; 
			//when we have to pop , we need to return 3 as a correspodence to y =2, n next min = 4
			min = 2* min - y;
			
			return t;
		}
	}
	static void push(int x)
	{
		if(s.isEmpty())
		{
			s.push(x);
			min = x;
			
		}
		else
		{
			if(x >= min)
				s.push(x);
			else
			{
				//inserting 2*x - min so that once we pop an element which is min , we could 
				//easily find next min.
				s.push(2 * x - min);
				min = x;
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
