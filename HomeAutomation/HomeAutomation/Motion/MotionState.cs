using HomeAutomation.Core;
using System.ComponentModel;

namespace HomeAutomation.Motion;

public class MotionState : State
{
    public string Location { get; set; } = default!;
    public DateTime Time { get; set; }

    public override string ToString()
    {
        return $"Motion detected at {Location} at {Time}";
    }
}
