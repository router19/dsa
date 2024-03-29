/*
In MS-Paint, when we take the brush to a pixel and click, the color of the region of that pixel is replaced with a new selected color. Following is the problem statement to do this task.
Given a 2D screen, location of a pixel in the screen and a color, replace color of the given pixel and all adjacent same colored pixels with the given color.

Example:

Input:
       screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},
                      {1, 1, 1, 1, 1, 1, 0, 0},
                      {1, 0, 0, 1, 1, 0, 1, 1},
                      {1, 2, 2, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 0, 1, 0},
                      {1, 1, 1, 2, 2, 2, 2, 0},
                      {1, 1, 1, 1, 1, 2, 1, 1},
                      {1, 1, 1, 1, 1, 2, 2, 1},
                      };
    x = 4, y = 4, newColor = 3
The values in the given 2D screen indicate colors of the pixels.
x and y are coordinates of the brush, newColor is the color that
should replace the previous color on screen[x][y] and all surrounding
pixels with same color.

Output:
Screen should be changed to following.
       screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},
                      {1, 1, 1, 1, 1, 1, 0, 0},
                      {1, 0, 0, 1, 1, 0, 1, 1},
                      {1, 3, 3, 3, 3, 0, 1, 0},
                      {1, 1, 1, 3, 3, 0, 1, 0},
                      {1, 1, 1, 3, 3, 3, 3, 0},
                      {1, 1, 1, 1, 1, 3, 1, 1},
                      {1, 1, 1, 1, 1, 3, 3, 1},
                      };
 
 
 
 */

public class FloodFillProblem {
	static int M = 8; 
	static int N = 8; 
	
	static public void floodFill(int [][] screen , int x, int y , int prevC,int newC)
	{
		if(x < 0 || y < 0 || x >= M || y >= N)
			return;
		
		if(screen[x][y] != prevC)
			return;
		
		screen[x][y] = newC;
		
		floodFill(screen, x-1, y, prevC, newC);
		floodFill(screen, x+1, y, prevC, newC);
		floodFill(screen, x, y -1, prevC, newC);
		floodFill(screen, x, y +1, prevC, newC);
		
	}
	static public void floodFill(int[][] screen, int x,int y, int newC)
	{
		int prevC = screen[x][y];
		floodFill(screen,x,y,prevC,newC);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1}, 
                {1, 1, 1, 1, 1, 1, 0, 0}, 
                {1, 0, 0, 1, 1, 0, 1, 1}, 
                {1, 2, 2, 2, 2, 0, 1, 0}, 
                {1, 1, 1, 2, 2, 0, 1, 0}, 
                {1, 1, 1, 2, 2, 2, 2, 0}, 
                {1, 1, 1, 1, 1, 2, 1, 1}, 
                {1, 1, 1, 1, 1, 2, 2, 1}, 
                }; 
		int x = 4, y = 4, newC = 3;
		floodFill(screen, x, y, newC);

		System.out.println("Updated screen after call to floodFill: ");
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(screen[i][j] + " ");
			System.out.println();
		}
	}

}
