package Nodes;
public class NodeSimpleQueueList {

    private int value;
    private NodeSimpleQueueList next;

    public NodeSimpleQueueList(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeSimpleQueueList getNext() {
        return next;
    }

    public void setNext(NodeSimpleQueueList next) {
        this.next = next;
    }

}
