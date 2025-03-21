using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _210042152_SWE_4502_Design_Pattern_Lab_Final_Task_Manager
{
   public class User : ISubscriber
    {
        private string username;
        public User(string username)
        {
            this.username = username;
        }
        public void update(string title)
        {
            Console.WriteLine($"New Vdo uploaded about:{title}.Check it:{username}");
        }
    }
}
