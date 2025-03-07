using Lab_7.Adepters;
using Lab_7.Interfaces;
using Lab_7.Outsiders;

namespace Lab_7.Facade;

public class NotificationFacade
{
    private readonly List<INotification> _notifications;

    public NotificationFacade()
    {
        _notifications = new List<INotification>();
        
        _notifications.Add(new FacebookAdepter(new FaceBookNotification()));
        _notifications.Add(new TwitterAdepter(new TwitterNotification()));
        _notifications.Add(new LinkedInAdepter(new LinkedInNotification()));
    }

    public void ShowNotification()
    {
        foreach (INotification notification in _notifications)
        {
            Console.WriteLine(notification.GetNotification());
        }
    }
}