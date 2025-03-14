using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_7_SoGossip
{
    public class SocialMediaMetaFacade
    {
        private List<INotification> _allNotifications;
        private List<object> _platformFacades;

        public SocialMediaMetaFacade(List<object> platformFacades)
        {
            _platformFacades = platformFacades;
            _allNotifications = new List<INotification>();
        }

        public List<INotification> GetAllNotifications()
        {
            _allNotifications.Clear();
            foreach (var facade in _platformFacades)
            {
                if (facade is FacebookFacade facebookFacade)
                    _allNotifications.AddRange(facebookFacade.GetNotifications());

                if (facade is InstagramFacade instagramFacade)
                    _allNotifications.AddRange(instagramFacade.GetNotifications());

                if (facade is TwitterFacade twitterFacade)
                    _allNotifications.AddRange(twitterFacade.GetNotifications());

                if (facade is LinkedInFacade linkedInFacade)
                    _allNotifications.AddRange(linkedInFacade.GetNotifications());
            }

            return _allNotifications;
        }

        public void MarkAllAsRead()
        {
            foreach (var notification in GetAllNotifications())
            {
                notification.MarkAsRead();
            }
        }

        public void MarkAllAsUnread()
        {
            foreach (var notification in GetAllNotifications())
            {
                notification.MarkAsUnread();
            }
        }

        public void DeleteAllNotifications()
        {
            foreach (var notification in GetAllNotifications())
            {
                notification.Clear();
            }
        }
    }



}
