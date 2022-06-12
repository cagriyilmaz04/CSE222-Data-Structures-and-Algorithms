import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class ShortestPath {
    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    static final int V = 10;
    int minDistance(int dist[], Boolean sptSet[]) {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
 
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
 
    // A utility function to print the constructed distance array
    void printSolution(int dist[])
    {
        //System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }
 
    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    int[] dijkstra(double graph[][], int src)
    {
        int dist[] = new int[V]; // The output array. dist[i] will hold
        // the shortest distance from src to i
 
        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];
 
        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        // Distance of source vertex from itself is always 0
        dist[src] = 0;
 
        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);
 
            // Mark the picked vertex as processed
            sptSet[u] = true;
 
            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)
 
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = (int) (dist[u] + graph[u][v]);
        }
 
        // print the constructed distance array
        //printSolution(dist);
        return dist;
    }

}


public class ThirQuestion {

    /**
     * Perform a breadth-first search of a graph.
     * post: The array parent will contain the predecessor
     * of each vertex in the breadth-first
     * search tree.
     *
     * @param graph The graph to be searched
     * @param start The start vertex
     * @return The array of parents
     */
    public static int[] breadthFirstSearch(MyGraph<Integer> graph, int start) {

        Queue<Integer> theQueue = new LinkedList<Integer>();
        int[] parent = new int[graph.getNumV()];

        for (int i = 0; i < graph.getNumV(); i++) {
            parent[i] = -1;
        }

        boolean[] identified = new boolean[graph.getNumV()];

        identified[start] = true;
        theQueue.offer(start);

        while (!theQueue.isEmpty()) {
            int current = theQueue.remove();
            Iterator<Edge> itr = graph.edgeIterator(current);
            Iterator<Edge> itr1 = graph.edgeIterator(current);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                //    Edge edge1=itr1.next();

                int neighbor = edge.getDest();

                if (!identified[neighbor]) {
                    identified[neighbor] = true;
                    theQueue.offer(neighbor);

                    parent[neighbor] = (int) graph.getVertexList().get(edge.getDest()).getWeight();
                }
            }

        }
        return parent;
    }
    
    
    
    
    public static double DiffBetweenTravers(MyGraph<Integer> graph, int start , int end) {
        boolean flag1 = false  , flag3 = false ;
        double temp = 0;
        double temp2 = 0;
        ShortestPath path = new ShortestPath();
        DepthFirstSearch depth = new DepthFirstSearch(graph);
        int [] arr  = depth.depthFirstSearch(start);
        int [] arr1 = BreadthFirstSearch.breadthFirstSearch(graph,start);
        arr1[0] = start;

        for(int i = 0;i< arr.length;i++){
            if (arr[i] == end) {
                if(flag1){

                }
                break;
            }
            else if(arr[i] == start) flag1= true;
            
        }

        for(int i = 0;i< arr1.length;i++){
            if (arr1[i] == end) {
                if(flag3){

                }
                break;
            }
            else if(arr1[i] == start) flag3= true;
            
        }

        if(flag1){
            int idx = 0;
            while(arr[idx] != start) idx++;
            while(true){
                temp+= graph.getEdgeArray()[arr[idx]][arr[idx+1]];
                idx++;
                if(arr[idx] == end){
                    break;
                }
            }
        }
        else{
            int idx = 0;
            while(arr[idx] != end) idx++;
            while(true){
                temp+= graph.getEdgeArray()[arr[idx]][arr[idx+1]];
                idx++;
                if(arr[idx] == start){
                    break;
                }
                
            }
        }
        
        if(flag3){
            int idx = 0;
            while(arr1[idx] != start) idx++;
            while(true){
                temp2+= graph.getEdgeArray()[arr1[idx]][arr1[idx+1]];
                idx++;
                if(arr1[idx] == end) break;
            }
        }
        else{
            int idx = 0;
            while(arr1[idx] != end) idx++;
            while(true){
                temp2+= graph.getEdgeArray()[arr1[idx]][arr1[idx+1]];
                idx++;
                if(arr1[idx] == start){
                    break;
                }
            }
        }
        

        temp += path.dijkstra(graph.getEdgeArray(), start)[end];
        
        System.out.println("DFS : "+temp);
        System.out.println("BFS : "+temp2);
        return temp-temp2;

    }

}
