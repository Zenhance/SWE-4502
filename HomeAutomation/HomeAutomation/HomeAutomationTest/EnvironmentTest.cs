using HomeAutomate.Components;
using HomeAutomate.Core;

namespace HomeAutomationTest;

public class EnvironmentTest
{
    private static EnvironmentState _environment;
    private static MotionDetector _motionDetector;
    private static LightManager _lightManager;
    private static TempManager _temperatureManager;
    private static EnergyConsumptionManager _energyManager;
    private static VoiceCommandManager _voiceCommandManager;

    [SetUp]
    public void Setup()
    {
        _environment = new EnvironmentState();
        
        _motionDetector = new MotionDetector(0.5f);
        _environment.AddComponent(_motionDetector);

        _lightManager = new LightManager();
        _environment.AddComponent(_lightManager);
        
        _temperatureManager = new TempManager();
        _environment.AddComponent(_temperatureManager);
        
        _energyManager = new EnergyConsumptionManager(130);
        _environment.AddComponent(_energyManager);
        
        _voiceCommandManager = new VoiceCommandManager(_environment);
        _environment.AddComponent(_voiceCommandManager);
    }

}