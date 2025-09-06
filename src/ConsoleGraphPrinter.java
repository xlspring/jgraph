import java.util.ArrayList;

public class ConsoleGraphPrinter implements GraphPrinter {
	private ConsoleGraphPrinter() { };

	public static final ConsoleGraphPrinter INSTANCE = new ConsoleGraphPrinter();

	@Override
	public void print(Graph graph) {
		ArrayList<ArrayList<Integer>> adjMatrix = graph.getAdjacencyMatrix();

		System.out.print("    ");

		for (int i = 0; i < adjMatrix.size(); i++) {
			System.out.print(i + " ");
		}

		System.out.println();

		for (int i = 0; i < adjMatrix.size(); i++) {
			ArrayList<Integer> row = adjMatrix.get(i);

			System.out.print(i + " | ");

			for (int j = 0; j < row.size(); j++) {
				System.out.print(row.get(j) + " ");
			}

			System.out.println();
		}

		System.out.println();
	}
}
