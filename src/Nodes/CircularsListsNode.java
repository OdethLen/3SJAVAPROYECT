package Nodes;
public class CircularsListsNode {

    private int value;
    private CircularsListsNode next;

    // Constructor sin parámetros
    public CircularsListsNode() {
        this.value = 0;
        this.next = null;
    }

    // Constructor con un valor
    public CircularsListsNode(int value) {
        this.value = value;
        this.next = null;
    }

    // Métodos getter y setter para el valor
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Métodos getter y setter para el siguiente nodo
    public CircularsListsNode getNext() {
        return next;
    }

    public void setNext(CircularsListsNode next) {
        this.next = next;
    }
}
