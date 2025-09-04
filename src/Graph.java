public interface Graph {
	public void addVertex();
	public void removeVertex();
	public void removeVertex(int node) throws IllegalArgumentException;
	public String addEdge(int nodeA, int nodeB) throws IllegalArgumentException;
}
