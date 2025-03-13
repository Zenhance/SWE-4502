using HomeAutomation;
using Moq;
using System.IO;

namespace HomeAutomationTests
{

    public class IssueLightManagementUnitTest
    {
        public StringWriter sw;

        public IssueLightManagementUnitTest()
        {
            sw = new StringWriter();
        }

        [Fact]
        public void ShouldTurnOnLightsIfRoomIsTaken()
        {
            // Arrange
            var mockLight = new Mock<Light>();  
            var lightControl = new RoomLightControl(mockLight.Object);  

            var state = new LightState(true, 50);  //room taken

            Console.SetOut(sw);

            // Act
            lightControl.AdjustLight(state);  

            // Assert
            mockLight.Verify(light => light.Manage(It.IsAny<LightState>()), Times.Once);  
        }

        [Fact]
        public void ShouldIncreaseIfAmbientLightIsLow()
        {
            // Arrange
            var mockLight = new Mock<Light>();  
            var lightControl = new RoomLightControl(mockLight.Object);  

            var state = new LightState(true, 12);  //ambient light too low

            
            Console.SetOut(sw);

            // Act
            lightControl.AdjustLight(state);  

            // Assert
            mockLight.Verify(light => light.Manage(It.IsAny<LightState>()), Times.Once);  
        }
    }
}
