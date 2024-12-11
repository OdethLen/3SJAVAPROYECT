package LinkedListClasses;
public class DoubleCircularList {

    private DoubleCircularListNode head;

    public DoubleCircularList() {
        head = null;
    }

    public void add(DoubleCircularListNode newDoubleCircularListNode) {
        // If the list is empty
        if (head == null) {
            head = newDoubleCircularListNode;
            head.next = head;
            head.prev = head;
            return;
        }

        // Insert a node at the beginning if its value is less than head
        if (newDoubleCircularListNode.value < head.value) {
            newDoubleCircularListNode.next = head;
            newDoubleCircularListNode.prev = head.prev;
            head.prev.next = newDoubleCircularListNode; // Update the next of the last node
            head.prev = newDoubleCircularListNode;
            head = newDoubleCircularListNode;
            return;
        }

        // Insert a node at the end if its value is greater than the last node
        if (newDoubleCircularListNode.value > head.prev.value) {
            newDoubleCircularListNode.next = head; // The next of new node
            newDoubleCircularListNode.prev = head.prev;
            head.prev.next = newDoubleCircularListNode; // Update the next of the last node
            head.prev = newDoubleCircularListNode; // Update head's previous to the new node
            return;
        }

        // Find the correct position for the new node
        DoubleCircularListNode current = head;

        // Traverse the list to find the right spot
        while (current.next != head && current.next.value < newDoubleCircularListNode.value) {
            current = current.next;
        }

        // Insert the new node
        newDoubleCircularListNode.next = current.next;
        newDoubleCircularListNode.prev = current;

        current.next.prev = newDoubleCircularListNode; // Update the next node's previous
        current.next = newDoubleCircularListNode; // Link current node to the new node
    }

    public void remove(int value) {
        if (head == null) {
            return;
        }

        if (head.next == head) { // Only one node in the list
            head = null; // The list is empty now
            return;
        }

        // Remove from the beginning
        if (head.value == value) {
            head.prev.next = head.next; // Update last node's next
            head.next.prev = head.prev; // Update second node's previous
            head = head.next; // Update head to the next node
            return;
        }

        // Remove from the end
        if (head.prev.value == value) {
            // Remove the last node
            head.prev = head.prev.prev; // Move the head pointer back
            head.prev.next = head; // Update the next of the new last node
            return;
        }

        // Remove from the middle
        DoubleCircularListNode current = head;
        while (current.next != head && current.value != value) {
            current = current.next;
        }

        // If the node with the value was found
        if (current.value == value) {
            current.prev.next = current.next; // Update the next of the previous node
            current.next.prev = current.prev; // Update the previous of the next node
        }
    }

    public boolean contains(int value) {
        if (head == null) {
            return false;
        }

        DoubleCircularListNode current = head;
        do {
            if (current.value == value) {
                return true;
            }
            current = current.next;

        } while (current != head);
        return false;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "The doubly circular linked list is empty.";
        }

        StringBuilder result = new StringBuilder();
        DoubleCircularListNode current = head;

        do {
            result.append(current.toString()).append(" "); // Call toString of the node
            current = current.next; // Move to the next node
        } while (current != head); // Stop when we circle back to the head

        return result.toString();
    }

    // Inner class for the doubly circular list node
    public static class DoubleCircularListNode {
        int value;
        DoubleCircularListNode next;
        DoubleCircularListNode prev;

        public DoubleCircularListNode(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

}
