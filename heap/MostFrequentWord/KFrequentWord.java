package MostFrequentWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KFrequentWord {

	public static ArrayList<String> topKFrequent(List<String> words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String w1, String w2) {
				return count.get(w1).equals(count.get(w2)) ? 
						w2.compareTo(w1) : count.get(w1) - count.get(w2);
			}
        	
        };
        //MinHeap - we want out of n word , all min to be removed
        /*
         * Use lambda
        PriorityQueue<String> heap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w2.compareTo(w1) : count.get(w1) - count.get(w2) );
		*/
        PriorityQueue<String> heap = new PriorityQueue<String>(comp);
        
        for (String word: count.keySet()) {
            heap.offer(word);
            if (heap.size() > k) heap.poll();
        }

        ArrayList<String> ans = new ArrayList();
        while (!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
	
	public static ArrayList<String> popularNFeatures(int numFeatures, 
            int topFeatures, 
            List<String> possibleFeatures, 
			 int numFeatureRequests, 
			 List<String> featureRequests)
{
		List<String> featureRequestsInterested = new ArrayList<>();
		for(String requested : featureRequests)
		{
			for(String possible : possibleFeatures)
			{
				if(requested.contains(possible))
					featureRequestsInterested.add(possible);
			}
		}
		
		return  topKFrequent(featureRequestsInterested, topFeatures);
		//String 
		
}
	public static void main(String[] args) {
				
		int numFeatures = 6;
		int topFeatures = 2;
		
		String possibleFeaturesArray[] = {"battery","storage","hover","alexa","waterproof","solar"};
		String testP[]= {};
		int numFeatureRequest = 7;
		
		String featureRequests[] = {"abcd battery efgh ","sas hover sass","dsd alexa das","dsd s waterproof dsd","dsd solar sd","sdd battery dsd","sd solar dsds","sdd battery dsd","dsd solar sd","dsd s waterproof dsd","dsd s waterproof dsd"};
		
		List<String> kFrequent  = popularNFeatures(numFeatures,topFeatures,Arrays.asList(possibleFeaturesArray),numFeatureRequest,Arrays.asList(featureRequests));
//		List<String> kFrequent = topKFrequent(Arrays.asList(possibleFeaturesArray), 2);
//		String test = "sddjkj Storage sdds";
//		System.out.println(test.contains("storage"));
		for(String s: kFrequent)
			System.out.println(s);
	}

}
