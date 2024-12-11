package GraphClasses;
import java.util.ArrayList;
import java.util.List;

public class NodeGraph {

     public String name;
    public List<Edge> neighbors;

    // Constructor
    public NodeGraph(String name) {
        this.name = name;
        this.neighbors = new ArrayList<Edge>(); // Inicializa la lista de vecinos
    }

}
