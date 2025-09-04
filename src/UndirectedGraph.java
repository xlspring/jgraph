import java.util.ArrayList;
import java.util.Collections;

public class UndirectedGraph implements Graph {
	ArrayList<ArrayList<Integer>> adjMatrix;

	public UndirectedGraph() {
		adjMatrix = new ArrayList<ArrayList<Integer>> ();
	}

	public void addVertex() {
		int nodes = adjMatrix.size();
		ArrayList<Integer> newNode = new ArrayList<Integer>(Collections.nCopies(nodes + 1, 0));

		for (int i = 0; i < nodes; i++) {
			ArrayList<Integer> currNode = adjMatrix.get(i);
			currNode.addLast(0);
		}

		adjMatrix.addLast(newNode);
	}

	public void removeVertex() {
		adjMatrix.removeLast();

		for (int i = 0; i < adjMatrix.size(); i++) {
			ArrayList<Integer> currNode = adjMatrix.get(i);
			currNode.removeLast();
		}
	}

	public void removeVertex(int node) {
		if (!isValidNode(node)) {
			throw new IllegalArgumentException("Invalid node index, valid indexes are 0-" + (adjMatrix.size() - 1));
		}

		adjMatrix.remove(node);

		for (int i = 0; i < adjMatrix.size(); i++) {
			ArrayList<Integer> currNode = adjMatrix.get(i);
			currNode.remove(node);
		}
	}

	public String addEdge(int nodeA, int nodeB) {
		if (!isValidNode(nodeA) || !isValidNode(nodeB)) {
			throw new IllegalArgumentException("Invalid node index, valid indexes are 0-" + (adjMatrix.size() - 1));
		}

		increment(nodeA, nodeB);
		increment(nodeB, nodeA);

		return nodeA + " -- " + nodeB;
	}

	public void print() {
		for (int i = 0; i < adjMatrix.size(); i++) {
			ArrayList<Integer> currRow = adjMatrix.get(i);
			System.out.print(i + " | ");

			for (int j = 0; j < currRow.size(); j++) {
				System.out.print(currRow.get(j) + " ");
			}

			System.out.print("\n");
		}

		System.out.print("\n");
	}

	private void increment(int from, int to) {
		adjMatrix.get(from).set(to, adjMatrix.get(from).get(to) + 1);
	}

	private boolean isValidNode(int node) {
		return node >= 0 && node < adjMatrix.size();
	}
}
