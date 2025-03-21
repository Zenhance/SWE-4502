using System;

public class User : IObserver
{
    public string Name { get; }

    public User(string name)
    {  Name = name; }
        
    public void Update(string message)
    {
        Console.WriteLine($"Notification for {Name}: {message}");
    }
       
}