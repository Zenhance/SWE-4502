using System;
using HomeAutomation.Core_Model;
using HomeAutomation.Components;

class Program
{
    static void Main(string[] args)
    {
        // Initialize the central state manager
        CentralStateManager stateManager = new CentralStateManager();
        CentralState centralState = new CentralState();

        // Initialize components and register them as observers
        EnergyConsumtion energyMonitor = new EnergyConsumtion();
        LightManagment lightManager = new LightManagment();
        MotionDetection motionDetector = new MotionDetection();
        RemoteAccessApp remoteAccess = new RemoteAccessApp();
        TemperatureControl temperatureControl = new TemperatureControl();
        VoiceCommandSystem voiceCommandSystem = new VoiceCommandSystem();

        stateManager.RegisterObserver(energyMonitor);
        stateManager.RegisterObserver(lightManager);
        stateManager.RegisterObserver(motionDetector);
        stateManager.RegisterObserver(remoteAccess);
        stateManager.RegisterObserver(temperatureControl);
        stateManager.RegisterObserver(voiceCommandSystem);

        // Simulate changing state
        centralState.MotionDetected = true;
        centralState.LightLevel = 70;
        centralState.RoomOccupied = true;
        centralState.Temperature = 24;
        centralState.EnergyUsage = 5.4;
        centralState.VoiceCommand = "Turn on the lights";

        // Notify observers
        stateManager.NotifyObservers();

        Console.WriteLine("\nSimulation Complete. Press any key to exit.");
        Console.ReadKey();
    }
}
