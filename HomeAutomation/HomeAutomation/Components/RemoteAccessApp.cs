using HomeAutomation.Core;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace HomeAutomation.Components
{
    public class RemoteAccessApp : IComponent
    {
        public EnvironmentalState CurrentState { get; private set; }
        public List<string> Notifications { get; private set; } = new List<string>();

        public void OnStateChanged(EnvironmentalState state)
        {
            CurrentState = state;
            if (state.MotionDetected)
            {
                Notifications.Add("Motion detected!");
            }
        }

        public string GetDisplay()
        {
            return $"Temp: {CurrentState?.Temperature ?? 0}, Light: {CurrentState?.AmbientLight ?? 0}";
        }
    }
}
