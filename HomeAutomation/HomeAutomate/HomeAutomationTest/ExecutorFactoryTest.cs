using HomeAutomate.Core;
using HomeAutomate.Models;
using HomeAutomate.Components;
using HomeAutomate.Enum;
using HomeAutomate.Executor;
using HomeAutomate.Factory;

namespace HomeAutomationTest;

public class ExecutorFactoryTest
{
    [SetUp]
    public void Setup()
    {
    }
    
    
    [Test]
    public void ExecutorFactoryTemperatureObjectSetTest()
    {
        EnvironmentState environment = new EnvironmentState();

        Command cmd = new Command("temperature value 37 degree");
        
        StateChangeExecutor sce = ExecutorFactory.getExecutor(cmd, environment);
        
        Assert.That(sce, Is.InstanceOf<TemperatureStateChangeExecutor>());
    }
    
    
    [Test]
    public void ExecutorFactoryAmbientLightLevelObjectSetTest()
    {
        EnvironmentState environment = new EnvironmentState();

        Command cmd = new Command("ambientlightlevel value 0.6 lux");
        
        StateChangeExecutor sce = ExecutorFactory.getExecutor(cmd, environment);
        
        Assert.That(sce, Is.InstanceOf<AmbientLightLevelStateChangeExecutor>());
    }
    
    
    [Test]
    public void ExecutorFactoryMotionLevelObjectSetTest()
    {
        EnvironmentState environment = new EnvironmentState();

        Command cmd = new Command("motion value 0.7");
        
        StateChangeExecutor sce = ExecutorFactory.getExecutor(cmd, environment);
        
        Assert.That(sce, Is.InstanceOf<MotionLevelStateChangeExecutor>());
    }
    
    
    [Test]
    public void ExecutorFactoryEnergyConsumptionObjectSetTest()
    {
        EnvironmentState environment = new EnvironmentState();

        Command cmd = new Command("energy value 125 watt");
        
        StateChangeExecutor sce = ExecutorFactory.getExecutor(cmd, environment);
        
        Assert.That(sce, Is.InstanceOf<EnergyConsumptionStateChangeExecutor>());
    }
    
    [Test]
    public void ExecutorFactoryCommandConversionTest()
    {
        EnvironmentState environment = new EnvironmentState();

        Command cmd = new Command("energy value 125 watt");
        
        StateChangeExecutor sce = ExecutorFactory.getExecutor(cmd, environment);
        
        Command returnedCommand = sce.getCommand();
        
        Assert.That(returnedCommand.getValue(), Is.EqualTo(125));
    }
}