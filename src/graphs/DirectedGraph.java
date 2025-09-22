package graphs;

import java.util.ArrayList;

public class DirectedGraph extends BaseGraph {
	public DirectedGraph() {
		super.adjMatrix = new ArrayList<ArrayList<Integer>> ();
	}

	public boolean addEdge(int nodeA, int nodeB) {
		if (!isValidNode(nodeA) || !isValidNode(nodeB)) {
			throw new IllegalArgumentException("Invalid node index, valid indexes are 0-" + (super.adjMatrix.size() - 1));
		}

		super.increment(nodeA, nodeB);

		return true;
	}
}
