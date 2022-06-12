import java.util.*;

/** Class to implement the depth-first search algorithm.
*   @author Koffman and Wolfgang
* */

public class DepthFirstSearch {


  private MyGraph<Integer> graph;

  /** Array of parents in the depth-first search tree. */
  private int[] parent;


  private boolean[] visited;


  private int[] discoveryOrder;


  private int[] finishOrder;
  

  private int[] res;


  private int discoverIndex = 0;


  private int finishIndex = 0;


   public static void swap(int i1 ,int i2 , List<Edge> list){
    Edge ed1 = list.get(i1);
    Edge ed2 = list.get(i2);
    
    list.set(i1, ed2);
    list.set(i2, ed1);

 }
    
   
  public DepthFirstSearch(MyGraph<Integer> graph) {
    this.graph = graph;
    int n = graph.getNumV();
    res = new int[n];
    parent = new int[n];
    visited = new boolean[n];
    discoveryOrder = new int[n];
    finishOrder = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = -1;
    }
    for (int i = 0; i < n; i++) {
      if (!visited[i])
        depthFirstSearch(i);
    }
  }

  /** Construct the depth-first search of a Graph
      selecting the start vertices in the specified order.
      The first vertex visited is order[0].
      @param graph The graph
      @param order The array giving the order
                   in which the start vertices should be selected
   */
  public DepthFirstSearch(MyGraph<Integer> graph, int[] order) {
    // Same as constructor above except for the if statement.
  }

  /** Recursively depth-first search the graph
      starting at vertex current.
      @param current The start vertex
   */
  
  public int findMinIdx(int idx , List<Edge> list){
      int min = 999999;
      int minIdx = 0;
      
      int[] temp  = new int[list.size()];
      
      for(int i = 0;i< temp.length;i++)
          temp[i] = (int) list.get(i).getWeight();
      
      
      for(int j = 0; j<= idx; j++){
          for(int i = 0;  i < list.size();i++){
                if(temp[i] < min){
                    min = temp[i];
                    minIdx = i;
                }
            }
          if(j != idx){
              temp[minIdx] = 999999;
              min = 999999;
          }
      }
      
      return minIdx;
      
  }
  public int[] depthFirstSearch(int current) {
      
     if(discoverIndex >= discoveryOrder.length) return finishOrder;
    /* Mark the current vertex visited. */
    visited[current] = true;
    discoveryOrder[discoverIndex++] = current;
    /* Examine each vertex adjacent to the current vertex */
    Iterator < Edge > itr = graph.edgeIterator(current);
    
    
    
    
    List<Edge> list = new ArrayList<>();
      
      while (itr.hasNext()) {
          Edge edge = itr.next();
          list.add(edge);
          
      }
      for(int i = 0;i< list.size();i++){
          for(int j = i+1;j< list.size();j++){
              /*if(list.get(i).getWeight() > list.get(j).getWeight()){
                  swap(i, j, list);
              }*/
          }
      }
    
    for(int i = 0; i < list.size();i++) {
        
        int res = findMinIdx(i , list);
        
        
        int neighbor = list.get(res).getDest();
        /* Process a neighbor that has not been visited */

        if (!visited[neighbor]) {
            /* Insert (current, neighbor) into the depth-
               first search tree. */
            parent[neighbor] = current;
            /* Recursively apply the algorithm
               starting at neighbor. */
            depthFirstSearch(neighbor);
        }
    }
    /* Mark current finished. */
    
    res[finishIndex] = (int) graph.getVertexList().get(current).getWeight();
    finishOrder[finishIndex++] = current;
    
    return res;
  }

  /**** BEGIN EXERCISE ****/
  /** Get the finish order
      @return finish order
   */
  public int[] getFinishOrder() {
    return finishOrder;
  }

  /**** END EXERCISE ****/
}