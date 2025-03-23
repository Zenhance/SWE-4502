using HomeAutomation.Observables;
using HomeAutomation.Observers;

public class SmartHomeIntegrationTests
{
    [Fact]
    public void MotionDetection_ShouldTriggerLightsAndNotifications()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var securitySystem = new SecuritySystem();
        var smartLighting = new SmartLighting();
        var mobileApp = new MobileApp();
        
        homeEnvironment.RegisterObserver(securitySystem);
        homeEnvironment.RegisterObserver(smartLighting);
        homeEnvironment.RegisterObserver(mobileApp);
        
        // First set room as unoccupied and dark
        homeEnvironment.SetRoomOccupancy(false);
        homeEnvironment.SetAmbientLightLevel(10);
        
        // Verify initial state
        Assert.Equal(0, smartLighting.GetCurrentBrightness()); // Lights off
        
        // Act - Detect motion
        homeEnvironment.SetMotionDetected(true, "Living Room");
        homeEnvironment.SetRoomOccupancy(true);
        
        // Assert
        Assert.True(securitySystem.IsMotionDetected());
        Assert.NotEqual(0, smartLighting.GetCurrentBrightness()); // Lights should be on
        
        var notifications = mobileApp.GetNotifications();
        Assert.Contains(notifications, n => n.Contains("Motion detected"));
    }
    
    [Fact]
    public void VoiceCommand_ShouldAffectMultipleComponents()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var smartThermostat = new SmartThermostat();
        var voiceControl = new VoiceControl();
        var mobileApp = new MobileApp();
        
        homeEnvironment.RegisterObserver(smartThermostat);
        homeEnvironment.RegisterObserver(voiceControl);
        homeEnvironment.RegisterObserver(mobileApp);
        
        // Act - Process voice command
        voiceControl.ProcessCommand("set temperature to 25", homeEnvironment);
        
        // Assert
        Assert.Equal(25, smartThermostat.GetTargetTemperature());
        Assert.Equal("set temperature to 25", voiceControl.GetLastCommand());
        Assert.Equal(25, mobileApp.GetCurrentData().TargetTemperature);
    }
    
    [Fact]
    public void RemovalOfObserver_ShouldStopUpdates()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var securitySystem = new SecuritySystem();
        
        homeEnvironment.RegisterObserver(securitySystem);
        
        // Verify initial registration works
        homeEnvironment.SetMotionDetected(true, "Kitchen");
        Assert.True(securitySystem.IsMotionDetected());
        Assert.Equal("Kitchen", securitySystem.GetMotionLocation());
        
        // Act - Remove observer and send new updates
        homeEnvironment.RemoveObserver(securitySystem);
        homeEnvironment.SetMotionDetected(true, "Bedroom");
        
        // Assert - Should still have old data
        Assert.Equal("Kitchen", securitySystem.GetMotionLocation());
    }
}