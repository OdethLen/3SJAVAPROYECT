package QueueClasses;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PriorityQueueListVectors {

 private LinkedList<List<Integer>> priorityQueue;

    public PriorityQueueListVectors(int priorityLevels) {
        priorityQueue = new LinkedList<>();
        for (int i = 0; i < priorityLevels; i++) {
            priorityQueue.add(new ArrayList<>());
        }
    }

    public void enqueue(int value, int priority) {
        if (priority < 0 || priority >= priorityQueue.size()) {
            throw new IllegalArgumentException("Invalid priority level.");
        }

        List<Integer> list = getNodeByPriority(priority);
        list.add(value);
    }

    public int dequeue() {
        for (List<Integer> list : priorityQueue) {
            if (!list.isEmpty()) {
                int value = list.get(0);
                list.remove(0);
                return value;
            }
        }

        throw new IllegalStateException("Priority queue is empty.");
    }

    public LinkedList<List<Integer>> getQueueElements() {
        return priorityQueue;
    }

    private List<Integer> getNodeByPriority(int priority) {
        return priorityQueue.get(priority);
    }
}
