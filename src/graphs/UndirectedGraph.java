package graphs;

import java.util.ArrayList;

public class UndirectedGraph extends BaseGraph {
	public UndirectedGraph() {
		adjMatrix = new ArrayList<ArrayList<Integer>> ();
	}

	public boolean addEdge(int nodeA, int nodeB) {
		if (!isValidNode(nodeA) || !isValidNode(nodeB)) {
			throw new IllegalArgumentException("Invalid node index, valid indexes are 0-" + (adjMatrix.size() - 1));
		}

		increment(nodeA, nodeB);
		increment(nodeB, nodeA);

		return true;
	}
}
