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
    
    
    [Test]
    public void SetTemperatureCoolingTest()
    {
        Command command = new Command(40);
        _environment.SetTemperature(command);
        
        Assert.That(_environment.GetTemperature(), Is.EqualTo(40));
        Assert.That(_temperatureManager.GetCurrentState(), Is.EqualTo(TEMPSTATE.COOLING));
    }
    
    
    [Test]
    public void SetTemperatureHeatingTest()
    {
        Command command = new Command(9);
        _environment.SetTemperature(command);
        
        Assert.That(_environment.GetTemperature(), Is.EqualTo(9));
        Assert.That(_temperatureManager.GetCurrentState(), Is.EqualTo(TEMPSTATE.HEATING));
    }
    
    
    [Test]
    public void SetTemperatureNormalTest()
    {
        Command command = new Command(20);
        _environment.SetTemperature(command);
        
        Assert.That(_environment.GetTemperature(), Is.EqualTo(20));
        Assert.That(_temperatureManager.GetCurrentState(), Is.EqualTo(TEMPSTATE.IDLE));
    }
    
    
    [Test]
    public void SetMotionLevelSuspiciousTest()
    {
        Command command = new Command(0.6f);
        _environment.SetMotionLevel(command);
        
        Assert.That(_environment.GetMotionLevel(), Is.EqualTo(0.6f));
        Assert.That(_motionDetector.overall(), Is.EqualTo(MOTIONBEHAVIOR.SUSPICIOUSBEHAVIOR));
    }
    
    
    
    [Test]
    public void SetMotionLevelNormalTest()
    {
        Command command = new Command(0.4f);
        _environment.SetMotionLevel(command);
        
        Assert.That(_environment.GetMotionLevel(), Is.EqualTo(0.4f));
        Assert.That(_motionDetector.overall(), Is.EqualTo(MOTIONBEHAVIOR.NORMALBEHAVIOR));
    }
    
    
    
    [Test]
    public void SetAmbientLightLevelNightTest()
    {
        Command command = new Command(0.01f);
        _environment.SetAmbientLightLevel(command);
        
        Assert.That(_environment.GetAmbientLightLevel(), Is.EqualTo(0.01f));
        Assert.That(_lightManager.getCurrentMode(), Is.EqualTo(LIGHTMODE.NIGHT));
    }
    
    
    [Test]
    public void SetAmbientLightLevelMovieTest()
    {
        Command command = new Command(0.1f);
        _environment.SetAmbientLightLevel(command);
        
        Assert.That(_environment.GetAmbientLightLevel(), Is.EqualTo(0.1f));
        Assert.That(_lightManager.getCurrentMode(), Is.EqualTo(LIGHTMODE.MOVIE));
    }
    
    
    [Test]
    public void SetAmbientLightLevelReadingTest()
    {
        Command command = new Command(0.4f);
        _environment.SetAmbientLightLevel(command);
        
        Assert.That(_environment.GetAmbientLightLevel(), Is.EqualTo(0.4f));
        Assert.That(_lightManager.getCurrentMode(), Is.EqualTo(LIGHTMODE.READING));
    }
    
    
    [Test]
    public void SetAmbientLightLevelPartyTest()
    {
        Command command = new Command(0.6f);
        _environment.SetAmbientLightLevel(command);
        
        Assert.That(_environment.GetAmbientLightLevel(), Is.EqualTo(0.6f));
        Assert.That(_lightManager.getCurrentMode(), Is.EqualTo(LIGHTMODE.PARTY));
    }
    
    
    [Test]
    public void SetAmbientLightLevelDaylightTest()
    {
        Command command = new Command(0.8f);
        _environment.SetAmbientLightLevel(command);
        
        Assert.That(_environment.GetAmbientLightLevel(), Is.EqualTo(0.8f));
        Assert.That(_lightManager.getCurrentMode(), Is.EqualTo(LIGHTMODE.DAYLIGHT));
    }
    
    
    [Test]
    public void SetEnergyConsumptionUnusualTest()
    {
        Command command = new Command(150);
        _environment.SetEnergyConsumption(command);
        
        Assert.That(_environment.GetEnergyConsumption(), Is.EqualTo(150));
        Assert.That(_energyManager.getConsumptionPattern(), Is.EqualTo(CONSUMPTIONPATTERN.UNUSUAL));
    }
    
    
    [Test]
    public void SetEnergyConsumptionUsualTest()
    {
        Command command = new Command(100);
        _environment.SetEnergyConsumption(command);
        
        Assert.That(_environment.GetEnergyConsumption(), Is.EqualTo(100));
        Assert.That(_energyManager.getConsumptionPattern(), Is.EqualTo(CONSUMPTIONPATTERN.USUAL));
    }
    
    
    [Test]
    public void SetVoiceCommandOnEnergyTest()
    {
        Command command = new Command("energy value 127 kWh");
        _environment.SetVoiceCommand(command);
        
        Assert.That(_environment.GetLastVoiceCommand(), Is.EqualTo("energy value 127 kWh"));
        Assert.That(_energyManager.getConsumptionPattern(), Is.EqualTo(CONSUMPTIONPATTERN.USUAL));
    }
    
    
    [Test]
    public void SetVoiceCommandOnTemperatureTest()
    {
        Command command = new Command("temperature value 5 degrees");
        _environment.SetVoiceCommand(command);
        
        Assert.That(_environment.GetLastVoiceCommand(), Is.EqualTo("temperature value 5 degrees"));
        Assert.That(_temperatureManager.GetCurrentState(), Is.EqualTo(TEMPSTATE.HEATING));
    }
    
    
    [Test]
    public void SetVoiceCommandOnMotionTest()
    {
        Command command = new Command("motion value 0.6 level");
        _environment.SetVoiceCommand(command);
        
        Assert.That(_environment.GetLastVoiceCommand(), Is.EqualTo("motion value 0.6 level"));
        Assert.That(_motionDetector.overall(), Is.EqualTo(MOTIONBEHAVIOR.SUSPICIOUSBEHAVIOR));
    }
    
    
    [Test]
    public void SetVoiceCommandOnLightTest()
    {
        Command command = new Command("light value 0.6 level");
        _environment.SetVoiceCommand(command);
        
        Assert.That(_environment.GetLastVoiceCommand(), Is.EqualTo("light value 0.6 level"));
        Assert.That(_lightManager.getCurrentMode(), Is.EqualTo(LIGHTMODE.PARTY));
    }
}