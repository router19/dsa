package my.binary.tree.max.sum.path;

class Node {
	int data;
	
	Node left,right;
	
	public Node(int key)
	{
		data = key;
	}
}

/*
 * Time Complexity: O(n) where n is number of nodes in Binary Tree.
 */
public class MaxSumPathBinaryTree {
	Node root;
	
	int max_value_so_far= Integer.MIN_VALUE;
	// This function returns overall maximum path sum in 'res' 
    // And returns max path sum going through root. 
	int findMaxUtil(Node node)
	{
		// Base Case 
		if(node == null)
			return 0;
		
		// l and r store maximum path sum going through left and 
        // right child of root respectively 
		int l = findMaxUtil(node.left);
		int r = findMaxUtil(node.right);
		
		// Max path for parent call of root. This path must 
        // include at-most one child of root 
		// We are using Max single because to go to the parent root, 
		// there can be only one path, we cannot include both left and right if we have to go to root.
		int max_single = Math.max(node.data, Math.max(l, r) + node.data);
		
		// Max Top represents the sum when the Node under 
        // consideration is the root of the maxsum path and no 
        // ancestors of root are there in max sum path 
		int max_top = Math.max(l + r + node.data,max_single);
		
		// Store the Maximum Result.
		max_value_so_far = Math.max(max_value_so_far, max_top);
		
		return max_single;
		
	}
	int findMaxSum()
	{

		findMaxUtil(root);
		
		return max_value_so_far; 
	}
	public static void main(String[] args) {
		
		MaxSumPathBinaryTree tree = new MaxSumPathBinaryTree(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(10); 
        tree.root.left.left = new Node(20); 
        tree.root.left.right = new Node(1); 
        tree.root.right.right = new Node(-25); 
        tree.root.right.right.left = new Node(3); 
        tree.root.right.right.right = new Node(4); 
        System.out.println("maximum path sum is : " + 
                            tree.findMaxSum()); 

		
	}

}
