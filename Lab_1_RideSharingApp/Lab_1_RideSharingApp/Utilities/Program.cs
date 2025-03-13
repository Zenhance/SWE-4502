using Lab_1_RideSharingApp;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_1_RideSharingApp
{
    public class Program
    {
        public static void Main(string[] args)
        {
            // Create instances of services and user interface
            PaymentService paymentService = new PaymentService();
            TripService tripService = new TripService(paymentService); // Pass paymentService to tripService
            UserInterface userInterface = new UserInterface(paymentService, tripService);

            // Start the ride-sharing application
            try
            {
                userInterface.StartRideSharingApp();
            }
            catch (Exception ex)
            {
                Console.WriteLine($"An error occurred: {ex.Message}");
            }

            // Wait for user input before closing
            Console.WriteLine("\nPress Enter to exit...");
            Console.ReadLine();
        }
    }
}
