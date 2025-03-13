using HomeAutomation.Core;

namespace HomeAutomation.Temperature;

public class TemperatureState : State
{
    public double Temperature { get; set; }
    public override string ToString()
    {
        return $"Temperature: {Temperature}";
    }
}
