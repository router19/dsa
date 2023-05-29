import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MaxElementGreaterThanFloor {

	static int maxElement(List<Integer> A)
	{
		double n = Math.floor(A.size()/2);
        Map<Integer,Integer> hashMap = new HashMap<>();
        Iterator<Integer> it = A.iterator();
        while(it.hasNext())
        {
            int ele =  it.next();
            hashMap.put(ele,hashMap.getOrDefault(ele,0) + 1);
            if(hashMap.getOrDefault(ele,0) > n)
                return ele;
        }
    

		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(2);
		list.add(1);
		list.add(2);
		
		System.out.println(maxElement(list));
		

	}

}
