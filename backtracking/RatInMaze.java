/*
 * Given a maze with obstacles, count number of paths to reach rightmost-bottommost cell from topmost-leftmost cell. A cell in given maze has value -1 if it is a blockage or dead end, else 0.

From a given cell, we are allowed to move to cells (i+1, j) and (i, j+1) only.


Algorithm : O(R x C)

We can recursively compute grid[i][j] using below 
formula and finally return grid[R-1][C-1]

  // If current cell is a blockage
  if (maze[i][j] == -1)
      maze[i][j] = -1; //  Do not change

  // If we can reach maze[i][j] from maze[i-1][j]
  // then increment count.
  else if (maze[i-1][j] > 0)
      maze[i][j] = (maze[i][j] + maze[i-1][j]);

  // If we can reach maze[i][j] from maze[i][j-1]
  // then increment count.
  else if (maze[i][j-1] > 0)
      maze[i][j] = (maze[i][j] + maze[i][j-1]);
      
      
##### PLEASE NOTE : THIS IS NOT ESSENTIALLY A BACKTRACKING SOLUTION #####
### We do not backtrack at all .      
 */


public class RatInMaze {

	static int countPaths(int maze[][])
	{
		int i,C= maze[0].length,R= maze.length;
		if(maze[0][0] == -1)
			return 0;
		
		//fill the first column
		for(i=0; i < C; i ++ )
		{
			// If we encounter a blocked cell  
            // in leftmost row, there is no way  
            // of visiting any cell directly below it. 
			if(maze[i][0] == -1)
				break;
			else
				maze[i][0] =1;
			
		}
		
		//fill the first column
		for(i=0; i < R; i ++ )
		{
			// If we encounter a blocked cell  
            // in leftmost row, there is no way  
            // of visiting any cell directly below it. 
			if(maze[0][i] == -1)
				break;
			else
				maze[0][i] =1;			
		}
		
		for(i =1; i < R; i++)
		{
			for(int j=1; j < C; j++)
			{
				if(maze[i][j] == -1)
					continue;
				
				// If we can reach maze[i][j] from  
                // maze[i-1][j] then increment count. 
				if(maze[i-1][j] > 0)
					maze[i][j] += maze[i-1][j];
				
				// If we can reach maze[i][j] from 
                //  maze[i][j-1] then increment count. 
				if(maze[i][j-1] > 0)
					maze[i][j] += maze[i][j-1];
				
			}
		}
			
		return (maze[R-1][C-1] > 0 ? maze[R-1][C-1] : 0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int maze[][] = {{0, 0, 0, 0}, 
                {0, -1, 0, 0}, 
                {-1, 0, 0, 0}, 
                {0, 0, 0, 0}}; 
		System.out.println (countPaths(maze)); 
		
	}

}
