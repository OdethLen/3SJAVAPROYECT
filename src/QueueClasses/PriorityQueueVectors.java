package QueueClasses;
import java.util.ArrayList;
import java.util.List;

public class PriorityQueueVectors {

     private List<List<Integer>> priorityQueue;

    public PriorityQueueVectors(int priorityLevels) {
        priorityQueue = new ArrayList<>(priorityLevels);
        for (int i = 0; i < priorityLevels; i++) {
            priorityQueue.add(new ArrayList<>());
        }
    }

    public void enqueue(int value, int priority) {
        if (priority < 0 || priority >= priorityQueue.size()) {
            throw new IllegalArgumentException("Invalid priority level.");
        }

        priorityQueue.get(priority).add(value);
    }

    public int dequeue() {
        for (int i = 0; i < priorityQueue.size(); i++) {
            List<Integer> list = priorityQueue.get(i);
            if (!list.isEmpty()) {
                int value = list.get(0);
                list.remove(0);
                return value;
            }
        }

        throw new IllegalStateException("Priority queue is empty.");
    }

    public List<Integer>[] getQueueElements() {
        // Using a raw type here for the return type, to match the C# code behavior
        return priorityQueue.toArray(new ArrayList[0]);
    }

}
