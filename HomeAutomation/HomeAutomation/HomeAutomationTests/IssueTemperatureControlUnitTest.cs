using HomeAutomation;
using System.IO;

namespace HomeAutomationTests
{
    public class IssueTemperatureControlUnitTest
    {
        private readonly StringWriter stringWriter;
        public IssueTemperatureControlUnitTest()
        {
            stringWriter = new StringWriter();
        }
        [Fact]
        public void ShouldActivateHeatingWhenTemperatureIsLow()
        {
            // Arrange
            var tempControl = new TemperatureControl(22.0);
            var homeEnvironment = new HomeEnvironment();
            homeEnvironment.Subscribe(tempControl);
            homeEnvironment.UpdateHomeEnvironment(false, 20.0, "Living Room");

            Console.SetOut(stringWriter); 

            // Act
            homeEnvironment.UpdateHomeEnvironment(false, 20.0, "Living Room");

            // Assert
            Assert.Contains("Activating heating...", stringWriter.ToString());
        }

        
    }
}
