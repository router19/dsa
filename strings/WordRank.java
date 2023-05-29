/*
 * Not Solved yet
 */
import java.util.Arrays;
import java.util.Scanner;

public class WordRank {

	static int factorial(int n)
	{
		if(n == 1)
			return 1;
		return n * factorial(n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int t;
		Scanner in = new Scanner(System.in);
		String s;
		char c[];
		int a[] = new int[26];
		int combination,element;
		t = in.nextInt();
		while(t-- > 0 )
		{
			in.nextLine();
			s= in.nextLine();
			c = s.toCharArray();
			combination = factorial(c.length);
			Arrays.sort(c);
			for(int i =0; i < c.length; i ++)
			{
				a[c[i] - 'a']++;
			}
		
			for(int i = 0; i < c.length;i ++)
			{
				if(a[c[i] - 'a'] > 1)
					combination = combination /factorial(a[c[i]- 'a']);
			}
			
			element = in.nextInt();
			
		}

	}

}
