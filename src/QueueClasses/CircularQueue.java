package QueueClasses;
import java.util.NoSuchElementException;

public class CircularQueue {
    
    private int[] queue;
    private int front, rear, count, size;

    // Constructor
    public CircularQueue(int capacity) {
        this.size = capacity;
        this.queue = new int[size];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    // Método para agregar un elemento a la cola
    public void enqueue(int element) {
        if (count == size) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % size; // Mover `rear` a la siguiente posición
        queue[rear] = element;
        count++;
    }

    // Método para eliminar y devolver el elemento al frente de la cola
    public int dequeue() {
        if (count == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        int element = queue[front];
        front = (front + 1) % size; // Mover `front` a la siguiente posición
        count--;
        return element;
    }

    // Método para obtener todos los elementos de la cola
    public int[] getQueueElements() {
        int[] elements = new int[count];
        for (int i = 0; i < count; i++) {
            elements[i] = queue[(front + i) % size];
        }
        return elements;
    }

}
