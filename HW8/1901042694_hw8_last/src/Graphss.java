import java.util.Iterator;
import java.util.LinkedList;

class Graphss {
    private int V; // No. of vertices

    // Array  of lists for
    // Adjacency List Representation
    private LinkedList<Integer> adj[];

    MyGraph<Integer> datas;

    // Constructor
    @SuppressWarnings("unchecked")
    Graphss(int v,MyGraph<Integer> data) {

        datas=data;
        V = v;
        adj = new LinkedList[data.getNumv()];
    }

    void DFSUtil(int v, boolean visited[]) {

        visited[v] = true;

        Iterator<Vertex> i = datas.getAdjLists()[v].listIterator();

        while (i.hasNext()) {
            Vertex a=i.next();
            int n = a.getId();
                System.out.print(" "+a.getWeight()+" ");
            if (!visited[n]){
                DFSUtil(n, visited);
            }
        }
        System.out.println();
    }

    void DFS(int v) {

        boolean visited[] = new boolean[V];

        DFSUtil(v, visited);
    }
    public static void main(String args[])
    {

        MyGraph<Integer> graph = new MyGraph<>(4);
        Vertex test1 = graph.newVertex("amk", 5);
        Vertex test2 = graph.newVertex("uclercagri", 9);
        Vertex test3 = graph.newVertex("burakiro", 31);
        Vertex test4 = graph.newVertex("kiro", 3111);
        graph.addVertex(test1);
        graph.addVertex(test2);
        graph.addVertex(test3);
        graph.addVertex(test4);
        graph.addEdge(0, 1, 69);
        graph.addEdge(0, 2, 73);
        graph.addEdge(1, 2, 100);
        graph.addEdge(0,3,24);
        graph.addEdge(1,3,25);
        graph.addEdge(2,3,26);
        Graphss g = new Graphss(graph.getNumv(),graph);

                g.DFS(0);


    }
}