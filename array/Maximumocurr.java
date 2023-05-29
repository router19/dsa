import java.util.HashMap;

public class Maximumocurr {

	static int mostFrequentStrength(int k, int[] troops, long l, long r){
        // Write your code here
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int arr[] = new int[troops.length * k];
		for(int i=0,j= 0; i < troops.length *k ; i++,j++)
		{
			if(j == troops.length  )
				j = j % troops.length;
			arr[i] = troops[j];
		}
		int mostoc = 0;
		int reqdno = arr[(int)l];
		for(int i =(int)l;i <= r ; i++)
		{
			if(map.containsKey(arr[i]))
			{
				if(mostoc < map.get(arr[i]) || 
						(map.get(arr[i]) > mostoc && (mostoc == map.get(arr[i]))))
						{mostoc = map.get(arr[i]);reqdno = arr[i];}
				map.put(arr[i], map.get(arr[i]) + 1);
			}
			else
			{
				
				map.put(arr[i], 1);
			}
		}
		
        return reqdno;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2, 5, 1 ,8 ,4 ,2 ,2 ,7 ,9, 8 };
		System.out.println(10%10);
		
		System.out.println(mostFrequentStrength(2, a, 1, 5));
	}

}
