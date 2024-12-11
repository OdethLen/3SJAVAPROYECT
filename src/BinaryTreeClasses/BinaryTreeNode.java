package BinaryTreeClasses;
public class BinaryTreeNode {

    public int valor;
    public BinaryTreeNode izquierda;
    public BinaryTreeNode derecha;

    // Constructor
    public BinaryTreeNode(int valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }

}
