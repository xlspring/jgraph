import graphs.DirectedGraph;
import printers.GraphPrinter;

public class Main {
    public static void main(String[] args) {
			System.out.print("graphs.Graph thingy!\n");

			DirectedGraph graph = new DirectedGraph();

			for (int i = 0; i < 6; i++) {
				graph.addVertex();
			}

			graph.addEdge(0, 1);
			graph.addEdge(1, 2);
			graph.addEdge(2, 0);
			graph.addEdge(0, 2);
			graph.addEdge(3, 4);
			graph.addEdge(4, 5);
			graph.addEdge(5, 3);

			GraphPrinter
					.console()
					.print(graph);

			GraphPrinter
					.graphviz()
					.print(graph);
    }
}