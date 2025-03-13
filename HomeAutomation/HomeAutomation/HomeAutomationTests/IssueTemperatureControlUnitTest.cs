using HomeAutomation;
using Moq;
using System.IO;

namespace HomeAutomationTests
{
    public class IssueTemperatureControlUnitTest
    {

        [Fact]
        public void ShouldActivateHeatingWhenTemperatureIsLow()
        {
            // Arrange
            var mockHeatCommand = new Mock<ITemp>();  
            var mockCoolCommand = new Mock<ITemp>(); 
            var tempControl = new TemperatureControl(12.12);  
            tempControl.heat = mockHeatCommand.Object;  
            tempControl.cool = mockCoolCommand.Object;  

            var homeEnvironment = new HomeEnvironment();
            homeEnvironment.Subscribe(tempControl);

            // Act: temperature difference exceeds the hysteresis threshold
            homeEnvironment.UpdateHomeEnvironment(false, 39.12, "Bedroom 1");  

            // Assert
            mockCoolCommand.Verify(command => command.Do(), Times.Once);  
            mockHeatCommand.Verify(command => command.Do(), Times.Never);  
        }

        [Fact]
        public void ShouldActivateCoolingWhenTemperatureIsHigh()
        {
            // Arrange
            var mockHeatCommand = new Mock<ITemp>(); 
            var mockCoolCommand = new Mock<ITemp>(); 
            var tempControl = new TemperatureControl(12.12);  
            tempControl.heat = mockHeatCommand.Object;  
            tempControl.cool = mockCoolCommand.Object;  

            var homeEnvironment = new HomeEnvironment();
            homeEnvironment.Subscribe(tempControl);

            // Act: temperature difference exceeds the hysteresis threshold
            homeEnvironment.UpdateHomeEnvironment(false, 39.12, "Sheldon's Spot");  

            // Assert
            mockCoolCommand.Verify(command => command.Do(), Times.Once);  
            mockHeatCommand.Verify(command => command.Do(), Times.Never);  
        }

        [Fact]
        public void ShouldDoNothingWhenTemperatureIsStable()
        {
            // Arrange
            var mockHeatCommand = new Mock<ITemp>();  
            var mockCoolCommand = new Mock<ITemp>(); 
            var tempControl = new TemperatureControl(12.12);  
            tempControl.heat = mockHeatCommand.Object;  
            tempControl.cool = mockCoolCommand.Object;  

            var homeEnvironment = new HomeEnvironment();
            homeEnvironment.Subscribe(tempControl);

            // Act: Temperature is equal to target, nothing should happen
            homeEnvironment.UpdateHomeEnvironment(false, 12.12, "Hell on earth");  

            // Assert
            mockHeatCommand.Verify(command => command.Do(), Times.Never);  
            mockCoolCommand.Verify(command => command.Do(), Times.Never);  
        }
    }
}
