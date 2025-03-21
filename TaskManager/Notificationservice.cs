using System;
using System.Collections.Generic;

public class NotificationService
{
    private List<IObserver> observers = new();

    public void Subscribe(IObserver observer) => observers.Add(observer);
    public void Unsubscribe(IObserver observer) => observers.Remove(observer);
    public void Notify(string message)
    {
        foreach (var observer in observers)
            observer.Update(message);
    }
}