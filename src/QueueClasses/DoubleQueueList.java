package QueueClasses;
public class DoubleQueueList {
    
    private NodeDoubleQueueList front;
    private NodeDoubleQueueList rear;
    private int count;

    public DoubleQueueList() {
        front = null;
        rear = null;
        count = 0;
    }

    public void insertFront(int value) {
        NodeDoubleQueueList newDoubleQueueListNode = new NodeDoubleQueueList(value);

        if (count == 0) {
            front = rear = newDoubleQueueListNode;
        } else {
            newDoubleQueueListNode.setNext(front);
            front.setPrev(newDoubleQueueListNode);
            front = newDoubleQueueListNode;
        }

        count++;
    }

    public void insertRear(int value) {
        NodeDoubleQueueList newDoubleQueueListNode = new NodeDoubleQueueList(value);

        if (count == 0) {
            front = rear = newDoubleQueueListNode;
        } else {
            newDoubleQueueListNode.setPrev(rear);
            rear.setNext(newDoubleQueueListNode);
            rear = newDoubleQueueListNode;
        }

        count++;
    }

    public int removeFront() {
        if (count == 0) {
            throw new IllegalStateException("Deque is empty");
        }

        int value = front.getValue();
        front = front.getNext();

        if (front != null) {
            front.setPrev(null);
        } else {
            rear = null;
        }

        count--;
        return value;
    }

    public int removeRear() {
        if (count == 0) {
            throw new IllegalStateException("Deque is empty");
        }

        int value = rear.getValue();
        rear = rear.getPrev();

        if (rear != null) {
            rear.setNext(null);
        } else {
            front = null;
        }

        count--;
        return value;
    }

    public int[] getDequeElements() {
        int[] elements = new int[count];
        NodeDoubleQueueList current = front;
        for (int i = 0; i < count; i++) {
            elements[i] = current.getValue();
            current = current.getNext();
        }
        return elements;
    }

    // Node class for the deque
    private static class NodeDoubleQueueList {
        private int value;
        private NodeDoubleQueueList next;
        private NodeDoubleQueueList prev;

        public NodeDoubleQueueList(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public NodeDoubleQueueList getNext() {
            return next;
        }

        public void setNext(NodeDoubleQueueList next) {
            this.next = next;
        }

        public NodeDoubleQueueList getPrev() {
            return prev;
        }

        public void setPrev(NodeDoubleQueueList prev) {
            this.prev = prev;
        }
    }
    

}
