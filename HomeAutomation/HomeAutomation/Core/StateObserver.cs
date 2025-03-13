namespace HomeAutomation.Core;

public class StateObserver
{
    private Dictionary<StateChangeEvent, HashSet<ISubscriber>> _subscribers = new Dictionary<StateChangeEvent, HashSet<ISubscriber>>();
    private Dictionary<StateChangeEvent, State> _currentState = new Dictionary<StateChangeEvent, State>();

    public bool AddSubscriber(StateChangeEvent changeEvent, ISubscriber subscriber)
    {
        if(!_subscribers.ContainsKey(changeEvent))
        {
            _subscribers.Add(changeEvent, new HashSet<ISubscriber>());
        }
        return _subscribers[changeEvent].Add(subscriber);
    }

    public bool RemoveSubscriber(StateChangeEvent changeEvent, ISubscriber subscriber)
    {
        if (_subscribers.ContainsKey(changeEvent))
        {
            return _subscribers[changeEvent].Remove(subscriber);
        }
        return false;
    }

    private int NotifySubscribers(StateChangeEvent changeEvent, State state)
    {
        int count = 0;
        if(!_subscribers.ContainsKey(changeEvent))
        {
            return count;
        }
        foreach (var subscriber in _subscribers[changeEvent])
        {
            subscriber.Update(state);
            count++;
        }

        return count;
    }

    public State? GetCurrentState(StateChangeEvent changeEvent)
    {
        if (_currentState.ContainsKey(changeEvent))
        {
            return _currentState[changeEvent];
        }
        return null;
    }

    public int ChangeCurrentState(StateChangeEvent changeEvent, State state)
    {
        _currentState[changeEvent] = state;
        return NotifySubscribers(changeEvent, state);
    }
}
