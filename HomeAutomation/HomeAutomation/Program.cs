using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Home Automation System Initialized");

            // Initialize Lighting Controller
            ILightingController lighting = new LightingController();
            lighting.TurnOn();
            lighting.AdjustBrightness(75);
            lighting.TurnOff();

            // Initialize Thermostat
            IThermostat thermostat = new Thermostat();
            thermostat.SetTargetTemperature(22);
            thermostat.UpdateCurrentTemperature(20);
            thermostat.ControlTemperature();
            Console.WriteLine($"Thermostat Target Temperature: 22°C");

            // Initialize Energy Monitor
            IEnergyMonitor energyMonitor = new EnergyMonitor();
            energyMonitor.RecordPowerUsage(50);
            energyMonitor.RecordPowerUsage(75);
            Console.WriteLine($"Total Energy Consumption: {energyMonitor.GetTotalConsumption()}W");
            energyMonitor.AnalyzeUsagePatterns();

            // Initialize Motion Sensor and Analyzer
            IMotionSensor motionSensor = new MotionSensor();
            motionSensor.DetectMotion("Living Room");
            MotionAnalyzer motionAnalyzer = new MotionAnalyzer();
            motionAnalyzer.LogMotion("Living Room");
            motionAnalyzer.AnalyzePatterns();

            // Initialize Voice Processor
            IVoiceProcessor voiceProcessor = new VoiceProcessor();
            voiceProcessor.ProcessCommand("Turn on the lights");
            voiceProcessor.ProcessCommand("Set thermostat to 22 degrees");

            // Get and display the last command processed
            string lastCommand = voiceProcessor.GetLastCommand();
            Console.WriteLine($"Last Command Processed: {lastCommand}");


            // Initialize Remote Controller
            IRemoteController remoteController = new RemoteController();
            remoteController.DisplayCurrentState();
            remoteController.GenerateNotifications("Security Alert: Front door left open.");
            remoteController.ControlSystem("Activate Security Mode");

            Console.WriteLine("Home Automation System Operations Completed.");
<<<<<<< HEAD
<<<<<<< HEAD
            Console.ReadLine();
=======
>>>>>>> 75f1046 (Completing Base Project)
=======
            Console.ReadLine();
>>>>>>> 8e1234a (Add Test)
        }
    }
}
