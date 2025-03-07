package RideType;

public class CarPool implements RideType{
    public String CarModel;
    public String CarColor;
    public String CarNumber;
    public int numberOfPassengers;
    public double perHeadCost;


    public CarPool(String CarModel, String CarColor, String CarNumber, double perHeadCost, int numberOfPassengers){
        this.CarModel = CarModel;
        this.CarColor = CarColor;
        this.CarNumber = CarNumber;
        this.perHeadCost = perHeadCost;
        this.numberOfPassengers = numberOfPassengers;
    }

    public CarPool(double perHeadCost, int numberOfPassengers){
        this.CarModel = "Not Available";
        this.CarColor = "Not Available";
        this.CarNumber = "Not Available";
        this.perHeadCost = perHeadCost;
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public void bookRide() {
        System.out.println("Car Pool Booked!");
    }

    @Override
    public double calculateFare() {
        return perHeadCost * numberOfPassengers;
    }
}
