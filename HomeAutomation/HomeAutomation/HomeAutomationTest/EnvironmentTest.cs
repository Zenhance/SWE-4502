using HomeAutomation.Components;
using HomeAutomation.Core;
using HomeAutomation.ENUM;
using HomeAutomation.Models;

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
        
        _voiceCommandManager = new VoiceCommandManager(_environment);
        _environment.AddComponent(_voiceCommandManager);
    }
    
    [Test]
    public void TestEnvironmentState()
    {
        Assert.That(_environment.GetTemperature(), Is.EqualTo(0));
        Assert.That(_environment.GetMotionLevel(), Is.EqualTo(0));
        Assert.That(_environment.GetAmbientLightLevel(), Is.EqualTo(0));
        Assert.That(_environment.GetEnergyConsumption(), Is.EqualTo(0));
        Assert.That(_environment.GetLastVoiceCommand(), Is.EqualTo(""));
    }
    
    [Test]
    public void TestAddMotionComponent()
    {
        
        Assert.That(_environment.GetComponents()[0], Is.EqualTo(_motionDetector));
    }
    
    [Test]
    public void TestAddLightComponent()
    {
        Assert.That(_environment.GetComponents()[1], Is.EqualTo(_lightManager));
    }
    
    [Test]
    public void TestAddTemperatureComponent()
    {
        Assert.That(_environment.GetComponents()[2], Is.EqualTo(_temperatureManager));
    }
    
    [Test]
    public void TestAddEnergyConsumptionComponent()
    {
        Assert.That(_environment.GetComponents()[3], Is.EqualTo(_energyConsumptionManager));
    }
    
    [Test]
    public void TestAddVoiceCommandComponent()
    {
        Assert.That(_environment.GetComponents()[4], Is.EqualTo(_voiceCommandManager));
    }
    
    [Test]
    public void TestSetTemperature()
    {
        Command command = new Command(40);
        _environment.SetTemperature(command);
        Assert.That(_environment.GetTemperature(), Is.EqualTo(40));
        Assert.That(_temperatureManager.GetState(), Is.EqualTo(TEMPSTATE.COOLING));
    }

    [Test]
    public void TestSetTemperatureHeating()
    {
        Command command = new Command(9);
        _environment.SetTemperature(command);
        
        Assert.That(_environment.GetTemperature(), Is.EqualTo(9));
        Assert.That(_temperatureManager.GetState(), Is.EqualTo(TEMPSTATE.HEATING));
    }

    [Test]
    public void TestSetTemperatureNormal()
    {
        Command command = new Command(25);
        _environment.SetTemperature(command);
        
        Assert.That(_environment.GetTemperature(), Is.EqualTo(25));
        Assert.That(_temperatureManager.GetState(), Is.EqualTo(TEMPSTATE.IDLE));
    }
}