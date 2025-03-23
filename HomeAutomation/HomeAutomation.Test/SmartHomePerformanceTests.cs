using HomeAutomation.Observables;
using HomeAutomation.Observers;
using Moq;

public class SmartHomePerformanceTests
{
    [Fact]
    public void NotifyObservers_ShouldScaleWithManyObservers()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var observers = new List<Mock<IObserver>>();
        
        // Add 100 observers
        for (int i = 0; i < 100; i++)
        {
            var mockObserver = new Mock<IObserver>();
            observers.Add(mockObserver);
            homeEnvironment.RegisterObserver(mockObserver.Object);
        }
        
        // Act
        var stopwatch = System.Diagnostics.Stopwatch.StartNew();
        homeEnvironment.SetTemperature(22);
        stopwatch.Stop();
        
        // Assert
        // This is more of a benchmark than a true assertion
        // In a real test, you might compare to a baseline or set a maximum time
        Assert.True(stopwatch.ElapsedMilliseconds < 1000, $"Notification took {stopwatch.ElapsedMilliseconds}ms, which is too slow");
        
        // Verify all observers were called
        foreach (var observer in observers)
        {
            observer.Verify(o => o.Update(It.IsAny<HomeEnvironmentData>()), Times.Once);
        }
    }
}