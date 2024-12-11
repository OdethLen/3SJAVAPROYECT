package QueueClasses;
public class SimpleVectorQueue {

    private int[] queue;
    private int front, rear, size;

    public SimpleVectorQueue(int capacity) {
        queue = new int[capacity];
        front = -1;
        rear = -1;
        size = capacity;
    }

    public void enqueue(int element) {
        if (rear == size - 1) {
            throw new IllegalStateException("Queue is full");
        }

        if (front == -1) front = 0; // Set front if it's the first element
        queue[++rear] = element;
    }

    public int dequeue() {
        if (front == -1 || front > rear) {
            throw new IllegalStateException("Queue is empty");
        }

        int element = queue[front];
        if (front == rear) { // Reset queue when empty
            front = rear = -1;
        } else {
            front++;
        }

        return element;
    }

    public int[] getQueueElements() {
        if (front == -1) {
            return new int[0]; // Return an empty array
        }

        int[] elements = new int[rear - front + 1];
        System.arraycopy(queue, front, elements, 0, elements.length);
        return elements;
    }
}
