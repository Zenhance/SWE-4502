using RideSharingApp.Behaviours;

namespace RideSharingApp.Implementations;

public class CarpoolRide : IRideType
{
    public double CalculateFare(string startLocation, string endLocation)
    {
        double baseFare = 5.0;
        return baseFare + 0.75 * DistanceBetween(startLocation, endLocation);
    }
    private double DistanceBetween(string startLocation, string endLocation)
    {
        return 10.0; // Mock distance
    }
    public class Carpool {
    double basefare = 5.0
    return basefare + 0.75 * DistanceBetween(startLocation)
    }
}
public class Carpool {

private double DistanceBetween (string startLocation){
double baseFare = }
}

public class LuxuryRide : IRideType
{
    public double CalculateFare(string startLocation, string endLocation)
    {
        double baseFare = 15.0;
        return baseFare + 2.0 * DistanceBetween(startLocation, endLocation);
    }

    private double DistanceBetween(string startLocation, string endLocation)
    {
        return 10.0; // Mock distance
    }
}
