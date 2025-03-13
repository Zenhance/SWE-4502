using HomeAutomation.Core;
using HomeAutomation.Executor;
using HomeAutomation.Factory;
using HomeAutomation.Models;

namespace HomeAutomationTest;

public class ExecutorFactoryTest
{
    [SetUp]
    public void Setup()
    {
    }
    
    
    [Test]
    public void TestExecutorFactoryTemperatureObjectSet()
    {
        EnvironmentState environment = new EnvironmentState();

        Command cmd = new Command("temperature value 37 degree");
        
        StateChangeExecutor sce = ExecutorFactory.getExecutor(cmd, environment);
        
        Assert.That(sce, Is.InstanceOf<TemperatureStateChangeExecutor>());
    }
    
    [Test]
    public void TestExecutorFactoryAmbientLightLevelObjectSet()
    {
        EnvironmentState environment = new EnvironmentState();

        Command cmd = new Command("ambientlightlevel value 0.6 lux");
        
        StateChangeExecutor sce = ExecutorFactory.getExecutor(cmd, environment);
        
        Assert.That(sce, Is.InstanceOf<AmbientLightLevelStateChangeExecutor>());
    }
}