using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _210042111_Lab08
{
    public class WeatherService
    {

        WeatherFacade weatherFacade = new WeatherFacade();
        bool exit = false;
        public void Go()
        {
            while (!exit)
            {
                Console.WriteLine("1. Check weather");
                Console.WriteLine("2. Exit");

             

                string choice = Console.ReadLine();

                switch (choice)
                {
                    case "1":
                        weatherFacade.Start().Wait();
                        break;
                    case "2":
                        exit = true;
                        Console.WriteLine("Exiting.");
                        break;
                    default:
                        Console.WriteLine("Try again.");
                        break;
                }

                if (!exit)
                {
                    Console.WriteLine("Would you like to perform another operation? (y/n)");
                    string option = Console.ReadLine();
                    if (option != "y")
                    {
                        exit = true;
                        Console.WriteLine("Program closing");
                    }
                }
            }
        }
    }
}
