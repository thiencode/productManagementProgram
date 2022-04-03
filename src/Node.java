/**
 * Generic version of the Node class.
 *
 * @param <T> the type of the value
 */
public class Node<T> {
    //     The info of this node
    T info;
    //     The next node
    Node<T> next;

    /**
     * Default constructor
     */
    public Node() {
    }

    /**
     * Constructor with info and next node
     *
     * @param info The info of this node
     * @param next The next Node of this node
     */

    public Node(T info, Node<T> next) {
        this.info = info;
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Overriding to convert this node to String
     */

    @Override
    public String toString() {
        return " " + this.getInfo();
    }
}
