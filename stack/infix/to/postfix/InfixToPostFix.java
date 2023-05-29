
/*
 * 
 * ***** SEE Below for Infix to Prefix
 * Infix to Prefix : 
 * 
    Step 1: Reverse the infix expression i.e A+B*C will become C*B+A. Note while reversing each ‘(‘ will become ‘)’ and each ‘)’ becomes ‘(‘.
    Step 2: Obtain the postfix expression of the modified expression i.e CB*A+.
    Step 3: Reverse the postfix expression. Hence in our example prefix is +A*BC.

 * 
 */
package infix.to.postfix;
import java.util.Stack;

public class InfixToPostFix {

	static int precedence(char c)
	{
		switch(c)
		{
			case '+':
			case '-':
				return 1;
			
			case '*':
			case '/':
				return 2;
			
			case '^':
				return 3;
		
		}
		return -1;	
	}
	
	static String infixToPostFix(String exp)
	{
		StringBuilder result = new StringBuilder();
		
		Stack<Character> stack = new Stack<>();
		char c;
		for(int i=0; i < exp.length();i++)
		{
			c = exp.charAt(i);
			
			if(Character.isLetterOrDigit(c))
				result.append(c);
			
			else if(c=='(')
				stack.push(c);
			
			else if(c==')')
			{
				while(!stack.isEmpty() && stack.peek() !='(')
					result.append(stack.pop());
				
				if(!stack.isEmpty() && stack.peek() != '(')
					return "Invalid Expression";
				else
					stack.pop();
			}
			else
			{
				while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
				{
					if(stack.peek() == '(')
						return "Inavlid Expression";
					result.append(stack.pop());
				}
				stack.push(c);
			}			
			
		}
		while(!stack.isEmpty())
		{
			if(stack.peek() == '(')
				return "Inavlid Expression";
			result.append(stack.pop());
		}
		
		return result.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp = "a+b*(c^d-e)^(f+g*h)-i"; 
//		String exp = "a*b";
        System.out.println(infixToPostFix(exp)); 
	}

}
