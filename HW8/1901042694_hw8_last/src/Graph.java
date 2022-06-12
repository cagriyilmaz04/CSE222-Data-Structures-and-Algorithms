import java.util.Iterator;

/** Interface to specify a Graph ADT. A graph is a set
*   of vertices and a set of edges. Vertices are
*   represented by integers from 0 to n - 1. Edges
*   are ordered pairs of vertices. Each implementation
*   of the Graph interface should provide a constructor
*   that specifies the number of vertices and whether
*   or not the graph is directed.
*   @author Koffman and Wolfgang
*/

public interface Graph {

  // Accessor Methods
  /** Return the number of vertices.
      @return The number of vertices
   */
  int getNumV();

  /** Determine whether this is a directed graph.
      @return true if this is a directed graph
   */
  boolean isDirected();

  void insert(Edge edge);


  boolean isEdge(int source, int dest);

  Edge getEdge(int source, int dest);

  Iterator < Edge > edgeIterator(int source);

}
