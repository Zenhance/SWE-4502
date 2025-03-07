import java.util.ArrayList;
import java.util.List;

public abstract class CompositProduct implements Iproduct{

    public List<Iproduct> products = new ArrayList<>();

    public List<Iproduct> getProducts(){
        return products;
    }

    protected void addProduct(Iproduct product){
        products.add(product);
    }

    public abstract void build();

    @Override
    public double getPrice(){
        double totalPrice = 0;
        for (Iproduct product: products) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    @Override
    public void printDetails(){
        for(Iproduct product : products){
            product.printDetails();
        }
    }

}
