package minHeap;

/*
 * Binary Heap
A Binary Heap is a Binary Tree with following properties.
1) It�s a complete tree (All levels are completely filled except possibly the last level and the last level has 
all keys as left as possible). This property of Binary Heap makes them suitable to be stored in an array.

2) A Binary Heap is either Min Heap or Max Heap.
	a) In a Min Binary Heap, the key at root must be minimum among all keys 
present in Binary Heap. The same property must be recursively true for all nodes in Binary Tree.

 	b) Max Binary Heap is similar to MinHeap.
 */
public class MinHeap {

	int[] heapArray;
	int capacity;
	int heap_size;
	
	MinHeap(int capacity){
		this.capacity = capacity;
		heap_size = 0;
		heapArray = new int[capacity];
				
	}
	
	int parent(int i) {
		return (i-1)/2;
	}
	int leftChild(int i) {
		return 2*i+1;
	}
	
	int rightChild(int i) {
		return 2*i + 2;
		
	}
	void swap(int i,int j ) {
		int temp = heapArray[i];
		heapArray[i] = heapArray[j];
		heapArray[j] = temp;
	}
	void insertKey(int key) {
		if(heap_size == capacity) {
			System.out.println("Heap is full");
			return;
		}
		heap_size++;
		int i = heap_size -1;
		heapArray[i] = key;
		
		while(i !=0 && heapArray[parent(i)] > heapArray[i] ) {
			 swap(i,parent(i));
			 i = parent(i);
		}
	}
	
	void deleteKey(int i) {
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}
	
	int getMin() {
		if(heap_size<= 0)
			return Integer.MAX_VALUE;
		return heapArray[0];
	}
	void decreaseKey(int i,int new_val) {
		heapArray[i] = new_val;
		
		while(i!=0 && heapArray[parent(i)] > heapArray[i]) {
			swap(i,parent(i));
			i = parent(i);
		}
	}
	
	int extractMin() {
		
		if(heap_size <= 0)
			return Integer.MAX_VALUE;
		if(heap_size == 1) {
			heap_size--;
			return heapArray[0];
		}
		
		int root = heapArray[0];
		heapArray[0] = heapArray[heap_size -1];
		heap_size--;
		minHeapify(0);
		
		return root;
	}
	
	//O(logn) time
	void minHeapify(int i) {
		int left = leftChild(i);
		int right = rightChild(i);
		int smallest = i;
		
		if(left < heap_size && heapArray[left] < heapArray[smallest])
			smallest = left;
		if(right < heap_size && heapArray[right] < heapArray[smallest])
			smallest = right;
		
		if(smallest != i) {
			swap(i,smallest);
			minHeapify(smallest);
		}
	}
	
	public static void main(String[] args) {
		
		MinHeap minHeap = new MinHeap(11);
		minHeap.insertKey(10);
		minHeap.insertKey(11);
		minHeap.insertKey(12);
		minHeap.insertKey(3);
		System.out.print("Current heap is ");
		for (int i =0 ; i < minHeap.heap_size;i++)
			System.out.print(minHeap.heapArray[i] + " ");
		System.out.println("");
		System.out.println("Minimum value in heap is "+ minHeap.getMin());
//		int min = minHeap.extractMin();
//		System.out.println("!!!EXTRACTED MIN VALUE --> "+ min + " from heap.");
//		System.out.println("Now minimum value in heap is "+ minHeap.getMin());
//		for (int i =0 ; i < minHeap.heap_size;i++)
//			System.out.print(minHeap.heapArray[i] + " ");
//		System.out.println();
		System.out.println("Decreasing value of element at 1 to 1");
		minHeap.decreaseKey(1, 1);
		System.out.print("New heap is : ");
		for (int i =0 ; i < minHeap.heap_size;i++)
			System.out.print(minHeap.heapArray[i] + " ");
		
		System.out.println("\nMinimum value in new heap  is "+ minHeap.getMin());
		
		
		//Heapifying a given array 
		//Note Heap is a complete binary tree hence heapSize must be odd
		MinHeap minHeap2 = new MinHeap(11);
		minHeap2.heapArray[0]  = 10;
		minHeap2.heapArray[1]  = 2;
		minHeap2.heapArray[2]  = 19;
		minHeap2.heapArray[3]  = 24;
		minHeap2.heapArray[4]  = 17;
		minHeap2.heapArray[5]  = 15;
		minHeap2.heapArray[6]  = 16;
		minHeap2.heapArray[7]  = 18;
		minHeap2.heapArray[8]  = 25;
		minHeap2.heapArray[9]  = 21;
		minHeap2.heapArray[10]  = 1;		
		minHeap2.heap_size = 11;
		System.out.println("******************");
		System.out.println();
		
		System.out.print("Input array to create heap is ");
		for (int i =0 ; i < minHeap2.heap_size;i++)
			System.out.print(minHeap2.heapArray[i] + " ");
		System.out.println();
		
		/*
		 * input array is  10 2 19 24 17 15 16 18 19 21 1 
		 * Whose tree representation is 
							10
					 2	            19
 	   			24 	     17       15  16
	 		  18  25   21  1
	 		  We can see that we only need to heapify the non-leaf nodes as
	 		  when we heapify a non-leaf nodes , the leaf nodes are takes into consideration
	 		  Hence we only need to heapify {10,2,19,24,17} => heap_size/2-1 to 0
		 */
		/**
		 * CREATING A HEAP of a input array : O(n)
		 * 
		 */
		for(int i =minHeap2.heap_size/2 -1; i >= 0; i--) {
			
			minHeap2.minHeapify(i);
			
			/*
			 *                           1
			 *                         /   \  
			 *                       2      15
			                       /  \     / \ 
			                     18    10  19  16 
			                    / \    / \
			                   24  25 21  17
			
			*/
			//System.out.println("Heap array after " + (minHeap2.heap_size/2 -1 -i) + " iterations");
//			for (int j =0 ; j < minHeap2.heap_size;j++)
//				System.out.print(minHeap2.heapArray[j] + " ");
//			System.out.println();
		}
		
		System.out.print("Created heap is ");
		for (int i =0 ; i < minHeap2.heap_size;i++)
			System.out.print(minHeap2.heapArray[i] + " ");
		System.out.println("\nMinimum element in the created heap is "+minHeap2.getMin());
	}

}
