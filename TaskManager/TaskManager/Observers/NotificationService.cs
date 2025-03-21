namespace TaskManager.Observers;

public class NotificationService : IObserver
{
    public void Update(string message)
    {
      Console.WriteLine($"Notification: {message}");  
    }
    
}