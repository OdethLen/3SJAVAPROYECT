package GraphClasses;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    public List<NodeGraph> nodes;
    public List<List<Edge>> adjacencyList;

    // Constructor
    public Graph() {
        nodes = new ArrayList<NodeGraph>();
        adjacencyList = new ArrayList<List<Edge>>();
    }

    // Método para agregar un nodo
    public void addNode(NodeGraph newNode) {
        nodes.add(newNode);
        adjacencyList.add(new ArrayList<Edge>());
    }

    // Método para agregar una arista (sin peso)
    public void addEdge(NodeGraph fromNode, NodeGraph toNode) {
        if (nodes.contains(fromNode) && nodes.contains(toNode)) {
            Edge newEdge = new Edge(toNode); // Creamos la arista sin peso
            fromNode.neighbors.add(newEdge);
            adjacencyList.get(nodes.indexOf(fromNode)).add(newEdge);
        }
    }

    // Método para agregar una arista con peso
    public void addEdge(NodeGraph fromNode, NodeGraph toNode, int weight) {
        if (nodes.contains(fromNode) && nodes.contains(toNode)) {
            Edge newEdge = new Edge(toNode, weight);
            fromNode.neighbors.add(newEdge);
            adjacencyList.get(nodes.indexOf(fromNode)).add(newEdge);
        }
    }

    // Método para agregar una arista no dirigida con peso
    public void addNoDirectedEdge(NodeGraph node1, NodeGraph node2, int weight) {
        addEdge(node1, node2, weight);
        addEdge(node2, node1, weight);
    }

    // Sobrecarga de método para agregar una arista no dirigida sin peso
    public void addNoDirectedEdge(NodeGraph node1, NodeGraph node2) {
        addEdge(node1, node2);
        addEdge(node2, node1);
    }

    // Método para eliminar un nodo
    public void removeNode(NodeGraph nodeToRemove) {
        if (nodes.contains(nodeToRemove)) {
            int index = nodes.indexOf(nodeToRemove);
            nodes.remove(index);
            adjacencyList.remove(index);

            // Eliminar las aristas hacia este nodo
            for (NodeGraph node : nodes) {
                node.neighbors.removeIf(edge -> edge.to == nodeToRemove);
            }

            // Eliminar las aristas en la lista de adyacencia
            for (List<Edge> adjList : adjacencyList) {
                adjList.removeIf(edge -> edge.to == nodeToRemove);
            }
        }
    }

    // Método para eliminar una arista no dirigida
    public void removeNoDirectedEdge(NodeGraph node1, NodeGraph node2) {
        removeEdge(node1, node2);
        removeEdge(node2, node1);
    }

    // Método para eliminar una arista
    public void removeEdge(NodeGraph fromNode, NodeGraph toNode) {
        if (nodes.contains(fromNode) && nodes.contains(toNode)) {
            Edge edgeToRemove = null;
            for (Edge edge : fromNode.neighbors) {
                if (edge.to == toNode) {
                    edgeToRemove = edge;
                    break;
                }
            }

            if (edgeToRemove != null) {
                fromNode.neighbors.remove(edgeToRemove);
                adjacencyList.get(nodes.indexOf(fromNode)).remove(edgeToRemove);
            }
        }
    }

    // Método para eliminar todo el grafo
    public void removeGraph() {
        nodes.clear();
        adjacencyList.clear();
    }

    // Método para mostrar la lista de adyacencia
    public String showAdjacencyList() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nodes.size(); i++) {
            sb.append(nodes.get(i).name).append(": ");
            for (Edge edge : adjacencyList.get(i)) {
                sb.append(edge.to.name).append(", ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    // Método para mostrar la lista de adyacencia con pesos
    public String showAdjacencyListWithWeights() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nodes.size(); i++) {
            sb.append(nodes.get(i).name).append(": ");
            for (Edge edge : adjacencyList.get(i)) {
                sb.append(edge.to.name).append(" (").append(edge.weight).append("), ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    // Método DFS recursivo
    public String dfs(NodeGraph startNode) {
        if (startNode == null || !nodes.contains(startNode)) return "";

        List<NodeGraph> visited = new ArrayList<>();  // Lista de nodos visitados
        StringBuilder result = new StringBuilder();  // Para acumular el resultado

        dfsRecursive(startNode, visited, result);
        return result.toString();
    }

    private void dfsRecursive(NodeGraph currentNode, List<NodeGraph> visited, StringBuilder result) {
        // Marcar el nodo como visitado
        visited.add(currentNode);

        // Agregar el nodo actual al resultado
        if (result.length() > 0) {
            result.append(" → ");  // Añadir flecha entre nodos
        }
        result.append(currentNode.name);

        // Recorrer los nodos adyacentes
        for (Edge edge : currentNode.neighbors) {
            NodeGraph adjacentNode = edge.to;
            if (!visited.contains(adjacentNode)) {
                dfsRecursive(adjacentNode, visited, result);  // Llamada recursiva
            }
        }
    }

    // Método DFS iterativo
    public String dfsIterative(NodeGraph startNode) {
        if (startNode == null || !nodes.contains(startNode)) return "";

        List<NodeGraph> visited = new ArrayList<>();  // Lista de nodos visitados
        Stack<NodeGraph> stack = new Stack<NodeGraph>();  // Pila para el recorrido
        StringBuilder result = new StringBuilder();  // Para acumular el resultado

        stack.push(startNode);  // Agregar el nodo de inicio a la pila

        while (!stack.isEmpty()) {
            NodeGraph currentNode = stack.pop();  // Obtener el nodo en la cima de la pila

            if (!visited.contains(currentNode)) {
                // Agregar el nodo actual al resultado
                if (result.length() > 0) {
                    result.append(" → ");  // Añadir flecha entre nodos
                }
                result.append(currentNode.name);

                visited.add(currentNode);  // Marcar el nodo como visitado

                List<Edge> reversedEdges = new ArrayList<>(currentNode.neighbors);
                Collections.reverse(reversedEdges);  // Revertir las aristas para que el orden sea correcto

                // Apilar los nodos adyacentes no visitados
                for (Edge edge : reversedEdges) {
                    NodeGraph adjacentNode = edge.to;
                    if (!visited.contains(adjacentNode)) {
                        stack.push(adjacentNode);  // Agregar a la pila si no ha sido visitado
                    }
                }
            }
        }

        return result.toString();
    }

    // Método BFS
    public String bfs(NodeGraph startNode) {
        if (startNode == null || !nodes.contains(startNode)) return "";

        List<NodeGraph> visited = new ArrayList<>();  // Lista de nodos visitados
        Queue<NodeGraph> queue = new LinkedList<NodeGraph>();  // Cola para el recorrido
        StringBuilder result = new StringBuilder();  // Para acumular el resultado

        queue.offer(startNode);  // Agregar el nodo de inicio a la cola

        while (!queue.isEmpty()) {
            NodeGraph currentNode = queue.poll();  // Obtener el nodo al frente de la cola

            if (!visited.contains(currentNode)) {
                // Agregar el nodo actual al resultado
                if (result.length() > 0) {
                    result.append(" → ");  // Añadir flecha entre nodos
                }
                result.append(currentNode.name);

                visited.add(currentNode);  // Marcar el nodo como visitado

                // Encolar los nodos adyacentes no visitados
                for (Edge edge : currentNode.neighbors) {
                    NodeGraph adjacentNode = edge.to;
                    if (!visited.contains(adjacentNode) && !queue.contains(adjacentNode)) {
                        queue.offer(adjacentNode);  // Agregar a la cola si no ha sido visitado
                    }
                }
            }
        }

        return result.toString();
    }

}
