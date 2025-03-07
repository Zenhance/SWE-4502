namespace Lab_7.Outsiders;

public class LinkedInNotification
{
    List<string> _notifications;

    public LinkedInNotification()
    {
        _notifications = new List<string>();
    }
    
    public void AddLinkedInNotification(string notification)
    {
        _notifications.Add(notification);
    }
    
    public List<string> GetLinkedInNotification()
    {
        return _notifications;
    }
}