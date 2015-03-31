public class Graph {
	private Vertex[] nodes;
	private int size;

	public Graph() {
		nodes = new Vertex[10000];
		size = 0;
	}

	public void addVertex(String name) {
		nodes[size] = new Vertex(name);
		size++;
	}

	public Vertex getVertex(int position) {
		if (position < 0 || position >= 10000) {
			return null;
		} else {
			return nodes[position];
		}
	}

	public int findVertex(String name) {
		// Binary search on the array because input/graph is in alphabetical
		// order
		int min = 0;
		int max = size - 1;
		int mid;

		while (max >= min) {
			mid = (max + min) / 2;
			if (nodes[mid].getName().compareTo(name) < 0) {
				min = mid + 1;
			} else if (nodes[mid].getName().compareTo(name) > 0) {
				max = mid - 1;
			} else {
				return mid;
			}
		}

		// node not found
		return -1;
	}

	public int getSize() {
		return size;
	}

	public Vertex[] getNodes() {
		return nodes;
	}
}
