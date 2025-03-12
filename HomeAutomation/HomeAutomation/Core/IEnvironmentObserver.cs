using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Core
{
    public interface IEnvironmentObserver
    {
        void OnEnvironmentStateChanged(EnvironmentState state);
    }

}
