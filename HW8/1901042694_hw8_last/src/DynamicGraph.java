public interface DynamicGraph extends Graph {
    Vertex newVertex(String label, double weight);
    void addVertex(Vertex new_Vertex);
    void addEdge(int vertexID1, int vertexID2, double weight);
    void removeEdge(int vertexID1, int vertexID2);
    void removeVertex(int vertexID);
    void removeVertex(String label);
    MyGraph filterVertices(String key, String filter);
    double[][] exportMatrix();
    void printGraph();
}
