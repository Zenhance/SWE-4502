using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_1_RideSharingApp
{
    public class Driver : User
    {
        public string VehicleType { get; set; }
        public bool IsAvailable { get; set; }

        public Driver(int id, string name, string location, string vehicleType)
            : base(id, name, location)
        {
            VehicleType = vehicleType;
            IsAvailable = true;
        }

        public void AcceptRide(Trip trip)
        {
            if (IsAvailable)
            {
                trip.AssignDriver(this);
                Console.WriteLine($"{Name} has accepted the ride."); 
            }
        }

        public void StartTrip(Trip trip)
        {
            trip.StartTrip();
        }

        public void CompleteTrip(Trip trip)
        {
            trip.CompleteTrip();
        }

        public void UpdateRating(double rating)
        {
            Rating = (Rating + rating) / 2;
        }

        public void RateRider(Rider rider, double rating)
        {
            Console.WriteLine($"{Name} rated {rider.Name} with {rating} stars.");
        }

        public override void DisplayInfo()
        {
            Console.WriteLine($"Driver: {Name}, Vehicle Type: {VehicleType}, Location: {Location}, Rating: {Rating}");
        }
    }

}
