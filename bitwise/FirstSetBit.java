
public class FirstSetBit {

	static int firstbit(int n)
	{
		if( n == 0)
			return -1;
		int position = 1;
		int m = 1;
		
		while((n & m) == 0)
		{
			m = m << 1;
			position++;
		}
		return position;
		
		
	}
	public static void main(String[] args) {
		// 
		//n = 10 , 1010, n-1 = 9 (1001)  , ~(n-1) = 0110   => n& ~(n-1) = 0010
		int n = 8;//1000
		int c = ~(n-1); // n-1 = 0111 , ~(n-1) = 1000
		
		//n & ~(n-1) = 1000 , which is 2^3 , hence when we do log2(1000) we get 3 , 
		//hence first set bit is log2( n & ~(n-1))  + 1 , as written below 
		System.out.println("O(1) approach : First set bit is " + (int)(Math.log(n & ~(n-1))/Math.log(2) + 1));
		
		System.out.println("O(n) approach , first set bit is "+ firstbit(n));

	}

}
