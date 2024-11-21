using FindWeather.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FindWeather
{
    internal class FindWeatherApp
    {
        LocationService _locationService = new LocationService();
      
        public void Launch()
        {
            while (true)
            {
                AskLocationMethod();
                try
                {
                    
                    int input = int.Parse(Console.ReadLine());
                    
                    switch (input)
                    {
                        case 1:
                            // by ip
                            _locationService.FindLocationByIp();
                            break;
                        case 2:
                            // by city
                            break;
                        case 3:
                            Console.WriteLine("Exiting App...");
                            return;
                    }
                }
                catch (Exception e) {
                    Console.WriteLine(e.Message);
                }
            }
        }

        private void AskLocationMethod()
        {
            Console.WriteLine("Select location method: ");
            Console.WriteLine("1. By Ip, 2. By City, 3. Exit");
        }
    }
}
