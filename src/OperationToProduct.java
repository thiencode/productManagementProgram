import java.io.*;
import java.util.Scanner;

/**
 * This class manages all functions relate to the product
 */
public class OperationToProduct {

    static Scanner scanner = new Scanner(System.in);


    /**
     * Creating and returning a product with info input from keyboard.
     *
     * @return The product
     */

    public Product createProduct(PrintStream file) {
        System.out.print("Input new ID: ");
        String ID = scanner.next();
        file.append(String.valueOf(ID)).append("\n");
        System.out.print("Input Product's Name: ");
        String name = scanner.next();
        file.append(String.valueOf(name)).append("\n");
        System.out.print("Input Product's quantity: ");
        int quanity = scanner.nextInt();
        file.append(String.valueOf(quanity)).append("\n");
        System.out.print("Input Product's price: ");
        double price = scanner.nextDouble();
        file.append(String.valueOf(price)).append("\n");
        return new Product(ID, name, quanity, price);
    }


    /**
     * Reading all products from the file and insert them to the list at tail.
     *
     * @param fileName The file name of the file
     * @param list     The Linked List contains all products that read from file
     */

    public void getAllItemsFromFile(String fileName, MyList<Product> list) throws IOException {
        //Reading file
        FileInputStream fileInputStream = new FileInputStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        while (line != null) {
            //Splitting up line by " "
            String[] arr = line.split("\\s");
            //Creating product
            Product addProduct = new Product(arr[0], arr[1], Integer.parseInt(arr[2]), Double.parseDouble(arr[3]));
            // Adding product at tail of list
            list.insertToTail(addProduct);
            line = bufferedReader.readLine();
        }
        //Close file
        fileInputStream.close();
        inputStreamReader.close();
        bufferedReader.close();
    }


    /**
     * Reading all products from the file and insert them to the stack.
     *
     * @param fileName The file name of the file
     * @param stack    The Stack contains all products that read from file
     */
    public void getAllItemsFromFile(String fileName, MyStack<Product> stack) throws IOException {
        //Reading file
        FileInputStream fileInputStream = new FileInputStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        while (line != null) {
            //Splitting up line by " "
            String[] arr = line.split("\\s");
            //Creating product
            Product addProduct = new Product(arr[0], arr[1], Integer.parseInt(arr[2]), Double.parseDouble(arr[3]));
            // Pushing product in stack
            stack.push(addProduct);
            line = bufferedReader.readLine();
        }
        //Close file
        fileInputStream.close();
        inputStreamReader.close();
        bufferedReader.close();
    }

    /**
     * Reading all products from the file and insert them to the queue.
     *
     * @param fileName The file name of the file
     * @param queue    The Queue contains all products that read from file
     */
    public void getAllItemsFromFile(String fileName, MyQueue<Product> queue) throws IOException {
        //Reading file
        FileInputStream fileInputStream = new FileInputStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        while (line != null) {
            //Splitting up line by " "
            String[] arr = line.split("\\s");
            //Creating product
            Product addProduct = new Product(arr[0], arr[1], Integer.parseInt(arr[2]), Double.parseDouble(arr[3]));
            // Adding product in queue
            queue.enqueue(addProduct);
            line = bufferedReader.readLine();
        }
        //Close file
        fileInputStream.close();
        inputStreamReader.close();
        bufferedReader.close();
    }


    /**
     * Adding a product to the list, info of the product input from keyboard.
     *
     * @param list The Linked list
     */
    public void addLast(MyList<Product> list, PrintStream file) {
        list.insertToTail(createProduct(file));
    }

