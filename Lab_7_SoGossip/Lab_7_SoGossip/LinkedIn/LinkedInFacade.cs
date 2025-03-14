using System;
using System.Collections.Generic;

namespace Lab_7_SoGossip
{
    public class LinkedInFacade
    {
        public List<INotification> GetNotifications()
        {
            // Simulate fetching notifications from LinkedIn API
            return new List<INotification>
            {
                new LinkedInNotification("New connection request."),
                new LinkedInNotification("Someone viewed your profile."),
                new LinkedInNotification("New job opportunity posted.")
            };
        }
    }
}
