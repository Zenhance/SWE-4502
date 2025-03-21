using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TaskManager
{
    public interface IObserver
    {
        void Notify(string message);
    }


}
