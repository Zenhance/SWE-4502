using HomeAutomation.Observables;
using HomeAutomation.Observers;

public class VoiceControlTests
{
    [Fact]
    public void VoiceControl_ShouldProcessLightCommands()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var voiceControl = new VoiceControl();
        homeEnvironment.RegisterObserver(voiceControl);
        
        // Act
        bool result = voiceControl.ProcessCommand("turn on the lights", homeEnvironment);
        
        // Assert
        Assert.True(result);
        var data = homeEnvironment.GetCurrentData();
        Assert.True(data.RoomOccupied);
        Assert.Equal(50, data.AmbientLightLevel);
    }
    
    [Fact]
    public void VoiceControl_ShouldProcessTemperatureCommands()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var voiceControl = new VoiceControl();
        homeEnvironment.RegisterObserver(voiceControl);
        
        // Act
        bool result = voiceControl.ProcessCommand("set temperature to 23", homeEnvironment);
        
        // Assert
        Assert.True(result);
        var data = homeEnvironment.GetCurrentData();
        Assert.Equal(23, data.TargetTemperature);
    }
    
    [Fact]
    public void VoiceControl_ShouldReturnFalseForUnrecognizedCommands()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var voiceControl = new VoiceControl();
        homeEnvironment.RegisterObserver(voiceControl);
        
        // Act
        bool result = voiceControl.ProcessCommand("do something impossible", homeEnvironment);
        
        // Assert
        Assert.False(result);
    }
    
    [Fact]
    public void VoiceControl_ShouldReceiveProcessedCommands()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var voiceControl = new VoiceControl();
        homeEnvironment.RegisterObserver(voiceControl);
        
        // Act
        homeEnvironment.ProcessVoiceCommand("turn on the lights");
        
        // Assert
        Assert.Equal("turn on the lights", voiceControl.GetLastCommand());
        Assert.Contains("turn on the lights", voiceControl.GetCommandHistory());
    }
}