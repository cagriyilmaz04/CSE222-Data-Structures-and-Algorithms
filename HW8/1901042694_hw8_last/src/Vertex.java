import java.util.HashMap;

public class Vertex {


    private String label;
    private double weight;
    private int id;
    HashMap<String,String> properties = new HashMap<String,String>();
    private double boosting=0;


    public double getBoosting() {
        return boosting;
    }

    public void setBoosting(double boosting) {
        this.boosting = boosting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }



    public Vertex(String Label, Double Weight){
        this.label=Label;
        this.weight=Weight;
    }
    public Vertex(String Label, double Weight, double boosting){
        this.label=Label;
        this.weight=Weight;
        this.boosting=boosting;
    }



}
