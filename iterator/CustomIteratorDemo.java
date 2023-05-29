import java.util.Iterator;

/*
 Given below is a Custom Linked List which makes use of Generics. The linked list consists of Node objects which
  contain a Generic data value and pointer to next node. The class provides some standard ‘get’ methods like
   getHead() and getTail(), and the necessary Iterator() function, which has to be implemented while implementing
    Iterable interface.

Then the necessary custom class ‘ListIterator’ is created, which will implement the Iterator interface, 
along with it the functionalities of hasNext() and next() are also to be implemented. 
These two functions form the core of Iterable and Iterator interface.
 */
class MyList<T> implements Iterable{
	Node<T> head,tail;
	
	public void add(T data)
	{
		Node<T> node = new Node<>(data,null);
		if(head == null)
			tail = head = node;
		else
		{
			tail.setNext(node);
			tail = node;
		}
	}
	
	public Node<T> getHead()
	{
		return head;
	}
	
	public Node<T> getTail()
	{
		return tail;
	}
	
	public Iterator<T> iterator()
	{
		return new ListIterator<T>(this);
	}
	
}

class ListIterator<T> implements Iterator<T>{
	Node<T> current;
	public ListIterator(MyList<T> list)
	{
		current = list.getHead();
	}
	
	public boolean hasNext()
	{
		return current != null;
	}
	
	public T next() {
		T data = current.getData();
		current = current.getNext();
		return data;
	}
	
	
}
class Node<T>{
	
	T data;
	Node<T> next;
	
	public Node(T data, Node<T> next)
	{
		this.data = data;
		this.next = next;
	}
	
	public void setData(T data)
	{
		this.data = data;
	}
	
	public void setNext(Node<T> next)
	{
		this.next = next;
	}
	
	public T getData()
	{
		return this.data;
	}
	
	public Node<T> getNext()
	{
		return this.next;
	}
}
public class CustomIteratorDemo {

	public static void main(String[] args) {
		MyList<String> mylist = new MyList<>();
		
		mylist.add("one");
		mylist.add("two");
		mylist.add("three");
		mylist.add("four");
		
		
		
	}

}
