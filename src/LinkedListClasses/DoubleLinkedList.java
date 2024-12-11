package LinkedListClasses;
public class DoubleLinkedList {

    private DoubleLinkedListNode head; // Puntero al primer nodo de la lista.

    // Constructor que inicializa la lista como vacía (head es null).
    public DoubleLinkedList() {
        head = null;
    }

    // Método para agregar un nodo manteniendo el orden numérico ascendente.
    public void add(int data) {
        DoubleLinkedListNode newDoubleLinkedListNode = new DoubleLinkedListNode(data);

        if (head == null || head.getData() >= data) { // Insertar al inicio si está vacía o el valor es menor.
            newDoubleLinkedListNode.setNext(head);
            if (head != null) {
                head.setPrev(newDoubleLinkedListNode);
            }
            head = newDoubleLinkedListNode;
        } else {
            DoubleLinkedListNode current = head;
            while (current.getNext() != null && current.getNext().getData() < data) {
                current = current.getNext();
            }

            newDoubleLinkedListNode.setNext(current.getNext());
            if (current.getNext() != null) {
                current.getNext().setPrev(newDoubleLinkedListNode);
            }
            current.setNext(newDoubleLinkedListNode);
            newDoubleLinkedListNode.setPrev(current);
        }
    }

    // Método para eliminar un nodo por su valor.
    public void delete(int data) {
        if (head == null) { // Si la lista está vacía, no hacer nada.
            return;
        }

        DoubleLinkedListNode current = head;

        // Buscar el nodo con el valor especificado.
        while (current != null && current.getData() != data) {
            current = current.getNext();
        }

        if (current == null) { // Si no se encontró el valor, salir.
            return;
        }

        // Ajustar los punteros de los nodos adyacentes.
        if (current.getPrev() != null) {
            current.getPrev().setNext(current.getNext());
        } else {
            head = current.getNext(); // Si el nodo a eliminar es la cabeza, mover la cabeza.
        }

        if (current.getNext() != null) {
            current.getNext().setPrev(current.getPrev());
        }
    }

    // Método para buscar un número en la lista.
    public boolean search(int data) {
        DoubleLinkedListNode current = head;

        // Recorrer la lista buscando el dato.
        while (current != null) {
            if (current.getData() == data) {
                return true;
            }
            current = current.getNext();
        }
        return false; // Retornar false si no se encontró el dato.
    }

    public DoubleLinkedListNode getHead() {
        return head;
    }

    // Clase interna para los nodos de la lista doblemente enlazada
    public static class DoubleLinkedListNode {
        private int data;
        private DoubleLinkedListNode next;
        private DoubleLinkedListNode prev;

        public DoubleLinkedListNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public DoubleLinkedListNode getNext() {
            return next;
        }

        public void setNext(DoubleLinkedListNode next) {
            this.next = next;
        }

        public DoubleLinkedListNode getPrev() {
            return prev;
        }

        public void setPrev(DoubleLinkedListNode prev) {
            this.prev = prev;
        }
    }

}
