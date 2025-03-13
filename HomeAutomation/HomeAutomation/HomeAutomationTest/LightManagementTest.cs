using HomeAutomation.Components;
using HomeAutomation.ENUM;
using HomeAutomation.Models;

namespace HomeAutomationTest;

public class LightManagementTest
{
    [SetUp]
    public void Setup()
    {
    }
    
    [Test]
    public void TestLightModeInitialization()
    {
        LightManager lightManagement = new LightManager();
        LIGHTMODE lightmode = lightManagement.GetCurrentMode();
        
        Assert.That(lightmode, Is.EqualTo(LIGHTMODE.DAYLIGHT));
    }
    [Test]
    public void TestLightLevelInitialization()
    {
        LightManager lightManagement = new LightManager();
        float lightLevel = lightManagement.GetCurrentLightLevel();
        
        Assert.That(lightLevel, Is.EqualTo(1.0f));
    }
    
    [Test]
    public void TestLightModeUpdateForParty()
    {
        LightManager lightManagement = new LightManager();
        Command command = new Command(0.6f);
        lightManagement.update(SENSOR.LIGHT, command);
        LIGHTMODE lightmode = lightManagement.GetCurrentMode();
        
        Assert.That(lightmode, Is.EqualTo(LIGHTMODE.PARTY));
    }
    
    [Test]
    public void TestLightModeUpdateForNight()
    {
        LightManager lightManagement = new LightManager();
        Command command = new Command(0.05f);
        lightManagement.update(SENSOR.LIGHT, command);
        LIGHTMODE lightmode = lightManagement.GetCurrentMode();
        
        Assert.That(lightmode, Is.EqualTo(LIGHTMODE.NIGHT));
    }

    [Test]
    public void TestLightLevelUpdateForMovie()
    {
        LightManager lightManagement = new LightManager();
        Command command = new Command(0.2f);
        lightManagement.update(SENSOR.LIGHT, command);
        LIGHTMODE lightmode = lightManagement.GetCurrentMode();
        Assert.That(lightmode, Is.EqualTo(LIGHTMODE.MOVIE));
    }
}