using HomeAutomation.Core;

namespace HomeAutomation.Temperature;

public class TemperatureController : ISubscriber
{
    private TemperatureState _state = default!;
    public string Update(State state)
    {
        _state = (TemperatureState)state;
        return _state.ToString();
    }

    public string GetRequiredAction(double targetTemperature)
    {
        return _state.Temperature > targetTemperature ? "Cooling" : "Heating";
    }
}