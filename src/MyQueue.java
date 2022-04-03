/**
 * Generic version of the Queue class.
 *
 * @param <T> the type of the value
 */
public class MyQueue<T> {
    //     Head node contains front node in the queue
    Node<T> head;
    //     Tail node contains last node in the queue
    Node<T> tail;

    /**
     * Default constructor
     */
    MyQueue() {
        head = tail = null;
    }

    /**
     * Check if queue is empty
     *
     * @return - true if queue is empty
     */
    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    /**
     * Add an item to queue
     *
     * @param item to be added
     */
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item, null);
        if (isEmpty())
            head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
     * Converting this queue to String for printing
     */
    public void printQueue() {
        if (isEmpty())
            System.out.println("Queue is empty!");
        Node<T> curr = head;
        while (curr != null) {
            System.out.print(curr.info.toString());
            curr = curr.next;
        }
    }
}
