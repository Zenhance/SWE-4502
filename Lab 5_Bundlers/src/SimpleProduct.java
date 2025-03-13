public class SimpleProduct implements Product {
    private String name;
    private double price;
    private String description;

    public SimpleProduct(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Product: " + name + " | Price: $" + price + " | Description: " + description);
    }
}
