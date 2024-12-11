package StackClasses;
public class NodeStacks {

    private int data;
    private NodeStacks next; // Apunta al siguiente nodo

    // Constructor por defecto
    public NodeStacks() {
        this.data = 0;
        this.next = null; // El siguiente nodo inicialmente es null
    }

    // Constructor con un valor de datos
    public NodeStacks(int data) {
        this.data = data;
        this.next = null; // El siguiente nodo inicialmente es null
    }

    // Getter para el valor de datos
    public int getData() {
        return data;
    }

    // Setter para el valor de datos
    public void setData(int data) {
        this.data = data;
    }

    // Getter para el siguiente nodo
    public NodeStacks getNext() {
        return next;
    }

    // Setter para el siguiente nodo
    public void setNext(NodeStacks next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return Integer.toString(data); // Devuelve el valor de datos como una cadena
    }

}
