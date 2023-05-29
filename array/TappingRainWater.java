import java.util.Scanner;

public class TappingRainWater {

	
	int calcuateCapacity(int arr[])
	{
		int left=0,capacity=0, left_max=0,right_max =0;
		int right = arr.length-1;
		while(left < right)
		{
			if(arr[left] < arr[right])
			{
				if(arr[left] >= left_max)
				{
					left_max = arr[left];
				}
				else
					capacity += arr[left];
				left++;
			}
			else
			{
				if(arr[right] >= right_max)
					right_max= arr[right];
				else
					capacity += arr[right];
				right--;			
			}
		}
		
		return capacity;
		
		
	}
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int n,capacity;// =0;
		int a[];
		int left,right,left_max,right_max;
		while(t-- > 0)
		{
		    n = in.nextInt();
		    a = new int[n];
		    for(int i =0; i < n ; i++)
		        a[i] = in.nextInt();
		     
		    left = left_max = right_max = capacity = 0;
		    right = n-1;
		    
		    while(left < right)
		    {
		    	if(a[left] < a[right])
		    	{
		    		if(a[left] >= left_max)
		    			left_max = a[left];
		    		else
		    			capacity += left_max-a[left];
		    		left++;
		    	}
		    	else
		    	{
		    		if(a[right] >= right_max)
		    			right_max = a[right];
		    		else
		    			capacity += right_max - a[right];
		    		right--;
		    	}
		    }
		    System.out.println(capacity);
		     
		}
	}

}
