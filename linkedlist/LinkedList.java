/*
 * 
 */
import java.util.HashMap;
import java.util.Stack;

public class LinkedList {
	Node head;
	static class Node{
		int data;
		Node next;
		Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	
	public static Node reverse(Node head)
	{
		Node curr = head;
		Node prev = null;
		Node next = head.next;
		
		while(curr.next != null)
		{
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}
		curr.next = prev;
		return curr;
	}
	
	/*
	 * Given a linked list, write a function to reverse every k nodes (where k is an input to the function). 

	Example: 
	
	Input: 1->2->3->4->5->6->7->8->NULL, K = 3 
	Output: 3->2->1->6->5->4->8->7->NULL 
	Input: 1->2->3->4->5->6->7->8->NULL, K = 5 
	Output: 5->4->3->2->1->8->7->6->NULL 
	 */
	 
	Node reverse(Node head, int k)
    {
        if(head == null)
          return null;
        Node current = head;
        Node next = null;
        Node prev = null;
 
        int count = 0;
 
        /* Reverse first k nodes of linked list */
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
 
        /* next is now a pointer to (k+1)th node
           Recursively call for the list starting from
           current. And make rest of the list as next of
           first node */
        if (next != null)
            head.next = reverse(next, k);
 
        // prev is now head of input list
        return prev;
    }
	
	
	
	//modify the LL such that 
	//Given a Singly Linked list, Update the second half of the list such that n-th element becomes 
	//sum(1st + nth) element, (n-1)st element becomes sum(2nd + n-1st) element and so on.
	//Eg: 2->3->4->5->6 => 2->3->(4+4)->(5+3)->(6+2)
	public static  Node modify(Node head){
        //Write your 
        Node temp1 = head, temp2 = head;
        Stack<Integer> s = new Stack<Integer>();
        while(temp1 != null)
        {
            s.push(temp2.data);
            // 2 3 4 5 6 7 
            if(temp1.next != null)
            {
              temp1 = temp1.next.next;
              temp2 = temp2.next;
            }
            else
                break;
               
        }
        while(temp2 != null)
        {
         temp2.data += s.pop();
         temp2 = temp2.next;
        }
        return head;
    }

	
	
	public static void main(String a[]) {
		LinkedList ll = new LinkedList();
		ll.head = new Node(3);
		ll.head.next = new Node(2);
		ll.head.next.next = new Node(5);
		ll.head.next.next.next = new Node(8);
		ll.head.next.next.next.next = new Node(5);
		ll.head.next.next.next.next.next = new Node(2);
		ll.head.next.next.next.next.next.next = new Node(1);
		Node temp = ll.head;
		System.out.print("LinkedList is : ");
		HashMap<Integer,Integer> map = new HashMap();
		int count;
		while(temp !=null) {
			System.out.print(temp.data +" -> ");
			if(map.containsKey(temp.data))
			 {
				count = map.get(temp.data);
				map.put(temp.data, count+1);
			 }
			else
			 {
				map.put(temp.data, 1);
			 }
			temp = temp.next;
		}
		System.out.println("X");
		
		int a1[] = { 5, 1, 3, 2, 8 }; 
		for(int i =0;i < a1.length;i++)
		{
			if(map.containsKey(a1[i]))
			{
				count = map.get(a1[i]);
				while(count -- > 0)
					System.out.print(a1[i] +" -> ");
			}
		}
		LinkedList ll2 = new LinkedList();
		ll2.head = new Node(2);
		ll2.head.next = new Node(3);
		ll2.head.next.next = new Node(4);
		ll2.head.next.next.next = new Node(5);
		ll2.head.next.next.next.next = new Node(6);
		ll2.head.next.next.next.next.next = new Node(7);
		
		//modify the LL such that 
		//Given a Singly Linked list, Update the second half of the list such that n-th element becomes 
		//sum(1st + nth) element, (n-1)st element becomes sum(2nd + n-1st) element and so on.
		//Eg: 2->3->4->5->6 => 2->3->(4+4)->(5+3)->(6+2)
		System.out.println("\n\nModifying the list");
		ll2.head = modify(ll2.head);
		while(ll2.head != null)
		{	
			System.out.print(ll2.head.data + " -> ");
			ll2.head  = ll2.head.next;
		}
		System.out.println("NULL");
		
	}
}
