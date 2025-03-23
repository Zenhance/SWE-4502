using HomeAutomation.Observables;
using HomeAutomation.Observers;
using Moq;

public class SmartHomeEdgeCaseTests
{
    [Fact]
    public void EmptyObserverList_ShouldNotCauseErrors()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        
        // Act & Assert - Should not throw
        homeEnvironment.NotifyObservers();
    }
    
    [Fact]
    public void MultipleRegistrations_ShouldOnlyRegisterOnce()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var mockObserver = new Mock<IObserver>();
        
        // Act - Register the same observer twice
        homeEnvironment.RegisterObserver(mockObserver.Object);
        homeEnvironment.RegisterObserver(mockObserver.Object);
        
        // Send notification
        homeEnvironment.SetTemperature(20);
        
        // Assert - Should only be called once
        mockObserver.Verify(o => o.Update(It.IsAny<HomeEnvironmentData>()), Times.Once);
    }
    
    [Fact]
    public void RemovingNonExistentObserver_ShouldNotCauseErrors()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var mockObserver = new Mock<IObserver>();
        
        // Act & Assert - Should not throw
        homeEnvironment.RemoveObserver(mockObserver.Object);
    }
    
    [Fact]
    public void ObserverThrowing_ShouldNotAffectOtherObservers()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        
        var throwingObserver = new Mock<IObserver>();
        throwingObserver.Setup(o => o.Update(It.IsAny<HomeEnvironmentData>()))
            .Throws(new Exception("Test exception"));
        
        var workingObserver = new Mock<IObserver>();
        
        homeEnvironment.RegisterObserver(throwingObserver.Object);
        homeEnvironment.RegisterObserver(workingObserver.Object);
        
        // Act & Assert - Should complete without unhandled exception
        try
        {
            homeEnvironment.SetTemperature(22);
            
            // The throwing observer would have thrown, but we caught it
            // The working observer should still be called
            workingObserver.Verify(o => o.Update(It.IsAny<HomeEnvironmentData>()), Times.Once);
        }
        catch (Exception)
        {
            Assert.True(false, "Exception should not propagate out of NotifyObservers");
        }
    }
}