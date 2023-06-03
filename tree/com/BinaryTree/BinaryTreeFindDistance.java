package com.BinaryTree;



public class BinaryTreeFindDistance extends BinaryTree {



	static boolean isNodePresent(Node root, Node x)
	{
		if(root == null)
			return false;
		if(root == x)
			return true;
		
		return isNodePresent(root.leftChild, x) || isNodePresent(root.rightChild, x);
	}
	// Helper function to find the level of a given node present in a binary tree
    public static int findLevel(Node root, Node node, int level)
    {
        // base case
        if (root == null) {
            return Integer.MIN_VALUE;
        }
 
        // return level if the node is found
        if (root == node) {
            return level;
        }
 
        // search node in the left subtree
        int left = findLevel(root.leftChild, node, level + 1);
 
        // if the node is found in the left subtree, return the left child
        if (left != Integer.MIN_VALUE) {
            return left;
        }
 
        // otherwise, continue the search in the right subtree
        return findLevel(root.rightChild, node, level + 1);
    }
    static Node findLCA(Node root, Node x, Node y)
    {
    	// base case 1: if the tree is empty
    	if(root == null)
    		return null;
    	
    	// base case 2: if either `x` or `y` is found
    	if(root == x || root == y)
    		return root;
    	
    	// recursively check if `x` or `y` exists in the left subtree
    	Node left = findLCA(root.leftChild, x, y);
    	
    	// recursively check if `x` or `y` exists in the right subtree
    	Node right = findLCA(root.rightChild, x, y);
    	
    	// if `x` is found in one subtree and `y` is found in the other subtree,
        // update lca to the current node
    	if(left != null && right != null)
    		return root;
    	
    	// if `x` and `y` exist in the left subtree
    	if(left != null) 
    		return left;
    	
    	// if `x` and `y` exist in the right subtree
    	if(right !=null)
    		return right;
    	
    	return null;
    }
    
    // Function to find the distance between node `x` and node `y` in a
    // given binary tree rooted at `root` node
	static int findDistance(Node root, Node x, Node y)
	{
		Node lca = null;
		// call LCA procedure only if both `x` and `y` are present in the tree
		if(isNodePresent(root,x) && isNodePresent(root,y))
		{
			lca = findLCA(root,x,y);
			
		}
		else
		{
			return Integer.MIN_VALUE;
		}
		// return distance of `x` from lca + distance of `y` from lca
		return findLevel(lca, x,0) + findLevel(lca,y, 0);
		/*
        The above statement is equivalent to the following:

        return findLevel(root, x, 0) + findLevel(root, y, 0) -
                2*findLevel(root, lca, 0);

        We can avoid calling the `isNodePresent()` function by using
        return values of the `findLevel()` function to check if
        `x` and `y` are present in the tree or not.
    */
	}
	public static void main(String a[])
	{
	
		/*
		 *                               1
		 *                             /    \
		 *                           2        8
		 *                         /   \        \
		 *                        3     4        9
		 *                            /  \
		 *                           5    6
		 *                               /  
		 *                              7
		 * 
		 */
		
		BinaryTree treeForBoundary = new BinaryTree();
		treeForBoundary.rootNode = new Node(1);
		treeForBoundary.rootNode.leftChild = new Node(2);
		treeForBoundary.rootNode.leftChild.leftChild = new Node(3);
		treeForBoundary.rootNode.leftChild.rightChild = new Node(4);
		treeForBoundary.rootNode.leftChild.rightChild.leftChild = new Node(5);
		treeForBoundary.rootNode.leftChild.rightChild.rightChild = new Node(6);
		treeForBoundary.rootNode.leftChild.rightChild.rightChild.leftChild = new Node(7);
		treeForBoundary.rootNode.rightChild = new Node(8);
		treeForBoundary.rootNode.rightChild.rightChild = new Node(9);
		
		System.out.println(findDistance(treeForBoundary.rootNode, treeForBoundary.rootNode.leftChild.leftChild, treeForBoundary.rootNode.leftChild));
	}

}
