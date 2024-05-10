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
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

	public static List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null)
			return result;
		List<Integer> nodes = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		Node node = null;
		while(!q.isEmpty())
		{
			node = q.poll();
			System.out.println(node);
			if(node != null)
			{
				nodes.add(node.data);
				if(node.left != null)
					q.add(node.left);
				if(node.right != null)
					q.add(node.right);

			}else if(!q.isEmpty())
			{
				result.add(nodes);
				nodes = new ArrayList<>();
				System.out.println("Adding null");
				q.add(null);
			}

		}
		result.add(nodes);
		return result;
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

		Node root1 = new Node(3);
		root1.left = new Node(9);
		root1.right = new Node(20);
		root1.right.left = new Node(15);
		root1.right.right = new Node(7);

		System.out.println(levelOrder(null));
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
