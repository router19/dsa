import java.util.Scanner;

class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
}


public class BST
{
    Node rootNode;
    int minValue(Node node)
    {
        if(node == null)
            return -1;
        if(node.left == null)
            return node.data;
        if(node.left !=null)
            return minValue(node.left);
        return -1;
    }
    
    
    void addToBST(int key){
        rootNode = addToBSTRec(rootNode,key);
    }
    
    Node addToBSTRec(Node root,int key){
        if(root == null ){
            root = new Node(key);
            return root;
        }
        if(key > root.data)
            root.right = addToBSTRec(root.right,key);
        else if(key <= root.data)
            root.left = addToBSTRec(root.left,key);
            
        return root;
    }
    
    public boolean isBST(Node root)
    {
    	return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    public boolean isBSTUtil(Node root,int min,int max)
    {
    	if(root == null)
    		return true;
    	
    	if(root.data < min || root.data > max)
    		return false;
    	
    	return isBSTUtil(root.left, min, root.data ) &&
    			isBSTUtil(root.right, root.data, max);
    }
    
    public Node lca(Node root,int n1,int n2)
    {
    	if(root == null)
    		return null;
    	
    	if(root.data > n1 && root.data > n2)
    		return lca(root.left, n1, n2);
    	if(root.data < n1 && root.data < n2)
    		return lca(root.right, n1, n2);
    	
    	return root;
    }
    
    int check =1;
    Node printKthSmallestElement(Node root, int k )
    {
    	if(root == null)
    	{
    		return null;
    	}
    		
		Node left = printKthSmallestElement(root.left, k);
	
		if(left != null)
			return left;

		if(check == k)
		{
			System.out.println(k+"th smallest element is "+ root.data);
			return root;
		}			
		check++;
		
		return printKthSmallestElement(root.right, k);
    	
    }
    public static void main(String arg[]){
       // Scanner in = new Scanner(System.in);
        //int test_cases = in.nextInt();
        
        BST tree;
        
        /*
        for(int i =0; i< test_cases;i++){
            int noOfNodes = in.nextInt();
            tree = new BST();
            for(int j =0; j< noOfNodes;j++){
                tree.addToBST(in.nextInt());
            }
            int minValue = tree.minValue(tree.rootNode);
            System.out.println(minValue);
        }*/
       tree = new BST();
       tree.addToBST(10);
       tree.addToBST(3);
       tree.addToBST(2);
       tree.addToBST(4);
       tree.addToBST(11);
       /*
        *          10 
        *         /  \
        *        3    11
        *       /  \
        *      2    4
        */
       System.out.println(tree.isBST(tree.rootNode));
       
       System.out.println("LCA of 2 and 4 is " +(tree.lca(tree.rootNode, 2, 4)).data);
       
       Node node = tree.printKthSmallestElement(tree.rootNode, 5);
       System.out.println(node.data);
    }
}
