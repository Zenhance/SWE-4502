using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyHomeAutomation.Test
{
    public class TemperatureControlTests
    {
        [Fact]
        public void TestSetTargetTemperature()
        {
            var coreSystem = new CoreSystem();
            var temperatureControl = new TemperatureControl(coreSystem);
            temperatureControl.SetTargetTemperature("72°F");
            Assert.Equal("72°F", coreSystem.GetState("temperature"));
        }
    }
}
