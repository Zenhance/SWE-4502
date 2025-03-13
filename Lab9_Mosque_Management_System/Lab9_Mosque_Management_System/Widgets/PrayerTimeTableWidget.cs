using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab9_Mosque_Management_System
{
    public class PrayerTimeTableWidget : IWidget
    {
        private IMediator _mediator;

        public void SetMediator(IMediator mediator)
        {
            _mediator = mediator;
        }

        public void Update()
        {
            Console.WriteLine("Prayer Time Table updated based on Prayer Time Settings.");
        }
    }
}
