package Nodes;
public class DoubleCircularListNode {

    private int value;
    private DoubleCircularListNode next;
    private DoubleCircularListNode prev;

    // Constructor sin parámetros
    public DoubleCircularListNode() {
        this.value = 0;
        this.next = null;
        this.prev = null;
    }

    // Constructor con un valor
    public DoubleCircularListNode(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    // Métodos getter y setter para el valor
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Métodos getter y setter para el siguiente nodo
    public DoubleCircularListNode getNext() {
        return next;
    }

    public void setNext(DoubleCircularListNode next) {
        this.next = next;
    }

    // Métodos getter y setter para el nodo previo
    public DoubleCircularListNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleCircularListNode prev) {
        this.prev = prev;
    }

    // Método toString para mostrar el nodo
    @Override
    public String toString() {
        return value + ",";
    }

}
