package LinkedListClasses;
import java.util.ArrayList;
import java.util.List;

public class CircularsLists {


    private CircularsListsNode head;

    public CircularsLists() {
        head = null;
    }

    public void add(int value) {
        CircularsListsNode newCircularsListsNode = new CircularsListsNode(value);

        // Lista vacía
        if (head == null) {
            head = newCircularsListsNode;
            head.next = head;
        }
        // Si el valor es menor que el head, el valor será el nuevo head
        else if (value < head.value) {
            CircularsListsNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            newCircularsListsNode.next = head;
            current.next = newCircularsListsNode;
            head = newCircularsListsNode;
        }
        // Buscar la posición correcta en la lista
        else {
            CircularsListsNode current = head;

            while (current.next != head && current.next.value < value) {
                current = current.next;
            }
            // Verificamos si el valor ya existe
            if (current.next.value == value) {
                return;
            }
            newCircularsListsNode.next = current.next;
            current.next = newCircularsListsNode;
        }
    }

    public void remove(int value) {
        if (head == null) {
            System.out.println("The list is empty, no nodes to remove.");
            return;
        }

        CircularsListsNode current = head;

        if (head.value == value) {

            if (head.next == head) {
                head = null;
            } else {
                while (current.next != head) {
                    current = current.next;
                }

                head = head.next;
                current.next = head;
            }
            System.out.println("Node removed successfully.");
            return;
        }

        // El nodo a eliminar no es el head
        current = head;

        while (current.next != head) {
            if (current.next.value == value) {
                current.next = current.next.next;
                System.out.println("Node removed successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Node not found.");
    }

    public boolean contains(int value) {
        if (head == null) {
            return false;
        }

        CircularsListsNode current = head;

        do {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        } while (current != head);
        return false;
    }

    public String[] display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return new String[0];
        }

        List<String> result = new ArrayList<>();
        CircularsListsNode current = head;

        do {
            result.add(String.valueOf(current.value));
            current = current.next;
        } while (current != head);

        return result.toArray(new String[0]);
    }

    public int count() {
        if (head == null) {
            return 0;
        }

        int count = 1;
        CircularsListsNode current = head;

        while (current.next != head) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Clase interna para los nodos de la lista circular
    private static class CircularsListsNode {
        int value;
        CircularsListsNode next;

        public CircularsListsNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

}
