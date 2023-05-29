import java.util.HashSet;
import java.util.Scanner;

/**
 * Given an array A of distinct integers. The task is to find if there are two pairs (a, b) and (c, d) 
 * such that a+b = c+d, and elements of array are distinct.
 * @author vinitku
 *Output:
Single line output, print the 1 if pair exists else 0.
3 4 7 1 2 9 8
1
65 30 7 90 1 9 8
0
 */
public class FindPairsWithEqualSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int n=0,a[];
		HashSet<Integer> hash ;//= new HashSet<>();
		boolean found = false;
		while(t-- > 0 )
		{
		    hash = new HashSet<Integer>();
			found = false;
		    n = in.nextInt();
		    a = new int[n];
		    for(int i = 0;i< n ; i ++  )
		    {
		        a[i] = in.nextInt();
		    }
		    for(int i = 0; i < n && !found; i++)
		    {
		        for(int j = i +1 ; j < n && !found ; j++)
		        {
		            if(hash.contains(a[j] + a[i])){
		                System.out.println(1);
		                found = true;
		                break;
		            }
		            hash.add(a[j] + a[i]);
		        }
		    }
		    if(!found)
		        System.out.println(0);
		    
		}
	}

}
