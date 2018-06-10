package cellularData;

/**
 *  This class produces an object type Node with variables for its name, number of years, and an array of SubscriptionYear objects
 * @author Foothill College, Jessica Dickinson Goodman
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * This is the constructor method that takes a Country parameter
     * @param data       The data being inputted
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * This is a constructor method that takes two parameters, Node and generic object
     * @param data       A generic object
     * @param next          The next Node
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * This is setNext method and sets this.next to next
     * @param next      The next Node
     * @return          A boolean indicating if the set worked (or not)
     */
    boolean setNext(Node next){
        this.next = next;
        return true;
    }

    /**
     * This is the getObject method and returns a generic object
     * @return      This returns an object of generic type
     */
    public T getData(){ return data; }

    /**
     * This is the getNext method and returns next
     * @return  This returns an object of type Node
     */
    public Node getNext(){
        return next;
    }

    /**
     * This uses the object's toString method to return a string
     * @return  A string representing the data of the generic object
     */
    public String toString(){
        return data.toString();
    }
}