namespace RideSharingApp.Behaviours;

public interface IRideType
{
    double CalculateFare(string startLocation, string endLocation);
}