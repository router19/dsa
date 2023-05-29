/*Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.*/ 
public class SubArrayWithSum {
	
	
	static void findSubArrayWithSum(int a[],int sum)
	{
		int curr_sum = a[0],start=0;
		boolean found = false;
		for(int i = 1;i <= a.length;i++)
		{
			//2,7,8,2,2,4
			while(curr_sum > sum && start< i-1)
			{
				curr_sum -= a[start];
				start++;
			}
			if(curr_sum == sum)
			{
				found = true;
				System.out.println(start+1 +" " + (i));
				break;
			}
			if(i < a.length)
			{
				curr_sum += a[i];
			}
		}
		if(!found)
			System.out.println("No Such sub array found");
		
	}
	public static void main(String[] args) {
		
		int a[] = {2,7,8,3,6,7};
		int b[] = {135 ,101 ,170 ,125, 79 ,159 ,163 ,65, 106 ,146 ,82 ,28 ,162 ,92 ,196 ,143 ,28 ,37 ,192 ,5 ,103 ,154 ,93 ,183, 22 ,117 ,119, 96, 48 ,127 ,172 ,139 ,70 ,113, 68 ,100, 36 ,95 ,104,12,123,134};
		findSubArrayWithSum(a, 8);

	}

}
