import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PriorityTreeMap {

	public static List<Integer> reassign(List<Integer> priorities)
	{
		Map<Integer,Boolean> flagMap = new HashMap<>();
        
        //treeMap would contain sorted keys with their re-assigned values
        Map<Integer,Integer> treeMap = new TreeMap<>();
        
        for(int i =1 ; i <= 99; i++)
        {
            flagMap.put(i, true);
        }
        
        
        for(Integer i: priorities)
        {
            flagMap.put(i, false);
            //let re-assigned values are 0
            treeMap.put(i, 0);
        }
        List<Integer> list = new ArrayList<>();
        
        for(Integer item : treeMap.keySet())
        {
            list.add(item);
        }
        int j =0;
        for(int i =1; i<=99 && j < list.size(); i++)
        {
        	if(flagMap.get(i) && i < list.get(j))
            {
                treeMap.put(list.get(j), i);
                if(!flagMap.get(list.get(j)))
                    flagMap.put(list.get(j), true);
                j++;
            }
            else
            	j++;
        }
        
        List<Integer> result = new ArrayList<>(); 
        for(Integer i : priorities)
        {
            result.add(treeMap.get(i) == 0 ? i : treeMap.get(i));
        }
        
        return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> prioroties = new ArrayList<>();
		
		prioroties.add(2);
		prioroties.add(9);
		prioroties.add(3);
		prioroties.add(2);
		prioroties.add(3);
//		prioroties.add(2);
		reassign(prioroties);
		
	}

}
