/*
Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value
 in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and
 weights associated with n items respectively. Also given an integer W which represents knapsack capacity, 
 find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
public class KnapSackProblem {

	//Time complexity of this naive recursive solution is exponential (2^n).
	static int knapSackRec(int W,int wt[],int val[],int n)
	{
		if(W== 0 || n== 0)
			return 0;
		if(wt[n-1] > W)
			return knapSackRec(W, wt, val, n-1);
		else
			return Math.max(knapSackRec(W, wt, val, n-1), val[n-1] + knapSackRec(W-wt[n-1], wt, val, n-1));
	}
	
	//Time Complexity: O(nW) where n is the number of items and W is the capacity of knapsack.
	static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int i, w; 
     int K[][] = new int[n+1][W+1]; 
       
     // Build table K[][] in bottom up manner 
     for (i = 0; i <= n; i++) 
     { 
         for (w = 0; w <= W; w++) 
         { 
             if (i==0 || w==0) 
                  K[i][w] = 0; 
             else if (wt[i-1] <= w) 
                   K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]); 
             else
                   K[i][w] = K[i-1][w]; 
         } 
      } 
       
      return K[n][W]; 
    } 
	public static void main(String[] args) {
		
		int val[] = {60,100,120};
		int wt[] =  {10,30, 20};
		//weight of the knapsack
		int W = 50;
		
		System.out.println("knapsack can have max value of "+ knapSack(W,wt,val,val.length));
		System.out.println("knapsack can have max value of "+ knapSackRec(W,wt,val,val.length));
	}

}
