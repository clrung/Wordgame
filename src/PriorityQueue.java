public class PriorityQueue {
	private Heap heap;

	public PriorityQueue() {
		heap = new Heap();
	}

	public HeapElt removeMin() {
		if (isEmpty())
			return null;
		return heap.removeMin();
	}

	public HeapElt peekMin() {
		if (isEmpty())
			return null;
		return heap.peekMin();
	}

	public void insert(HeapElt inElt) {
		heap.insert(inElt);
	}

	public boolean isEmpty() {
		return heap.getHeapSize() == 0;
	}

	public void updateElement(HeapElt newElt) {
		heap.heapifyUp(newElt.getHandle());
	}
}
