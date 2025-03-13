using HomeAutomation.Components;
using HomeAutomation.Core;

namespace HomeAutomationTest;

public class VoiceCommandManagerTest
{
    [SetUp]
    public void Setup()
    {
    }

    [Test]
    public void TestVoiceCommandInitiate()
    {
        EnvironmentState environmentState = new EnvironmentState();
        VoiceCommandManager voiceCommandManager = new VoiceCommandManager(environmentState);
        
        Assert.That(voiceCommandManager.getEnvironment(), Is.EqualTo(environmentState));
    }
}