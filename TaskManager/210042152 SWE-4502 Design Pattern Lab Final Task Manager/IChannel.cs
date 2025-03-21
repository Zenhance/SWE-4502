using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _210042152_SWE_4502_Design_Pattern_Lab_Final_Task_Manager
{
   public interface IChannel
    {
        void subscribe(ISubscriber subscriber);
        void unsubscribe(ISubscriber subscriber);
      //  void notify(string title);    

    }
}
