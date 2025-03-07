using Lab_7.Interfaces;
using Lab_7.Outsiders;

namespace Lab_7.Adepters;

public class FacebookAdepter : INotification
{
    private FaceBookNotification _faceBookNotification;
    public FacebookAdepter(FaceBookNotification faceBookNotification)
    {
        this._faceBookNotification = faceBookNotification;
    }

    public List<string> GetNotification()
    {
        return _faceBookNotification.GetFbNotification();
        
    }
}