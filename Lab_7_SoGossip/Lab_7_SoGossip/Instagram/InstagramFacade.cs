using System.Collections.Generic;

namespace Lab_7_SoGossip
{
    public class InstagramFacade
    {
        public List<INotification> GetNotifications()
        {
            return new List<INotification>
            {
                new InstagramNotification("Someone liked your photo."),
                new InstagramNotification("Happy birthday from your friend!")
            };
        }
    }
}
