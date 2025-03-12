using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation
{
    public interface IStateChangeListener
    {
        void OnStateChange(EnvironmentState state);
    }
}
