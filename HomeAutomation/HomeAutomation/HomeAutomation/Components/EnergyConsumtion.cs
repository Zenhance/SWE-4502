﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HomeAutomation.Core_Model;

namespace HomeAutomation.Components
{
    public class EnergyConsumtion:IObserver
    {
        public List<double> UsageHistory { get; set; } = new List<double>();
        public double TotalUsage { get; set; } = 0;
        public int Count { get; set; } = 0;
        public double AverageUsage { get; set; } = 0;


        public void Update(CentralState state)
        {
            double currentEnergyUsage = state.EnergyUsage;
            TrackUsagesStatistics(currentEnergyUsage);
            DetectUnusualConsumption(currentEnergyUsage);
        }

        public void TrackUsagesStatistics (double usage)
        {
            UsageHistory.Add(usage);
            TotalUsage += usage;
            Count++;
            AverageUsage = TotalUsage/Count;

        }

        public void DetectUnusualConsumption(double curentEnergyUsage)
        {
            if (Count > 1)
            {
                if(curentEnergyUsage>AverageUsage * 2)
                {
                    Console.WriteLine("Warning : Unusually high energy consumption detected !");
                }
                else if(curentEnergyUsage<AverageUsage / 2)
                {
                    Console.WriteLine("Notice : Unusuually low energy consumption detected .");
                }
            }
        }
    }
}
