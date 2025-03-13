using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_1_RideSharingApp
{
    public class TripService
    {
        private readonly PaymentService _paymentService;

        // Constructor to inject the PaymentService
        public TripService(PaymentService paymentService)
        {
            _paymentService = paymentService;
        }

        // Method to request a ride
        public Trip RequestRide(Rider rider)
        {
            Console.Write("Enter Pickup Location: ");
            string pickupLocation = Console.ReadLine();

            Console.Write("Enter Drop-off Location: ");
            string dropOffLocation = Console.ReadLine();

            Console.Write("Enter Distance (in km): ");
            double distance = double.Parse(Console.ReadLine());

            Console.WriteLine("\nSelect Ride Type:");
            Console.WriteLine("1. Carpool");
            Console.WriteLine("2. Luxury");
            Console.WriteLine("3. Bike");
            Console.Write("Enter your choice: ");
            RideType rideType = GetRideType();

            // Ask for payment method before starting the journey
            Console.WriteLine("\nPlease select a payment method before starting the journey:");
            rider.ChangePaymentMethod(_paymentService.GetPaymentMethod());

            // Create a new trip with the provided details
            Trip trip = new Trip(1, pickupLocation, dropOffLocation, rideType, distance);

            // Assign a driver (simulated)
            Driver driver = new Driver(1, "John Doe", "Current Location", "Luxury Car");
            trip.AssignDriver(driver);

            // Start the trip
            trip.StartTrip();

            // Fare is automatically calculated during initialization; no need to set it manually.
            Console.WriteLine($"Fare for the trip: {trip.Fare}");

            return trip;
        }

        // Method to complete a trip
        public void CompleteTrip(Trip trip)
        {
            trip.CompleteTrip();
            Console.WriteLine($"The calculated fare based on distance is {trip.Fare}.");
            _paymentService.ValidatePayment(trip.Fare);
        }

        // Helper method to get ride type from user
        private RideType GetRideType()
        {
            string choice = Console.ReadLine();
            switch (choice)
            {
                case "1":
                    return RideType.Carpool;
                case "2":
                    return RideType.Luxury;
                case "3":
                    return RideType.Bike;
                default:
                    throw new ArgumentException("Invalid ride type selected.");
            }
        }

        // Helper method to get distance input from user
        private double GetDistance()
        {
            Console.Write("Enter Distance (in km): ");
            return double.Parse(Console.ReadLine());
        }
    }
}
