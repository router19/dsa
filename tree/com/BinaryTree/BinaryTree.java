package com.BinaryTree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



class Node
 {
	int data;
	Node leftChild;
	Node rightChild;
	
	Node(int data){
		this.data = data;
	}
 }
public class BinaryTree {
	Node rootNode;
		 
	//BFS of a tree, aka level order traversal
	void printLevelOrderTraversal() {
		if(rootNode == null)
			return;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(rootNode);
		
		Node node;
		while(!queue.isEmpty()) {
			node = queue.poll();
			System.out.print(node.data +  " ");
			if(node.leftChild != null)
				queue.add(node.leftChild);
			
			if(node.rightChild != null)
				queue.add(node.rightChild);
		}
		
	}
	
	//prints tree in zig zag pattern
	void printZigZagTree()
	{
		if(rootNode == null)
			return;
		
		Stack<Node> currentLevel = new Stack<Node>();
		Stack<Node> nextLevel = new Stack<Node>();
		
		currentLevel.push(rootNode);
		
		boolean leftToRight = true;
		
		while(!currentLevel.isEmpty()) 
		{
		  
		  Node node = currentLevel.pop();
		  System.out.print(node.data + " ");
		  
		  if(leftToRight) {
			  if(node.leftChild != null)
				  nextLevel.push(node.leftChild);
			  if(node.rightChild != null)
				  nextLevel.push(node.rightChild);
		  }
		  else {
			  if(node.rightChild != null)
				  nextLevel.push(node.rightChild);
			  if(node.leftChild != null)
				  nextLevel.push(node.leftChild);
		  }
		  
		  if(currentLevel.isEmpty()) {
			  leftToRight = !leftToRight;
			  //swap currentLevel and nextLevel
			  Stack<Node> temp = currentLevel;
			  currentLevel = nextLevel;
			  nextLevel = temp;
		  }
		}
	}
	
	
    
	//Gets the level of key recursively
	public static int  getLevelRec(Node root,int key,int level)
    {
        if(root == null)
          return 0;
        
        if(root.data == key)
            return level;
        int l , r;
        if(root.leftChild != null && root.rightChild == null )
            return getLevelRec(root.leftChild,key,level+1);
        
        if(root.rightChild != null && root.leftChild == null)
            return getLevelRec(root.rightChild,key,level+1);
        
        if(root.leftChild != null && root.rightChild !=null )
        {
            int l1 = getLevelRec(root.leftChild,key,level+1);
            int l2 = getLevelRec(root.rightChild,key,level +1);
            if(l1!=0)
                return l1;
            if(l2!= 0)
                return l2;
        }
        return 0;    
        
    }
	//Find the level of an element in the given binary tree
    public static int getLevel(Node root, int key)
    {
        return getLevelRec(root,key,1);    
        
    }
    
    
    int diameter(Node node)
    {
        if(node == null)
            return 0;
        int leftHeight =0,rightHeight=0;
        if(node.leftChild!=null)    
             leftHeight = height(node.leftChild,1);    
        if(node.rightChild != null)
            rightHeight = height(node.rightChild,1);
            
        int th = leftHeight + rightHeight + 1;    
        
        int ld = diameter(node.leftChild);
        int rd = diameter(node.rightChild);
        int max_td = ld >rd ? ld:rd;
        
        return (max_td >th ? max_td:th);
    }
    
    
    int height(Node node,int h)
    {
        if(node.leftChild == null && node.rightChild == null)
            return h;
        
        if(node.leftChild != null && node.rightChild == null)
            return height(node.leftChild,h+1);
            
        if(node.leftChild == null && node.rightChild != null)
            return height(node.rightChild,h+1);    
        
        if(node.leftChild != null && node.rightChild != null)
            {
                int lh = height(node.leftChild,h+1);
                int rh = height(node.rightChild,h+1);
                h = (lh > rh ? lh:rh);
                return h;
            }
        return 0;    
    }
    
