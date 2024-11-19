using System;
namespace _210042111_Lab08
{public class WeatherService
    { WeatherFacade weatherFacade = new WeatherFacade();
        bool exit = false;
        public void Go() { while(!exit)
            {
                Console.WriteLine("1. Check weather by city");
                Console.WriteLine("2. Exit");
                Console.Write("Enter your choice: ");
            } }
    }
}
