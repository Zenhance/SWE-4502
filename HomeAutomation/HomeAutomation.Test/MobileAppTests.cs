using HomeAutomation.Observables;
using HomeAutomation.Observers;

public class MobileAppTests
{
    [Fact]
    public void MobileApp_ShouldReceiveEnvironmentUpdates()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var mobileApp = new MobileApp();
        homeEnvironment.RegisterObserver(mobileApp);
        
        // Act
        homeEnvironment.SetTemperature(24.5);
        homeEnvironment.SetAmbientLightLevel(70);
        
        // Assert
        var data = mobileApp.GetCurrentData();
        Assert.Equal(24.5, data.Temperature);
        Assert.Equal(70, data.AmbientLightLevel);
    }
    
    [Fact]
    public void MobileApp_ShouldGenerateNotificationsForMotion()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var mobileApp = new MobileApp();
        homeEnvironment.RegisterObserver(mobileApp);
        
        // Act
        homeEnvironment.SetMotionDetected(true, "Front Door");
        
        // Assert
        var notifications = mobileApp.GetNotifications();
        Assert.Single(notifications);
        Assert.Contains("Motion detected in Front Door", notifications[0]);
    }
    
    [Fact]
    public void MobileApp_ShouldSendCommandsToHomeEnvironment()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var mobileApp = new MobileApp();
        homeEnvironment.RegisterObserver(mobileApp);
        
        // Act
        mobileApp.SendCommand("set temperature to 22", homeEnvironment);
        
        // Assert
        Assert.Equal("set temperature to 22", homeEnvironment.GetCurrentData().LastVoiceCommand);
        Assert.True(homeEnvironment.GetCurrentData().VoiceCommandProcessed);
    }
}