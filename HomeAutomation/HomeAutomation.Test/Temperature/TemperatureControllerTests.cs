using Xunit;
using HomeAutomation.Temperature;

namespace HomeAutomation.Temperature.Tests;

public class TemperatureControllerTests
{
    [Fact()]
    public void UpdateTest()
    {
        TemperatureController controller = new();
        TemperatureState state = new();
        var result = controller.Update(state);
        Assert.Equal(state.ToString(), result);
    }

    [Fact()]
    public void GetRequiredActionTestNoUpdate()
    {
        TemperatureController controller = new();
        Assert.Throws<NullReferenceException>(() => controller.GetRequiredAction(25));
    }

    [Fact()]
    public void GetRequiredActionTestHeating()
    {
        TemperatureController controller = new();
        TemperatureState state = new() { Temperature = 20 };
        controller.Update(state);
        var result = controller.GetRequiredAction(25);
        Assert.Equal("Heating", result);
    }

    [Fact()]
    public void GetRequiredActionTestCooling()
    {
        TemperatureController controller = new();
        TemperatureState state = new() { Temperature = 30 };
        controller.Update(state);
        var result = controller.GetRequiredAction(25);
        Assert.Equal("Cooling", result);
    }
}