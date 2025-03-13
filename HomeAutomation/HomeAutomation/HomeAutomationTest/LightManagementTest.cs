using HomeAutomation.Components;
using HomeAutomation.ENUM;

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
}