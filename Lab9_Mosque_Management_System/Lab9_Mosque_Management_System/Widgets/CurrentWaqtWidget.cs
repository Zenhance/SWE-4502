using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab9_Mosque_Management_System
{
    public class CurrentWaqtWidget : IWidget
    {
        private IMediator _mediator;

        public void SetMediator(IMediator mediator)
        {
            _mediator = mediator;
        }

        public void Update()
        {
            Console.WriteLine("Current Waqt updated based on Current Time and Waqt Time Tables.");
        }
    }
}
