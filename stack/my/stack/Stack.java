package my.stack;

public class Stack {

	char items[];
	int top;
	
	public Stack(int size)
	{
		items = new char[size];
		top = -1;		
	}
	
	void push(char x)
	{
		if(top ==99)
		{
			System.out.println("Stack Full");
		}
		else
		{
			items[++top] = x;
		}
		
	}
	
	char pop()
	{
		if(top == -1)
		{
			System.out.println("Underflow error");
			return '\0';
		}
		else
		{
			char element = items[top--];
			return element;
		}
		
	}
	
	boolean isEmpty() {
		return (top == -1) ? true: false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c[] = {'[','{','(',')','}',']'}; 
		
	}

}