    int height_shortCode(Node node) {
    	if(node == null )
    		return 0;
    	return max(height_shortCode(node.leftChild) + 1,height_shortCode(node.rightChild) + 1);
    	
    }
    
    int max(int a,int b)
    {
    	return a>b ? a:b;
    }
    //O(n^2) in worst case of skewed tree.
    boolean isBalanceTree(Node node)
    {
    	if(node == null)
    		return true;
    	
    	int lh = height_shortCode(node.leftChild);
    	int rh = height_shortCode(node.rightChild);
    	
    	if(Math.abs(lh - rh) <= 1 && 
    			isBalanceTree(node.leftChild) && 
    			isBalanceTree(node.rightChild))
    		return true;
    		
    	return false;
    }
    
    //isBalanceTree in O(n) approach
    //wrapper class for height
    class Height{
    	int height = 0;
    }
    
    boolean isBalanceTree(Node node, Height height)
    {
    	if(node == null)
    	{
    		height.height = 0;
    		return true;
    	}
    	Height lheight = new Height(), rheight = new Height();
    	boolean l = isBalanceTree(node.leftChild, lheight);
    	boolean r = isBalanceTree(node.rightChild, rheight);
    	int lh = lheight.height, rh = rheight.height;
    	
    	//height of the current node is the max between left and right + 1
    	height.height = (lh > rh ? lh : rh) + 1;
    	
    	if(Math.abs(lh-rh) > 1)
    		return false;
    	else
    		/* If this node is balanced and left and right subtrees 
            are balanced then return true */
    		return l && r;
    }
    int getLeafNodeCount(Node node)
    {
    	if(node == null)
    		return 0;
    	if(node.leftChild == null && node.rightChild == null)
    		return 1;
    	
    	return getLeafNodeCount(node.leftChild) + getLeafNodeCount(node.rightChild);
    }
    
    /*
     *      1
     *     /  \
     *    2    3
     */
    public Node mirror(Node node)
    {
      if(node == null)
    		return node;
    	
	  Node left = mirror(node.leftChild);
	  Node right = mirror(node.rightChild);
	  
	  node.leftChild = right;
	  node.rightChild = left;
    	    	
      return node;
    	
    }
    
    /**
     * DFS 
     * inorder,preorder and postorder
     * 
     * @param node
     */
    public void inorder(Node node)
    {
    	if(node!=null) {
    	inorder(node.leftChild);
    	System.out.print(node.data + " ");
    	inorder(node.rightChild);
    	}
    }
    
    public void preorder(Node node)
    {
    	if(node!=null)
    	{
    		System.out.print(node.data +" ");
    		preorder(node.leftChild);
    		preorder(node.rightChild);    		
    	}
    }
    
    public void postorder(Node node)
    {
    	if(node != null)
    	{
    		postorder(node.leftChild);
    		postorder(node.rightChild);
    		System.out.print(node.data + " ");
    	}
    }
    
    //Print anti-clockwise boundary elements 
    /*
     *             1
     *          /    \ 
     *         2      7
     *          \    /
     *           3  6
     *            \  \
     *             4  5
     *   Output should be 1234567          
     */
    /*
     * SOLUTION : Print rootNode , preOrder(root.left),postOrder(root.right);
     */
//    public static void printBoundaryElements(Node node) {
//    	if(node != null ) 
//    	{    		
//    		System.out.print(node.data + " ");
//    		printBoundaryElementsL(node.leftChild,true);
//    		printBoundaryElementsR(node.rightChild,true);
//    	}
//    }
//    
//    public static void printBoundaryElementsL(Node node,boolean left)
//    {
//    	if(node != null)
//    	{
//    		if(left || (node.leftChild == null && node.rightChild == null))
//    			System.out.print(node.data+" ");
//    		printBoundaryElementsL(node.leftChild,left);
//    		if(node.leftChild != null)
//    			printBoundaryElementsL(node.rightChild,false);
//    		else
//    			printBoundaryElementsL(node.rightChild,true);
//    	}
//    }
//    
//    public static void printBoundaryElementsR(Node node,boolean right)
//    {
//    	if(node != null)
//    	{
//    		if(node.rightChild != null)
//    			printBoundaryElementsR(node.leftChild,false);
//    		else
//    			printBoundaryElementsR(node.leftChild,true);
//    		
//    		printBoundaryElementsR(node.rightChild,right);
//    		if(right || (node.leftChild == null && node.rightChild == null))
//    			System.out.print(node.data + " ");
//    	}
//    }
    void printLeaves(Node node)
    {
        if (node == null)
            return;
 
        printLeaves(node.leftChild);
        // Print it if it is a leaf node
        if (node.leftChild == null && node.rightChild == null)
            System.out.print(node.data + " ");
        printLeaves(node.rightChild);
    }
 
