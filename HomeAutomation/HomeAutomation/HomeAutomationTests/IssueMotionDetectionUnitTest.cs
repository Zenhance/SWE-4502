using HomeAutomation;
using Moq;

namespace HomeAutomationTests
{

    public class IssueMotionDetectionUnitTest
    {
        [Fact]
        public void ShouldLogMotionWhenMotionIsDetected()
        {
            // Arrange
            var mockObserver = new Mock<IObserver>();  
            var homeEnvironment = new HomeEnvironment();
            homeEnvironment.Subscribe(mockObserver.Object);

            // Act
            homeEnvironment.UpdateHomeEnvironment(true, 12.12, "Batcave");

            // Assert
            mockObserver.Verify(observer => observer.Notify(It.IsAny<EnvironmentalState>()), Times.Once);
        }
    }
}
