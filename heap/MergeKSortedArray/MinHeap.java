package MergeKSortedArray;
/**
 * Merge k sorted array 
 * Time complexity O(NK * LOGK ) , Space Complexity (K*N)
 * @author vinitku
 *
 *
 *ALGORITHM
 ********************** 
1. Create an output array of size n*k.
2. Create a min heap of size k and insert 1st element in all the arrays into the heap
3. Repeat following steps n*k times.
     a) Get minimum element from heap (minimum is always at root) and store it in output array.
     b) Replace heap root with next element from the array from which the element is extracted. 
     	If the array doesn’t have any more elements, then replace root with infinite. 
     	After replacing the root, heapify the tree.
 */

	
	class MinHeapNode {
		int element;
		int currentArray;//used to move between k array
		int nextElement;
		MinHeapNode(int data,int i,int j)
		{
			this.element = data;
			this.currentArray = i;
			this.nextElement = j;
		}
		
		 public String toString()
			{
				return element +""; 
			}
	}

	class MinHeap {
		MinHeapNode hArr[];
		int heapSize;
		
		MinHeap(MinHeapNode arr[], int size)
		{
		  hArr = arr;
		  heapSize = size;
		  int i = (heapSize - 1)/2;
		  while(i >= 0)
		  {
			  MinHeapify(i);
			  i--;
		  }	
		 
		  
		}
		
		int left(int index)
		{
			return 2*index +1;
		}
		
		int right(int index)
		{
			return 2*index +2;
		}
		
		void MinHeapify(int index)
		  {
			 int smallest = index;
			 int l = left(index);
			 int r = right(index);
			 
			 if(l < heapSize && hArr[l].element < hArr[smallest].element)
				 smallest = l;
			 if(r < heapSize && hArr[r].element < hArr[smallest].element)
				 smallest = r;
			 
			 if(smallest != index)
			 {
				 swap(hArr, index,smallest);
				 MinHeapify(smallest);
			 }
		  }
		
		
		void swap(MinHeapNode a[] , int i , int j)
		 {
			 MinHeapNode temp = a[i];
			 a[i] = a[j];
			 a[j] = temp;
		 }
		
		MinHeapNode getMin()
	     {
	    	 if(heapSize <=0)
	    	 {
	    		 System.out.println("Heap is empty");
	    		 return null;
	    	 }
	    	 
	    	 return hArr[0];	    	 
	     }
		
		void replaceMin(MinHeapNode root)
		{
			hArr[0] = root;
			MinHeapify(0);
		}
	
	
	 static void mergeKSortedArray(int a[][],int k)
		{
			MinHeapNode[] hArrInside = new MinHeapNode[k];
			int resultSize =0;
			for(int i = 0;i < a.length; i++)
			{
				MinHeapNode node = new MinHeapNode(a[i][0], i, 1);//i here goes from 0 to k , and nextElement is set to 1 as next to be chosed is from index 1
				hArrInside[i] = node;
				resultSize += a[i].length;
			}
			
			int result[] = new int[resultSize];//n*k size array , space complexity (O(nk))
			MinHeap mh = new MinHeap(hArrInside, k);
			
			for(int i =0; i < resultSize; i++) // runs for n*k time , also replaceMin will take logk , hence time complexity : O(n*k*logk)
			{
				MinHeapNode root = mh.getMin();
				result[i] = root.element;
				
				if(root.nextElement < a[root.currentArray].length)
					root.element = a[root.currentArray][root.nextElement++];
				else
					root.element = Integer.MAX_VALUE;
				
				mh.replaceMin(root);
			}
			
			printArray(result);
			
		}
		
		static void printArray(int result[])
		{
			for(int i =0; i < result.length;i++)
			{
				System.out.print(result[i] + " " );
				
			}
			System.out.println();
		}
	
	
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {{1,6,9,10},
				     {2,5,8},
				     {3,4,7,11}};
		mergeKSortedArray(a, a.length);
		
		}
	}


