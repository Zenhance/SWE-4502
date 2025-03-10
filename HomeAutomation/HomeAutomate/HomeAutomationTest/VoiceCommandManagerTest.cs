using HomeAutomate.Components;
using HomeAutomate.Core;
using HomeAutomate.Enum;
using HomeAutomate.Models;

namespace HomeAutomationTest;

public class VoiceCommandManagerTest
{
    [SetUp]
    public void Setup()
    {
    }

    [Test]
    public void VoiceCommandInitiateTest()
    {
        EnvironmentState environmentState = new EnvironmentState();
        VoiceCommandManager voiceCommandManager = new VoiceCommandManager(environmentState);
        
        Assert.That(voiceCommandManager.getEnvironment(), Is.EqualTo(environmentState));
    }
    

    [Test]
    public void VoiceCommandEnvironmentStateChangeTest()
    {
        EnvironmentState env = new EnvironmentState();
        VoiceCommandManager voiceCommandManager = new VoiceCommandManager(env);
        
        env.AddComponent(voiceCommandManager);
        Command command = new Command("energy value 127 kWh");
        
        env.SetVoiceCommand(command);
        
        Assert.That(env.GetEnergyConsumption(), Is.EqualTo(127));
    }
    
    [Test]
    public void VoiceCommandImpactOnTemperatureComponentTest()
    {
        EnvironmentState env = new EnvironmentState();
        VoiceCommandManager voiceCommandManager = new VoiceCommandManager(env);
        TemperatureManager temperatureManager = new TemperatureManager();
        
        env.AddComponent(voiceCommandManager);
        env.AddComponent(temperatureManager);
        Command command = new Command("temperature value 40 degrees");
        
        env.SetVoiceCommand(command);
        
        Assert.That(temperatureManager.GetCurrentState(), Is.EqualTo(TEMPSTATE.COOLING));
    }
    
    
    [Test]
    public void VoiceCommandImpactOnMotionComponentTest()
    {
        EnvironmentState env = new EnvironmentState();
        VoiceCommandManager voiceCommandManager = new VoiceCommandManager(env);
        MotionDetector motionDetector = new MotionDetector(0.5f);
        
        env.AddComponent(voiceCommandManager);
        env.AddComponent(motionDetector);
        Command command = new Command("motion value 0.6 level");
        
        env.SetVoiceCommand(command);
        
        Assert.That(motionDetector.overall(), Is.EqualTo(MOTIONBEHAVIOR.SUSPICIOUSBEHAVIOR));
    }
    
    [Test]
    public void VoiceCommandImpactOnLightComponentTest()
    {
        EnvironmentState env = new EnvironmentState();
        VoiceCommandManager voiceCommandManager = new VoiceCommandManager(env);
        LightManager lightManager = new LightManager();
        
        env.AddComponent(voiceCommandManager);
        env.AddComponent(lightManager);
        Command command = new Command("light value 0.6 level");
        
        env.SetVoiceCommand(command);
        
        Assert.That(lightManager.getCurrentMode(), Is.EqualTo(LIGHTMODE.PARTY));
    }
    
    
}