import java.util.ArrayList;

public interface GraphPrinter {
	void print(Graph graph);

	static GraphPrinter console() {
		return ConsoleGraphPrinter.INSTANCE;
	}

	static GraphPrinter graphviz() {
		return FileGraphPrinter.INSTANCE;
	}
}
