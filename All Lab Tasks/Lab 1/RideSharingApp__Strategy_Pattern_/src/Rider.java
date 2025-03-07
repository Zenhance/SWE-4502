public class Rider extends User {
    private IPaymentMethod preferredPaymentMethod;

    public Rider(int id, String name, String location, IPaymentMethod preferredPaymentMethod) {
        super(id, name);
        this.preferredPaymentMethod = preferredPaymentMethod;
    }

    public void requestRide(String pickupLocation, String dropOffLocation, RideType rideType) {
        System.out.println(name + " has requested a " + rideType + " ride from " + pickupLocation + " to " + dropOffLocation + ".");
    }

    public void rateDriver(Driver driver, double rating) {
        driver.updateRating(rating);
        System.out.println(name + " rated " + driver.getName() + " with " + rating + " stars.");
    }
    public void changePaymentMethod(IPaymentMethod newMethod) {
        this.preferredPaymentMethod = newMethod;
        System.out.println(name + " selected a payment method.");
    }

    @Override
    public void displayInfo() {
        System.out.println("Rider: " + name + ", Rating: " + rating);
    }
}
