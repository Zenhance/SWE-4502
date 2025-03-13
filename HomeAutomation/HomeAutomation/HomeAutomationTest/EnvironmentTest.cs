using HomeAutomate.Core;
using HomeAutomate.Models;
using HomeAutomate.Components;
using HomeAutomate.Enum;

namespace HomeAutomationTest;

public class EnvironmentTest
{
    private static EnvironmentState _environment;
    private static MotionDetector _motionDetector;
    private static LightManager _lightManager;
    private static TemperatureManager _temperatureManager;
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
        
        _temperatureManager = new TemperatureManager();
        _environment.AddComponent(_temperatureManager);
        
        _energyManager = new EnergyConsumptionManager(130);
        _environment.AddComponent(_energyManager);
        
        _voiceCommandManager = new VoiceCommandManager(_environment);
        _environment.AddComponent(_voiceCommandManager);
    }
    
    [Test]
    public void EnvironmentInitializeTest()
    {
        Assert.That(_environment.GetTemperature(), Is.EqualTo(0));
        Assert.That(_environment.GetMotionLevel(), Is.EqualTo(0));
        Assert.That(_environment.GetAmbientLightLevel(), Is.EqualTo(0));
        Assert.That(_environment.GetEnergyConsumption(), Is.EqualTo(0));
        Assert.That(_environment.GetLastVoiceCommand(), Is.EqualTo(""));
    }
    
    
    
    
}
