package QueueClasses;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PriorityQueueVectorLists {
 private List<LinkedList<Integer>> priorityQueue;

    public PriorityQueueVectorLists(int priorityLevels) {
        priorityQueue = new ArrayList<>(priorityLevels);
        for (int i = 0; i < priorityLevels; i++) {
            priorityQueue.add(new LinkedList<>());
        }
    }

    public void enqueue(int value, int priority) {
        if (priority < 0 || priority >= priorityQueue.size()) {
            throw new IllegalArgumentException("Invalid priority level.");
        }

        priorityQueue.get(priority).addLast(value);
    }

    public int dequeue() {
        for (int i = 0; i < priorityQueue.size(); i++) {
            if (!priorityQueue.get(i).isEmpty()) {
                int value = priorityQueue.get(i).getFirst();
                priorityQueue.get(i).removeFirst();
                return value;
            }
        }

        throw new IllegalStateException("Priority queue is empty.");
    }

    public List<LinkedList<Integer>> getQueueElements() {
        return priorityQueue;
    }
}
