using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab9_Mosque_Management_System
{
    public class WaqtTimeTablesWidget : IWidget
    {
        private IMediator _mediator;

        public void SetMediator(IMediator mediator)
        {
            _mediator = mediator;
        }

        public void Update()
        {
            Console.WriteLine("Waqt Time Tables updated based on Location and TimeZone.");
            _mediator.Notify(this, "WaqtTimeUpdated");
        }
    }
}
