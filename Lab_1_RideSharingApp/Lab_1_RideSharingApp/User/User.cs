using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_1_RideSharingApp
{
    public abstract class User
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Location { get; set; }
        public double Rating { get; set; }

        public User(int id, string name, string location)
        {
            Id = id;
            Name = name;
            Location = location;
            Rating = 5.0; // Default rating for a new user
        }

        public abstract void DisplayInfo(); 
    }

}
