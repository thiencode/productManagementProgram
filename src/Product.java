public class Product {
    private String code;
    private String title;
    private int quantity;
    private double price;

    /**
     * Constructor method to initialize a product
     *
     * @param code     Product's bar code
     * @param title    Product's title
     * @param quantity Product's quantity
     * @param price    Product's price
     */
    public Product(String code, String title, int quantity, double price) {
        this.code = code;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    //Setters & getters to get and set product's information
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Overriding convert this product to String for printing
     */
    @Override
    public String toString() {
        String formatBody = "| %-13s| %-21s| %-13d| %-13.1f|\n";
        System.out.printf(formatBody, this.getCode(), this.getTitle(), this.getQuantity(), this.getPrice());
        return "";
    }
}
