using HomeAutomation.Components;
using HomeAutomation.ENUM;
using HomeAutomation.Models;

namespace HomeAutomationTest;

public class TemparatureManagementTest
{
    [SetUp]
    public void Setup()
    {
    }
    
    [Test]
    public void TestTemperatureManagerInitialize()
    {
        TemperatureManager temperatureManager = new TemperatureManager();
        Assert.That(temperatureManager.GetState(), Is.EqualTo(TEMPSTATE.IDLE));
        Assert.That(temperatureManager.GetTemperature(), Is.EqualTo(25));
    }
    
    [Test]
    public void TestTemperatureManagerUpdateForHeating()
    {
        TemperatureManager temperatureManager = new TemperatureManager();
        temperatureManager.update(SENSOR.TEMPERATURE, new Command(10));
        Assert.That(temperatureManager.GetState(), Is.EqualTo(TEMPSTATE.HEATING));
        Assert.That(temperatureManager.GetTemperature(), Is.EqualTo(25));
    }
    
    [Test]
    public void TestTemperatureManagerUpdateForCooling()
    {
        TemperatureManager temperatureManager = new TemperatureManager();
        temperatureManager.update(SENSOR.TEMPERATURE, new Command(35));
        Assert.That(temperatureManager.GetState(), Is.EqualTo(TEMPSTATE.COOLING));
        Assert.That(temperatureManager.GetTemperature(), Is.EqualTo(20));
    }
    
    [Test]
    public void TestTemperatureManagerUpdateForIdle()
    {
        TemperatureManager temperatureManager = new TemperatureManager();
        temperatureManager.update(SENSOR.TEMPERATURE, new Command(25));
        Assert.That(temperatureManager.GetState(), Is.EqualTo(TEMPSTATE.IDLE));
        Assert.That(temperatureManager.GetTemperature(), Is.EqualTo(22));
    }
}