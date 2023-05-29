import java.util.ArrayList;
import java.util.List;

/*
 * 
 * The problem is to count all the possible paths from top left to bottom right of a mXn matrix with 
 * the constraints that from each cell you can either move only to right or down
 * 
 * Example : 
Input :  m = 2, n = 2;
Output : 2
There are two paths
(0, 0) -> (0, 1) -> (1, 1)
(0, 0) -> (1, 0) -> (1, 1)

Input :  m = 2, n = 3;
Output : 3
There are three paths
(0, 0) -> (0, 1) -> (0, 2) -> (1, 2)
(0, 0) -> (0, 1) -> (1, 1) -> (1, 2)
(0, 0) -> (1, 0) -> (1, 1) -> (1, 2)
 * 
 */


public class NoOfPath {

	static int numOfPath(int m,int n)
	{
		if(m == 1 || n ==1)
			return 1;
		
		return numOfPath(m -1, n) + numOfPath(m, n -1);
	}
	
	
	/*The problem is to print all the possible paths from top left to bottom right of a mXn matrix with the constraints that from each cell you can either move only to right or down.

	Examples :

	Input : 1 2 3
	        4 5 6
	Output : 1 4 5 6
	         1 2 5 6
	         1 2 3 6
	         */
	/* mat:  Pointer to the starting of mXn matrix 
	   i, j: Current position of the robot (For the first call use 0,0) 
	   m, n: Dimentions of given the matrix 
	   idx:   Next index to be filed in path array 
	   *path[0..idx-1]: The path traversed by robot till now (Array to hold the 
	                  path need to have space for at least m+n elements) */
	    private static void printPath(int mat[][], int m, int n, 
	                                    int i, int j, int path[], int idx) 
	    { 
	        path[idx] = mat[i][j]; 
	          
	         // Reached the bottom of the matrix so we are left with 
	        // only option to move right 
	        if (i == m - 1)  
	        { 
	            for (int k = j + 1; k < n; k++) 
	            { 
	                path[idx + k - j] = mat[i][k]; 
	            } 
	            for (int l = 0; l < idx + n - j; l++)  
	            { 
	                System.out.print(path[l] + " "); 
	            } 
	            System.out.println(); 
	            return; 
	        } 
	          
	        // Reached the right corner of the matrix we are left with 
	        // only the downward movement. 
	        if (j == n - 1)  
	        { 
	            for (int k = i + 1; k < m; k++)  
	            { 
	                path[idx + k - i] = mat[k][j]; 
	            } 
	            for (int l = 0; l < idx + m - i; l++)  
	            { 
	                System.out.print(path[l] + " "); 
	            } 
	            System.out.println(); 
	            return; 
	        } 
	        // Print all the paths that are possible after moving down 
	        printPath(mat, m, n, i + 1, j, path, idx + 1); 
	  
	         // Print all the paths that are possible after moving right 
	        printPath(mat, m, n, i, j + 1, path, idx + 1); 
	    }
	public static void main(String[] args) {
		
		System.out.println(numOfPath(3,3));
		
		int m = 2; 
        int n = 3; 
            
        int mat[][] = { { 1, 2, 3 },  
                        { 4, 5, 6 } }; 
        int maxLengthOfPath = m + n - 1; 
        printPath(mat, m, n, 0, 0, new int[maxLengthOfPath], 0); 

	}

}
