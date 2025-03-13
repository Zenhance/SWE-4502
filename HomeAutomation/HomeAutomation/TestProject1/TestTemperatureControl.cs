using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xunit;
using HomeAutomation.Components;
using HomeAutomation.Core_Model;

namespace TestProject1
{
    public class TestTemperatureControl
    {
        
            [Fact]
            public void Test_TemperatureControl_RoomUnoccupied()
            {
                TemperatureControl tempControl = new TemperatureControl();
                CentralState state = new CentralState { Temperature = 20, RoomOccupied = false };

                tempControl.Update(state);

                Assert.Equal(25.0, tempControl.GetDesiredTemperature());
                Assert.Equal("Idle", tempControl.GetMode());
            }

            [Fact]
            public void Test_TemperatureControl_HeatingMode()
            {
                TemperatureControl tempControl = new TemperatureControl();
                CentralState state = new CentralState { Temperature = 16, RoomOccupied = true };

                tempControl.Update(state);

                Assert.Equal(22.0, tempControl.GetDesiredTemperature());
                Assert.Equal("Heating", tempControl.GetMode());
            }
        }
}
