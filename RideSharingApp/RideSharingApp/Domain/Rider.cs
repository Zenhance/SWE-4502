using RideSharingApp.Behaviours;
using RideSharingApp.Events;

namespace RideSharingApp.Domain;

public class Rider(string name, string contactInfo, IPayment paymentStrategy) : User(name, contactInfo)
{
    public Trip RequestRide(Driver driver, IRideType rideTypeStrategy, string startLocation, string endLocation)
    {
        Trip ride = new Trip(this, driver, rideTypeStrategy, paymentStrategy);
        ride.SetStartLocation(startLocation);
        ride.SetEndLocation(endLocation);
        Console.WriteLine($"{Name} requested a ride from {startLocation} to {endLocation}");
        return ride;
    }

    public void SetPaymentMethod(Trip ride, IPayment currentPaymentStrategy)
    {
        ride.SetPaymentMethod(currentPaymentStrategy);
        Console.WriteLine($"{Name} changed the payment method.");
    }

    public void UpdateDropoffLocation(Trip ride, string newEndLocation)
    {
        ride.SetEndLocation(newEndLocation);
        Console.WriteLine($"{Name} updated the drop-off location to {newEndLocation}");
    }
    

    public override decimal RecalculateRating(decimal updatedRating)
    {
        throw new NotImplementedException();
    }
}






