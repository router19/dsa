import java.util.HashSet;
import java.util.Scanner;

//Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals 
//the third element.
public class ArrayTriplets {
	
	static int countTriplets(int a[])
	{
		HashSet<Integer> hash = new HashSet<Integer>();
		int n = a.length;
		int count = 0;
		for(int i =0;i < n ; i++)
		{
			hash.add(a[i]);
		}
		
		for(int i =0;i < n-1 ; i++)
		{
			for(int j =i+1; j < n;j++ )
			{
				if(hash.contains(a[i] + a[j]) )
					count++;
			}
		}
		
		if(count != 0)
			return count;
		
		return -1;
				
	}

	public static void main(String[] args) {
				
		Scanner in = new Scanner(System.in);
		int t,a[],n;
		
		t = in.nextInt();
		while(t-- > 0)
		{
			n= in.nextInt();
			a = new int[n];
			for(int i=0;i < n; i++ )
			{
				a[i] = in.nextInt();
				
			}
			
			System.out.println(countTriplets(a));
		}
	}

}
