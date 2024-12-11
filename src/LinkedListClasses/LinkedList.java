package LinkedListClasses;
import Nodes.SingleListNode;

public class LinkedList {
    
    private SingleListNode head;

    public LinkedList() {
        head = null;
    }

    public void add(SingleListNode newNode) {
        // If the list is empty, add the new node as the head
        if (head == null) {
            head = newNode;
            return;
        }

        // If the new node is less than the head, add it as the new head
        if (newNode.getValue() < head.getValue()) {
            newNode.setNext(head);
            head = newNode;
            return;
        }

        // Find the correct position for the new node
        SingleListNode current = head;

        // While the current node is not the last node and the value of the next node is less than the value of the new node
        while (current.getNext() != null && current.getNext().getValue() < newNode.getValue()) {
            current = current.getNext();
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
    }

    public void remove(int value) {
        if (head == null) {
            return;
        }

        // If the head node's value matches, remove the head
        if (head.getValue() == value) {
            head = head.getNext();
            return;
        }

        SingleListNode current = head;
        while (current.getNext() != null) {
            if (current.getNext().getValue() == value) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }

    public boolean contains(int value) {
        SingleListNode current = head;
        while (current != null) {
            if (current.getValue() == value) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public int count() {
        int count = 0;
        SingleListNode current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        SingleListNode current = head;
        while (current != null) {
            result.append(current.toString()).append(" ");
            current = current.getNext();
        }
        return result.toString().trim();
    }

}
