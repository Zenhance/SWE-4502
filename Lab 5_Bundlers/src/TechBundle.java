import java.util.ArrayList;
import java.util.List;

public class TechBundle extends Bundle {

    public TechBundle() {
        super("Tech Bundle", "A collection of tech products", 100);  // $100 discount
    }

    @Override
    public List<Product> createBundle() {
        List<Product> products = new ArrayList<>();
        products.add(new SimpleProduct("Laptop", 1000, "A high-performance laptop"));
        products.add(new SimpleProduct("Phone", 600, "A latest-model smartphone"));
        return products;
    }
}
