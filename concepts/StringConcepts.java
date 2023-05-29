
public class StringConcepts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String s = "We love to hack on hack";
		//System.out.println(14 + s.substring(14,s.length()).indexOf("hack"));
		
		String s2 = "hack";
		int I = 14;
		String s1 = s.substring(I, s.length());
		System.out.println("substring is "+s1 );
		int index = s.substring(I, s.length()).indexOf(s2);
		System.out.println(index);
		System.out.println(s1.charAt(index -1));
		if(index == 0 || s1.charAt(index -1) == ' ' && 
				((index + I + s2.length() == s.length()) || s1.charAt(index + s2.length()) == ' ') )
			System.out.println(I + index);
		else
			System.out.println("bbye");*/
		
		String str = "aabcccabba";
		//aabcc cabba
		int len = str.length();
		String left = str.substring(0,len/2);
		String right = str.substring(len/2,len);
		System.out.println("left is "+ left);
		System.out.println("right is "+ right);
		
		str = right + left;
		System.out.println(str);
		int r = right.length() -1;
		int l = 0;
		while(true)
		{
			if(right.charAt(r) == left.charAt(l))
			{
				//System.out.println(right.charAt(r));
				
				char c = right.charAt(r);
				r--;l++;
				while(right.charAt(r) == c)
					r--;
				while(left.charAt(l) == c)
					l++;
				System.out.println("right os "+ right.substring(0, r+1));
				str = right.substring(0, r+1) + left.substring(l, left.length());
				System.out.println("str is "+ str);
				len = str.length();
				right = str.substring(0,len/2);
				left = str.substring(len/2,len);
				r = right.length() -1;;
				l = 0;
				//System.out.println(right.substring(0, r+1) + left.substring(l, left.length()));
			}
			else
				break;
		}
		System.out.println("final str is "+ str);
		
	}

}
