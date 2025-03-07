namespace Lab_7.Outsiders;

public class FaceBookNotification
{
    List<string> _notifications;

    public FaceBookNotification()
    {
        _notifications = new List<string>();
    }
    
    public void AddFbNotification(string notification)
    {
        _notifications.Add(notification);
    }

    public List<string> GetFbNotification()
    {
        return _notifications;
    }
}