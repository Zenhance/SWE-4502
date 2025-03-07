using Lab_7.Interfaces;
using Lab_7.Outsiders;

namespace Lab_7.Adepters;

public class TwitterAdepter : INotification
{
    private TwitterNotification _twitterNotification;

    public TwitterAdepter(TwitterNotification twitterNotification)
    {
        this._twitterNotification = twitterNotification;
    }
    

    public List<string> GetNotification()
    {
        return _twitterNotification.GetTwitterNotification();
    }
}