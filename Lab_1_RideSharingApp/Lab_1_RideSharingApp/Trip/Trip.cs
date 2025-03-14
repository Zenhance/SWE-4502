using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_1_RideSharingApp
{
    public class Trip
    {
        public int Id { get; set; }
        public string PickupLocation { get; set; }
        public string DropOffLocation { get; set; }
        public RideType RideType { get; set; }
        public double Fare { get; private set; }
        public double Distance { get; set; }
        public Driver Driver { get; private set; }
        public string Status { get; private set; }

        public Trip(int id, string pickupLocation, string dropOffLocation, RideType rideType, double distance)
        {
            Id = id;
            PickupLocation = pickupLocation;
            DropOffLocation = dropOffLocation;
            RideType = rideType;
            Distance = distance;

            // Immediately calculate the fare after initialization
            Fare = CalculateFare();
            Status = "Requested";
        }

        public double CalculateFare()
        {
            // Updated fare calculation logic based on ride type
            double baseFare = 0;
            switch (RideType)
            {
                case RideType.Carpool:
                    baseFare = 20;
                    break;

                case RideType.Luxury:
                    baseFare = 35;
                    break;

                case RideType.Bike:
                    baseFare = 15;
                    break;

                default:
                    baseFare = 10; // Default fare for unknown ride types
                    break;
            }

            // Calculate fare based on the ride type and distance
            return baseFare * Distance;
        }

        public void AssignDriver(Driver driver)
        {
            Driver = driver;
            Status = "Driver Assigned";
        }

        public void StartTrip()
        {
            Status = "In Progress";
            Console.WriteLine("\nTrip has started.");
        }

        public void CompleteTrip()
        {
            Status = "Completed";
            Console.WriteLine("\nTrip has been completed.");
        }
    }

}
