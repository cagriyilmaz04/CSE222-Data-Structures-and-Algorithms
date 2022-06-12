import java.util.*;

public class BreadthFirstSearch {

 public static void swap(int i1 ,int i2 , List<Edge> list){
    Edge ed1 = list.get(i1);
    Edge ed2 = list.get(i2);
    
    list.set(i1, ed2);
    list.set(i2, ed1);

 }

  public static int[] breadthFirstSearch(MyGraph<Integer> graph, int start) {
    Queue < Integer > theQueue = new LinkedList < Integer > ();
    List<Integer> myList = new ArrayList<>();
    // Declare array parent and initialize its elements to �1.
    int[] parent = new int[graph.getNumV()];
    for (int i = 0; i < graph.getNumV(); i++) {
      parent[i] = -1;
    }
    // Declare array identified and
    // initialize its elements to false.
    boolean[] identified = new boolean[graph.getNumV()];
    /* Mark the start vertex as identified and insert it
       into the queue */
    identified[start] = true;
    theQueue.offer(start);
    /* While the queue is not empty */
    while (!theQueue.isEmpty()) {
      /* Take a vertex, current, out of the queue.
       (Begin visiting current). */
      int current = theQueue.remove();
      /* Examine each vertex, neighbor, adjacent to current. */
      Iterator < Edge > itr = graph.edgeIterator(current);
      
      List<Edge> list = new ArrayList<>();
      
      while (itr.hasNext()) {
          Edge edge = itr.next();
          list.add(edge);
          
      }
      for(int i = 0;i< list.size();i++){
          for(int j = i+1;j< list.size();j++){
              if(list.get(i).getWeight() > list.get(j).getWeight()){
                  swap(i, j, list);
              }
          }
      }

      
      for(int i = 0; i < list.size();i++) {
        Edge edge = list.get(i);
        int neighbor = edge.getDest();

        if (!identified[neighbor]) {

          identified[neighbor] = true;

          theQueue.offer(neighbor);

          myList.add(edge.getDest());


          parent[neighbor] = (int) graph.getVertexList().get(edge.getDest()).getWeight();
        }
      }
    }

      for(int i = 1;i<myList.size()+1;i++)
          parent[i] = myList.get(i-1);
      
    return parent;
  }
}