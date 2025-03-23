using HomeAutomation.Observables;
using HomeAutomation.Observers;

public class SmartThermostatTests
{
    [Fact]
    public void SmartThermostat_ShouldTurnOnHeatingWhenCold()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var thermostat = new SmartThermostat();
        homeEnvironment.RegisterObserver(thermostat);
        
        // Act - set target temperature and current temperature below target
        homeEnvironment.SetTargetTemperature(22);
        homeEnvironment.SetTemperature(19);
        
        // Assert
        Assert.True(thermostat.IsHeatingOn());
        Assert.False(thermostat.IsCoolingOn());
    }
    
    [Fact]
    public void SmartThermostat_ShouldTurnOnCoolingWhenHot()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var thermostat = new SmartThermostat();
        homeEnvironment.RegisterObserver(thermostat);
        
        // Act - set target temperature and current temperature above target
        homeEnvironment.SetTargetTemperature(22);
        homeEnvironment.SetTemperature(25);
        
        // Assert
        Assert.False(thermostat.IsHeatingOn());
        Assert.True(thermostat.IsCoolingOn());
    }
    
    [Fact]
    public void SmartThermostat_ShouldTurnOffBothWhenTemperatureIdeal()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var thermostat = new SmartThermostat();
        homeEnvironment.RegisterObserver(thermostat);
        
        // Act - set target temperature and current temperature very close to target
        homeEnvironment.SetTargetTemperature(22);
        homeEnvironment.SetTemperature(22.2);
        
        // Assert
        Assert.False(thermostat.IsHeatingOn());
        Assert.False(thermostat.IsCoolingOn());
    }
    
    [Fact]
    public void SmartThermostat_ShouldMaintainHysteresis()
    {
        // Arrange
        var homeEnvironment = new HomeEnvironment();
        var thermostat = new SmartThermostat();
        homeEnvironment.RegisterObserver(thermostat);
        
        // Act 1 - Set heating on
        homeEnvironment.SetTargetTemperature(22);
        homeEnvironment.SetTemperature(20);
        
        // Assert 1
        Assert.True(thermostat.IsHeatingOn());
        
        // Act 2 - Set temperature a bit warmer but still below target
        homeEnvironment.SetTemperature(21.5);
        
        // Assert 2 - Heating should stay on until we get closer to target
        Assert.True(thermostat.IsHeatingOn());
        
        // Act 3 - Set temperature very close to target
        homeEnvironment.SetTemperature(21.9);
        
        // Assert 3 - Heating should turn off when we're close enough
        Assert.False(thermostat.IsHeatingOn());
    }
}