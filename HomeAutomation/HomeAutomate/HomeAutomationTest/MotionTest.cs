using HomeAutomate.Core;
using HomeAutomate.Models;
using HomeAutomate.Components;
using HomeAutomate.Enum;

namespace HomeAutomationTest;

public class MotionTest
{
    [SetUp]
    public void Setup()
    {
    }

    [Test]
    public void SetMotionLevelSuspiciousTest()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.AddComponent(motionDetector);
        environmentState.SetMotionLevel(new Command(0.6f));
        MOTIONBEHAVIOR motionBehavior = motionDetector.overall();
        Assert.That(motionBehavior, Is.EqualTo(MOTIONBEHAVIOR.SUSPICIOUSBEHAVIOR));
    }
    
    [Test]
    public void SetMotionLevelNormalTest()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.AddComponent(motionDetector);
        environmentState.SetMotionLevel(new Command(0.4f));
        MOTIONBEHAVIOR motionBehavior = motionDetector.overall();
        Assert.That(motionBehavior, Is.EqualTo(MOTIONBEHAVIOR.NORMALBEHAVIOR));
    }
    
    [Test]
    public void SetMotionLevelMultipleSuspiciousTest()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.AddComponent(motionDetector);
        environmentState.SetMotionLevel(new Command(0.6f));
        environmentState.SetMotionLevel(new Command(0.6f));
        environmentState.SetMotionLevel(new Command(0.4f));
        MOTIONBEHAVIOR motionBehavior = motionDetector.overall();
        Assert.That(motionBehavior, Is.EqualTo(MOTIONBEHAVIOR.SUSPICIOUSBEHAVIOR));
    }
    
    [Test]
    public void SetMotionLevelMultipleNormalTest()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.AddComponent(motionDetector);
        environmentState.SetMotionLevel(new Command(0.4f));
        environmentState.SetMotionLevel(new Command(0.4f));
        environmentState.SetMotionLevel(new Command(0.6f));
        
        MOTIONBEHAVIOR motionBehavior = motionDetector.overall();
        Assert.That(motionBehavior, Is.EqualTo(MOTIONBEHAVIOR.NORMALBEHAVIOR));
    }

    [Test]
    public void SetMotionLevelSuspiciousCountTest()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.AddComponent(motionDetector);
        environmentState.SetMotionLevel(new Command(0.6f));
        environmentState.SetMotionLevel(new Command(0.4f));
        environmentState.SetMotionLevel(new Command(0.6f));
        
        int suspiciousCount = motionDetector.suspiciousCount();
        Assert.That(suspiciousCount, Is.EqualTo(2));
    }
    
    
    [Test]
    public void SetMotionLevelNormalCountTest()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.AddComponent(motionDetector);
        environmentState.SetMotionLevel(new Command(0.6f));
        environmentState.SetMotionLevel(new Command(0.4f));
        environmentState.SetMotionLevel(new Command(0.4f));
        environmentState.SetMotionLevel(new Command(0.3f));
        
        int normalCount = motionDetector.normalCount();
        Assert.That(normalCount, Is.EqualTo(3));
    }
    
    
}