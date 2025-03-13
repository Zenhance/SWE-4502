using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_05_NotifiDapters
{
    // Adapter class to adapt the EPostalMailService to the INotification interface
    public class EPostalMailAdapter : INotification
    {
        private EPostalMailService _postalService;

        public EPostalMailAdapter(EPostalMailService postalService)
        {
            _postalService = postalService;
        }

        public void Send(string to, string message)
        {
            // In a real application, you might split the 'to' string into more detailed address parts
            string recipientName = "John Doe"; // For simplicity
            string streetAddress = "123 Main St";
            string city = "Example City";
            string postalCode = "12345";

            // Call the third-party postal mail service
            _postalService.SendPostalMail(recipientName, streetAddress, city, postalCode, message);
        }
    }

}
