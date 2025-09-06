import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileGraphPrinter implements GraphPrinter {
	private FileGraphPrinter() { };
	private final String filename = "graph.gv";

	public static final FileGraphPrinter INSTANCE = new FileGraphPrinter();

	@Override
	public void print(Graph graph) {
		ArrayList<ArrayList<Integer>> adjMatrix = graph.getAdjacencyMatrix();

		StringBuffer sb = new StringBuffer();
		sb.append("Graph g {\n");

		System.out.println();

		for (int i = 0; i < adjMatrix.size(); i++) {
			ArrayList<Integer> row = adjMatrix.get(i);

			for (int j = adjMatrix.size() - 1; j >= 0; j--) {
				if (row.get(j) != 0) {
					sb
						.append("  ")
						.append(i)
						.append(" -- ")
						.append(j)
						.append("\n");

					decrementEdge(adjMatrix, i, j);
				}
			}
		}

		sb.append("}");

		createFile();
		writeToFile(sb.toString());
	}

	private void decrementEdge(ArrayList<ArrayList<Integer>> adjMatrix, int i, int j) {
		adjMatrix.get(i).set(j, adjMatrix.get(i).get(j) - 1);
		adjMatrix.get(j).set(i, adjMatrix.get(j).get(i) - 1);
	}

	private void createFile() {
		try {
			File gvFile = new File(filename);
			if (gvFile.exists()) {
				System.out.println("File already exists, overwriting");
			} else {
				System.out.println("Created " + filename);
				gvFile.createNewFile();
			}
		} catch (IOException e) {
			System.out.println("An error occurred while creating the file");
		}
	}

	private void writeToFile(String s) {
		try {
			FileWriter gvWriter = new FileWriter(filename);
			gvWriter.write(s);
			gvWriter.close();
		} catch (IOException e) {
			System.out.println("An error occurred while writing to file");
		}
	}
}
