using HomeAutomation.Observables;
using HomeAutomation.Observers;

public class SmartLightingTests
{
    [Fact]
    public void SmartLighting_ShouldAdjustBasedOnAmbientLight()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var smartLighting = new SmartLighting();
        homeEnvironment.RegisterObserver(smartLighting);
        
        // Act - set room as occupied with high ambient light (bright day)
        homeEnvironment.SetRoomOccupancy(true);
        homeEnvironment.SetAmbientLightLevel(80);
        
        // Assert - brightness should be low because room is already bright
        Assert.Equal(20, smartLighting.GetCurrentBrightness());
        
        // Act - now set low ambient light (dark room)
        homeEnvironment.SetAmbientLightLevel(10);
        
        // Assert - brightness should be high because room is dark
        Assert.Equal(90, smartLighting.GetCurrentBrightness());
    }
    
    [Fact]
    public void SmartLighting_ShouldTurnOffWhenRoomEmpty()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var smartLighting = new SmartLighting();
        homeEnvironment.RegisterObserver(smartLighting);
        
        // Act - first set room as occupied with medium ambient light
        homeEnvironment.SetRoomOccupancy(true);
        homeEnvironment.SetAmbientLightLevel(50);
        
        // Verify lights are on at expected brightness
        Assert.Equal(50, smartLighting.GetCurrentBrightness());
        
        // Act - now set room as unoccupied
        homeEnvironment.SetRoomOccupancy(false);
        
        // Assert - lights should turn off
        Assert.Equal(0, smartLighting.GetCurrentBrightness());
    }
    
    [Fact]
    public void SmartLighting_ShouldSetSceneCorrectly()
    {
        // Arrange
        var smartLighting = new SmartLighting();
        
        // Act & Assert for different scenes
        smartLighting.SetScene("reading");
        Assert.Equal(80, smartLighting.GetCurrentBrightness());
        
        smartLighting.SetScene("movie");
        Assert.Equal(20, smartLighting.GetCurrentBrightness());
        
        smartLighting.SetScene("evening");
        Assert.Equal(40, smartLighting.GetCurrentBrightness());
        
        // Unknown scene should default to standard brightness
        smartLighting.SetScene("unknown");
        Assert.Equal(60, smartLighting.GetCurrentBrightness());
    }
}