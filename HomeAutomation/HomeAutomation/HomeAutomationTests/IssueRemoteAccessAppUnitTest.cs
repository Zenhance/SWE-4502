using HomeAutomation;
namespace HomeAutomationTests
{

    public class IssueRemoteAccessAppUnitTest
    {
        [Fact]
        public void ShouldControlSystemSuccessfully()
        {
            var homeEnvironment = new HomeEnvironment();
            var remoteAccessApp = new RemoteAccess(homeEnvironment);

            // Act
            remoteAccessApp.ControlSystem(true);  

            // Assert
            Assert.True(homeEnvironment.CurrentState.isMotionDetected);
        }
    }

}
