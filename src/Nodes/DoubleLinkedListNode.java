package Nodes;
public class DoubleLinkedListNode {
    private int data;
    private DoubleLinkedListNode next;
    private DoubleLinkedListNode prev;

    // Constructor
    public DoubleLinkedListNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    // Métodos getter y setter para `data`
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    // Métodos getter y setter para `next`
    public DoubleLinkedListNode getNext() {
        return next;
    }

    public void setNext(DoubleLinkedListNode next) {
        this.next = next;
    }

    // Métodos getter y setter para `prev`
    public DoubleLinkedListNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleLinkedListNode prev) {
        this.prev = prev;
    }

}
