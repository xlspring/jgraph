package graphs;

import java.util.ArrayList;
import java.util.Collections;

public abstract class BaseGraph implements Graph {
	protected ArrayList<ArrayList<Integer>> adjMatrix;

	public BaseGraph() {
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

	public abstract boolean addEdge(int nodeA, int nodeB);

	public ArrayList<ArrayList<Integer>> getAdjacencyMatrix() { return adjMatrix; }

	protected void increment(int from, int to) {
		adjMatrix.get(from).set(to, adjMatrix.get(from).get(to) + 1);
	}

	protected boolean isValidNode(int node) {
		return node >= 0 && node < adjMatrix.size();
	}
}
