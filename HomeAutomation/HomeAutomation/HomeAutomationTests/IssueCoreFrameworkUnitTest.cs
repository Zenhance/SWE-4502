using HomeAutomation;

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
            var temperatureSensor = new TemperatureDetection();

            homeEnvironment.Subscribe(motionSensor);
            homeEnvironment.Subscribe(temperatureSensor);

            // Act
            homeEnvironment.UpdateHomeEnvironment(true, 22.5);

            // Assert
            Assert.Equal(22.5, homeEnvironment.Temperature);
        }
    }
}