import java.util.Arrays;

/*
 Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm}
  valued coins, how many ways can we make the change? The order of coins doesn�t matter.

For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
  So the output should be 5.
 */
public class CoinChangeProblem {

	
	static int countWays(int coins[],int total)
	{
		int m = coins.length;
		
		//table to store the no of ways jth value can be achieved using coins in coins array
		int table[] = new int[total+1];
		
		//initialize the table array with zero
		Arrays.fill(table, 0);
		
		//0 value can be achived by using 0 coins, so 1 way.
		table[0] = 1;
		
		//now for each coin in coins array
		//the no of way jth value can be achieved is 
		//table[j] = table[j] + table[j-coins[i]]
		//e.g. 
		//for coin = 1, any j value can be achieved using 1 way as (1),(1,1,...j)
		//now for coin = 2, any j value can be achieved  = no of ways j value can be achieved using 1 and 2
		// for j = 2 => no of ways using coin 1 is 1 and 1 more way using coin 2 ..
		//here is the code
		for(int i =0; i < m ;i++)
		{
			//we start j with coins[i], because there is no new way to achieve j <= coins[i], 
			//e.g. we cant get value 3 using coins less than 3
			for(int j = coins[i];j <=total;j++)
			{
				table[j] = table[j] + table[j-coins[i]];
			}
		}
		
		return table[total];
	}
	
	
	static int minNoOfWays(int coins[],int total)
	{
		int[] table = new int[total+1];
		int coinsTable[] = new int[total+1];
		
		Arrays.fill(table, Integer.MAX_VALUE -1);
		Arrays.fill(coinsTable, -1);
		table[0] =0;
		for(int i=0;i <coins.length;i++)
		{
			for(int j = coins[i]; j <=total;j++)
			{
				if(table[j-coins[i]] + 1 < table[j])
				{
					table[j] = 1 + table[j-coins[i]];
					coinsTable[j] = i;
				}
			}
		}
		System.out.println("Coins used to form total "+ total + " is :");
		printCoinCombination(coins,coinsTable);
		return table[total];
	}
	
	static void printCoinCombination(int coins[],int[] coinsTable)
	{
		if(coinsTable[coinsTable.length -1] == -1)
		{
			System.out.println("No solution exists");
			return;
		}
		int start = coinsTable.length -1;
		
		while(start != 0)
		{
			int j = coinsTable[start];
			System.out.print(coins[j] + " ");
			start = start - coins[j];
		}
		System.out.println();
	}
	public static void main(String[] args) {
		
		int coins[] = {1,2,3};
		int ntotal = 4;
		System.out.println("Total no of ways coins can be print is "+ countWays(coins,ntotal));
		
		//System.out.println("Minm no ways to achieve "+ntotal + " is "+ minNoOfWays(coins, ntotal));
		//min no of ways to achieve a total
		//
		int m_coins[] = {7,2,3,6};
		int total = 13;
		System.out.println("Minm no ways to achieve "+total + " is "+ minNoOfWays(m_coins, total));
	}

}
