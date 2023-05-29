import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenList<T> implements Iterator<T>,Iterable<T> {

	List<List<T>> listofList;
	int elemIndex = 0;
	int listIndex = 0;
	
	List<T> curList;
	
	public FlattenList(List<List<T>> listofList)
	{
		this.listofList = listofList;
		
		if(listofList.size() > 0)
			curList = listofList.get(0);
	}
	
	
	@Override
	public boolean hasNext() {
		
		while(listIndex < listofList.size())
		{
			if(elemIndex < curList.size())
				return true;
			if(++listIndex < listofList.size()) {
				curList = listofList.get(listIndex);
				elemIndex = 0;
			}
		}
		return false;
	}

	@Override
	public T next() {
		if(elemIndex >= curList.size())
			return null;
		return curList.get(elemIndex++);
	}

	@Override
	public Iterator<T> iterator() {
		
		return this;
	}
	
	public static void main(String[] args) {
		
		List<List<Integer>> listoflist = new ArrayList<List<Integer>>();
		List<Integer> intList;
		for (int i = 2; i <= 6; i++) {
			intList = new ArrayList<Integer>();
			for (int j = 1; j < i; j++)
				intList.add(j);
			listoflist.add(intList);
		}
		FlattenList<Integer> flatlist = new FlattenList<>(listoflist);
		Iterator<Integer> iter = flatlist.iterator();
		while (iter.hasNext())
			System.out.print(iter.next() +" ");
	}
}
