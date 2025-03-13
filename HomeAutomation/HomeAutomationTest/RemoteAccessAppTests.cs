using HomeAutomation.Components;
using HomeAutomation.Core;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomationTest
{
    public class RemoteAccessAppTests
    {
        [Fact]
        public void OnStateChanged_UpdatesCurrentStateAndNotifies()
        {
            var app = new RemoteAccessApp();
            var state = new EnvironmentalState { Temperature = 21, AmbientLight = 40, MotionDetected = true };

            app.OnStateChanged(state);

            Assert.Equal(21, app.CurrentState.Temperature);
            Assert.Equal(40, app.CurrentState.AmbientLight);
            Assert.Contains("Motion detected!", app.Notifications);
        }

        [Fact]
        public void GetDisplay_ReturnsFormattedString()
        {
            var app = new RemoteAccessApp();
            var state = new EnvironmentalState { Temperature = 23, AmbientLight = 75 };
            app.OnStateChanged(state);

            string display = app.GetDisplay();
            Assert.Contains("Temp: 23", display);
            Assert.Contains("Light: 75", display);
        }
    }
}
