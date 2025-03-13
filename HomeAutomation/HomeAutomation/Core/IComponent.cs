using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Core
{
    public interface IComponent
    {
        void Update(string property, object value);
    }
}
