/**
 * Generic version of the Stack class.
 *
 * @param <T> the type of the value
 */
public class MyStack<T> {
    /**
     * Head node contains front node in the stack
     */
    Node<T> head;

    /**
     * Default constructor
     */
    MyStack() {
        head = null;
    }

    /**
     * Checking if this stack is empty
     *
     * @return - true if stack is empty
     */
    boolean isEmpty() {
        return (head == null);
    }

    /**
     * Push an element in Stack
     *
     * @param item is pushed
     */
    public void push(T item) {
        Node<T> newNode = new Node<>(item, null);
        if (isEmpty())
            this.head = newNode;
        else {
            Node<T> temp = head;
            head = newNode;
            newNode.next = temp;
        }
    }

    /**
     * convert this stack to String for printing
     */
    public void printStack() {
        if (isEmpty())
            System.out.println("Queue is empty!");
        Node<T> curr = head;
        while (curr != null) {
            System.out.print(curr.info.toString());
            curr = curr.next;
        }
    }
}
