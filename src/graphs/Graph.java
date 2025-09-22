package graphs;

import java.util.ArrayList;

public interface Graph {
	public void addVertex();
	public void removeVertex();
	public void removeVertex(int node) throws IllegalArgumentException;
	public boolean addEdge(int nodeA, int nodeB) throws IllegalArgumentException;
	public ArrayList<ArrayList<Integer>> getAdjacencyMatrix();
}
