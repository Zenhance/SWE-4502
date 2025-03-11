public class AccessoriesBundle extends Bundle {

    public AccessoriesBundle() {
        super("Accessories Bundle", "A collection of electronic accessories", 500);
        this.createBundle();
    }

    @Override
    public void  createBundle() {
        products.add(new SimpleProduct("Mouse", 950, "Wireless mouse"));
        products.add(new SimpleProduct("Keyboard", 4500, "Havit Mechanical keyboard"));

    }
}

