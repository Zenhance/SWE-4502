using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HomeAutomation.Test
{
    public class TemperatureControlTests
    {
        [Fact]
        public void TestSetTargetTemperature()
        {
            var coreSystem = new CoreSystem();
            var temperatureControl = new TemperatureControl(coreSystem);
            temperatureControl.SetTargetTemperature("100°F");
            Assert.Equal("100°F", coreSystem.GetState("temperature"));
        }
    }
}
