using Lab_7.Interfaces;
using Lab_7.Outsiders;

namespace Lab_7.Adepters;

public class LinkedInAdepter : INotification
{
    private LinkedInNotification _linkedInNotification;

    public LinkedInAdepter(LinkedInNotification linkedInNotification)
    {
        this._linkedInNotification = linkedInNotification;
    }
    

    public List<string> GetNotification()
    {
        return _linkedInNotification.GetLinkedInNotification();
    }
}