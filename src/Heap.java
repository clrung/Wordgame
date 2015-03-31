public class Heap {
	private HeapElt[] array;
	private int heapSize;
	private int arraySize;

	public Heap() {
		array = new HeapElt[4];
		heapSize = 0;
		arraySize = 4;
	}

	private void exchange(int pos1, int pos2) {
		HeapElt temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
		array[pos1].setHandle(pos1);
		array[pos2].setHandle(pos2);
	}

	private void doubleHeap() {
		HeapElt[] temp = array;
		array = new HeapElt[arraySize * 2];

		for (int x = 1; x <= heapSize; x++) {
			array[x] = temp[x];
		}

		arraySize *= 2;
	}

	@SuppressWarnings("unchecked")
	public void heapifyUp(int pos) {
		while (pos > 1 && array[parent(pos)].getRecord().compareTo(array[pos].getRecord()) > 0) {
			exchange(pos, parent(pos));
			pos = parent(pos);
		}
	}

	@SuppressWarnings("unchecked")
	public void heapifyDown(int pos) {
		int l = left(pos);
		int r = right(pos);
		int smallest;

		if (l <= heapSize && array[l].getRecord().compareTo(array[pos].getRecord()) < 0)
			smallest = l;
		else
			smallest = pos;

		if (r <= heapSize && array[r].getRecord().compareTo(array[smallest].getRecord()) < 0)
			smallest = r;

		if (smallest != pos) {
			exchange(pos, smallest);
			heapifyDown(smallest);
		}

	}

	public void insert(HeapElt inElt) {
		if (heapSize + 1 == arraySize)
			doubleHeap();

		heapSize++;

		array[heapSize] = inElt;
		inElt.setHandle(heapSize);
		heapifyUp(heapSize);
	}

	public HeapElt removeMin() {
		HeapElt min = array[1];
		array[1] = array[heapSize];
		array[1].setHandle(1);
		heapSize--;
		heapifyDown(1);

		return min;
	}

	public HeapElt peekMin() {
		return array[1];
	}

	public int getHeapSize() {
		return heapSize;
	}

	public void printHeap() {
		System.out.println("value  handle");
		System.out.println("-----  ------");

		for (int x = 1; x <= heapSize; x++) {
			System.out.println("  " + array[x].getRecord() + "       " + array[x].getHandle());
		}
	}

	private int parent(int x) {
		return x / 2;
	}

	private int right(int x) {
		return x * 2 + 1;
	}

	private int left(int x) {
		return x * 2;
	}
}
