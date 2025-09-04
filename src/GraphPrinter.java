import java.util.ArrayList;

public interface GraphPrinter {
	void print(ArrayList<ArrayList<Integer>> adjMatrix);

	static GraphPrinter console() {
		return ConsoleGraphPrinter.INSTANCE;
	}
}
