using HomeAutomation;
using Moq;

namespace HomeAutomationTests
{
    public class IssueCoreFrameworkUnitTest
    {
        [Fact]
        public void ShouldNotifyObserversWhenEnvironmentChanges()
        {
            // Arrange
            var homeEnvironment = new HomeEnvironment();
            var motionSensor = new MotionDetector();

            homeEnvironment.Subscribe(motionSensor);

            // Act
            homeEnvironment.UpdateHomeEnvironment(true, 12.12, "Batcave");


            // Assert
            Assert.True(homeEnvironment.CurrentState.isMotionDetected);
            Assert.Equal(12.12, homeEnvironment.CurrentState.Temperature);
            Assert.Equal("Batcave", homeEnvironment.CurrentState.Location);


            Assert.Contains("Motion detected at", motionSensor.detectionLogs[0]);
            Assert.Contains("Batcave", motionSensor.detectionLogs[0]);
        }
    }
}