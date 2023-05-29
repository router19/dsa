import java.util.Queue;

public class Fibonacci {
	
	/**
	 *  Method to calculate and return the 
	 *  product of first n terms of fibonacci series
	 * @param n  the number upto which product is required.
	 * @return  the product of n terms of a fibonacci series
	 */
	static int product_of_fib(int n) 
    { 
       
		if(n <0)
        	return Integer.MIN_VALUE;
        if(n ==1 || n ==2)
        	return 1;
		int f1 = 1;//F[1] = 1
        int f2 = 1;//F[2] = 1
        int fn;//to get the F[n]
        int prod_fn=1; // stores the product if n fibonacci terms 
        if (n == 0) 
            return f1; 
        for (int i = 3; i <= n; i++) 
        { 
            fn = f1 + f2;
            prod_fn *= fn;
            f1 = f2; 
            f2 = fn; 
        } 
        return prod_fn; 
    } 
	public static void main(String[] args) {
		
		int n=2;
		System.out.println(product_of_fib(n));
	}

}
