using HomeAutomation.Core;

namespace HomeAutomation.Motion;

public class MotionDetector : ISubscriber
{
    private List<State> _states = new List<State>();
    public string Update(State state)
    {
        _states.Add(state);
        return state.ToString()!;
    }
}
