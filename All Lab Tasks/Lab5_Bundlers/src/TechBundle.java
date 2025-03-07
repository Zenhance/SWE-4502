public class TechBundle extends Bundle {

    public TechBundle() {
        super("Tech Bundle", "A collection of tech products", 5000);
        this.createBundle();
    }

    @Override
    public void  createBundle() {
        products.add(new SimpleProduct("Laptop", 150000, "Legion"));
        products.add(new SimpleProduct("Phone", 90000, "iphone15"));

    }
}

