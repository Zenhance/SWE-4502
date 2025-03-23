using HomeAutomation.Observables;
using HomeAutomation.Observers;
using Moq;

public class CoreObserverPatternTests
{
    [Fact]
    public void RegisterObserver_ShouldAddObserverToList()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var mockObserver = new Mock<IObserver>();
        
        // Act
        homeEnvironment.RegisterObserver(mockObserver.Object);
        homeEnvironment.SetTemperature(25);
        
        // Assert
        mockObserver.Verify(o => o.Update(It.IsAny<HomeEnvironmentData>()), Times.Once);
    }
    
    [Fact]
    public void RemoveObserver_ShouldRemoveObserverFromList()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var mockObserver = new Mock<IObserver>();
        homeEnvironment.RegisterObserver(mockObserver.Object);
        
        // Initial verification
        homeEnvironment.SetTemperature(25);
        mockObserver.Verify(o => o.Update(It.IsAny<HomeEnvironmentData>()), Times.Once);
        
        // Act
        homeEnvironment.RemoveObserver(mockObserver.Object);
        homeEnvironment.SetTemperature(30);
        
        // Assert - still only called once (not twice)
        mockObserver.Verify(o => o.Update(It.IsAny<HomeEnvironmentData>()), Times.Once);
    }
    
    [Fact]
    public void NotifyObservers_ShouldNotifyAllRegisteredObservers()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var mockObserver1 = new Mock<IObserver>();
        var mockObserver2 = new Mock<IObserver>();
        var mockObserver3 = new Mock<IObserver>();
        
        homeEnvironment.RegisterObserver(mockObserver1.Object);
        homeEnvironment.RegisterObserver(mockObserver2.Object);
        homeEnvironment.RegisterObserver(mockObserver3.Object);
        
        // Act
        homeEnvironment.SetMotionDetected(true, "Living Room");
        
        // Assert
        mockObserver1.Verify(o => o.Update(It.IsAny<HomeEnvironmentData>()), Times.Once);
        mockObserver2.Verify(o => o.Update(It.IsAny<HomeEnvironmentData>()), Times.Once);
        mockObserver3.Verify(o => o.Update(It.IsAny<HomeEnvironmentData>()), Times.Once);
    }
    
    [Fact]
    public void EnvironmentData_ShouldBeClonedForObservers()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        HomeEnvironmentData capturedData = null;
        
        var mockObserver = new Mock<IObserver>();
        mockObserver.Setup(o => o.Update(It.IsAny<HomeEnvironmentData>()))
            .Callback<HomeEnvironmentData>(data => capturedData = data);
        
        homeEnvironment.RegisterObserver(mockObserver.Object);
        
        // Act
        homeEnvironment.SetTemperature(22.5);
        
        // Assert
        Assert.NotNull(capturedData);
        Assert.Equal(22.5, capturedData.Temperature);
        
        // Modify captured data (shouldn't affect original)
        capturedData.Temperature = 99;
        
        // Verify original data unchanged
        var currentData = homeEnvironment.GetCurrentData();
        Assert.Equal(22.5, currentData.Temperature);
    }
}