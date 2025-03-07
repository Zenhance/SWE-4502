public class BikeRide implements RideType{
    private double pricePerKilometer;
    private double distance;

    public BikeRide(double pricePerKilometer, double distance) {
        this.pricePerKilometer = pricePerKilometer;
        this.distance = distance;
    }

    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    public double getDistance() {
        return distance;
    }

    public void setPricePerKilometer(double pricePerKilometer) {
        this.pricePerKilometer = pricePerKilometer;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public double calculatePrice() {
        return pricePerKilometer * distance;
    }
}
