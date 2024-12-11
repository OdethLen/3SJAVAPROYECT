package QueueClasses;
public class DoubleQueueVector {


    private int[] deque;
    private int front, rear, size, count;

    public DoubleQueueVector(int capacity) {
        size = capacity;
        deque = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void insertFront(int value) {
        if (count == size) {
            throw new IllegalStateException("Deque is full");
        }

        front = (front - 1 + size) % size;
        deque[front] = value;
        count++;
    }

    public void insertRear(int value) {
        if (count == size) {
            throw new IllegalStateException("Deque is full");
        }

        rear = (rear + 1) % size;
        deque[rear] = value;
        count++;
    }

    public int removeFront() {
        if (count == 0) {
            throw new IllegalStateException("Deque is empty");
        }

        int value = deque[front];
        front = (front + 1) % size;
        count--;
        return value;
    }

    public int removeRear() {
        if (count == 0) {
            throw new IllegalStateException("Deque is empty");
        }

        int value = deque[rear];
        rear = (rear - 1 + size) % size;
        count--;
        return value;
    }

    public int[] getDequeElements() {
        int[] elements = new int[count];
        for (int i = 0; i < count; i++) {
            elements[i] = deque[(front + i) % size];
        }
        return elements;
    }
}
