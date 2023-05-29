package iteratorForKSortedArrays;

import java.util.PriorityQueue;

class MyIterator {
	PriorityQueue<Integer> pq = new PriorityQueue<>();
	int[][] data = null;
	int[] k = null;// array to keep track of element index of each k array to be taken next

	public MyIterator(int[][] data) {
		this.data = data;
		//initialize all with zeros
		k = new int[data.length];
		//take first element of all k sorted arrays
		this.preProcess(data);
	}

	int next() {
		int tmp = pq.remove();
		this.postProcess(tmp);
		return tmp;

	}

	boolean hashNext() {
		return pq.isEmpty();

	}

	public void preProcess(int[][] data) {
		for (int i = 0; i < k.length; i++) {
			pq.add(data[i][k[i]]);
		}
	}

	public void postProcess(int removedData) {
		//Iterate over 1 element each of k array until next element is picked up from one of the array
		for (int i = 0; i < k.length; i++) {
			//Make sure that the k[i] that the element removed index is less than length of the current array
			//if k[i] element of a particular element is removed then increase the pointer and add next element in that array in the PQ.
			if (k[i] < data[i].length && data[i][k[i]] == removedData) {
				k[i] = k[i] + 1;
				//Add next element of the array of which element has been removed.
				if (k[i] < data[i].length) {
					pq.add(data[i][k[i]]);
				}
				return;
			}
		}
	}
}

public class IteratorInKSortedArray {

	public static void main(String[] args) {
		int[][] in = { { 1, 5, 7 }, { 2, 3, 10 }, { 4, 6, 9 } };

		MyIterator itr = new MyIterator(in);
		while (!itr.hashNext()) {
			System.out.print(itr.next() + " ");
		}

	}

}
