﻿using System;
 using System.Collections.Generic;
 using System.Linq;
 using System.Text;
 using System.Threading.Tasks;
 using HomeAutomation.Core_Model;
 
 namespace HomeAutomation.Components
 {
     public class RemoteAccessApp : IObserver
     {
         public List<string> Notifications { get; private set; } = new List<string>();
         public CentralState CurrentState { get; private set; } = new CentralState();
 
         public void Update(CentralState state)
         {
             CurrentState = state;
             Notifications.Add($"State updated: Motion: {state.MotionDetected}, Light: {state.LightLevel}, Temp: {state.Temperature}, Energy: {state.EnergyUsage}, VoiceCmd: {state.VoiceCommand}");
         }
     }
 }