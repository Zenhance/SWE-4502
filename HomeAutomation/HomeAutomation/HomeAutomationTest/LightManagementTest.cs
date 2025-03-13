using HomeAutomate.Core;
using HomeAutomate.Models;
using HomeAutomate.Components;
using HomeAutomate.Enum;

namespace HomeAutomationTest;

public class LightManagementTest
{
    [SetUp]
    public void Setup()
    {
    }

    [Test]
    public void LightModeInitialTest()
    {
        LightManager lightManager = new LightManager();
        LIGHTMODE lightMode = lightManager.getCurrentMode();
        
        Assert.That(lightMode, Is.EqualTo(LIGHTMODE.DAYLIGHT));
    }
    
    
    [Test]
    public void LightLevelInitialTest()
    {
        LightManager lightManager = new LightManager();
        float lightLevel = lightManager.getCurrentLightLevel();
        
        Assert.That(lightLevel, Is.EqualTo(1.0f));
    }
    
    
    [Test]
    public void LightModeUpdateTestForNight()
    {
        LightManager lightManager = new LightManager();
        Command command = new Command(0.05f);
        lightManager.update(SENSOR.LIGHT, command);
        LIGHTMODE lightMode = lightManager.getCurrentMode();
        
        Assert.That(lightMode, Is.EqualTo(LIGHTMODE.NIGHT));
    }
    
    [Test]
    public void LightModeUpdateTestForMovie()
    {
        LightManager lightManager = new LightManager();
        Command command = new Command(0.2f);
        lightManager.update(SENSOR.LIGHT, command);
        LIGHTMODE lightMode = lightManager.getCurrentMode();
        
        Assert.That(lightMode, Is.EqualTo(LIGHTMODE.MOVIE));
    }
    
    
    [Test]
    public void LightModeUpdateTestForReading()
    {
        LightManager lightManager = new LightManager();
        Command command = new Command(0.4f);
        lightManager.update(SENSOR.LIGHT, command);
        LIGHTMODE lightMode = lightManager.getCurrentMode();
        
        Assert.That(lightMode, Is.EqualTo(LIGHTMODE.READING));
    }
    
    [Test]
    public void LightModeUpdateTestForParty()
    {
        LightManager lightManager = new LightManager();
        Command command = new Command(0.6f);
        lightManager.update(SENSOR.LIGHT, command);
        LIGHTMODE lightMode = lightManager.getCurrentMode();
        
        Assert.That(lightMode, Is.EqualTo(LIGHTMODE.PARTY));
    }
    
    
    [Test]
    public void LightModeUpdateTestForDaylight()
    {
        LightManager lightManager = new LightManager();
        Command command = new Command(0.8f);
        lightManager.update(SENSOR.LIGHT, command);
        LIGHTMODE lightMode = lightManager.getCurrentMode();
        
        Assert.That(lightMode, Is.EqualTo(LIGHTMODE.DAYLIGHT));
    }
    
    
    [Test]
    public void LightLevelUpdateTestFor0()
    {
        LightManager lightManager = new LightManager();
        Command command = new Command(0.05f);
        lightManager.update(SENSOR.MOTION, command);
        float lightLevel = lightManager.getCurrentLightLevel();
        
        Assert.That(lightLevel, Is.EqualTo(0.0f));
    }
    
    [Test]
    public void LightLevelUpdateTestFor0_3()
    {
        LightManager lightManager = new LightManager();
        Command command = new Command(0.2f);
        lightManager.update(SENSOR.MOTION, command);
        float lightLevel = lightManager.getCurrentLightLevel();
        
        Assert.That(lightLevel, Is.EqualTo(0.3f));
    }
    
    
    [Test]
    public void LightLevelUpdateTestFor0_5()
    {
        LightManager lightManager = new LightManager();
        Command command = new Command(0.4f);
        lightManager.update(SENSOR.MOTION, command);
        float lightLevel = lightManager.getCurrentLightLevel();
        
        Assert.That(lightLevel, Is.EqualTo(0.5f));
    }
    
    [Test]
    public void LightLevelUpdateTestFor0_7()
    {
        LightManager lightManager = new LightManager();
        Command command = new Command(0.6f);
        lightManager.update(SENSOR.MOTION, command);
        float lightLevel = lightManager.getCurrentLightLevel();
        
        Assert.That(lightLevel, Is.EqualTo(0.7f));
    }
    
    
    [Test]
    public void LightLevelUpdateTestFor1()
    {
        LightManager lightManager = new LightManager();
        Command command = new Command(0.8f);
        lightManager.update(SENSOR.MOTION, command);
        float lightLevel = lightManager.getCurrentLightLevel();
        
        Assert.That(lightLevel, Is.EqualTo(1.0f));
    }
}