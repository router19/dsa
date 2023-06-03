package my.binary.tree.nextRight;
/*
 * 
Write a function to connect all the adjacent nodes at the same level in a binary tree.

Example:

Input Tree
       A
      / \
     B   C
    / \   \
   D   E   F


Output Tree
       A--->NULL
      / \
     B-->C-->NULL
    / \   \
   D-->E-->F-->NULL

 */
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int data;
	Node right,left;
	Node nextRight;

	Node(int key)
	{
		data = key;
	}
}
public class ConnectNodeAtSameLevel {
	
	Node root;
	
	public ConnectNodeAtSameLevel(Node root)
	{
		this.root = root;
	}

	static void connect(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		// null marker to represent end of current level 
		queue.add(null);
		
		 // Do Level order of tree using NULL markers 
		while(!queue.isEmpty())
		{
			Node p = queue.poll();
			
			if(p != null)
			{
				// next element in queue represents next  
                // node at current Level  
				p.nextRight = queue.peek();
				
				// push left and right children of current 
                // node 
				if(p.left != null) 
					queue.add(p.left);
				if(p.right != null)
					queue.add(p.right);
			}
			 // Note: we had pushed NULL to mark end of level,
			//if p == NULL , means we are end of a level , 
			//now if queue is not empty means a new level as been pushed, 
			//hence push NULL to mark nodes at this level are visited 
			/*
			  Input Tree
					       A
					      / \
					     B   C
					    / \   \
					   D   E   F
			 */
			

			else if(!queue.isEmpty())
				queue.add(null);
		}
		
	}
	public static void main(String[] args) {
		

		/* Constructed binary tree is 
        			10 
      			  /   \ 
    			 8      2 
  				/         \ 
			   3            90 
		 */
		Node root = new Node(10); 
		root.left = new Node(8); 
		root.right = new Node(2); 
		root.left.left = new Node(3); 
		root.right.right = new Node(90); 

		// Populates nextRight pointer in all nodes 
		connect(root); 

		// Let us check the values of nextRight pointers 
		System.out.println("Following are populated nextRight pointers in \n" + 
				"the tree (-1 is printed if there is no nextRight)"); 
		System.out.println("nextRight of "+ root.data +" is "+ 
				((root.nextRight != null) ? root.nextRight.data : -1)); 
		System.out.println("nextRight of "+ root.left.data+" is "+ 
				((root.left.nextRight != null) ? root.left.nextRight.data : -1)); 
		System.out.println("nextRight of "+ root.right.data+" is "+ 
				((root.right.nextRight != null) ? root.right.nextRight.data : -1)); 
		System.out.println("nextRight of "+  root.left.left.data+" is "+ 
				((root.left.left.nextRight != null) ? root.left.left.nextRight.data : -1)); 
		System.out.println("nextRight of "+  root.right.right.data+" is "+ 
				((root.right.right.nextRight != null) ? root.right.right.nextRight.data : -1)); 
		
	}

}
