import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class AS2_Main {
    static Scanner sc = new Scanner(System.in);
    static OperationToProduct operation = new OperationToProduct();
    static MyList<Product> list = new MyList<>();
    static MyStack<Product> stack = new MyStack<>();
    static MyQueue<Product> queue = new MyQueue<>();

    //Showing functions of program
    public static void showMenu() {
        System.out.println("\nChoose one of these options:");
        System.out.println("\tProduct list:");
        System.out.println("\t\t1. Load data from file and display.");
        System.out.println("\t\t2. Input & add to the end.");
        System.out.println("\t\t3. Display data.");
        System.out.println("\t\t4. Save product list to file.");
        System.out.println("\t\t5. Search by ID.");
        System.out.println("\t\t6. Delete by ID.");
        System.out.println("\t\t7. Sort by ID.");
        System.out.println("\t\t8. Convert to Binary.");
        System.out.println("\t\t9. Load to stack and display.");
        System.out.println("\t\t10. Load to queue and display.");
        System.out.println("\t\t0. Exit");
        System.out.print("\nChoice = ");
    }


    public static void main(String[] args) throws IOException {
        PrintStream file = new PrintStream("src/console_output.txt");
        CustomPrintStream custom = new CustomPrintStream(System.out, file);

        System.setOut(custom);
        int choice;
        do {
            showMenu();
            if (!sc.hasNextInt()) {
                System.out.println("---- Try again! ----");
                return;
            }
            choice = sc.nextInt();
            file.append(String.valueOf(choice)).append("\n");

            switch (choice) {
                case 0 -> System.out.println("Thanks!!!");
                case 1 -> {
                    System.out.println("\n1. Load data from file and display");
                    operation.getAllItemsFromFile("src/data.txt", list);
                    operation.displayAll(list);
                    System.out.println("\nSuccessfully!");
                }
                case 2 -> {
                    System.out.println("\n2. Input & add to the end");
                    operation.addLast(list, file);
                }
                case 3 -> {
                    System.out.println("\n3. Display data");
                    operation.displayAll(list);
                }
                case 4 -> {
                    System.out.println("\n4. Save product list to file");
                    operation.writeAllItemsToFile("src/data.txt", list);
                }
                case 5 -> {
                    System.out.println("\n5. Search by ID");
                    operation.searchByCode(list, file);
                }
                case 6 -> {
                    System.out.println("\n6. Delete by ID");
                    operation.deleteByCode(list, file);
                }
                case 7 -> {
                    System.out.println("\n7. Sort by ID");
                    operation.sortByCode(list);
                }
                case 8 -> {
                    System.out.println("\n8. Convert to Binary");
                    System.out.print("Quantity = " + list.head.info.getQuantity() + " => (" + operation.convertToBinary(list.head.info.getQuantity()) + ")\n");
                }
                case 9 -> {
                    System.out.println("\n9. Load to stack and display");
                    operation.getAllItemsFromFile("src/data.txt", stack);
                    operation.displayAll(stack);
                    System.out.println("\nSuccessfully!");
                }
                case 10 -> {
                    System.out.println("\n10. Load to queue and display");
                    operation.getAllItemsFromFile("src/data.txt", queue);
                    operation.displayAll(queue);
                    System.out.println("\nSuccessfully!");
                }
                default -> System.out.println("\t!---- Enter wrong re-enter ----!");
            }
        } while (choice != 0);
    }
}

