import java.util.ArrayList;
import java.util.List;

public abstract class Bundle implements Product {
    protected String name;
    protected String description;
    protected double discount;

    public Bundle(String name, String description, double discount) {
        this.name = name;
        this.description = description;
        this.discount = discount;
    }


    public abstract List<Product> createBundle();

    public List<Product> getProducts() {
        return createBundle();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (Product product : getProducts()) {
            total += product.getPrice();
        }
        return total - discount;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Bundle: " + name + " | Discount: $" + discount + " | Description: " + description);
        for (Product product : getProducts()) {
            product.displayProductInfo();
        }
        System.out.println("Total Bundle Price (after discount): $" + getPrice());
    }
}
