using HomeAutomation.Core;

namespace HomeAutomation.Light;

public class LightManager : ISubscriber
{
    private State _state = default!;
    private Dictionary<string, int> _scenes = new Dictionary<string, int>
    {
        { "Reading", 10 },
        {"Movie", 5 },
        {"Sleep", 1 }
    };
    public string Update(State state)
    {
        _state = state;
        return state.ToString()!;
    }

    public int SetScene(string scene)
    {
        return _scenes[scene];
    }
}
