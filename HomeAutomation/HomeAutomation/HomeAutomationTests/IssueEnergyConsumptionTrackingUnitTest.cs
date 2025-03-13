using HomeAutomation;
using Moq;

namespace HomeAutomationTests
{
    public class IssueEnergyConsumptionTrackingUnitTest
    {
        [Fact]
        public void ShouldTrackEnergyConsumptionWhenMotionIsDetected()
        {
            // Arrange
            var mockEnergyChain = new Mock<EnergyChain>();  
            var homeEnvironment = new HomeEnvironment();

            var energyTracker = new EnergyTracker(mockEnergyChain.Object);
            homeEnvironment.Subscribe(energyTracker);

            // Act
            homeEnvironment.UpdateHomeEnvironment(true, 12.12, "Kitchen");

            // Assert
            mockEnergyChain.Verify(chain => chain.Manager(It.IsAny<EnvironmentalState>()), Times.Once);

        }
    }
 }
