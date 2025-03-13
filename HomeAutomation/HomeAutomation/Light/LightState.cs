using HomeAutomation.Core;

namespace HomeAutomation.Light;

public class LightState : State
{
    public int AmbientLightLevel { get; set; }

    public override string ToString()
    {
        return $"Ambient light level: {AmbientLightLevel}";
    }
}
