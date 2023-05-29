package my.binary.tree.max.sum.path;

/*
 * Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that the sum of chosen nodes 
 * is maximum under a constraint that no two chosen nodes in the subset should be directly connected that is, 
 * if we have taken a node in our sum then we can’t take any of its children in consideration and vice versa
 */


public class MaxSumPathWithoutConsecutiveNodes {

	Node root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSumPathWithoutConsecutiveNodes tree =new MaxSumPathWithoutConsecutiveNodes();
		tree.root = new Node(1); 
        tree.root.left = new Node(5); 
        tree.root.right = new Node(2); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(1); 
        tree.root.right.right = new Node(25); 
//        tree.root.right.right.left = new Node(3); 
//        tree.root.right.right.right = new Node(4); 
        System.out.println("maximum path sum is : " + 
                            tree.findMaxSumUtil(tree.root)); 
	}
	int max_sum = Integer.MIN_VALUE;
	
	public int sumofGrandChildren(Node root)
	{
		int sum = 0;
		if(root.left != null)
			sum += findMaxSumUtil(root.left.left) + findMaxSumUtil(root.left.right);
		if(root.right != null)
			sum+= findMaxSumUtil(root.right.left) + findMaxSumUtil(root.right.left);
		
		return sum;
		
	}
	public int findMaxSumUtil(Node root) {
		// TODO Auto-generated method stub
		if(root == null)
			return 0;
		
		int sum_including_node_data = root.data + sumofGrandChildren(root);
		
		int sum_without_node_data = findMaxSumUtil(root.left) 	+ findMaxSumUtil(root.right);
		max_sum = Math.max(sum_including_node_data, sum_without_node_data);
		
		return max_sum;
		
	}

}
