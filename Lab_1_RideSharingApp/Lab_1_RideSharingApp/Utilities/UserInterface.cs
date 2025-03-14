using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Lab_1_RideSharingApp
{
    public class UserInterface
    {
        private readonly PaymentService _paymentService;
        private readonly TripService _tripService;

        public UserInterface(PaymentService paymentService, TripService tripService)
        {
            _paymentService = paymentService;
            _tripService = tripService;
        }

        public void StartRideSharingApp()
        {
            Console.WriteLine("Welcome to the Ride-Sharing App!");

            // Get user details
            Console.Write("Enter Rider ID: ");
            int riderId = int.Parse(Console.ReadLine());

            Console.Write("Enter Rider Name: ");
            string riderName = Console.ReadLine();

            Rider rider = new Rider(riderId, riderName, null, null);

            // Request a ride
            Trip trip = _tripService.RequestRide(rider);

            // Simulate the journey
            Thread.Sleep(3000); // Simulate a delay for 3 seconds

            // Offer to change payment method
            Console.Write("\nDo you want to change your payment method? (yes/no): ");
            if (Console.ReadLine().ToLower() == "yes")
            {
                rider.ChangePaymentMethod(_paymentService.GetPaymentMethod());
            }

            _tripService.CompleteTrip(trip);


            // Rate the driver
            Console.Write("\nRate the driver (1 to 5): ");
            double rating = double.Parse(Console.ReadLine());
            rider.RateDriver(trip.Driver, rating);

            // Show completion message
            Console.WriteLine("\n###################################################################################\n");
            Console.WriteLine($"You have completed your journey from {trip.PickupLocation} to {trip.DropOffLocation}.");
        }
    }

}
