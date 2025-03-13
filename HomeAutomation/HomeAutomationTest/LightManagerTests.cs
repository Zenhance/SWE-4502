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
        public void OnStateChanged_TurnsLightsOff_WhenAmbientLightHigh()
        {
            var lightManager = new LightManager();
            var state = new EnvironmentalState { AmbientLight = 80 };

            lightManager.OnStateChanged(state);

            Assert.False(lightManager.LightsOn);
        }

        [Fact]
        public void SetScene_ChangesCurrentScene()
        {
            var lightManager = new LightManager();
            lightManager.SetScene("Movie");

            Assert.Equal("Movie", lightManager.CurrentScene);
        }
    }
}
