package RideType;

public class LuxeryCar implements RideType{
    public String CarModel;
    public String CarColor;
    public String CarNumber;

    public double hours;
    public double costPerHour;

    //constructor
    public LuxeryCar(String CarModel, String CarColor, String CarNumber, double hours, double costPerHour){
        this.CarModel = CarModel;
        this.CarColor = CarColor;
        this.CarNumber = CarNumber;
        this.hours = hours;
        this.costPerHour = costPerHour;
    }

    public LuxeryCar(double hours, double costPerHour){
        this.CarModel = "Not Available";
        this.CarColor = "Not Available";
        this.CarNumber = "Not Available";
        this.hours = hours;
        this.costPerHour = costPerHour;
    }

    @Override
    public void bookRide() {
        System.out.println("Luxery Car Booked!");
    }

    @Override
    public double calculateFare() {
        return hours * costPerHour;
    }

}
