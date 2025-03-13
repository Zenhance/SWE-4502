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
            var tempControl = new TemperatureControl(22.0);  
            var homeEnvironment = new HomeEnvironment();
            homeEnvironment.Subscribe(tempControl);

            Console.SetOut(stringWriter);

            homeEnvironment.UpdateHomeEnvironment(false, 9.0, "Living Room");  

            Assert.Contains("Activating heating...", stringWriter.ToString());
        }

        [Fact]
        public void ShouldActivateCoolingWhenTemperatureIsHigh()
        {
            var tempControl = new TemperatureControl(22.0);
            var homeEnvironment = new HomeEnvironment();
            homeEnvironment.Subscribe(tempControl);

            Console.SetOut(stringWriter);

            homeEnvironment.UpdateHomeEnvironment(false, 25.0, "Living Room");  

            Assert.Contains("Activating Cooling...", stringWriter.ToString());
        }

        


    }
}
