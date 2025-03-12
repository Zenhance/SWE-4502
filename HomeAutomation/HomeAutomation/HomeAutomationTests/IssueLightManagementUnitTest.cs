using HomeAutomation;
using System.IO;

namespace HomeAutomationTests
{
    public class IssueLightManagementUnitTest
    {
        [Fact]
        public void ShouldTurnOnLightsIfRoomIsTaken()
        {
            var lightControl = new RoomLightControl();
            var state = new LightState(true, 50);

            var stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            // Act
            lightControl.AdjustLight(state);

            // Assert
            Assert.Contains("Turning lights on.", stringWriter.ToString());
        }
        [Fact]
        public void ShouldIncreaseIfAmbientLightIsLow()
        {
            // Arrange
            var lightControl = new RoomLightControl();
            var state = new LightState(true, 12);

            
            var stringWriter = new StringWriter();
            Console.SetOut(stringWriter);

            // Act
            lightControl.AdjustLight(state);

            // Assert
            Assert.Contains("Ambient light too low : increasing light.", stringWriter.ToString());
        }
    }
}
