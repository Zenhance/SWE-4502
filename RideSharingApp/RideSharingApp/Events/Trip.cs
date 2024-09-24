using RideSharingApp.Behaviours;
using RideSharingApp.Domain;
using RideSharingApp.Enums;

namespace RideSharingApp.Events;

public class Trip
{
    private readonly Rider _rider;
    private Driver _driver;
    private string _startLocation;
    private string _endLocation;
    private double _fare;
    private RideStatus _status;

    private readonly IRideType _rideTypeStrategy;
    private IPayment _paymentStrategy;

    public Trip(Rider rider, Driver driver, IRideType rideTypeStrategy, IPayment paymentStrategy)
    {
        _rider = rider;
        _driver = driver;
        _rideTypeStrategy = rideTypeStrategy;
        _paymentStrategy = paymentStrategy;
        _status = RideStatus.Pending;
    }

    public void SetStartLocation(string startLocation)
    {
        if (_status == RideStatus.Pending)
        {
            _startLocation = startLocation;
            Console.WriteLine($"Pickup location updated to: {_startLocation}");
        }
        else
        {
            throw new InvalidOperationException("Cannot change start location after ride has started");
        }
    }

    public void SetEndLocation(string endLocation)
    {
        if (_status == RideStatus.Pending || _status == RideStatus.InProgress)
        {
            _endLocation = endLocation;
            Console.WriteLine($"Drop-off location updated to: {_endLocation}");
        }
        else
        {
            throw new InvalidOperationException("Cannot change drop-off location after ride is completed");
        }
    }

    public void StartRide()
    {
        if (_startLocation == null || _endLocation == null)
        {
            throw new ArgumentException("Locations must be set before starting the ride");
        }
        _status = RideStatus.InProgress;
        Console.WriteLine($"Ride started from {_startLocation} to {_endLocation}");
    }

    public void CompleteRide()
    {
        _status = RideStatus.Completed;
        _fare = _rideTypeStrategy.CalculateFare(_startLocation, _endLocation);
        Console.WriteLine($"Ride completed. Fare: ${_fare}");
    }

    public void SetPaymentMethod(IPayment paymentStrategy)
    {
        if (_status is RideStatus.InProgress or RideStatus.Pending)
        {
            _paymentStrategy = paymentStrategy;
            Console.WriteLine("Payment method changed.");
        }
        else
        {
            throw new InvalidOperationException("Cannot change payment method after the ride is completed");
        }
    }

    public void MakePayment()
    {
        _paymentStrategy.ProcessPayment(_fare);
    }
}


