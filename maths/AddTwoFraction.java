
public class AddTwoFraction {
	
	static int gcd(int a,int b)
	{
		if(a == 0)
			return b;
		return gcd(b%a,a);
	}
	public static void fraction(int a[],int b[])
	{
		
		int den = gcd(a[1],b[1]);
		//LCM * gcd = a* b
		den = (a[1] * b[1] )/den;
		
		int num = (a[0] * den/a[1] ) + (b[0] * den/b[1]);
		
		int common_factor = gcd ( num,den);
		
		System.out.println(num/common_factor +"/" + den/common_factor);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {1,500};
		int b[]  = {2,1500};
		System.out.print("The new fraction is " );
		fraction(a,b);
	}

}
