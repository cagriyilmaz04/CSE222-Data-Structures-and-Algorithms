import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class ListGraph extends AbstractGraph {


  private List < Edge > [] edges;


  public ListGraph(int numV, boolean directed) {
    super(numV, directed);
    edges = new List[numV];
    for (int i = 0; i < numV; i++) {
      edges[i] = new LinkedList < Edge > ();
    }
  }



  public boolean isEdge(int source, int dest) {
    return edges[source].contains(new Edge(source, dest));
  }


  public void insert(Edge edge) {
    edges[edge.getSource()].add(edge);
    if (!isDirected()) {
      edges[edge.getDest()].add(new Edge(edge.getDest(),
                                         edge.getSource(),
                                         edge.getWeight()));
    }
  }

  public Iterator < Edge > edgeIterator(int source) {
    return edges[source].iterator();
  }

  public Edge getEdge(int source, int dest) {
    Edge target =
        new Edge(source, dest, Double.POSITIVE_INFINITY);
    for (Edge edge : edges[source]) {
      if (edge.equals(target))
        return edge; // Desired edge found, return it.
    }
    // Assert: All edges for source checked.
    return target; // Desired edge not found.
  }


  public void loadEdgesFromFile(BufferedReader bufferedReader) throws
      IOException {

    String line;
    while ( (line = bufferedReader.readLine()) != null
           && line.length() != 0) {
      Scanner sc = new Scanner(line);
      int source = sc.nextInt();
      int dest = sc.nextInt();
      double weight = 1.0;
      if (sc.hasNextDouble())
        weight = sc.nextDouble();
      insert(new Edge(source, dest, weight));
    }

  }

}
