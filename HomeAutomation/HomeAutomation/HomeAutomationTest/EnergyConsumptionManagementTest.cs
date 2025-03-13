using HomeAutomation.Components;

namespace HomeAutomationTest;

public class EnergyConsumptionManagementTest
{
    [SetUp]
    public void Setup()
    {
    }
    
    [Test]
    public void TestEnergyConsumptionManagerInitialize()
    {
        EnergyConsumptionManager energyConsumptionManager = new EnergyConsumptionManager(130);
        
        Assert.That(energyConsumptionManager.getThreshold(), Is.EqualTo(130));
    }
}