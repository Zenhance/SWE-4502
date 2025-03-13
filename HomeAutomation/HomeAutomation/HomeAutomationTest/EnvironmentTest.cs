using HomeAutomation.Components;
using HomeAutomation.Core;

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
    
    [Test]
    public void AddMotionComponentTest()
    {
        Assert.That(_environment.GetComponents()[0], Is.EqualTo(_motionDetector));
    }
    
    [Test]
    public void AddLightComponentTest()
    {
        Assert.That(_environment.GetComponents()[1], Is.EqualTo(_lightManager));
    }
    
    
    [Test]
    public void AddTemperatureComponentTest()
    {
        Assert.That(_environment.GetComponents()[2], Is.EqualTo(_temperatureManager));
    }
    
    
    [Test]
    public void AddEnergyComponentTest()
    {
        Assert.That(_environment.GetComponents()[3], Is.EqualTo(_energyManager));
    }
    
    
    [Test]
    public void AddVoiceCommandComponentTest()
    {
        Assert.That(_environment.GetComponents()[4], Is.EqualTo(_voiceCommandManager));
    }
}