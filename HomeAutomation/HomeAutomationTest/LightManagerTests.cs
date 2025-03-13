using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HomeAutomation.Core;
using HomeAutomation.Components;

namespace HomeAutomationTest
{
    public class LightManagerTests
    {
        [Fact]
        public void OnStateChanged_TurnsLightsOn_WhenAmbientLightLow()
        {
            var lightManager = new LightManager();
            var state = new EnvironmentalState { AmbientLight = 20 };

            lightManager.OnStateChanged(state);

            Assert.True(lightManager.LightsOn);
        }

        [Fact]
      
    }
}
