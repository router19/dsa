/*
 * A Maze is given as N*N binary matrix of blocks where source block is the upper left most block 
 * i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. 
 * A rat starts from source and has to reach the destination. The rat can move only in two directions: forward and down.
   In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path from source to
    destination
 * 
 * 
 */

/* Java program to solve Rat in a Maze problem using backtracking */
public class RatMazeUsingBackTracking {
	
	//rows
	static int m;
	//columns
	static int n;
	
	//Print solution matrix
	static void printSolution(int sol[][])
	{
		for(int i =0;i < m ;i++)
		{
			for(int j =0;j<n;j++)
				System.out.print(sol[i][j] + " ");
			System.out.println();
		}
			
	}
	
	static boolean isSafe(int maze[][],int x,int y)
	{
		return (x >=0 && x <m && y>=0 && y < n && maze[x][y] == 1);
	}
	
	/* This function solves the Maze problem using  
    Backtracking. It mainly uses solveMazeUtil()  
    to solve the problem. It returns false if no  
    path is possible, otherwise return true and  
    prints the path in the form of 1s. Please note  
    that there may be more than one solutions, this  
    function prints one of the feasible solutions.*/
    
	static boolean solveMaze(int maze[][])
	{
		
		 m= maze.length;
		 n = maze[0].length;
		int sol[][] = new int[m][n];
		
		if(solveMazeUtil(maze,0,0,sol) == false)
		{
			System.out.println("No Solution found");
			return false;
		}
		
		printSolution(sol);
		return true;
		
	}
	
	
	static boolean solveMazeUtil(int maze[][],int x,int y,int sol[][])
	{
		// if (x, y is goal) return true 
		if(x== m-1 && y == n-1)
		{
			sol[x][y] = 1;
			return true;
		}
		
		if(isSafe(maze,x,y))
		{
			
			sol[x][y] = 1;
			
			/* Move forward in x direction */
			if(solveMazeUtil(maze, x +1, y, sol))
				return true;
			
			/* If moving in x direction doesn't give  
            solution then Move down in y direction */
			if(solveMazeUtil(maze, x, y+1, sol))
				return true;
			
			/* If none of the above movements works then  
            BACKTRACK: unmark x, y as part of solution  
            path */
			sol[x][y] = 0;
			
			return false;
						
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		//0 means roadblock and 1 means path allowed
		int maze[][] = { { 1, 0, 0, 0 }, 
						 { 1, 1, 0, 1 }, 
						 { 1, 1, 0, 0 }, 
						 { 1, 1, 1, 1 } }; 

 
		solveMaze(maze); 
	}

}
