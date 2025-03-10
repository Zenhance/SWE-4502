using HomeAutomate.Core;
using HomeAutomate.Models;
using HomeAutomate.Components;
using HomeAutomate.Enum;

namespace HomeAutomationTest;

public class TemperatureManagementTest
{
    [SetUp]
    public void Setup()
    {
    }
    
    [Test]
    public void TemperatureManagerInitializeTest()
    {
        TemperatureManager temperatureManager = new TemperatureManager();
        Assert.That(temperatureManager.GetCurrentState(), Is.EqualTo(TEMPSTATE.IDLE));
        Assert.That(temperatureManager.GetCurrentTemperatureGoal(), Is.EqualTo(25));
    }
    
    [Test]
    public void TemperatureManagerUpdateTestForHeating()
    {
        TemperatureManager temperatureManager = new TemperatureManager();
        temperatureManager.update(SENSOR.TEMPERATURE, new Command(10));
        Assert.That(temperatureManager.GetCurrentState(), Is.EqualTo(TEMPSTATE.HEATING));
        Assert.That(temperatureManager.GetCurrentTemperatureGoal(), Is.EqualTo(25));
    }
    
    [Test]
    public void TemperatureManagerUpdateTestForCooling()
    {
        TemperatureManager temperatureManager = new TemperatureManager();
        temperatureManager.update(SENSOR.TEMPERATURE, new Command(35));
        Assert.That(temperatureManager.GetCurrentState(), Is.EqualTo(TEMPSTATE.COOLING));
        Assert.That(temperatureManager.GetCurrentTemperatureGoal(), Is.EqualTo(20));
    }
    
    [Test]
    public void TemperatureManagerUpdateTestForIdle()
    {
        TemperatureManager temperatureManager = new TemperatureManager();
        temperatureManager.update(SENSOR.TEMPERATURE, new Command(25));
        Assert.That(temperatureManager.GetCurrentState(), Is.EqualTo(TEMPSTATE.IDLE));
        Assert.That(temperatureManager.GetCurrentTemperatureGoal(), Is.EqualTo(22));
    }
}