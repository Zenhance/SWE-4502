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
    public class TestLightManagement
    {
        [Fact]
        public void Test_LightManagement_LightsOffWhenRoomEmpty()
        {
            LightManagment lightManager = new LightManagment();
            CentralState state = new CentralState { LightLevel = 70, RoomOccupied = false };

            lightManager.Update(state);

            Assert.Equal(0, lightManager.GetChangedLightLevel());
            Assert.Equal("Off", lightManager.GetScene());
        }

        [Fact]
        public void Test_LightManagement_LowLightIncrease()
        {
            LightManagment lightManager = new LightManagment();
            CentralState state = new CentralState { LightLevel = 30, RoomOccupied = true };

            lightManager.Update(state);

            Assert.Equal(50, lightManager.GetChangedLightLevel());
            Assert.Equal("Low", lightManager.GetScene());
        }

        [Fact]
        public void Test_LightManagement_BrightRoom()
        {
            LightManagment lightManager = new LightManagment();
            CentralState state = new CentralState { LightLevel = 100, RoomOccupied = true };

            lightManager.Update(state);

            Assert.Equal(100, lightManager.GetChangedLightLevel());
            Assert.Equal("High", lightManager.GetScene());
        }
    }
}
