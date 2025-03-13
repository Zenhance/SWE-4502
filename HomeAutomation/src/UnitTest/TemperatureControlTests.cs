using src;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UnitTest
{
    public class TemperatureControlTests
    {
        [Fact]
        public void TestSetTargetTemperature()
        {
            var coreComponent = new CoreComponent();

            var temperatureControl = new TemperatureControl(coreComponent);
            temperatureControl.SetTargetTemperature("72°F");
            Assert.Equal("72°F", coreComponent.GetState("temperature"));
        }
    }
}
