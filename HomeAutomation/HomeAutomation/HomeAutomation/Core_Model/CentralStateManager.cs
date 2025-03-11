﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Core_Model
{
    public class CentralStateManager
    {
        private List<IObserver> _observers = new List<IObserver>();
        private CentralState centralState = new CentralState();


        public void RegisterObserver(IObserver observer)
        {
            _observers.Add(observer);
        }

        public void RemoveObserver(IObserver observer)
        {
            _observers.Remove(observer);
        }
    }
}
