import java.util.Arrays;

public class GeneralizedGCD {

	static int prime[] = new int[100];
	 static int gcd(int a, int b) 
	    { 
	        if (a == 0) 
	            return b; 
	        return gcd(b % a, a); 
	    } 
	  
	    // Function to find gcd of array of 
	    // numbers 
	    static int findGCD(int arr[], int n) 
	    { 
	        int result = arr[0]; 
	        for (int i = 1; i < n; i++) 
	            result = gcd(arr[i], result); 
	  
	        return result; 
	    } 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,3,7,5,11};
		System.out.println(findGCD(a,a.length));
	}

}
