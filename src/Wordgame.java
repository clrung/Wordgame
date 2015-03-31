import java.util.Scanner;
import java.util.ArrayList;

public class Wordgame {
	private Graph graph;
	private Scanner scanner;

	public void buildGraph(Scanner scanner) {
		String read = null;
		graph = new Graph();
		while (scanner.hasNext()) {
			read = scanner.next();
			graph.addVertex(read);
		}

		Vertex current;
		int weight;
		for (int x = 0; x < graph.getSize(); x++) {
			current = graph.getVertex(x);
			for (int y = 0; y < graph.getSize(); y++) {
				if (y != x) {
					weight = compare(current.getName(), graph.getVertex(y).getName());
					if (weight == 1 || weight == 5) {
						current.addEdge(graph.getVertex(y), weight);
					}
				}
			}
		}
	}

	private int compare(String s1, String s2) {
		int diff = 0;

		for (int x = 0; x < 5; x++) {
			if (s1.charAt(x) != s2.charAt(x)) {
				diff++;
			}
		}

		if (diff == 1) {
			return 1;
		} else if (diff == 2) {
			return 5;
		} else {
			return -1;
		}
	}

	private void dijkstra(Graph graph, int sourceIndex) {
		Vertex source = graph.getVertex(sourceIndex);
		PriorityQueue PQ = new PriorityQueue();
		ArrayList<Edge> adjacentEdges = null;
		Vertex u = null;
		Edge e = null;

		// Initialize priority first search
		for (int i = 0; i < graph.getSize(); i++) {
			u = graph.getVertex(i);
			u.setRecord(Integer.MAX_VALUE);
			u.setPredecessor(null);
			PQ.insert(u);
		}

		source.setRecord(0);
		PQ.updateElement(source);

		while (!PQ.isEmpty()) {
			u = (Vertex) PQ.removeMin();
			adjacentEdges = u.getEdges();

			for (int i = 0; i < adjacentEdges.size(); i++) {
				e = adjacentEdges.get(i);
				if (((Integer) u.getRecord() + e.getWeight()) < (Integer) e.getVertex().getRecord()) {
					e.getVertex().setPredecessor(u);
					e.getVertex().setRecord((Integer) u.getRecord() + e.getWeight());
					PQ.updateElement(e.getVertex());
				}
			}
		}
	}

	private ArrayList<String> getPath(Vertex v1, Vertex v2) {
		ArrayList<String> path = new ArrayList<String>();
		Vertex v = v2;
		path.add(v2.getName());

		while (v != v1) {
			v = v.getPredecessor();
			path.add(v.getName());
		}

		return path;
	}

	/**
	 * This game finds all of the neighbors of a five letter word.
	 */
	public void startNeighborGame() {
		scanner = new Scanner(System.in);
		int index = -1;
		ArrayList<Edge> edges = null;
		Edge edge = null;
		String word = null;

		do {
			System.out.print("Enter a five-letter word: ");
			word = scanner.next().toUpperCase();
			if (word.length() != 5)
				System.out.println(word + " is not a 5-letter word.  Please try again.");
		} while (word.length() != 5);

		index = graph.findVertex(word);
		if (index == -1)
			System.out.println("Word not found!");
		else {
			System.out.print("\nThe neighbors of " + word + " are:\t");
			edges = graph.getVertex(index).getEdges();
			for (int i = 0; i < edges.size(); i++) {
				edge = edges.get(i);
				// insert newline after every 6th word
				if (i % 6 == 0)
					System.out.print("\n\t");
				System.out.print(edge.getVertex().getName() + " (" + edge.getWeight() + ")  ");
			}
		}
	}

	/**
	 * This game finds the distance between two five letter words.
	 */
	public void startDistanceGame() {
		String word1 = null;
		String word2 = null;
		scanner = new Scanner(System.in);

		do {
			System.out.print("Input the first five-letter word: ");
			word1 = scanner.next().toUpperCase();
			if (word1.length() != 5)
				System.out.println(word1 + " is not a 5-letter word.  Please try again.");
		} while (word1.length() != 5);

		do {
			System.out.print("Input the second five-letter word: ");
			word2 = scanner.next().toUpperCase();
			if (word2.length() != 5)
				System.out.println(word2 + " is not a 5-letter word.  Please try again.");
		} while (word2.length() != 5);

		int vertex1Index = graph.findVertex(word1);
		int vertex2Index = graph.findVertex(word2);

		if (vertex1Index != -1) {
			if (vertex2Index != -1) {
				// both words were found in the dictionary

				Vertex vertex1 = graph.getVertex(vertex1Index);
				Vertex vertex2 = graph.getVertex(vertex2Index);

				dijkstra(graph, vertex1Index);

				System.out.println("\nThe best score for " + word1 + " to " + word2 + " is " + (Integer) vertex2.getRecord()
						+ " points.");

				ArrayList<String> path = getPath(vertex1, vertex2);

				System.out.print("\n\t");
				for (int x = path.size() - 1; x > -1; x--) {
					System.out.print(path.get(x) + "  ");
				}
				System.out.println("");
			} else {
				System.out.println("The second word was not found in the dictionary.");
			}
		} else {
			if (graph.findVertex(word2) != -1) {
				System.out.println("The first word was not found in the dictionary.");
			} else {
				System.out.println("Neither of the words were found in the dictionary.");
			}
		}
	}
}