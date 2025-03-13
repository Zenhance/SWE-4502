using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HomeAutomation.Core;

namespace HomeAutomation.Components
{
    public class LightManager : IComponent
    {
        public double CurrentAmbientLight { get; private set; }
        public bool LightsOn { get; private set; }
        public string CurrentScene { get; private set; } = "Default";

        public void OnStateChanged(EnvironmentalState state)
        {
            CurrentAmbientLight = state.AmbientLight;
            LightsOn = state.AmbientLight < 30;  
        }

        public void SetScene(string scene)
        {
            CurrentScene = scene;
        }
    }
}
