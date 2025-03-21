using FindWeather.Location;
using FindWeather.Weather;

ILocationApi locationAPI = new IpstackLocationAdapter();

var weatherAPIs = new Dictionary<string, IWeatherAPI>
{
    { "OpenWeatherMap", new OpenWeatherAdapter() },
    { "WeatherStack", new WeatherStackAdapter() }
};

IWeatherAPI weatherProxy = new WeatherApiProxy(weatherAPIs);
var weatherFacade = new WeatherApiFacade(locationAPI, weatherProxy);

while (true)
{
    Console.WriteLine("Select location method: 1. By IP, 2. By City, 3. Exit");
    var choice = Console.ReadLine();

    switch (choice)
    {
        case "1":
            Console.WriteLine("Getting weather data by IP...");
            await weatherFacade.ShowWeatherByIp();
            break;

        case "2":
            Console.WriteLine("Enter city name to get weather data:");
            await weatherFacade.ShowWeatherByCity();
            break;

        case "3":
            Console.WriteLine("Exiting application...");
            return;  // Exit the while loop and end the application

        default:
            Console.WriteLine("Invalid choice. Please enter 1, 2, or 3.");
            break;
    }
    
    Console.WriteLine();  // Add an empty line for better readability
}