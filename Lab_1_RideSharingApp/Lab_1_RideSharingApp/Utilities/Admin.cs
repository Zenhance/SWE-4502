using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_1_RideSharingApp
{
    public class Admin
    {
        public int Id { get; set; }
        public string Name { get; set; }

        public Admin(int id, string name)
        {
            Id = id;
            Name = name;
        }

        public void ManageDriver(Driver driver)
        {
            Console.WriteLine($"{Name} is managing driver: {driver.Name}");
        }

        public void ViewTripHistory(Trip trip)
        {
            Console.WriteLine($"Trip history: {trip.Status} from {trip.PickupLocation} to {trip.DropOffLocation}.");
        }

        public void HandleDispute(Rider rider, Driver driver)
        {
            Console.WriteLine($"Admin handling dispute between {rider.Name} and {driver.Name}.");
        }

        public void DisplayInfo()
        {
            Console.WriteLine($"Admin: {Name}");
        }
    }

}
