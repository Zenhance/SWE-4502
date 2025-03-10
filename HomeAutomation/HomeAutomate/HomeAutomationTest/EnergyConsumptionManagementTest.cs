using HomeAutomate.Models;
using HomeAutomate.Components;
using HomeAutomate.Enum;

namespace HomeAutomationTest;

public class EnergyConsumptionManagementTest
{
    [SetUp]
    public void Setup()
    {
    }
    
    [Test]
    public void EnergyConsumptionManagerInitializeTest()
    {
        EnergyConsumptionManager energyConsumptionManager = new EnergyConsumptionManager(130);
        
        Assert.That(energyConsumptionManager.getThreshold(), Is.EqualTo(130));
    }


    [Test]
    public void EnergyConsumptionUpdateTest()
    {
        EnergyConsumptionManager energyConsumptionManager = new EnergyConsumptionManager(130);
        
        energyConsumptionManager.update(SENSOR.ENERGY, new Command(150));
        PowerConsumptionData powerConsumptionData = energyConsumptionManager.getLatestData();
        
        Assert.That(powerConsumptionData.getConsumption(), Is.EqualTo(150));
    }

    [Test]
    public void EnergyConsumptionPatternTestUsual()
    {
        EnergyConsumptionManager energyConsumptionManager = new EnergyConsumptionManager(130);
        
        energyConsumptionManager.update(SENSOR.ENERGY, new Command(128));
        energyConsumptionManager.update(SENSOR.ENERGY, new Command(129));
        energyConsumptionManager.update(SENSOR.ENERGY, new Command(127));
        energyConsumptionManager.update(SENSOR.ENERGY, new Command(120));
        
        CONSUMPTIONPATTERN consumptionPattern = energyConsumptionManager.getConsumptionPattern();
        
        Assert.That(consumptionPattern, Is.EqualTo(CONSUMPTIONPATTERN.USUAL));
    }
    
    
    [Test]
    public void EnergyConsumptionPatternTestUnusual()
    {
        EnergyConsumptionManager energyConsumptionManager = new EnergyConsumptionManager(130);
        
        energyConsumptionManager.update(SENSOR.ENERGY, new Command(129));
        energyConsumptionManager.update(SENSOR.ENERGY, new Command(132));
        energyConsumptionManager.update(SENSOR.ENERGY, new Command(128));
        energyConsumptionManager.update(SENSOR.ENERGY, new Command(126));
        
        CONSUMPTIONPATTERN consumptionPattern = energyConsumptionManager.getConsumptionPattern();
        
        Assert.That(consumptionPattern, Is.EqualTo(CONSUMPTIONPATTERN.UNUSUAL));
    }
}