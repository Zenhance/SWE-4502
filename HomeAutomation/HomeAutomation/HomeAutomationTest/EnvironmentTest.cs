using HomeAutomation.Components;
using HomeAutomation.Core;

namespace HomeAutomationTest;

public class EnvironmentTest
{
    private static EnvironmentState _environment;
    private static MotionDetector _motionDetector;
    private static LightManager _lightManager;
    private static TemperatureManager _temperatureManager;
    private static EnergyConsumptionManager _energyConsumptionManager;
    private static VoiceCommandManager _voiceCommandManager;
    
    [SetUp]
    public void Setup()
    {
        _environment = new EnvironmentState();
        
        _motionDetector = new MotionDetector(0.5f);
        _environment.AddComponent(_motionDetector);
        
        _lightManager = new LightManager();
        _environment.AddComponent(_lightManager);
        
        _temperatureManager = new TemperatureManager();
        _environment.AddComponent(_temperatureManager);
        
        _energyConsumptionManager = new EnergyConsumptionManager(130);
        _environment.AddComponent(_energyConsumptionManager);
        
        _voiceCommandManager = new VoiceCommandManager();
        _environment.AddComponent(_voiceCommandManager);
    }
}