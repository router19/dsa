package com.deque;
/* We can use Java inbuilt Deque as a double  
ended queue to store the cache keys, with  
the descending time of reference from front  
to back and a set container to check presence  
of a key. But remove a key from the Deque using 
remove(), it takes O(N) time. This can be  
optimized by storing a reference (iterator) to  
each key in a hash map. */

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {
	 // store keys of cache 
	static Deque<Integer> dq;
	 // store references of key in cache 
	static HashSet<Integer> map;
	// maximum capacity of cache 
	int cacheSize;

	public LRUCache(int size) {
		
		dq = new LinkedList<Integer>();
		map = new HashSet<Integer>();
		cacheSize = size;
	}
	
	/* Refers key x with in the LRU cache */
	void refer(int page) {
		if(!map.contains(page))
		{
			if(dq.size() == cacheSize)
			{
				int last = dq.removeLast();
				map.remove(last);
				
			}			
		}
		
		else 
		{
			/* The found page may not be always the last element, even if it's an  
            intermediate element that needs to be removed and added to the start  
            of the Queue */
			
		   dq.remove(page);	
		}
		dq.push(page);
		map.add(page);
		    
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
