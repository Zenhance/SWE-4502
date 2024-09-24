using RideSharingApp.Events;

namespace RideSharingApp.Domain;

public class Driver : User
{
    private bool IsAvailable { get; set; }

    public Driver(string name, string contactInfo) : base(name, contactInfo)
    {
        IsAvailable = true;
    }

    public void AcceptRide(Trip ride)
    {
        if (IsAvailable)
        {
            IsAvailable = false;
            Console.WriteLine($"{Name} accepted the ride.");
            ride.StartRide();
        }
        else
        {
            Console.WriteLine($"Driver {Name} is not available.");
        }
    }

    public void CompleteRide(Trip ride)
    {
        ride.CompleteRide();
        IsAvailable = true;
        Console.WriteLine($"{Name} completed the ride.");
    }

    public void UpdateDropoffLocation(Trip ride, string newEndLocation)
    {
        ride.SetEndLocation(newEndLocation);
        Console.WriteLine($"Driver {Name} updated the drop-off location to {newEndLocation}");
    }

    public void DisplayUserInfo()
    {
        Console.WriteLine($"Driver: {Name}, Rating: {Rating}, Availability: {(IsAvailable ? "Available" : "Busy")}");
    }

    public override decimal RecalculateRating(decimal updatedRating)
    {
        throw new NotImplementedException();
    }
}
