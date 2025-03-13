using System;
 using System.Collections.Generic;
 using System.Linq;
 using System.Text;
 using System.Threading.Tasks;
 
 namespace HomeAutomation.Core_Model
 {
     public  class CentralState
     {
         public bool MotionDetected { get; set; }
         public int LightLevel { get; set; }
         public bool RoomOccupied { get; set; }
         public int Temperature { get; set; }
         public double EnergyUsage { get; set; }
         public string VoiceCommand { get; set; }
     }
   public interface IObserver
     {
         void Update(CentralState state);
     }

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
          public void NotifyObservers()
         {
             foreach (var observer in _observers)
             {
                 observer.Update(centralState);
             }
         }
     }
 }
 
