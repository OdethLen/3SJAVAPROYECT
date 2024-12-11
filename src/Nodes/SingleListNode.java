package Nodes;
public class SingleListNode {

    private int value;
    private String name;
    private String phoneNumber;
    private String zipCode;
    private SingleListNode next;

    // Constructor por defecto
    public SingleListNode() {
        this.value = 0;
        this.name = "";
        this.phoneNumber = "";
        this.zipCode = "";
        this.next = null;
    }

    // Constructor con parámetros
    public SingleListNode(int value, String name, String phoneNumber, String zipCode) {
        this.value = value;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
        this.next = null;
    }

    // Métodos getter y setter para `value`
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Métodos getter y setter para `name`
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Métodos getter y setter para `phoneNumber`
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Métodos getter y setter para `zipCode`
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // Métodos getter y setter para `next`
    public SingleListNode getNext() {
        return next;
    }

    public void setNext(SingleListNode next) {
        this.next = next;
    }

    // Método toString
    @Override
    public String toString() {
        return value + " - " + name + " " + phoneNumber + " - " + zipCode;
    }

}
