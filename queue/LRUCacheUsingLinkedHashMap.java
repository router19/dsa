package com.deque;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCacheUsingLinkedHashMap {
	
	Set<Integer> cache;
	int capacity;
	
	public LRUCacheUsingLinkedHashMap(int capacity) {
		this.capacity = capacity;
		cache = new LinkedHashSet<Integer>(capacity);
	}
	
	// This function returns false if key is not
    // present in cache. Else it moves the key to
    // front by first removing it and then adding
    // it, and returns true.
	public boolean get(int key)
	{
		if(!cache.contains(key))
			return false;
		cache.remove(key);
		cache.add(key);
		
		return true;
	}
	
	public void put(int key)
	{
		if(cache.size() == capacity)
		{
			int firstKey = cache.iterator().next();
			cache.remove(firstKey);
		}
		cache.add(key);
	}
	
	public void refer(int key)
	{
		if(get(key) == false)
			put(key);
	}
	
	// displays contents of cache in Reverse Order
	public void display()
	{
		LinkedList<Integer> list = new LinkedList<Integer>(cache);
		
		// The descendingIterator() method of java.util.LinkedList
	      // class is used to return an iterator over the elements
	      // in this LinkedList in reverse sequential order
		Iterator<Integer> it = list.descendingIterator();
		
		while(it.hasNext())
			System.out.print(it.next() + " ");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCacheUsingLinkedHashMap ca = new LRUCacheUsingLinkedHashMap(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
	}

}