    /**
     * Printing all products of the list to console screen
     *
     * @param list The linked list
     */
    public void displayAll(MyList<Product> list) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|     ID       |         Title        |   Quantity   |     Price    |");
        System.out.println("---------------------------------------------------------------------");
        list.printList();
        System.out.println("---------------------------------------------------------------------");
    }

    /**
     * Printing all products of the stack to console screen
     *
     * @param stack The stack
     */
    public void displayAll(MyStack<Product> stack) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|     ID       |         Title        |   Quantity   |     Price    |");
        System.out.println("---------------------------------------------------------------------");
        stack.printStack();
        System.out.println("---------------------------------------------------------------------");
    }

    /**
     * Printing all products of the queue to console screen
     *
     * @param queue The queue
     */
    public void displayAll(MyQueue<Product> queue) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("|     ID       |         Title        |   Quantity   |     Price    |");
        System.out.println("---------------------------------------------------------------------");
        queue.printQueue();
        System.out.println("---------------------------------------------------------------------");
    }

    /**
     * Writing all products from the list to the file
     *
     * @param fileName Input file name
     * @param list     Input Linked list
     */
    public void writeAllItemsToFile(String fileName, MyList<Product> list) throws IOException {
        //Writing file
        FileWriter fileWriter = new FileWriter(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Node<Product> curr = list.head;
        while (curr != null) {
            bufferedWriter.write(curr.info.getCode() + " " + curr.info.getTitle() + " " + curr.info.getQuantity() + " " + curr.info.getPrice());
            bufferedWriter.newLine();
            curr = curr.next;
        }
        //Close file
        bufferedWriter.close();
        System.out.println("\nSuccessfully!");
    }


    /**
     * Searching product by ID input from keyboard.
     *
     * @param list Input linked list
     */
    public void searchByCode(MyList<Product> list, PrintStream file) {
        System.out.print("Input the ID to search = ");
//        creating f to be found
        String f = scanner.next();
        file.append(String.valueOf(f)).append("\n");
        System.out.print("Result: ");
        Node<Product> curr = list.head;
        while (curr != null) {
            if (curr.info.getCode().equalsIgnoreCase(f)) {
//                Printing the element to be found to console screen
                System.out.print(curr.info.toString());
                return;
            }
            curr = curr.next;
        }
        System.out.print(-1);
    }


    /**
     * Deleting first product that has the ID input from keyboard from the list.
     *
     * @param list input linked list
     */
    public void deleteByCode(MyList<Product> list, PrintStream file) {
        System.out.print("Input the bcode to delete = ");
//        Creating del to be deleted
        String del = scanner.next();
        file.append(String.valueOf(del)).append("\n");
        Node<Product> curr = list.head;
        while (curr != null) {
            if (curr.info.getCode().equalsIgnoreCase(del)) {
//                call method delete element
                list.deleteElement(curr.info);
                System.out.println("Deleted!");
                return;
            }
            curr = curr.next;
        }
        System.out.println("Not found to delete!");
    }


    /**
     * Sorting products in linked list by ID
     *
     * @param list The Linked list
     */
    public void sortByCode(MyList<Product> list) {
        Node<Product> n = list.head;
        while (n.next != null)
            n = n.next;
        //Calling quick sort recursive
        quickSortRecur(list, list.head, n);
        System.out.println("\nSuccessfully!");
    }

    /**
     * Sorting the list by quick sort recursive
     *
     * @param list  input linked list
     * @param left  left of linked list
     * @param right right of linked list
     */
    public void quickSortRecur(MyList<Product> list, Node<Product> left, Node<Product> right) {
        if (left == null || left == right || left == right.next)
            return;
        //Split list and partition recurse
        Node<Product> pivotPrev = Partition(list, left, right);
        quickSortRecur(list, left, pivotPrev);

        if (pivotPrev != null && pivotPrev == left)
            quickSortRecur(list, pivotPrev.next, right);
        else if (pivotPrev != null && pivotPrev.next != null)
            quickSortRecur(list, pivotPrev.next.next, right);
    }

    /**
     * Select the pivot element
     *
     * @param list  Input linked list
     * @param left  left of this linked list
     * @param right right of this linked list
     * @return the node that bisects the list
     */
    public Node<Product> Partition(MyList<Product> list, Node<Product> left, Node<Product> right) {
        if (left == right || left == null || right == null)
            return left;
        Node<Product> pivotPrev = left;
        Node<Product> curr = left;

        while (left != right) {
            if (left.info.getCode().compareToIgnoreCase(right.info.getCode()) < 0) {
                pivotPrev = curr;
                list.swap(curr, left);
                curr = curr.next;
            }
            left = left.next;
        }
        list.swap(curr, right);
        return pivotPrev;
    }


    /**
     * Convert a decimal to an array of binary. Example: input i = 18 -> Output =
     * <p>
     * {0, 1, 0, 0, 0, 1}
     *
     * @param i Input decimal number
     * @return int of binary numbers
     */
    public int convertToBinary(int i) {
        if (i == 0)
            return 0;
        else
            return (i % 2 + 10 * convertToBinary(i / 2));
    }
}
