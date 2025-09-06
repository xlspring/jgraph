public class Main {
    public static void main(String[] args) {
			System.out.print("Graph thingy!\n");

			UndirectedGraph graph = new UndirectedGraph();

			for (int i = 0; i < 8; i++) {
				graph.addVertex();
			}

			graph.addEdge(0, 2);
			graph.addEdge(0, 1);
			graph.addEdge(0, 3);
			graph.addEdge(3, 4);
			graph.addEdge(3, 5);
			graph.addEdge(4, 6);
			graph.addEdge(6, 2);
			graph.addEdge(7, 7);
			graph.addEdge(7, 4);
			graph.addEdge(0, 7);

			GraphPrinter
					.console()
					.print(graph);

			graph.removeVertex(2);

			GraphPrinter
					.console()
					.print(graph);

			GraphPrinter
					.graphviz()
					.print(graph);
    }
}