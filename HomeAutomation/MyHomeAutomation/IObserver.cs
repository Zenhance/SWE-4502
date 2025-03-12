using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyHomeAutomation
{
    public interface IObserver
    {
        void Update(string key, string value);
    }
}
