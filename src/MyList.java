/**
 * Generic version of the LinkedList class.
 *
 * @param <T> the type of the value
 */
public class MyList<T> {
    //Head node, default is null
    Node<T> head;

    //Tail node, default is null
    Node<T> tail;

    //Default constructor
    public MyList() {
        head = tail = null;
    }

    /**
     * Constructor with head and tail
     *
     * @param head Head node of this list
     * @param tail Tail node of this list
     */
    public MyList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    /**
     * Checking if this list is empty
     *
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Returning the length of this list
     *
     * @return The length of this list
     */
    public int length() {
        int len = 0;
        Node<T> curr = this.head;
        while (curr != null) {
            len++;
            curr = curr.getNext();
        }
        return len;
    }

    /**
     * Insert an item to the head of this list
     *
     * @param item The item to be inserted
     */

    public void insertToHead(T item) {
//        Creating new Node<T>
        Node<T> newNode = new Node<>(item, this.head);
        newNode.setNext(this.head);
        this.head = newNode;
    }

    /**
     * Insert an item to the Tail of the list
     *
     * @param item - The item to be inserted
     */
    public void insertToTail(T item) {
//        If list is empty create new node at head
        if (isEmpty()) {
            head = new Node<>(item, null);
        } else { //Else Create new node at tail
            Node<T> newNode = new Node<>(item, null);
            Node<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.setNext(newNode);
        }
    }

    /**
     * Insert an item at position to this list
     *
     * @param position The position of new item
     * @param item     The item to be inserted
     */
    public void insertAfterPosition(int position, T item) {
        if (head == null)
            return;
        Node<T> curr = head;
        Node<T> newNode = new Node<>(item, null);
        int index = 0;
        while (curr != null) {
            if (index == position) {
                newNode.next = curr.next.next;
                curr.next = newNode;
            }
            index++;
            curr = curr.next;
        }
    }

    /**
     * Deleting the tail of this list
     */

    public void deleteTail() {
        if (isEmpty())
            return;
        Node<T> curr = head;
        while (curr != null) {
            if (curr.next.next == null) {
                curr.setNext(null);
            }
            curr = curr.next;
        }

    }

    /**
     * Searching and deleting an item from this list by comparing the ID of items
     *
     * @param item The item to be deleted
     */
    public void deleteElement(T item) {
        Node<T> curr = head;
        Node<T> pre = null;
        if (curr != null && curr.info == item) {
            head = curr.next;
            return;
        }
        while (curr != null && curr.info != item) {
            pre = curr;
            curr = curr.next;
        }
        if (curr == null)
            return;
        //point previous node to current next node
        pre.next = curr.next;
    }


    /**
     * Swapping two nodes [firstNode] and [secondNode]
     *
     * @param firstNode  to be swapped with second Node
     * @param secondNode to be swapped with first Node
     */

    public void swap(Node<T> firstNode, Node<T> secondNode) {
        T temp = firstNode.info;
        firstNode.info = secondNode.info;
        secondNode.info = temp;
    }

    /**
     * convert this list to String for printing
     */
    public void printList() {
        if (isEmpty())
            System.out.println("List is empty!");
        Node<T> curr = head;
        while (curr != null) {
            System.out.print(curr.info.toString());
            curr = curr.next;
        }
    }

}
