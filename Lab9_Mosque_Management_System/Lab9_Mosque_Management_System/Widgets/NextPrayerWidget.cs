using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab9_Mosque_Management_System
{
    public class NextPrayerWidget : IWidget
    {
        private IMediator _mediator;

        public void SetMediator(IMediator mediator)
        {
            _mediator = mediator;
        }

        public void Update()
        {
            Console.WriteLine("Next Prayer updated based on Current Time and Prayer Times Table.");
        }
    }
}
