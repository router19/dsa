import java.util.ArrayList;

public class BuyAndSellStock {
	class Interval{
		 int buy,sell;
	}
	
	 void buyAndSell(int prices[],int n)
	{
		if(n == 1)
			return;
		
		int i = 0,count=0;
		ArrayList<Interval> sol = new ArrayList<Interval>();
		
		while(i < n-1)
		{
			while(i < n-1 && prices[i+1] <= prices[i] )
				i++;
			
			if(i == n-1)
				break;
			
			Interval e = new Interval();
			//store the minima
			e.buy = i++;
			
			while(i < n && prices[i] >= prices[i-1])
				i++;
			
			//ith price is less, hence sell at highest price i.e. at i-1
			//storing local maxima
			e.sell = i-1;
			
			sol.add(e);
			
			count++;
		}
		if(count == 0 )
			System.out.println("There is no day when buying stock will make profit");
		else
		{
			for(int j = 0; j < count ; j++)
			{
				System.out.println("Buy on day " + sol.get(j).buy + 
						" and sell on day  " + sol.get(j).sell);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuyAndSellStock stock = new BuyAndSellStock();
		// stock prices on consecutive days 
        int price[] = { 100, 180, 260, 310, 40, 535, 695 }; 
        int n = price.length; 
        stock.buyAndSell(price, n);
	}

}
