package StackClasses;
public class DynamicStack {


    private NodeStacks top;

    // Constructor que inicializa la pila como vacía.
    public DynamicStack() {
        top = null;
    }

    // Método para insertar un elemento en la pila
    public void push(NodeStacks newNode) {
        if (isEmpty()) {
            top = newNode;
            return;
        }

        newNode.setNext(top);
        top = newNode;
    }

    // Método para eliminar y devolver el elemento en el tope de la pila
    public NodeStacks pop() {
        if (!isEmpty()) {
            NodeStacks current = top;
            top = top.getNext();
            current.setNext(null);
            return current;
        }
        return null;
    }

    // Método para devolver el elemento en el tope de la pila sin eliminarlo
    public NodeStacks peek() {
        if (isEmpty()) {
            return null;
        }

        return top;
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return top == null;
    }

    // Método para obtener el tamaño de la pila
    public int size() {
        int count = 0;
        NodeStacks current = top;

        // Recorre la pila desde el frente hasta el final
        while (current != null) {
            count++;
            current = current.getNext(); // Avanza al siguiente nodo
        }

        return count; // Devuelve el número total de elementos
    }

    // Clase interna que representa los nodos de la pila
    public static class NodeStacks {
        private int data;
        private NodeStacks next;

        public NodeStacks(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public NodeStacks getNext() {
            return next;
        }

        public void setNext(NodeStacks next) {
            this.next = next;
        }
    }
}
