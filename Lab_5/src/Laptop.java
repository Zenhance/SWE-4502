public class Laptop implements Iproduct{
    private double price;
    private String modelName;

    public Laptop(String modelName, double price){
        this.price = price;
        this.modelName = modelName;
    }

    @Override
    public void printDetails(){
        System.out.println("\nLaptop : " + this.modelName + "\n" + "Price : " + this.price);
    }

    @Override
    public double getPrice(){
        return price;
    }
}
