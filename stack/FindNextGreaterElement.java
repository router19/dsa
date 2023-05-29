import java.util.Stack;

/*
 * Given an array A of size N having distinct elements, the task is to find the next greater element for each element
 * of the array in order of their appearance in the array. If no such element exists, output -1 
 */
public class FindNextGreaterElement {
	
	//
	static void findNextLargerElement(int a[])
    {
        int n = a.length;
        boolean found;
        for(int i = 0; i < n -1; i++)
        {
            found = false;
            for (int j= i + 1; j < n; j++)
            {
                if(a[j] > a[i]){
                    System.out.print(a[j] + " ");
                    found = true;
                    break;
                }
                    
            }
            if(!found)
                System.out.print("-1" + " ");
        }
        System.out.println("-1");
        
    }
	// 1 4 3 5 2 4 
	static public void findNGE(int a[]) 
	{
		Stack<Integer> s = new Stack<Integer>();
		int n = a.length;
		int nge[] = new int[n];
				
		for(int i= n-1 ;i >=0;i-- )
		{
			while(!s.isEmpty() && s.peek() <= a[i])
				s.pop();
			
			nge[i] = s.isEmpty() ? -1 : s.peek();
			s.push(a[i]);
		}
		
		for(int j = 0; j < n;j++)
			System.out.print(nge[j] + " ");
		System.out.println();
		
	}

	public static void main(String[] args) {
				
		/*Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int size,i,arr[];
		while(t-- > 0)
		{
		    size = in.nextInt();
		    arr = new int[size];
		    for(i=0;i<size;i++)
		    {
		        arr[i] = in.nextInt();
		    }
		    
		    findNextLargerElement(arr);
		    
		}*/
		
		int arr[] = {5,4,3,2,1,6};
	    //O(n^2) approach.
		//findNextLargerElement(arr);
		
		//O(n) approach
		findNGE(arr);
	}

}