    // A function to print all left boundary nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(Node node)
    {
        if (node == null)
            return;
 
        if (node.leftChild != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            System.out.print(node.data + " ");
            printBoundaryLeft(node.leftChild);
        }
        else if (node.rightChild != null) {
            System.out.print(node.data + " ");
            printBoundaryLeft(node.rightChild);
        }
 
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }
 
    // A function to print all right boundary nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(Node node)
    {
        if (node == null)
            return;
 
        if (node.rightChild != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printBoundaryRight(node.rightChild);
            System.out.print(node.data + " ");
        }
        else if (node.leftChild != null) {
            printBoundaryRight(node.leftChild);
            System.out.print(node.data + " ");
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }
 
    // A function to do boundary traversal of a given binary tree
    void printBoundary(Node node)
    {
        if (node == null)
            return;
 
        System.out.print(node.data + " ");
 
        // Print the left boundary in top-down manner.
        printBoundaryLeft(node.leftChild);
 
        // Print all leaf nodes
        printLeaves(node.leftChild);
        printLeaves(node.rightChild);
 
        // Print the right boundary in bottom-up manner
        printBoundaryRight(node.rightChild);
    }
    
    static int max_level = 0;
    public void printLeftView(Node root, int level)
    {
    	if(root == null)
    		return;
    	
    	if(max_level < level)
    	{
    		System.out.print(root.data + " ");
    		max_level = level;
    	}
    	
    	printLeftView(root.leftChild,level + 1);
    	printLeftView(root.rightChild, level + 1);
    	
    }
    
    // Initialize previously visited node as NULL. This is 
    // static so that the same value is accessible in all recursive 
    // calls 
    static Node prev = null;
    
    // head --> Pointer to head node of created doubly linked list 
    Node head = null;
    
    // A simple recursive function to convert a given Binary tree  
    // to Doubly Linked List 
    // root --> Root of Binary Tree 
    void BinaryTree2DoublyLinkedList(Node root)
    {
    	// Base case 
    	if(root == null)
    		return;
    	
    	// Recursively convert left subtree 
    	BinaryTree2DoublyLinkedList(root.leftChild);
    	
    	// Now convert this node 
    	//left most node is head node of DLL
    	if(prev == null)
    		head = root;
    	else
    	{
    		//
    		root.leftChild = prev;
    		prev.rightChild = root;
    	}
    	//save the current node as prev
    	prev = root;
    	
    	// Finally convert right subtree 
    	BinaryTree2DoublyLinkedList(root.rightChild);
    }
    
    void printDoublyList(Node head)
    {
    	while(head != null)
    	{
    		System.out.print(head.data + " ");
    		head = head.rightChild;
    	}
    }
    
   static boolean isIdenticalBTree(Node root1,Node root2)
    {
    	if(root1 == null && root2 == null)
    	{
    		return true;
    	}
    	
    	if(root1 != null && root2 != null)
    		return (root1.data == root2.data) && 
    			isIdenticalBTree(root1.leftChild, root2.leftChild) && 
    			isIdenticalBTree(root1.rightChild, root2.rightChild);
    	
    	return false;
    }
   
   static boolean isMirrorUtil(Node root1,Node root2)
   {
	   if(root1 == null && root2 == null)
		   return true;
	   
	   if(root1 != null && root2 != null && root1.data == root2.data)
		   return isMirrorUtil(root1.leftChild, root2.rightChild) && 
				   isMirrorUtil(root1.rightChild, root2.leftChild);
	   
	   return false;
   }
   static boolean isMirror(Node root) {
	   return isMirrorUtil(root,root);
   }
   /*
   Sum of all the numbers that are formed from root to leaf paths
   Given a binary tree, where every node value is a Digit from 1-9 .Find the sum of all the numbers which are formed from root to leaf paths.

	For example consider the following Binary Tree.

           6
       /      \
     3          5
   /   \          \
  2     5          4  
      /   \
     7     4
  	There are 4 leaves, hence 4 root to leaf paths:
   	Path                    Number
  	6->3->2                   632
  	6->3->5->7               6357
  	6->3->5->4               6354
  	6->5>4                    654   
	Answer = 632 + 6357 + 6354 + 654 = 13997 
   */
   
   // Returns sum of all root to leaf paths. The first parameter is  
   // root of current subtree, the second parameter is value of the   
   // number formed by nodes from root to this node 
   private static int treePathSumUtil(Node node, int val)
   {
	   // Base case
	   if(node == null)
		   return 0;
	   
	   // Update val
	   val = (val * 10 + node.data);
	   
	   
	   // if current node is leaf, return the current value of val
	   if(node.leftChild == null && node.rightChild == null)
		   return val;
	   
	   // recur sum of values for left and right subtree 
	   return treePathSumUtil(node.leftChild, val) + 
			   treePathSumUtil(node.rightChild, val);
   }
   
   // A wrapper function over treePathsSumUtil()
   private static int treePathSum(Node root)
   {
	// Pass the initial value as 0 as there is nothing above root 
	   return treePathSumUtil(root,0);
   }
   
   /* This function prints all nodes that are distance k from a leaf node
   path[] --> Store ancestors of a node
   visited[] --> Stores true if a node is printed as output.  A node may
   be k distance away from many leaves, we want to print it once */
  static void kDistantFromLeafUtil(Node node, int path[], boolean visited[],
                            int pathLen, int k)
  {
      // Base case
      if (node == null)
          return;

      /* append this Node to the path array */
      path[pathLen] = node.data;
      visited[pathLen] = false;
      pathLen++;

      /* it's a leaf, so print the ancestor at distance k only
       if the ancestor is not already printed  */
      if (node.leftChild == null && node.rightChild == null
          && pathLen - k - 1 >= 0 && visited[pathLen - k - 1] == false) {
          System.out.print(path[pathLen - k - 1] + " ");
          visited[pathLen - k - 1] = true;
          return;
      }

      /* If not leaf node, recur for left and right subtrees */
      kDistantFromLeafUtil(node.leftChild, path, visited, pathLen, k);
      kDistantFromLeafUtil(node.rightChild, path, visited, pathLen, k);
  }

	  /* Given a binary tree and a number k, print all nodes that are k
	   distant from a leaf*/
	  static void printKDistantfromLeaf(Node node, int k)
	  {
	      int path[] = new int[1000];
	      boolean visited[] = new boolean[1000];
	      kDistantFromLeafUtil(node, path, visited, 0, k);
	  }
	  
	  
	  /*
	   *                     1
	   *                    /  \
	   *                   2    3
	   *                  / \
	   *                 4   5
	   *                / \   \
	   *               6   7   8
	   *                   
	   */
	  static int printKthNodeFromLeaf(Node node, int k)
	  {
		  if(node == null)
			  return 0;
		  int l = printKthNodeFromLeaf(node.leftChild, k);
		  int r = printKthNodeFromLeaf(node.rightChild, k);
		  
		  if(l ==k || r == k)
			  System.out.println(" "+ node.data);
		  
		  return 1 + Math.max(l, r);
	  }
   
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.rootNode = new Node(1);
		tree.rootNode.leftChild = new Node(2);
		tree.rootNode.rightChild = new Node (3);
		
		/**
		 * PREORDER TRAVERSAL 
		 */
		System.out.print("PreOrder traversal ");
		tree.preorder(tree.rootNode);
		System.out.println();
		
		
		System.out.print("InOrder traversal ");
		tree.inorder(tree.rootNode);
		System.out.println();
		
		System.out.print("PostOrder traversal ");
		tree.postorder(tree.rootNode);
		System.out.println();
		
		
		tree.rootNode.leftChild.leftChild = new Node(4);
		tree.rootNode.leftChild.rightChild = new Node(5);
		
		tree.rootNode.leftChild.leftChild.leftChild = new Node(6);
		tree.rootNode.leftChild.leftChild.rightChild = new Node(7);
		
		System.out.println("ZigZag traversal is :");
		tree.printZigZagTree();
		
		System.out.println("\nLevel Order traversal is :");
		tree.printLevelOrderTraversal();
		System.out.println();
		
		
		System.out.println("3 is at the level "+getLevel(tree.rootNode, 3));
		
		
		System.out.print("Diameter of the given binary tree is "+ tree.diameter(tree.rootNode));
		
		System.out.println();
		
		
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
		
		System.out.print("Printing left view of the tree : ");
		treeForBoundary.printLeftView(treeForBoundary.rootNode, 1);
		System.out.println();
		
		System.out.print("Printing Boundary Nodes : ");
		treeForBoundary.printBoundary(treeForBoundary.rootNode);
		
		System.out.println("\nPrinting douly linked link conversion of tree ");
		treeForBoundary.BinaryTree2DoublyLinkedList(treeForBoundary.rootNode);
		treeForBoundary.printDoublyList(treeForBoundary.head);
		
		
		System.out.println("\nAre they identical ? " + isIdenticalBTree(tree.rootNode , treeForBoundary.rootNode));
		
		BinaryTree treeForLeafPathSum = new BinaryTree(); 
        treeForLeafPathSum.rootNode = new Node(6); 
        treeForLeafPathSum.rootNode.leftChild = new Node(3); 
        treeForLeafPathSum.rootNode.rightChild = new Node(5); 
        treeForLeafPathSum.rootNode.rightChild.rightChild = new Node(4); 
        treeForLeafPathSum.rootNode.leftChild.leftChild = new Node(2); 
        treeForLeafPathSum.rootNode.leftChild.rightChild = new Node(5); 
        treeForLeafPathSum.rootNode.leftChild.rightChild.rightChild = new Node(4); 
        treeForLeafPathSum.rootNode.leftChild.rightChild.leftChild = new Node(7); 
           
        System.out.print("Sum of all paths is " +  
                                 treeForLeafPathSum.treePathSum(treeForLeafPathSum.rootNode));
        
        /*
  	   *                     1
  	   *                    /  \
  	   *                   2    3
  	   *                  / \
  	   *                 4   5
  	   *                / \
  	   *               6   7 
  	   *                   
  	   */
        BinaryTree treekThNode = new BinaryTree();
        treekThNode.rootNode = new Node(1);
        treekThNode.rootNode.leftChild = new Node(2);
        treekThNode.rootNode.rightChild = new Node(3);
        treekThNode.rootNode.leftChild.leftChild = new Node(4);
        treekThNode.rootNode.leftChild.rightChild = new Node(5);
        treekThNode.rootNode.leftChild.leftChild.leftChild = new Node(6);
        treekThNode.rootNode.leftChild.leftChild.rightChild = new Node(7);
        treekThNode.rootNode.leftChild.rightChild.rightChild = new Node(8);
        System.out.println("\nKth node from leaf");
        printKthNodeFromLeaf(treekThNode.rootNode,1);
        
	}

}
