package QueueClasses;
import java.util.LinkedList;
import java.util.List;

public class SimpleQueueList {

    private NodeSimpleQueueList front;
    private NodeSimpleQueueList rear;

    public SimpleQueueList() {
        front = rear = null;
    }

    public void enqueue(int value) {
        NodeSimpleQueueList newSimpleQueueListNode = new NodeSimpleQueueList(value);

        if (rear == null) { // If the queue is empty
            front = rear = newSimpleQueueListNode;
        } else {
            rear.next = newSimpleQueueListNode;
            rear = newSimpleQueueListNode;
        }
    }

    public int dequeue() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }

        int value = front.value;
        front = front.next;

        if (front == null) { // If the queue becomes empty
            rear = null;
        }

        return value;
    }

    public List<Integer> getQueueElements() {
        List<Integer> elements = new LinkedList<>();
        NodeSimpleQueueList current = front;

        while (current != null) {
            elements.add(current.value);
            current = current.next;
        }

        return elements;
    }

    // Node class to represent each element in the queue
    private static class NodeSimpleQueueList {
        int value;
        NodeSimpleQueueList next;

        public NodeSimpleQueueList(int value) {
            this.value = value;
            this.next = null;
        }

    }
}
