import java.util.Vector;

//Java program to find minimum steps to reach to 
//specific cell in minimum moves by Knight 
public class KnightMinimumStepToDestination {

	// Class for storing a cell's data
	static class cell {
		int x,y,dis;
		
		public cell(int x,int y,int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}
	static boolean isInside(int x,int y,int N) {
		if(x>=1 && x<=N && y>=1 && y<=N)
			return true;
		return false;
	}
	
	// Method returns minimum step 
    // to reach target position 
	static int minStepToTarget(int knightPos[],int targetPos[],int N)
	{
		// x and y direction, where a knight can move		
		int dx[] = {-2,-1,1,2,-2,-1,1,2};
		int dy[] = {-1,-2,-2,-1,1,2,2,1};
		
		boolean visited[][] = new boolean[N+1][N+1];
		
		// queue for storing states of knight in board
		Vector<cell> q = new Vector<>();
		
		// push starting position of knight with 0 distance
		q.add(new cell(knightPos[0],knightPos[1],0));
		
		// visit starting state 
		visited[knightPos[0]][knightPos[1]] = true;
		
		cell t;
		int x,y;
		
		// loop until we have one element in queue 
		while(!q.isEmpty())
		{
			t= q.firstElement();
			q.remove(0);
			
			// if current cell is equal to target cell, 
            // return its distance 
			if(t.x == targetPos[0] && t.y == targetPos[1])
				return t.dis;
			
			// loop for all reachable states
			for(int i=0;i<8;i++)
			{
				x = t.x + dx[i];
				y = t.y + dy[i];
				
				// If reachable state is not yet visited and 
                // inside board, push that state into queue 
				if(isInside(x, y, N) && !visited[x][y])
				{
					visited[x][y] = true;
					q.add(new cell(x, y, t.dis +1));
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	public static void main(String[] args) {
	 
	 int knightPos[] = {1,1};
	 int targetPos[] = {30,30};
	 int N =30;
	 System.out.println(minStepToTarget(knightPos, targetPos, N));
	 

	}

}
