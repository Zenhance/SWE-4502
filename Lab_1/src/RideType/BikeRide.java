
package RideType;

public class BikeRide implements RideType{
    public String RegistrationNumber;
    public String BikeModel;
    public String BikeColor;

    public double distance;
    public double costPerKm;

    public BikeRide(String RegistrationNumber, String BikeModel, String BikeColor, double distance, double costPerKm){
        this.RegistrationNumber = RegistrationNumber;
        this.BikeModel = BikeModel;
        this.BikeColor = BikeColor;
        this.distance = distance;
        this.costPerKm = costPerKm;
    }

    public BikeRide(double distance, double costPerKm){
        this.RegistrationNumber = "Not Available";
        this.BikeModel = "Not Available";
        this.BikeColor = "Not Available";
        this.distance = distance;
        this.costPerKm = costPerKm;
    }

    @Override
    public void bookRide() {
        System.out.println("Bike Ride Booked!");
    }

    @Override
    public double calculateFare() {
        return distance * costPerKm;
    }
}
