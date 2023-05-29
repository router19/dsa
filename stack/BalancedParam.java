import java.util.Stack;

public class BalancedParam {

	boolean matchingParam(char a,char b)
	{
		if(a == '[' && b == ']')
			return true;
		else if(a == '{' && b == '}')
			return true;
		else if(a == '(' && b == ')')
			return true;
		
		return false;
	}
	
	boolean isBalanced(char c[])
	{
		Stack<Character> s = new Stack<>();
		
		for(int i=0;i < c.length;i++)
		{
			if(c[i] == '[' || c[i] == '{' || c[i] == '(')
				s.push(c[i]);
			
			if(c[i] == ']' || c[i] == '}' || c[i] == ')')
			{
				if(s.isEmpty())
					return false;
				
				else if(!matchingParam(s.pop(),c[i]))
				{
					return false;
				}
			}
		}
		
		if(s.isEmpty())
			return true;
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c[] = {'[','{','(',')',')','}',']'};
		BalancedParam bm = new BalancedParam();
		if(bm.isBalanced(c))
			System.out.println("Balanced");
		else
			System.out.println("Not Balanced");
	}

}
