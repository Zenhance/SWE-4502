namespace HomeAutomation.Core;

public class StateObserver
{
    private Dictionary<StateChangeEvent, List<ISubscriber>> _subscribers = new Dictionary<StateChangeEvent, List<ISubscriber>>();
    private Dictionary<StateChangeEvent, State> _currentState = new Dictionary<StateChangeEvent, State>();

    public void AddSubscriber(StateChangeEvent changeEvent, ISubscriber subscriber)
    {
        if(!_subscribers.ContainsKey(changeEvent))
        {
            _subscribers.Add(changeEvent, new List<ISubscriber>());
        }
        _subscribers[changeEvent].Add(subscriber);
    }

    public void RemoveSubscriber(StateChangeEvent changeEvent, ISubscriber subscriber)
    {
        if (_subscribers.ContainsKey(changeEvent))
        {
            _subscribers[changeEvent].Remove(subscriber);
        }
    }

    public void NotifySubscribers(StateChangeEvent changeEvent)
    {
        foreach (var subscriber in _subscribers[changeEvent])
        {
            subscriber.Notify();
        }

    }

    public State GetState(StateChangeEvent changeEvent)
    {
        return _currentState[changeEvent];
    }
}
