public class Edge {
	private Vertex connected;
	private int weight;

	public Edge(Vertex v, int w) {
		connected = v;
		weight = w;
	}

	public Vertex getVertex() {
		return connected;
	}

	public int getWeight() {
		return weight;
	}
}
