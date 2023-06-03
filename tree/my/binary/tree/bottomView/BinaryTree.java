package my.binary.tree.bottomView;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

class Node {
	int data;
	Node left;
	Node right;

	int hd;

	public Node(int data)
	{
		this.data = data;
		hd = Integer.MAX_VALUE;
		left = right = null;
	}
}
public class BinaryTree {

	Node root;
	
	public BinaryTree(Node node)
	{
		this.root = node;
	}
    //Vertical Print
    /*
     Given a binary tree, print it vertically. The following example illustrates vertical order traversal.

       1
    /    \ 
   2      3
  / \   /   \
 4   5  6   7
           /  \ 
          8    9 
           
          
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9
*/
	public void verticalView()
	{
		if(root == null)
			return ;
		
		Queue<Node> queue = new LinkedList();
		Map<Integer,List<Integer>> map = new TreeMap();
		
		int hd = 0;
		
		root.hd = hd;
		
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			Node temp = queue.poll();
			hd = temp.hd;
			
			List<Integer> value = map.get(hd);
			if(value == null)
			{
				value = new LinkedList();
				value.add(temp.data);
				
			}
			else
				value.add(temp.data);
			
			map.put(hd, value);
			
			if(temp.left != null)
			{
				temp.left.hd = hd - 1;
				queue.add(temp.left);
			}
			
			if(temp.right != null)
			{
				temp.right.hd = hd + 1;
				queue.add(temp.right);
			}
			
		}
		
		for(Entry<Integer, List<Integer>> entry : map.entrySet())
			System.out.println(entry.getValue() + " ");
		
	}
	
	
	/*
	 * Given a Binary Tree, we need to print the bottom view from left to right. A node x is there in output if 
	 * x is the bottommost node at its horizontal distance. Horizontal distance of left child of a node x is equal
	 *  to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.

	Examples:

                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \      
                  10    14

For the above tree the output should be 5, 10, 3, 14, 25.
	 */
	public void bottomView()
	{
		if(root == null)
			return;
		
		Map<Integer,Integer> map = new TreeMap();
		
		Queue<Node> queue = new LinkedList();
		
		int hd = 0;
		
		root.hd = hd;
		
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			Node temp = queue.poll();
			hd = temp.hd;
			
			map.put(hd, temp.data);
			
			if(temp.left != null)
			{
				temp.left.hd = hd - 1;
				queue.add(temp.left);
			}
			
			if(temp.right != null)
			{
				temp.right.hd = hd + 1;
				queue.add(temp.right);
			}
		}
		
		System.out.println("Botton view ");
		for(Entry<Integer,Integer> entry : map.entrySet())
			System.out.print(entry.getValue() +" ");
	}
	
	public static void main(String[] args) {
		
		
		Node root = new Node(20); 
        root.left = new Node(8); 
        root.right = new Node(22); 
        root.left.left = new Node(5); 
        root.left.right = new Node(3); 
        //root.right.left = new Node(4); 
        root.right.right = new Node(25); 
        root.left.right.left = new Node(10); 
        root.left.right.right = new Node(14); 
        BinaryTree tree = new BinaryTree(root); 
        
        /*
         * Examples:

                      20
                    /    \
                  8       22
                /   \    /  \
              5      3  4    25
                    / \      
                  10    14

	For the above tree the output should be 5, 10, 3, 14, 25.
         */
        System.out.println("Bottom view of the given binary tree:"); 
        tree.bottomView(); 
		
        
        //Vertical Print
        /*
         Given a binary tree, print it vertically. The following example illustrates vertical order traversal.

           1
        /    \ 
       2      3
      / \   /   \
     4   5  6   7
               /  \ 
              8   9 
               
              
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9
         */
        Node root1 = new Node(1); 
        root1.left = new Node(2); 
        root1.right = new Node(3); 
        root1.left.left = new Node(4); 
        root1.left.right = new Node(5); 
        root1.right.left = new Node(6); 
        root1.right.right = new Node(7); 
        root1.right.left.right = new Node(8); 
        root1.right.right.right = new Node(9); 
        BinaryTree tree1 = new BinaryTree(root1);
        System.out.println("\nVertical Order traversal is"); 
        tree1.verticalView(); 
	}

}
