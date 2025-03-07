public class CarpoolRide implements RideType{
    private int passengers;
    private double pricePerPassenger;

    public CarpoolRide(int passengers, double pricePerPassenger) {
        this.passengers = passengers;
        this.pricePerPassenger = pricePerPassenger;
    }

    public int getPassengers() {
        return passengers;
    }

    public double getPricePerPassenger() {
        return pricePerPassenger;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void setPricePerPassenger(double pricePerPassenger) {
        this.pricePerPassenger = pricePerPassenger;
    }

    @Override
    public double calculatePrice() {
        return passengers * pricePerPassenger;
    }
}
