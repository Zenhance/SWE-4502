using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab9_Mosque_Management_System
{
    public interface IWidget
    {
        void SetMediator(IMediator mediator);
        void Update();
    }
}
