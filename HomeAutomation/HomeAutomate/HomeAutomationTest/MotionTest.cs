using HomeAutomate.Core;
using HomeAutomate.Models;
using HomeAutomate.Components;
using HomeAutomate.Executor;
using HomeAutomate.Enum;

namespace HomeAutomationTest;

public class MotionTest
{
    [SetUp]
    public void Setup()
    {
    }

    [Test]
    public void setMotionLevelSuspiciousTest()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.addComponent(motionDetector);
        environmentState.setMotionLevel(new Command(0.6f));
        MOTIONBEHAVIOR motionBehavior = motionDetector.overall();
        Assert.AreEqual(motionBehavior, MOTIONBEHAVIOR.SUSPICIOUSBEHAVIOR);
    }
    
    [Test]
    public void setMotionLevelNormalTest()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.addComponent(motionDetector);
        environmentState.setMotionLevel(new Command(0.4f));
        MOTIONBEHAVIOR motionBehavior = motionDetector.overall();
        Assert.AreEqual(motionBehavior, MOTIONBEHAVIOR.NORMALBEHAVIOR);
    }
    
    [Test]
    public void setMotionLevelMultipleSuspiciousTest()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.addComponent(motionDetector);
        environmentState.setMotionLevel(new Command(0.6f));
        environmentState.setMotionLevel(new Command(0.6f));
        environmentState.setMotionLevel(new Command(0.4f));
        MOTIONBEHAVIOR motionBehavior = motionDetector.overall();
        Assert.AreEqual(motionBehavior, MOTIONBEHAVIOR.SUSPICIOUSBEHAVIOR);
    }
    
    [Test]
    public void setMotionLevelMultipleNormalTest()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.addComponent(motionDetector);
        environmentState.setMotionLevel(new Command(0.4f));
        environmentState.setMotionLevel(new Command(0.4f));
        environmentState.setMotionLevel(new Command(0.6f));
        
        MOTIONBEHAVIOR motionBehavior = motionDetector.overall();
        Assert.AreEqual(motionBehavior, MOTIONBEHAVIOR.NORMALBEHAVIOR);
    }

    [Test]
    public void setMotionLevelSuspiciousCountTest()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.addComponent(motionDetector);
        environmentState.setMotionLevel(new Command(0.6f));
        environmentState.setMotionLevel(new Command(0.4f));
        environmentState.setMotionLevel(new Command(0.6f));
        
        int suspiciousCount = motionDetector.suspiciousCount();
        Assert.That(2, Is.EqualTo(suspiciousCount));
    }
    
    
    [Test]
    public void setMotionLevelNormalCountTest()
    {
        MotionDetector motionDetector = new MotionDetector(0.5f);
        EnvironmentState environmentState = new EnvironmentState();
        environmentState.addComponent(motionDetector);
        environmentState.setMotionLevel(new Command(0.6f));
        environmentState.setMotionLevel(new Command(0.4f));
        environmentState.setMotionLevel(new Command(0.4f));
        environmentState.setMotionLevel(new Command(0.3f));
        
        int normalCount = motionDetector.normalCount();
        Assert.That(3, Is.EqualTo(normalCount));
    }
    
    
}