
public class Atoi {

	static Integer atoi(String s)
	{
		if(s.length() == 0)
			return -1;
		int sign = 1;
		int i = 0;
		
		//handle whitespaces
		while(s.charAt(i) == ' ')
			i++;
		
		//handle sign
		if(s.charAt(i) == '-') {
			sign = -1;
			i++;
			if(s.length() == 1)
				return null;
		}
		int res = 0;
		
		for(;i<s.length();i++)
		{
			//handle valid input
			if(!Character.isDigit(s.charAt(i)))
				return  null;
			
			//handle overflow of int capacity 
			//Integer.Max_Value = 2147483647 , hence we check for s.charAt(i) - '0' > 7 for overflow
			if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && s.charAt(i) -'0' > 7))
			{
				if(sign == 1)
					return Integer.MAX_VALUE;
				else
					return Integer.MIN_VALUE;
							
			}
			res = res * 10 + s.charAt(i) - '0';
		}
			
		return res * sign;		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "2147483s64";
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MIN_VALUE);
		System.out.println(atoi(s));

	}

}
