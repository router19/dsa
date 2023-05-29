

/**
 * Given an array arr[0 . . . n-1]. We need to efficiently find the minimum and maximum value from index qs (query start) to qe (query end)
 *  where 0 <= qs <= qe <= n-1. We are given multiple queries.

Examples:

Input : arr[] = {1, 8, 5, 9, 6, 14, 2, 4, 3, 7}
        queries = 5
        qs = 0 qe = 4
        qs = 3 qe = 7
        qs = 1 qe = 6
        qs = 2 qe = 5
        qs = 0 qe = 8
Output: Minimum = 1 and Maximum = 9 
        Minimum = 2 and Maximum = 14 
        Minimum = 2 and Maximum = 14 
        Minimum = 5 and Maximum = 14
        Minimum = 1 and Maximum = 14
 
#### simple solution ##### 
   is to run a loop from qs to qe and find minimum element in given range. This solution takes O(n) time in worst case.

######  Another solution #### 
   is to create a 2D array where an entry [i, j] stores the minimum value in range arr[i..j]. 
   Minimum of a given range can now be calculated in O(1) time, but pre processing takes O(n^2) time.
   Also, this approach needs O(n^2) extra space which may become huge for large input arrays.

 ### Segment tree ###
  can be used to do pre-processing and query in moderate time. With segment tree, preprocessing time is O(n) and time to for range minimum query is O(Logn). 
  The extra space required is O(n) to store the segment tree.


Representation of Segment trees
1. Leaf Nodes are the elements of the input array.
2. Each internal node represents minimum of all leaves under it.

An array representation of tree is used to represent Segment Trees. For each node at index i, the left child is at index 2*i+1, right child at 2*i+2 and
 the parent is at ceil((i-1)/2)
                                   1
                                 [0-5]
                                /      \
                               1        3
                             [0-2]      [3-5]
                             /   \      /   \
                            2     1    4     3
                          [0-1]       [3-4]
                          /   \       /   \
                         2     5     4     9
                      Segment tree for input array {2,5,1,4,9,3}   
Construction of Segment Tree from given array
We start with a segment arr[0 . . . n-1]. and every time we divide the current segment into two halves(if it has not yet become a segment of length 1),
 and then call the same procedure on both halves, and for each such segment, we store the minimum value in a segment tree node.
All levels of the constructed segment tree will be completely filled except the last level. Also, the tree will be a Full Binary Tree
 because we always divide segments in two halves at every level. Since the constructed tree is always full binary tree with n leaves,
  there will be n-1 internal nodes. So total number of nodes will be 2*n – 1.

Height of the segment tree will be Floor(log n). 

Since the tree is represented using array and relation between parent and child indexes must be maintained, 
size of memory allocated for segment tree will be 2 * 2^floor(log n) -1.

Query for minimum value of given range
Once the tree is constructed, how to do range minimum query using the constructed segment tree. Following is algorithm to get the minimum.

// qs --> query start index, qe --> query end index
int RMQ(node, qs, qe) 
{
   if range of node is within qs and qe
        return value in node
   else if range of node is completely outside qs and qe
        return INFINITE
   else
    return min( RMQ(node's left child, qs, qe), RMQ(node's right child, qs, qe) )
}

Time Complexity:
Time Complexity for tree construction is O(n). There are total 2n-1 nodes, and value of every node is calculated only once in tree construction.

Time complexity to query is O(Logn). To query a range minimum, we process at most two nodes at every level and number of levels is O(Logn). 

 * @author vinitku
 *
 */
public class MinMaxRangeQueryUsingSegmentTree {
	  class MinMax
	{
		int min;
		int max;
	}
	

	int minVal(int x, int y)
	{
		return x > y ? y :x;
	}
	int maxVal(int x, int y)
	{
		return x > y ? x :y;
	}
	int getMid(int s, int e) {  return s + (e -s)/2;  } 
	
	MinMax maxMinUtil(MinMax[] mm, int ss,int se,int qs, int qe,int index)
	{
		// If segment of this node is a part of given range, then return 
	    //  the minimum and maximum node of the segment  
		MinMax tmp = new MinMax();
		if(qs <= ss && qe >= se )
			return mm[index];
		// If segment of this node is outside the given range 
	    if (se < qs || ss > qe) 
	    { 
	       
	       tmp.min = Integer.MAX_VALUE; 
	       tmp.max = Integer.MIN_VALUE; 
	       return tmp; 
	     } 
	    int mid = getMid(ss, se);
	    MinMax left = maxMinUtil(mm, ss, mid, qs, qe, 2* index +1);
	    MinMax right = maxMinUtil(mm,mid +1, se, qs, qe, 2 *index +2);
	    tmp.min = minVal(left.min, right.min);
	    tmp.max = maxVal(left.max,right.max);
	    
	    return tmp;
		
	}
	MinMax maxMin(MinMax[] mm, int n, int qs, int qe)
	{
		if(qs < 0 || qe > n-1  || qs > qe)
		{
			MinMax temp = new MinMax();
			temp.max = Integer.MIN_VALUE;
			temp.min = Integer.MAX_VALUE;
			return temp;
		}
		return maxMinUtil(mm,0,n-1,qs,qe,0);
	}
	
	// A recursive function that constructs Segment Tree for array[ss..se]. 
	// si is index of current node in segment tree st 
	void constructSTUtil(int arr[], int ss, int se, MinMax[] mm, int si) 
	{
		// If there is one element in array, store it in current node of 
	    // segment tree and return 
	    if (ss == se) 
	    { 
	        mm[si].min = arr[ss]; 
	        mm[si].max = arr[ss]; 
	        return ; 
	    }
	    
	    // If there are more than one elements, then recur for left and 
	    // right subtrees and store the minimum and maximum of two values 
	    // in this node 
	    int mid = getMid(ss, se);
	    
	    constructSTUtil(arr, ss, mid, mm, si *2 +1);
	    constructSTUtil(arr, mid+1, se, mm, si *2 +2);
	    
	    mm[si].min = minVal(mm[si *2 +1].min, mm[si*2  +2].min); 
	    mm[si].max = maxVal(mm[si *2 +1].max, mm[si*2  +2].max);
	}
	
	MinMax[] constructST(int a[], int n)
	{
		//Height of segment tree 
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 
		
        //Maximum size of segment tree 
        int max_size = 2 * (int) Math.pow(2, x) - 1; 
		
		MinMax[] mm = new MinMax[max_size];
		for(int i =0 ; i < max_size;i++)
		{
			mm[i] = new MinMax();
		}
		
		constructSTUtil(a, 0, n-1, mm, 0);
		
		return mm;
	}
	public static void main(String[] args) {
		int arr[] = {1, 3, 2, 7, 9, 11}; 
        int n = arr.length; 
        MinMaxRangeQueryUsingSegmentTree tree = new MinMaxRangeQueryUsingSegmentTree(); 
  
        // Build segment tree from given array 
        MinMax[] mm = tree.constructST(arr, n); 
  
        int qs = 0;  // Starting index of query range 
        int qe = 5;  // Ending index of query range 
        MinMax result = tree.maxMin(mm,n,qs,qe);
        // Print minimum value in arr[qs..qe] 
        System.out.println("Minimum of values in range [" + qs + ", "
                           + qe + "] is = " + result.min); 
        System.out.println("Maximum of values in range [" + qs + ", "
                + qe + "] is = " + result.max);
		

	}

}
