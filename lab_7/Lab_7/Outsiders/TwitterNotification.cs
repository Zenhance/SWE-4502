namespace Lab_7.Outsiders;

public class TwitterNotification
{
    private List<string> _notifications;
    
    public TwitterNotification()
    {
        _notifications = new List<string>();
    }
    
    public void AddTwitterNotification(string notification)
    {
        _notifications.Add(notification);
    }
    
    public List<string> GetTwitterNotification()
    {
        return _notifications;
    }
}