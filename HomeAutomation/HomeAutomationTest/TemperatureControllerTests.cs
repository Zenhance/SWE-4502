using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using HomeAutomation.Core;
using HomeAutomation.Components;

namespace HomeAutomationTest
{
    public class TemperatureControllerTests
    {
        [Fact]
        public void OnStateChanged_ActivatesHeating_WhenTemperatureTooLow()
        {
            double target = 22;
            var controller = new TemperatureController(target);
            var state = new EnvironmentalState { Temperature = 20 };

            controller.OnStateChanged(state);

            Assert.True(controller.HeatingOn);
            Assert.False(controller.CoolingOn);
        }

        [Fact]
        public void OnStateChanged_ActivatesCooling_WhenTemperatureTooHigh()
        {
            double target = 22;
            var controller = new TemperatureController(target);
            var state = new EnvironmentalState { Temperature = 24 };

            controller.OnStateChanged(state);

            Assert.True(controller.CoolingOn);
            Assert.False(controller.HeatingOn);
        }
    }
}
