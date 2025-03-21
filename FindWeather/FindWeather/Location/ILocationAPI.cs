namespace FindWeather.Location;

public interface ILocationApi
{
    Task<(double Latitude, double Longitude, string City)> GetLocation();
}






