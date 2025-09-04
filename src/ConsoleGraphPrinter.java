import java.util.ArrayList;
import java.util.Collections;

public class ConsoleGraphPrinter implements GraphPrinter {
	public static final ConsoleGraphPrinter INSTANCE = new ConsoleGraphPrinter();

	@Override
	public void print(ArrayList<ArrayList<Integer>> adjMatrix) {
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
