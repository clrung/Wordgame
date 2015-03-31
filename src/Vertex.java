import java.util.ArrayList;

public class Vertex extends HeapElt {
	private ArrayList<Edge> edges;
	private String wordName;
	private Vertex predecessor;

	public Vertex(String name) {
		wordName = name;
		edges = new ArrayList<Edge>();
	}

	public void addEdge(Vertex v, int weight) {
		edges.add(new Edge(v, weight));
	}

	public String getName() {
		return wordName;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void setPredecessor(Vertex p) {
		predecessor = p;
	}

	public Vertex getPredecessor() {
		return predecessor;
	}
}
