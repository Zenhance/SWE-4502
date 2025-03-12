using HomeAutomation;

namespace HomeAutomationTests
{
    public class IssueMotionDetectionUnitTest
    {
        [Fact]
        public void ShouldLogMotionWhenMotionIsDetected()
        {
            // Arrange
            var motionDetector = new MotionDetector();
            var homeEnvironment = new HomeEnvironment();
            homeEnvironment.Subscribe(motionDetector);

            // Act
            homeEnvironment.UpdateHomeEnvironment(true, 12.12, "Basement");

            // Assert
            Assert.Single(motionDetector.detectionLogs);  
            Assert.Contains("Motion detected at", motionDetector.detectionLogs[0]);
            Assert.Contains("Basement", motionDetector.detectionLogs[0]); 

        }
    }
}
