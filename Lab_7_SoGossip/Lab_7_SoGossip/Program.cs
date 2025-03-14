using System;

namespace Lab_7_SoGossip
{
    class Program
    {
        static void Main(string[] args)
        {
            // Create the individual platform facades
            var facebookFacade = new FacebookFacade();
            var instagramFacade = new InstagramFacade();
            var twitterFacade = new TwitterFacade();
            var linkedInFacade = new LinkedInFacade();

            // Create MetaFacade and ProfessionalFacade that aggregate notifications
            var metaFacade = new MetaFacade(facebookFacade, instagramFacade);
            var professionalFacade = new ProfessionalFacade(twitterFacade, linkedInFacade);

            // Demonstrating MetaFacade (works with Facebook and Instagram)
            Console.WriteLine("MetaFacade - Managing Facebook and Instagram Notifications:");
            metaFacade.MarkAllAsRead();  // Mark all notifications as read on Meta platforms
            metaFacade.ClearBirthdayNotifications();  // Clear birthday-related notifications
            Console.WriteLine();  // For better readability

            // Demonstrating ProfessionalFacade (works with Twitter and LinkedIn)
            Console.WriteLine("ProfessionalFacade - Managing Twitter and LinkedIn Notifications:");
            professionalFacade.MarkAllAsRead();  // Mark all notifications as read on Professional platforms
            professionalFacade.ClearJobAndConnectionNotifications();  // Clear job and connection-related notifications
            professionalFacade.ClearAllNotifications();  // Clear all notifications


            Console.ReadLine();
        }
    }
}
