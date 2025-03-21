using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _210042152_SWE_4502_Design_Pattern_Lab_Final_Task_Manager
{
   public class Channel : IChannel
    {
        private List<ISubscriber> _subscribers = new List<ISubscriber>();
        private string channelname;
        public Channel(string channelname)
        {

        this.channelname = channelname; 
        }
        public void subscribe(ISubscriber subscriber)
        {
            _subscribers.Add(subscriber);
        }
        public void unsubscribe(ISubscriber subscriber)
        {
            _subscribers.Remove(subscriber);
        }
     
    }
    }

