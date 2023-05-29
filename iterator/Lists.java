//complicated

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

// Ignores ConcurrentModificationExceptions
public class Lists<T> implements Iterable<T> {
    private List<List<T>> lists;
    public Lists(List<List<T>> lists) {
        this.lists = lists;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new ListsIterator();
    }
    
    public class ListsIterator implements Iterator<T> {
        private Iterator<List<T>> listsIter;
        private Iterator<T> listIter;
        private void hop() {
            listIter = null;
            if (listsIter == null) {
                return;
            }
            while (listsIter.hasNext()) {
                List<T> list = listsIter.next();
                // Here is the flattening
                if (list == null || list.isEmpty()) {
                    listsIter.remove();
                } else {
                    listIter = list.iterator();
                    break;
                }
            }
        }
        public ListsIterator() {
            if (lists != null) {
                listsIter = lists.iterator();
            }
            hop();
        }
        @Override
        public boolean hasNext() {
            if (listIter == null) {
                return false;
            }
            if (listIter.hasNext()) {
                return true;
            }
            hop();
            if (listIter == null) {
                return false;
            }
            return true;
        }
        @Override
        public T next() {
            if (listIter == null) {
                throw new NoSuchElementException();
            }
            if (listIter.hasNext()) {
                return listIter.next();
            }
            hop();
            if (listIter == null) {
                throw new NoSuchElementException();
            }
            return listIter.next();
        }
        @Override
        public void remove() {
            if (listIter == null) {
                throw new IllegalStateException();
            }
            listIter.remove();
            if (!listIter.hasNext()) {
                hop();
            }
        }
    }
    public static void main(String[] args) {
        // Test 0
        Lists<Integer> lists = new Lists<Integer>(null);
        Iterator<Integer> i = lists.iterator();
        System.out.println(i.hasNext());
        try {
            i.next();
        } catch (NoSuchElementException e) {
        }
        try {
            i.remove();
        } catch (IllegalStateException e) {
        }
        // Test 1
        List<List<Integer>> test1 = new ArrayList<List<Integer>>();
        test1.add(null);
        List<Integer> list = new LinkedList<Integer>();
        list.add(1);list.add(2);
        test1.add(list);
        test1.add(Collections.<Integer>emptyList());
        list = new LinkedList<Integer>();
        list.add(3);list.add(4);
        test1.add(list);
        lists = new Lists<Integer>(test1);
        i = lists.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
            i.remove();
        }
        System.out.println();
        i = lists.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();
    }
}