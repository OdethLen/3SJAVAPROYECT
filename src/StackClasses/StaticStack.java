package StackClasses;
public class StaticStack {

    private int[] elements; // Arreglo para almacenar los elementos
    private int top;        // Índice del elemento en el tope de la pila

    // Constructor que inicializa la pila con un tamaño fijo
    public StaticStack() {
        elements = new int[8];
        top = -1;           // Inicialmente, la pila está vacía
    }

    // Método para insertar un elemento en la pila
    public void push(int dato) {
        if (isFull()) {
            System.out.println("La pila está llena.");
            return;
        }
        elements[++top] = dato; // Incrementar 'top' y agregar el dato
    }

    // Método para eliminar y devolver el elemento en el tope de la pila
    public String pop() {
        if (isEmpty()) {
            return "La pila está vacía.";
        }
        return Integer.toString(elements[top--]); // Devolver y decrementar 'top'
    }

    // Método para devolver el elemento en el tope de la pila sin eliminarlo
    public String peek() {
        if (isEmpty()) {
            return "La pila está vacía.";
        }
        return Integer.toString(elements[top]); // Devolver el valor sin modificar 'top'
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return top == -1; // La pila está vacía si 'top' es -1
    }

    // Método para verificar si la pila está llena
    public boolean isFull() {
        return top == elements.length - 1; // La pila está llena si 'top' alcanza el tamaño máximo
    }

    // Método para devolver el tamaño de la pila
    public int size() {
        return top + 1; // El tamaño actual es 'top + 1'
    }

}
