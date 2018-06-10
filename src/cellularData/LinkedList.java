package cellularData;
import java.util.Iterator;
/**
 *  This class produces an object type LinkedList that contains objects of type Node
 * @author Foothill College, Jessica Dickinson Goodman
 * -- Add doesn't make much sense right now
 * A method iterator() that returns object of type ListIterator.
 * Note: You must demonstrate the correct implementation of your iterator.
 * For example, by traversing your LinkedList of SubscriptionYear objects. Reminder to create an Iterator object:
 *
 *
 * Hint to compare objects in a generic LinkedList :
 *
 * Override the equals method of class Country and SubscriptionYear .
 * Then get the data at the current node.
 * Check whether the list contains the object via calling the equals method on the generic type.
 */
public class LinkedList<T> implements Iterable<T>{

    private Node<T> head;
    private int size = 0;

    /**
     * This is the simplest LinkedList constructor
     */
    public LinkedList(){
        this.head = head;
    }

    public LinkedList(Node<T> node){
        this.head = node;
    }

    /**
     * This is the add function ??
     * @param data       An object of generic type
     */
    public void add(T data) {
        Node<T> nextNode = new Node(data);
        if (size == 0) {
            head = new Node(data);
        }
        if (size == 1){
            head.setNext(nextNode);
        }
        else{
            Node walker = head;
            for(int i = 0; i < size - 1; i++){
                walker = walker.getNext();
            }
            walker.setNext(nextNode);
        }
            size++;
    }

    /**
     * This returns size
     * @return      This returns an int of the size of the list
     */
    public int size(){
        return size;
    }

    /**
     * This is the getIndex method which takes index as a parameter
     * @param index     This index at which we are seeking a Country
     * @return   This returns an object of type Country
     */
    public T getIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is either " +
                    "less than zero or larger than this current list. Please try again");
        }
        else {
            Node<T> walker = head;
            int i = 0;
            while (walker != null && i <= index) {
                if (i == index)
                    return walker.getData();
                walker = walker.getNext();
                i++;
            }
        }
        return null;
    }

    /**
     * This method checks to see if the list contains the name of a particular country
     * @param data       An object of generic type
     * @return  This returns an object of generic type
     */
    public T contains(T data){
        Node<T> walker = head;
        while (walker != null) {
            if(data.equals(walker))
                return walker.getData();
            walker = walker.getNext();
        }
        return null;
    }

    /**
     * This is the toString method
     * @return a string
     */
    public String toString() {
        String result = "";
        Node<T> walker = head;
        for (int i = 0; i < size; i++) {
            result += walker.getData().toString();
            result += "\n";
            walker = walker.getNext();

        }
        return result;
    }

    /**
     * This allows the user to insert at any index
     * @param data       This is the object being inserted
     * @param index         This is the location where the object is being inserted
     */
    public void insertAtIndex(int index, T data){
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is either " +
                    "less than zero or larger than this current list. Please try again");
        }
        else if (index >= size - 1){
            this.add(data);
        }
        else if (index == 0){
            Node<T> newNode = new Node(data);
            newNode.setNext(head);
            head = newNode;
            size++;
        }
        else{
            Node<T> newNode = new Node(data);
            Node<T> walker = head;
            int i = 0;
            while (walker != null && i < index - 1) {
                walker = walker.getNext();
                i++;
            }
            Node<T> temp = walker.getNext();
            walker.setNext(newNode);
            newNode.setNext(temp);
            size++;
        }
    }

    /**
     * This method allows the user to replace an item at a specific location in the linkedList
      * @param index        This is the index at which the replacement is happening
     * @param data       This is the object that is replacing the item at the index
     */
    public void replaceAtIndex(int index, T data){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is either " +
                    "less than zero or larger than this current list. Please try again");
        }
        else if (index >= size - 1){
            this.add(data);
        }
        else if (index == 0){
            Node<T> newNode = new Node(data);
            newNode.setNext(head.getNext());
            head = newNode;
        }
        else{
            Node<T> newNode = new Node(data);
            Node<T> walker = head;
            for(int i = 0; i < index - 1 && walker != null; i++){
                walker = walker.getNext();
                i++;
            }
            if(walker.getNext() != null)
                    newNode.setNext(walker.getNext().getNext());
            walker.setNext(newNode);
        }
    }

    public Iterator<T> iterator(){
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T>
    {
        private Node<T> current;

        // initialize this iterator

        public void setCurrent(){ current = head; }

        public ListIterator()
        {    current = head; }

        // test if more elements can be traversed
        public boolean hasNext()
        {
            // check if the next node is valid
            // if node is invalid, return false
            if (current == null)
                return false;

            // otherwise we haven't reached the end of the list
            return true;
        }

        // return the next available element
        public T next()
        {
            if (current == null)
            {
                throw new java.util.NoSuchElementException();
            }

            // if we're here, then we're looking at a valid current node
            // so grab the data portion, to give to the caller
            T data = current.getData();

            // move in preparation for the next time.
            current = current.getNext();

            return data;
        }

        // currently implementation is not supported
//        public void remove()
//        {  ... }
    }


    // other contents of class MyLinkedList
}