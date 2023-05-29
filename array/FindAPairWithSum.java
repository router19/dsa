import java.util.HashMap;

public class FindAPairWithSum {

	static void findPair(int a[],int sum) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i =0;i <a.length;i++ ) {
			map.put(a[i], i);
		}
		for(int i =0; i < a.length;i++) {
			if(map.get(sum-a[i]) != null) {
				System.out.println("Found Pair as "+ a[i] + ","+ a[map.get(sum-a[i])]);
				map.remove(a[i]);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10,1,34,23,12,14,15};
		findPair(arr,11);
		
	}

}
