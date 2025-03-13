﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace src
{
    public class CoreComponent
    {
        private List<IObserver> observers;
        private Dictionary<string, string> state;

        public CoreComponent()
        {
            observers = new List<IObserver>();
            state = new Dictionary<string, string>();
        }
    }
}
