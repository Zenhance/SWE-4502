import java.util.ArrayList;
import java.util.List;

public class AccessoriesBundle extends Bundle {

    public AccessoriesBundle() {
        super("Accessories Bundle", "A collection of electronic accessories", 50);  // $50 discount
    }

    @Override
    public List<Product> createBundle() {
        List<Product> products = new ArrayList<>();
        products.add(new SimpleProduct("Mouse", 50, "A wireless mouse"));
        products.add(new SimpleProduct("Keyboard", 100, "A mechanical keyboard"));
        return products;
    }
}
