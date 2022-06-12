import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyGraph<T> implements DynamicGraph{
    //DATA FIELD

    //Vertex List
   private  ArrayList<Vertex> vertexList;
    //Total Numv
   private  int numv =0;
    //Adjaceny List
   private  LinkedList<Vertex> adjLists[];
   private  List<Edge> [] edgeList;
   //number of edge
   private  int edge=0;
   // Matrix
   private  double edgeArray[][] = new double[100][100];
   private  int index=0;
    private int nodes=0;

    public ArrayList<Vertex> getVertexList() {
        return vertexList;
    }

    public double[][] getEdgeArray() {
        return edgeArray;
    }

    public int getEdge() {
        return edge;
    }

    public int getIndex() {
        return index;
    }

    public int getNumv() {
        return numv;
    }

    public LinkedList<Vertex>[] getAdjLists() {
        return adjLists;
    }

    public List<Edge>[] getEdgeList() {
        return edgeList;
    }

    public void setAdjLists(LinkedList<Vertex>[] adjLists) {
        this.adjLists = adjLists;
    }

    public void setEdge(int edge) {
        this.edge = edge;
    }

    public void setEdgeArray(double[][] edgeArray) {
        this.edgeArray = edgeArray;
    }

    public void setEdgeList(List<Edge>[] edgeList) {
        this.edgeList = edgeList;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setNumv(int numv) {
        this.numv = numv;
    }

    public void setVertexList(ArrayList<Vertex> vertexList) {
        this.vertexList = vertexList;
    }

    public MyGraph(int node){
        edgeList=new List[node];
        nodes=node;
        vertexList=new ArrayList<>();
        adjLists = new LinkedList[node];
        for (int i=0; i<node; i++) {
            adjLists[i] = new LinkedList<>();
            edgeList[i]=new LinkedList<Edge>();
        }
    }

    @Override
    public Vertex newVertex(String label, double weight) {
        Vertex vertex=new Vertex(label,weight);
        vertex.setId(index);
        ++index;
        return vertex;
    }

    @Override
    public void addVertex(Vertex new_Vertex) {
        numv++;
        vertexList.add(new_Vertex);
    }

    @Override
    public void addEdge(int vertexID1, int vertexID2, double weight) {
        adjLists[vertexList.get(vertexID1).getId()].add(vertexList.get(vertexID2));
        adjLists[vertexList.get(vertexID2).getId()].add(vertexList.get(vertexID1));
        ++edge;
        
        edgeArray[vertexID1][vertexID2] = weight;
        edgeArray[vertexID2][vertexID1] = weight;
        
        Edge edge=new Edge(vertexID1,vertexID2,weight);
        Edge edge2=new Edge(vertexID2,vertexID1,weight);

        edgeList[edge.getSource()].add(edge);
        edgeList[edge2.getSource()].add(edge2);
    }

    @Override
    public void removeEdge(int vertexID1, int vertexID2) {
        adjLists[vertexList.get(vertexID1).getId()].remove(vertexList.get(vertexID2));
        --edge;
        edgeArray[vertexID1][vertexID2] = -1;
        edgeArray[vertexID2][vertexID1] = -1;
        edgeList[vertexID1].remove(new Edge(vertexID1,vertexID2));
    }

    @Override
    public void removeVertex(int vertexID) {
        adjLists[vertexID].remove();

        for (int i = 0; i < numv -1; i++) {
            edgeArray[vertexID][i] = 0;
            edgeArray[i][vertexID] = 0;
        }
        --numv;
    }

    @Override
    public void removeVertex(String label) {
        for (int i = 0; i < adjLists.length; i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                removeVertex(vertexList.get(i).getId());
                break;
            }
        }
    }

    @Override
    public MyGraph filterVertices(String key, String filter) {
        MyGraph<Integer> filterVerticesGraph = new MyGraph<Integer>(numv);
        int size=0;
        for(int i=0;i<vertexList.size();++i){
            if(vertexList.get(i).properties.get(key).equals(filter)){
                Vertex data=filterVerticesGraph.newVertex(vertexList.get(i).getLabel(),vertexList.get(i).getWeight());
                filterVerticesGraph.addVertex(data);
                ++size;
            }
        }

        for(int i=0;i<size-1;++i){
            for(int j=i+1;j<size;++j){
                try {
                    filterVerticesGraph.addEdge(filterVerticesGraph.vertexList.get(i).getId(),filterVerticesGraph.vertexList.get(j).getId(),filterVerticesGraph.vertexList.get(j).getWeight());
                }catch (Exception e){
                        System.out.println(e.getLocalizedMessage());
                }
            }
        }
        return filterVerticesGraph;
    }

    @Override
    public double[][] exportMatrix() {
        return edgeArray;
    }

    @Override
    public void printGraph() {
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < index; ++j) {
                if(i != j ){
                    System.out.print(edgeArray[i][j] + " -> ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public int getNumV() {
        return numv;
    }

    @Override
    public boolean isDirected() {
        return false;
    }

    @Override
    public void insert(Edge edge) {
        addEdge(edge.getSource(),edge.getDest(),edge.getWeight());
    }

    @Override
    public boolean isEdge(int source, int dest) {
        return false;
    }

    @Override
    public Edge getEdge(int source, int dest){
        Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
        for(Edge edge : edgeList[source]){
            if(edge.equals(target))
                return edge;
        }
        return target;

    }

    @Override
    public Iterator < Edge > edgeIterator(int source) {
        return edgeList[source].iterator();
    }
}
