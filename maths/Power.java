/*
 * Given a number N, let the reverse of the number be R. The task is to print the output of the Expression pow(N,R),
 where pow function represents N raised to power R.
Note: As answers can be very large, print the result modulo 1000000007.
Example:
Input:
2
2
12

Output:
4
864354781

Explanation:
Testcase 1: The reverse of 2 is 2 and after raising power of 2 by 2 we get 4 which gives remainder as 4 by dividing 1000000007.
 */
import java.math.BigInteger;
import java.util.Scanner;

public class Power {

	static int getReverse(int n)
    {
        int r = 0;
        
        while(n > 0)
        {
            r = r * 10 + (n % 10);
            n = n/10;
        }
        
        return r;
    }
    
    static long getPowerOfNumbers(int n, int p)
    {
        int rev = 1;
        long r = 1;
        long c = n;
        
        if(p == 0)
        {
            return 1;
        }
        if(p == 1)
        {
            return c;
        }
        
        if(p < 0)
        {
            p = p * -1;
            rev = -1;
        }
        
        while(p > 0)
        {
            if((p&1) == 1 && rev == 1)
            {
                r = (r * c) % 100000007;
            }
            else if((p&1) == 1 && rev == -1)
            {
                r = r/n;
            }
            
            p = p >> 1;
            c = (c * c) % 100000007;
        }
        
        return r;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int n,r;
		
		while(t-- > 0) {
			n = in.nextInt();
			r = getReverse(n);
			System.out.println(getPowerOfNumbers(n, r));
		}
	}

}
