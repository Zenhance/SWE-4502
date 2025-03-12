using HomeAutomation;

namespace HomeAutomationTests
{
    public class IssueEnergyConsumptionTrackingUnitTest
    {
        private readonly StringWriter stringWriter;
        public IssueEnergyConsumptionTrackingUnitTest()
        {
            stringWriter = new StringWriter();
        }
        [Fact]
        public void ShouldTrackEnergyConsumptionWhenMotionIsDetected()
        {
            var energyTracker = new EnergyTracker();
            var homeEnvironment = new HomeEnvironment();
            homeEnvironment.Subscribe(energyTracker);

            Console.SetOut(stringWriter);
            homeEnvironment.UpdateHomeEnvironment(true, 12.12, "Backyard");


            Assert.Contains("Energy Consumption Updated", stringWriter.ToString());
        }
    }
}
