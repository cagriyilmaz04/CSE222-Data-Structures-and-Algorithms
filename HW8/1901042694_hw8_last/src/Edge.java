
public class Edge {

  // Data Fields

  private int source;


  private int dest;


  private double weight;

  // Constructor

  public Edge(int source, int dest) {
    this.source = source;
    this.dest = dest;
    weight = 1.0;
  }

  public Edge(int source, int dest, double w) {
    this.source = source;
    this.dest = dest;
    weight = w;
  }

  public int getSource() {
    return source;
  }

  public int getDest() {
    return dest;
  }

  public double getWeight() {
    return weight;
  }

  public String toString() {
    StringBuffer sb = new StringBuffer("[(");
    sb.append(Integer.toString(source));
    sb.append(", ");
    sb.append(Integer.toString(dest));
    sb.append("): ");
    sb.append(Double.toString(weight));
    sb.append("]");
    return sb.toString();
  }

  public boolean equals(Object obj) {
    if (obj instanceof Edge) {
      Edge edge = (Edge) obj;
      return (source == edge.source
              && dest == edge.dest);
    }
    else {
      return false;
    }
  }


  public int hashCode() {
    return (source << 16) ^ dest;
  }


}
