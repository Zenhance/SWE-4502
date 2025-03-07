public class Mobile implements Iproduct{
    private double price;
    private String modelName;

    public Mobile(String modelName, double price){
        this.price = price;
        this.modelName = modelName;
    }

    @Override
    public void printDetails(){
        System.out.println("\nMobile : " + this.modelName + "\n" + "Price : " + this.price);
    }

    @Override
    public double getPrice(){
        return price;
    }
}
