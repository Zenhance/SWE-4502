using HomeAutomation;
namespace HomeAutomationTests
{
    public class IssueRemoteAccessAppUnitTest
    {
        private readonly StringWriter stringWriter;
        public IssueRemoteAccessAppUnitTest()
        {
            stringWriter = new StringWriter();
        }
        
        [Fact]
        public void ShouldControlSystemSuccessfully()
        {
            var homeEnvironment = new HomeEnvironment();
            var remoteAccessApp = new RemoteAccess(homeEnvironment,stringWriter);

            // Act
            remoteAccessApp.ControlSystem(true);  

            // Assert
            Assert.True(homeEnvironment.CurrentState.isMotionDetected);
        }

    }
}
