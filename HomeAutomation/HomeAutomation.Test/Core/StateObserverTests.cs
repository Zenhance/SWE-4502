using Xunit;
using HomeAutomation.Core;
using HomeAutomation.Motion;

namespace HomeAutomation.Core.Tests;

public class StateObserverTests
{
    [Fact()]
    public void AddSubscriberTestSuccess()
    {
        StateObserver stateObserver = new StateObserver();
        ISubscriber subscriber = new MotionDetector();
        bool result = stateObserver.AddSubscriber(StateChangeEvent.Motion, subscriber);
        Assert.True(result);
    }
    [Fact()]
    public void AddSubscriberTestFailure()
    {
        StateObserver stateObserver = new StateObserver();
        ISubscriber subscriber = new MotionDetector();
        stateObserver.AddSubscriber(StateChangeEvent.Motion, subscriber);
        bool result = stateObserver.AddSubscriber(StateChangeEvent.Motion, subscriber);
        Assert.False(result);
    }

    [Fact()]
    public void RemoveSubscriberTestSuccess()
    {
        StateObserver stateObserver = new StateObserver();
        ISubscriber subscriber = new MotionDetector();
        stateObserver.AddSubscriber(StateChangeEvent.Motion, subscriber);
        bool result = stateObserver.RemoveSubscriber(StateChangeEvent.Motion, subscriber);
        Assert.True(result);
    }

    [Fact()]
    public void RemoveSubscriberTestFailure()
    {
        StateObserver stateObserver = new StateObserver();
        ISubscriber subscriber = new MotionDetector();
        bool result = stateObserver.RemoveSubscriber(StateChangeEvent.Motion, subscriber);
        Assert.False(result);
    }

    [Fact()]
    public void ChangeCurrentStateTestNoSubscriber()
    {
        StateObserver stateObserver = new StateObserver();
        State state = new MotionState();
        int result = stateObserver.ChangeCurrentState(StateChangeEvent.Motion, state);
        Assert.Equal(0, result);
    }

    [Fact()]
    public void ChangeCurrentStateTestOneSubscriber()
    {
        StateObserver stateObserver = new StateObserver();
        ISubscriber subscriber = new MotionDetector();
        stateObserver.AddSubscriber(StateChangeEvent.Motion, subscriber);
        State state = new MotionState();
        int result = stateObserver.ChangeCurrentState(StateChangeEvent.Motion, state);
        Assert.Equal(1, result);
    }

    [Fact()]
    public void GetCurrentStateTestNoStateChange()
    {
        StateObserver stateObserver = new StateObserver();
        var result = stateObserver.GetCurrentState(StateChangeEvent.Motion);
        Assert.Null(result);
    }

    [Fact()]
    public void GetCurrentStateTest()
    {
        StateObserver stateObserver = new StateObserver();
        State state = new MotionState();
        stateObserver.ChangeCurrentState(StateChangeEvent.Motion, state);
        var result = stateObserver.GetCurrentState(StateChangeEvent.Motion);
        Assert.Equal(state, result);
    }
}