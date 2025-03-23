using HomeAutomation.Observables;
using HomeAutomation.Observers;

// Issue #1: Core Observer Pattern Framework Tests

// Issue #2: Motion Detection Tests
public class SecuritySystemTests
{
    [Fact]
    public void SecuritySystem_ShouldReceiveMotionUpdates()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var securitySystem = new SecuritySystem();
        homeEnvironment.RegisterObserver(securitySystem);
        
        // Act
        homeEnvironment.SetMotionDetected(true, "Kitchen");
        
        // Assert
        Assert.True(securitySystem.IsMotionDetected());
        Assert.Equal("Kitchen", securitySystem.GetMotionLocation());
    }
    
    [Fact]
    public void SecuritySystem_ShouldLogActivity()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var securitySystem = new SecuritySystem();
        homeEnvironment.RegisterObserver(securitySystem);
        
        // Act
        homeEnvironment.SetMotionDetected(true, "Bedroom");
        
        // Assert
        var log = securitySystem.GetActivityLog();
        Assert.Single(log);
        Assert.Contains("Motion detected in Bedroom", log[0]);
    }
    
    [Fact]
    public void SecuritySystem_ShouldTrackMotionTimestamp()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var securitySystem = new SecuritySystem();
        homeEnvironment.RegisterObserver(securitySystem);
        
        // Get time just before setting motion
        var beforeTime = DateTime.Now;
        
        // Act
        homeEnvironment.SetMotionDetected(true, "Hallway");
        
        // Get time just after setting motion
        var afterTime = DateTime.Now;
        
        // Assert
        var motionTime = securitySystem.GetLastMotionTime();
        Assert.True(motionTime >= beforeTime && motionTime <= afterTime);
    }
}

// Issue #3: Light Management Tests

// Issue #4: Temperature Control Tests

// Issue #5: Energy Consumption Tracking Tests

// Issue #6: Voice Command System Tests

// Issue #7: Remote Access App Tests

// Integration Tests - Testing how multiple components work together

// Edge Cases and Error Handling Tests