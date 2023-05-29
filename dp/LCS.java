//find the longest common subsequence if given two sequences 
//LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
//LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

public class LCS {

	static int lcs(char x[],char y[],int m, int n)
	{
		if(m == 0 || n ==0)
			return 0;
		if(x[m-1] == y[n-1])
			return 1+ lcs(x,y,m-1,n-1);
		else
			return Math.max(lcs(x,y,m-1,n), lcs(x,y,m,n-1));
	}
	
	//using dynamic programming concept
	static int DPLCS(char x[],char y[],int m,int n)
	{
		int L[][] = new int[m+1][n+1];
		
		for(int i = 0; i <= m ;i++)
		{
			for(int j = 0; j <= n;j++)
			{
				if(i == 0 || j== 0)
					L[i][j] = 0;
				else if (x[i-1] == y[j-1] )
					L[i][j] = 1 + L[i-1][j-1];
				else
					L[i][j] = Math.max(L[i-1][j],L[i][j-1]);
			}
		}
		//if we need to return the count then we can just return the count.
		// Following code is used to print LCS 
        int index = L[m][n]; 
        int temp = index; 
   
        // Create a character array to store the lcs string 
        char[] lcs = new char[index+1]; 
        lcs[index] = ' '; // Set the terminating character 
   
        // Start from the right-most-bottom-most corner and 
        // one by one store characters in lcs[] 
        int i = m, j = n; 
        while (i > 0 && j > 0) 
        { 
            // If current character in X[] and Y are same, then 
            // current character is part of LCS 
            if (x[i-1] == y[j-1]) 
            { 
                // Put current character in result 
                lcs[index-1] = x[i-1];  
                  
                // reduce values of i, j and index 
                i--;  
                j--;  
                index--;      
            } 
   
            // If not same, then find the larger of two and 
            // go in the direction of larger value 
            else if (L[i-1][j] > L[i][j-1]) 
                i--; 
            else
                j--; 
        } 
   
        // Print the lcs 
        System.out.print("LCS of "+new String(x)+" and "+new String(y)+" is "); 
        for(int k=0;k<=temp;k++) 
            System.out.print(lcs[k]); 
		
		return L[m][n];
	}
	
	
	public static void main(String[] args) {
		String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB"; 
	  
	    char[] X=s1.toCharArray(); 
	    char[] Y=s2.toCharArray(); 
	    int m = X.length; 
	    int n = Y.length; 
	    
	    System.out.println("LCS is of length "+ lcs(X,Y,m,n));
	    System.out.println("LCS is of length "+ DPLCS(X,Y,m,n));

	}

}
