// See https://aka.ms/new-console-template for more information
using HomeAutomation.Componenets;
using HomeAutomation.Core;

class Program
{
    static void Main()
    {
        EnvironmentMonitor monitor = new();
        MotionDetector motionDetector = new();
        LightManager lightManager = new();
        TemperatureController tempController = new();
        EnergyTracker energyTracker = new();
        RemoteAccessApp remoteApp = new();

        // Register components
        monitor.RegisterObserver(motionDetector);
        monitor.RegisterObserver(lightManager);
        monitor.RegisterObserver(tempController);
        monitor.RegisterObserver(energyTracker);
        monitor.RegisterObserver(remoteApp);

        // Simulate an environment state change
        EnvironmentState newState = new()
        {
            MotionDetected = true,
            AmbientLight = 10,
            Temperature = 18,
            PowerUsage = 200
        };

        monitor.NotifyObservers(newState);
    }
}

