using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_1_RideSharingApp
{
    public class Rider : User
    {
        public IPaymentMethod PreferredPaymentMethod { get; set; }

        public Rider(int id, string name, string location, IPaymentMethod preferredPaymentMethod)
            : base(id, name, location)
        {
            PreferredPaymentMethod = preferredPaymentMethod;
        }

        public void RequestRide(string pickupLocation, string dropOffLocation, RideType rideType)
        {
            Console.WriteLine($"{Name} has requested a {rideType} ride from {pickupLocation} to {dropOffLocation}.");
        }

        public void RateDriver(Driver driver, double rating)
        {
            driver.UpdateRating(rating);
            Console.WriteLine($"{Name} rated {driver.Name} with {rating} stars.");
        }

        public void MakePayment(Trip trip)
        {
            if (PreferredPaymentMethod != null)
            {
                PreferredPaymentMethod.ProcessPayment(trip.Fare);
            }
            else
            {
                Console.WriteLine("No preferred payment method set. Cannot process payment.");
            }
        }

        // Updated method to change the payment method dynamically
        public void ChangePaymentMethod(IPaymentMethod newMethod)
        {
            if (newMethod != null)
            {
                PreferredPaymentMethod = newMethod;
                Console.WriteLine($"\n\n{Name} has selected {PreferredPaymentMethod.GetType().Name} payment method.\n");
            }
            else
            {
                Console.WriteLine("Invalid payment method. Change was not successful.");
            }
        }

        public override void DisplayInfo()
        {
            Console.WriteLine($"Rider: {Name}, Location: {Location}, Rating: {Rating}");
        }
    }
}
