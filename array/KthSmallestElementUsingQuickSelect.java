
import java.util.Random;
import java.util.Scanner;

public class KthSmallestElementUsingQuickSelect {

	
	static int kthsmallest(int arr[], int l, int r, int k)
    {
    // If k is smaller than number of elements in array
    if (k > 0 && k <= r - l + 1)
    {
        
        // partitioning the array along the pivot
        int pos = randomPartition(arr, l, r);
    
    
        // check if current element gives you the kth smallest element
        if (pos-l == k-1)
            return arr[pos];
        
        // else recurse for the left and right half accordingly
        if (pos-l > k-1)  
            return kthsmallest(arr, l, pos-1, k);
        return kthsmallest(arr, pos+1, r, k-pos+l-1);
    }

    return Integer.MAX_VALUE;
    }
    
    
    static int partition(int arr[], int l, int r)
    {
           int x = arr[r], i = l;
            for (int j = l; j <= r - 1; j++)
            {
                if (arr[j] <= x)
                {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    i++;
                }
            }
               int temp = arr[r];
               arr[r] = arr[i];
               arr[i] = temp;
        return i;
    }
        
        // Function to partition the array along the random pivot
        static int randomPartition(int arr[], int l, int r)
        {
            Random rand = new Random();
            int n = r-l+1;
            int pivot = rand.nextInt(n);
            int temp = arr[r];
            arr[r] = arr[l+pivot];
            arr[l+pivot] = temp;
            
            return partition(arr, l, r);
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t,a[],n,k,i;
		 Scanner in = new Scanner(System.in);
		 t = in.nextInt();
		 
		 while(t-- > 0)
		 {
			 n = in.nextInt();
			 
			 a = new int[n];
			 
			 for(i=0;i<n;i++)
				 a[i] = in.nextInt();
			 
			 k= in.nextInt();
			 System.out.println(kthsmallest(a, 0, a.length -1, k));
		 }
	}

}
