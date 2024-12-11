package GraphClasses;
public class Edge {

    public NodeGraph to;
    public int weight;

    // Constructor con peso
    public Edge(NodeGraph to, int weight) {
        // this.from = from; // Se comenta ya que no se está usando
        this.to = to;
        this.weight = weight;
    }

    // Constructor sin peso (solo el nodo de destino)
    public Edge(NodeGraph to) {
        // this.from = from; // Se comenta ya que no se está usando
        this.to = to;
        this.weight = 0; // Valor predeterminado para el peso
    }

}
