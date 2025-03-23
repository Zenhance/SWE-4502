using HomeAutomation.Observables;
using HomeAutomation.Observers;

public class EnergyMonitorTests
{
    [Fact]
    public void EnergyMonitor_ShouldTrackCurrentUsage()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var energyMonitor = new EnergyMonitor();
        homeEnvironment.RegisterObserver(energyMonitor);
        
        // Act
        homeEnvironment.SetCurrentEnergyUsage(250);
        
        // Assert
        Assert.Equal(250, energyMonitor.GetCurrentUsage());
    }
    
    [Fact]
    public void EnergyMonitor_ShouldCalculateDailyUsage()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var energyMonitor = new EnergyMonitor();
        homeEnvironment.RegisterObserver(energyMonitor);
        
        // Mock time passing with steady 100W usage for 2 hours
        var startTime = new DateTime(2025, 1, 1, 10, 0, 0);
        var endTime = startTime.AddHours(2);
        
        // Reflection to access private fields for test
        var timeHistoryField = typeof(EnergyMonitor).GetField("_timeHistory", System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Instance);
        var usageHistoryField = typeof(EnergyMonitor).GetField("_usageHistory", System.Reflection.BindingFlags.NonPublic | System.Reflection.BindingFlags.Instance);
        
        var timeHistory = new List<DateTime> { startTime, endTime };
        var usageHistory = new List<double> { 100, 100 };
        
        timeHistoryField.SetValue(energyMonitor, timeHistory);
        usageHistoryField.SetValue(energyMonitor, usageHistory);
        
        // Expected: 100W * 2 hours = 200Wh = 0.2kWh
        Assert.Equal(0.2, energyMonitor.GetDailyUsage(), 3); // precision to 3 decimal places
    }
    
    [Fact]
    public void EnergyMonitor_ShouldHandleEmptyHistory()
    {
        // Arrange
        var energyMonitor = new EnergyMonitor();
        
        // Assert
        Assert.Equal(0, energyMonitor.GetDailyUsage());
    }
}