public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private String vendorName;

    // Constructor, Getters, and Setters
    public Product(int id, String name, double price, String description, String vendorName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.vendorName = vendorName;
    }

    // Add getters and setters here

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", vendorName='" + vendorName + '\'' +
                '}';
    }
}